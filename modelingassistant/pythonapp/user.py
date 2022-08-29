"""
Module to manage users.
"""

from __future__ import annotations

import random
import secrets
from random import randint
from string import ascii_lowercase
from time import time

import requests

from constants import WEBCORE_ENDPOINT
from feedback import FeedbackTO
from modelingassistant_app import logger
from utils import cdm_diff, to_simplenamespace, warn, ClassDiagramDTO

USER_REGISTER_ENDPOINT = f"{WEBCORE_ENDPOINT}/user/public/register"
USER_LOGIN_ENDPOINT = f"{WEBCORE_ENDPOINT}/user/public/login"
USER_LOGOUT_ENDPOINT = f"{WEBCORE_ENDPOINT}/user/logout"

_USERNAME_PREFIX_LENGTH = 6

users: dict[str, User] = {}

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
        response = requests.put(USER_REGISTER_ENDPOINT, json=self._auth_creds)
        if not response.ok:
            raise ValueError(f"Could not get token for user {self.name}.\nError: {response.text}")
        return response.text.strip().removeprefix("User registered. Your authorization token is '").removesuffix(
            "'. Please embed this token in the header as 'Authorization : Bearer <token>' for the subsequent requests.")

    def login(self) -> bool:
        "Login the user and update their token if needed."
        response = requests.post(USER_LOGIN_ENDPOINT, headers=self._auth_header, json=self._auth_creds)
        if not response.ok:
            return False
        self.token = response.text.strip().removeprefix("Logged in. Your authorization token is '").removesuffix(
            "'. Please embed this token in the header as 'Authorization : Bearer <token>' for the subsequent requests.")
        self._logged_in = True
        return True

    def logout(self) -> bool:
        "Logout the user."
        response = requests.post(USER_LOGOUT_ENDPOINT, headers=self._auth_header)
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
        resp = requests.put(self.cdm_endpoint(name), headers=self._auth_header)
        return resp.ok

    def create_class(self, cdm_name: str, cls_name: str) -> str:
        "Create a class with the given name in the given class diagram belonging to the student and return its _id."
        old_cdm = self.get_cdm(cdm_name)
        old_class_mapping = old_cdm.get_class_names_by_ids()
        resp = requests.post(f"{self.cdm_endpoint(cdm_name)}/class", headers=self._auth_header,
                             json={"className": cls_name, "dataType": False, "isInterface": False,
                                   "x": randint(0, 600), "y": randint(0, 600)})
        resp.raise_for_status()
        new_cdm = self.get_cdm(cdm_name)
        new_cdm_mapping = new_cdm.get_class_names_by_ids()
        new_ids: set[str] = new_cdm_mapping.keys() - old_class_mapping
        if len(new_ids) != 1:
            warn(f"Student.create_class(): The number of new _ids is {len(new_ids)} instead of 1.")
        cls_id = new_ids.pop()
        logger.debug(f"MockStudent: Created class with _id {cls_id}")
        return cls_id

    def delete_class(self, cdm_name: str, cls_id: str):
        "Delete the class with the given _id from the given class diagram belonging to the student."
        resp = requests.delete(f"{self.cdm_endpoint(cdm_name)}/class/{cls_id}", headers=self._auth_header)
        resp.raise_for_status()

    def create_attribute(self, cdm_name: str, cls_id: str, attr_name: str, attr_type: type | str) -> str:
        "Create an attribute with the given name and return its _id."
        old_cdm = self.get_cdm(cdm_name)
        resp = requests.post(f"{self.cdm_endpoint(cdm_name)}/class/{cls_id}/attribute", headers=self._auth_header,
                             json={"rankIndex": 0, "typeId": old_cdm.type_id_for(attr_type),
                                   "attributeName": attr_name})
        resp.raise_for_status()
        new_cdm = self.get_cdm(cdm_name)
        logger.debug(cdm_diff(old_cdm, new_cdm))
        attr_id = cdm_diff(old_cdm, new_cdm).additions[0]
        logger.debug(f"MockStudent.create_attribute(): Returning {attr_id = }")
        return attr_id

    def delete_attribute(self, cdm_name: str, attr_id: str):
        "Delete the attribute from the given class."
        resp = requests.delete(f"{self.cdm_endpoint(cdm_name)}/class/attribute/{attr_id}",
                               headers=self._auth_header)
        resp.raise_for_status()

    def create_generalization(self, cdm_name: str, subclass_id: str, superclass_id: str) -> tuple[str, str]:
        "Create a generalization between the given subclass and superclass and return their _id's in that order."
        old_class_names = self._cdm.get_class_names_by_ids()
        subclass_name = old_class_names[subclass_id]
        superclass_name = old_class_names[superclass_id]
        resp = requests.post(f"{self.cdm_endpoint(cdm_name)}/association/supertype", headers=self._auth_header,
                                json={"subClassId": subclass_id, "superClassId": superclass_id})
        resp.raise_for_status()
        # The _ids of the subclass and superclass may change, so we need a 2nd API call to GET the new ones
        new_class_ids = self.get_cdm(cdm_name).get_ids_by_class_names()
        subclass_id = new_class_ids[subclass_name]
        superclass_id = new_class_ids[superclass_name]
        return subclass_id, superclass_id

    def request_feedback(self, cdm_name: str) -> FeedbackTO:
        "Request feedback from the Modeling Assistant via WebCORE."
        resp = requests.get(f"{self.cdm_endpoint(cdm_name)}/feedback", headers=self._auth_header)
        print(f"{resp.text = }")
        feedback_json = resp.json()
        return FeedbackTO(**feedback_json)

    def get_cdm(self, cdm_name: str) -> ClassDiagramDTO:
        "Get the student's class diagram with the given name from WebCORE in JSON format."
        resp = requests.get(self.cdm_endpoint(cdm_name), headers=self._auth_header)
        resp.raise_for_status()
        self._cdm = ClassDiagramDTO(resp.json(object_hook=to_simplenamespace))
        logger.debug(self._cdm.get_class_names_by_ids())
        return self._cdm

    def cdm_endpoint(self, cdm_name: str) -> str:
        "Return the class diagram endpoint for the student with the given name."
        return f"{WEBCORE_ENDPOINT}/{self.name}/classdiagram/{cdm_name}"
