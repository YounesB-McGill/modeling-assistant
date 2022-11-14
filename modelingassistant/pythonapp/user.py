"""
Module to manage users.
"""

from __future__ import annotations

import logging
import random
import secrets
from random import randint
from string import ascii_lowercase
from time import time
from typing import Literal

import requests

from constants import WEBCORE_ENDPOINT
from feedback import FeedbackTO
from modelingassistantapp import LOGGING_FORMAT, LOGGING_LEVEL, TIMEOUT
from utils import cdm_diff, to_simplenamespace, warn, ClassDiagramDTO, AeReferenceType

USER_REGISTER_ENDPOINT = f"{WEBCORE_ENDPOINT}/user/public/register"
USER_LOGIN_ENDPOINT = f"{WEBCORE_ENDPOINT}/user/public/login"
USER_LOGOUT_ENDPOINT = f"{WEBCORE_ENDPOINT}/user/logout"

_USERNAME_PREFIX_LENGTH = 6

users: dict[str, User] = {}

logging.basicConfig(level=LOGGING_LEVEL, format=LOGGING_FORMAT)
logger = logging.getLogger(__name__)

class User:
    "Class to represent a user."
    def __init__(self, name: str, password):
        "Register a new user."
        if name in users:
            raise ValueError(f"Username {name} already exists.")
        self.name = name
        self.password = password
        self.token = self.get_token()
        self._logged_in = False
        users[name] = self

    def get_token(self):
        "Get the user's token."
        response = requests.put(USER_REGISTER_ENDPOINT, json=self._auth_creds, timeout=TIMEOUT)
        if not response.ok:
            raise ValueError(f"Could not get token for user {self.name}.\nError: {response.text}")
        return response.text.strip().removeprefix("User registered. Your authorization token is '").removesuffix(
            "'. Please embed this token in the header as 'Authorization : Bearer <token>' for the subsequent requests.")

    def login(self) -> bool:
        "Login the user and update their token if needed."
        response = requests.post(USER_LOGIN_ENDPOINT, headers=self._auth_header, json=self._auth_creds, timeout=TIMEOUT)
        if not response.ok:
            return False
        self.token = response.text.strip().removeprefix("Logged in. Your authorization token is '").removesuffix(
            "'. Please embed this token in the header as 'Authorization : Bearer <token>' for the subsequent requests.")
        self._logged_in = True
        return True

    def logout(self) -> bool:
        "Logout the user."
        response = requests.post(USER_LOGOUT_ENDPOINT, headers=self._auth_header, timeout=TIMEOUT)
        if not response.ok:
            return False
        del self.token  # token invalidated in WebCORE, so get rid of here on the client side as well
        self._logged_in = False
        return True

    @property
    def logged_in(self):
        "Return True if the user is logged in."
        return self._logged_in

    @property
    def _auth_creds(self):
        "Return the user's authorization credentials."
        return {"username": self.name, "password": self.password}

    @property
    def _auth_header(self):
        "Get the user's authorization header."
        return {"Authorization": f"Bearer {self.token}"} if hasattr(self, "token") else {}

    @classmethod
    def create_random(cls):
        "Create a user with a random name and password, useful for testing."
        # fully ensure unique name for new user by using current timestamp
        name = f"{''.join(random.sample(ascii_lowercase, _USERNAME_PREFIX_LENGTH))}{int(time())}"
        password = secrets.token_urlsafe(16)
        return cls(name, password)  # use cls here to allow the creation of User subclasses

    def __repr__(self) -> str:
        # TODO token returned for debugging only, remove before release
        return f'{self.__class__.__name__}(name="{self.name}", token="{self.token}")'


class MockStudent(User):
    """
    Mock student used for testing.
    This represents a student who only interacts with the application via the frontend.
    """
    def __init__(self, name: str, password):
        super().__init__(name, password)
        self.student = None  # possible pointer to a Student metamodel instance for future integration tests
        self._cdm: ClassDiagramDTO = None  # internal CDM cache to minimize requests to WebCORE

    def create_cdm(self, name: str) -> bool:
        "Create a student class diagram."
        resp = requests.put(self.cdm_endpoint(name), headers=self._auth_header, timeout=TIMEOUT)
        return resp.ok

    def create_class(self, cdm_name: str, cls_name: str) -> str:
        "Create a class with the given name in the given class diagram belonging to the student and return its _id."
        old_cdm = self.get_cdm(cdm_name)
        old_class_mapping = old_cdm.get_class_names_by_ids()
        resp = requests.post(f"{self.cdm_endpoint(cdm_name)}/class", headers=self._auth_header, timeout=TIMEOUT,
                             json={"className": cls_name, "dataType": False, "isInterface": False,
                                   "x": randint(0, 600), "y": randint(0, 600)})
        resp.raise_for_status()
        new_cdm = self.get_cdm(cdm_name)
        new_cdm_mapping = new_cdm.get_class_names_by_ids()
        new_ids: set[str] = new_cdm_mapping.keys() - old_class_mapping
        if len(new_ids) != 1:
            warn(f"MockStudent.create_class(): The number of new _ids is {len(new_ids)} instead of 1.")
        cls_id = new_ids.pop()
        logger.debug(f"MockStudent: Created class with _id {cls_id}")
        return cls_id

    def delete_class(self, cdm_name: str, cls_id: str):
        "Delete the class with the given _id from the given class diagram belonging to the student."
        resp = requests.delete(f"{self.cdm_endpoint(cdm_name)}/class/{cls_id}", headers=self._auth_header,
                               timeout=TIMEOUT)
        resp.raise_for_status()

    def create_attribute(self, cdm_name: str, cls_id: str, attr_name: str, attr_type: type | str) -> str:
        "Create an attribute with the given name and return its _id."
        old_cdm = self.get_cdm(cdm_name)
        resp = requests.post(f"{self.cdm_endpoint(cdm_name)}/class/{cls_id}/attribute", headers=self._auth_header,
                             json={"rankIndex": 0, "typeId": old_cdm.type_id_for(attr_type),
                                   "attributeName": attr_name}, timeout=TIMEOUT)
        resp.raise_for_status()
        new_cdm = self.get_cdm(cdm_name)
        logger.debug(cdm_diff(old_cdm, new_cdm))
        attr_id = cdm_diff(old_cdm, new_cdm).additions[0]
        logger.debug(f"MockStudent.create_attribute(): Returning {attr_id = }")
        return attr_id

    def delete_attribute(self, cdm_name: str, attr_id: str):
        "Delete the attribute from the given class."
        resp = requests.delete(f"{self.cdm_endpoint(cdm_name)}/class/attribute/{attr_id}",
                               headers=self._auth_header, timeout=TIMEOUT)
        resp.raise_for_status()

    def create_generalization(self, cdm_name: str, subclass_id: str, superclass_id: str) -> tuple[str, str]:
        "Create a generalization between the given subclass and superclass and return their _id's in that order."
        old_class_names = self._cdm.get_class_names_by_ids()
        subclass_name = old_class_names[subclass_id]
        superclass_name = old_class_names[superclass_id]
        resp = requests.post(f"{self.cdm_endpoint(cdm_name)}/association/supertype", headers=self._auth_header,
                                json={"subClassId": subclass_id, "superClassId": superclass_id}, timeout=TIMEOUT)
        resp.raise_for_status()
        # The _ids of the subclass and superclass may change, so we need a 2nd API call to GET the new ones
        new_class_ids = self.get_cdm(cdm_name).get_ids_by_class_names()
        subclass_id = new_class_ids[subclass_name]
        superclass_id = new_class_ids[superclass_name]
        return subclass_id, superclass_id

    def create_association(self, cdm_name: str,
        multiplicities1: int | tuple[int, int] = 1, class1_id: str = "", rolename1: str = "",
        multiplicities2: int | tuple[int, int] = 1, class2_id: str = "", rolename2: str = "",
        bidirectional: bool = True, reftype1: AeReferenceType = "Regular", reftype2: AeReferenceType = "Regular"
    ) -> tuple[str, str, str, str, str]:
        """
        Create an association with the given inputs, which are ordered in mostly the same way as Umple:

        multiplicities1, class1_id, rolename1, multiplicities2, class2_id, rolename2, bidrectional, reftype1, reftype2

        (The last three arguments are at the end because they are optional.)

        For example:

            1..2   Pilot      pilots  --   *   Airplane      airplanes

        -> (1, 2), pilot_id, "pilots",   MANY, airplane_id, "airplanes", Regular, Regular

        The return value is a 5-tuple: (class1_id, ae1_id, assoc_id, ae2_id, class2_id).
        """
        # pylint: disable=too-many-arguments, too-many-locals, protected-access
        def value_or_index(element: int | tuple[int, int], index=0) -> int:
            return element if isinstance(element, int) else element[index]

        if not class1_id or not class2_id:
            raise ValueError(f"MockStudent.create_association(): {class1_id = } and/or {class2_id = } not valid.")
        # AssociationEnd lower and upper bounds
        ae1lb, ae1ub = value_or_index(multiplicities1), value_or_index(multiplicities1, 1)  # eg,  1,  2
        ae2lb, ae2ub = value_or_index(multiplicities2), value_or_index(multiplicities2, 1)  # eg, -1, -1
        old_class_names = self._cdm.get_class_names_by_ids()
        class1_name = old_class_names[class1_id]
        class2_name = old_class_names[class2_id]
        old_assoc_mapping = self._cdm.get_associations_by_ids()
        # Rudimentary pluralization when upper bound is 2+ or -1 (*)
        rolename1 = rolename1 or f"{class1_name[0].lower()}{class1_name[1:]}{'s' if ae1ub != 1 else ''}"  # eg, pilots
        rolename2 = rolename2 or f"{class2_name[0].lower()}{class2_name[1:]}{'s' if ae2ub != 1 else ''}"  # eg, airpl.

        # Create the association itself
        resp = requests.post(f"{self.cdm_endpoint(cdm_name)}/association", headers=self._auth_header, timeout=TIMEOUT,
                             json={"fromClassId": class1_id, "toClassId": class2_id, "bidirectional": bidirectional})
        resp.raise_for_status()
        new_cdm = self.get_cdm(cdm_name)
        ids_by_class_names = new_cdm.get_ids_by_class_names()
        class1_id = ids_by_class_names[class1_name]
        class2_id = ids_by_class_names[class2_name]
        class2_ae_ids = [ae._id for ae in new_cdm[class2_id].associationEnds]
        new_assoc_mapping = new_cdm.get_associations_by_ids()
        new_assoc_ids: set[str] = new_assoc_mapping.keys() - old_assoc_mapping
        if len(new_assoc_ids) != 1:
            warn(f"MockStudent.create_association(): The number of new _ids is {len(new_assoc_ids)} instead of 1.")
        assoc_id = new_assoc_ids.pop()
        assoc_end_ids: list[str] = new_cdm[assoc_id].ends
        # ae1 here means the association end that refers to class1 and is contained in class2
        ae1 = assoc_end_ids[0] if assoc_end_ids[0] in class2_ae_ids else assoc_end_ids[1]  # eg, Airplane.pilots
        ae2 = assoc_end_ids[0] if assoc_end_ids[0] != ae1 else assoc_end_ids[1]            # eg, Pilot.airplanes

        # Set the multiplicities of the association ends if different from 1 (the default)
        for ae, lb, ub in ((ae1, ae1lb, ae1ub), (ae2, ae2lb, ae2ub)):
            if not lb == ub == 1:  # if both are 1, save an API call
                resp = requests.put(f"{self.cdm_endpoint(cdm_name)}/association/end/{ae}/multiplicity", timeout=TIMEOUT,
                                    headers=self._auth_header, json={"lowerBound": lb, "upperBound": ub})
                resp.raise_for_status()

        # Set the rolenames of the association ends
        for ae, rolename in ((ae1, rolename1), (ae2, rolename2)):
            resp = requests.put(f"{self.cdm_endpoint(cdm_name)}/association/end/{ae}/rolename", timeout=TIMEOUT,
                                headers=self._auth_header, json={"roleName": rolename})
            resp.raise_for_status()

        # Set the reference types of the association ends if not Regular (the default)
        for ae, reftype in ((ae1, reftype1), (ae2, reftype2)):
            if reftype != "Regular":
                resp = requests.put(f"{self.cdm_endpoint(cdm_name)}/association/end/{ae}/referencetype",
                                    headers=self._auth_header, timeout=TIMEOUT, json={"referenceType": reftype})
                resp.raise_for_status()

        # eg, Pilot, Airplane.pilots, Pilot_Airplane, Pilot.airplanes, Airplane
        return (class1_id, ae1, assoc_id, ae2, class2_id)

    def create_composition(self, cdm_name: str,
        whole_multiplicities: Literal[1] | tuple[Literal[0], Literal[1]] = 1, whole_class_id: str = "",
        whole_rolename: str = "", part_multiplicities: int | tuple[int, int] = 1, part_class_id: str = "",
        part_rolename: str = "", bidirectional: bool = True) -> tuple[str, str, str, str, str]:
        """
        Create a composition with the given inputs and return a 5-tuple,
        (whole_class_id, whole_ae_id, compos_id, part_ae_id, part_class_id). See create_association() for parameter
        details. Note that the AssociationEnd with the part_rolename refers to the Part class and is contained in the
        Whole class and has the Composition ReferenceType.

        Example:
        ```
        1  Car car <@>- 1 Engine engine
        |   |   |       |    |      |
        |   |   |       |  Part     |
        |   |   |       |           |
        | Whole | part_multiplicity |
        |       |                   |
        |  whole_rolename           |
        |                           |
        whole_multiplicity    part_rolename (composend)
        ```
        """
        # pylint: disable=too-many-arguments
        return self.create_association(
            cdm_name, whole_multiplicities, whole_class_id, whole_rolename, part_multiplicities, part_class_id,
            part_rolename, bidirectional, "Regular", "Composition")

    def create_aggregation(self, cdm_name: str,
        whole_multiplicities: Literal[1] | tuple[Literal[0], Literal[1]] = 1, whole_class_id: str = "",
        whole_rolename: str = "", part_multiplicities: int | tuple[int, int] = 1, part_class_id: str = "",
        part_rolename: str = "", bidirectional: bool = True) -> tuple[str, str, str, str, str]:
        """
        Create an aggregation with the given inputs and return a 5-tuple,
        (whole_class_id, whole_ae_id, aggr_id, part_ae_id, part_class_id). See the methods above for parameter details.
        """
        # pylint: disable=too-many-arguments
        return self.create_association(
            cdm_name, whole_multiplicities, whole_class_id, whole_rolename, part_multiplicities, part_class_id,
            part_rolename, bidirectional, "Regular", "Aggregation")

    def request_feedback(self, cdm_name: str) -> FeedbackTO:
        "Request feedback from the Modeling Assistant via WebCORE."
        resp = requests.get(f"{self.cdm_endpoint(cdm_name)}/feedback", headers=self._auth_header, timeout=TIMEOUT)
        print(f"{resp.text = }")
        resp.raise_for_status()
        feedback_json = resp.json()
        return FeedbackTO(**feedback_json)

    def get_cdm(self, cdm_name: str) -> ClassDiagramDTO:
        "Get the student's class diagram with the given name from WebCORE in JSON format."
        resp = requests.get(self.cdm_endpoint(cdm_name), headers=self._auth_header, timeout=TIMEOUT)
        resp.raise_for_status()
        self._cdm = ClassDiagramDTO(resp.json(object_hook=to_simplenamespace))
        logger.debug(self._cdm)
        return self._cdm

    def cdm_endpoint(self, cdm_name: str) -> str:
        "Return the class diagram endpoint for the student with the given name."
        return f"{WEBCORE_ENDPOINT}/{self.name}/classdiagram/{cdm_name}"
