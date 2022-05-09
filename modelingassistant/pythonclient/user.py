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
from utils import cdm_diff, to_simplenamespace, ClassDiagramDTO

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
        response = requests.put(USER_REGISTER_ENDPOINT, json={"username": self.name, "password": self.password})
        if not response.ok:
            raise ValueError(f"Could not get token for user {self.name}.\nError: {response.text}")
        return response.text.strip().removeprefix("User registered. Your authorization token is '").removesuffix(
            "'. Please embed this token in the header as 'Authorization : Bearer <token>' for the subsequent requests.")

    def login(self) -> bool:
        "Login the user and update their token if needed."
        response = requests.post(USER_LOGIN_ENDPOINT, headers={"Authorization": f"Bearer {self.token}"},
                                 json={"username": self.name, "password": self.password})
        if not response.ok:
            return False
        self.token = response.text.strip().removeprefix("Logged in. Your authorization token is '").removesuffix(
            "'. Please embed this token in the header as 'Authorization : Bearer <token>' for the subsequent requests.")
        self._logged_in = True
        return True

    def logout(self) -> bool:
        "Logout the user."
        response = requests.post(USER_LOGOUT_ENDPOINT, headers={"Authorization": f"Bearer {self.token}"})
        if not response.ok:
            return False
        del self.token  # token invalidated in WebCORE, so get rid of here on the client side as well
        self._logged_in = False
        return True

    @property
    def logged_in(self):
        "Check if the user is logged in."
        return self._logged_in

    @classmethod
    def create_random(cls):
        "Create a user with a random name and password, useful for testing."
        # fully ensure unique name for new user by using current timestamp
        name = f"{''.join(random.sample(ascii_lowercase, _USERNAME_PREFIX_LENGTH))}{int(time())}"
        password = secrets.token_urlsafe(16)
        return cls(name, password)  # use cls here to allow the creation of User subclasses


class MockStudent(User):
    """
    Mock student used for testing.
    This represents a student who only interacts with the application via the frontend.
    """
    def __init__(self, name: str, password, file_name: str = ""):
        super().__init__(name, password)
        self.student = None  # possible pointer to a Student metamodel instance for future integration tests
        self.file_name: str = file_name  # assume one file name for now

    def create_cdm(self):
        "Create a student class diagram."
        # At the moment, there is exactly one file in WebCORE, so reset it instead
        requests.post(f"{self.cdm_endpoint()}/reset")

    def create_class(self, name: str) -> str:
        "Create a class with the given name and return its _id."
        old_cdm = self.get_cdm()
        resp = requests.post(f"{self.cdm_endpoint()}/class",
                             json={"className": name, "dataType": False, "isInterface": False,
                                   "x": randint(0, 600), "y": randint(0, 600)})
        resp.raise_for_status()
        new_cdm = self.get_cdm()
        # logger.debug(f"old_cdm: {old_cdm}")
        # logger.debug(f"new_cdm: {new_cdm}")
        logger.debug(cdm_diff(old_cdm, new_cdm))
        cls_id = cdm_diff(old_cdm, new_cdm).additions[0]
        logger.debug(f"MockStudent: Created class with _id {cls_id}")
        return cls_id

    def delete_class(self, cls_id: str):
        "Delete the class with the given _id."
        resp = requests.delete(f"{self.cdm_endpoint()}/class/{cls_id}")
        resp.raise_for_status()

    def create_attribute(self, cls_id: str, name: str, attr_type: type) -> str:
        "Create an attribute with the given name and return its _id."
        old_cdm = self.get_cdm()
        resp = requests.post(f"{self.cdm_endpoint()}/class/{cls_id}/attribute",
                             json={"rankIndex": 0, "typeId": old_cdm.type_id_for(attr_type), "attributeName": name})
        resp.raise_for_status()
        new_cdm = self.get_cdm()
        logger.debug(cdm_diff(old_cdm, new_cdm))
        attr_id = cdm_diff(old_cdm, new_cdm).additions[0]
        logger.debug(f"Returning {attr_id}")
        return attr_id

    def request_feedback(self) -> FeedbackTO:
        "Request feedback from the Modeling Assistant via WebCORE."
        resp = requests.get(f"{self.cdm_endpoint()}/feedback")
        print(f"{resp.text = }")
        feedback_json = resp.json()
        print(feedback_json)
        return FeedbackTO(**feedback_json)

    def get_cdm(self) -> ClassDiagramDTO:
        "Get the class diagram from WebCORE in json format."
        resp = requests.get(self.cdm_endpoint())
        resp.raise_for_status()
        cdm = ClassDiagramDTO(resp.json(object_hook=to_simplenamespace))
        logger.debug(cdm.get_class_names_by_ids())
        return cdm

    def cdm_endpoint(self) -> str:
        "Return the class diagram endpoint for the student, assuming there is only one (for now)."
        return f"{WEBCORE_ENDPOINT}/classdiagram/{self.file_name.removesuffix('.cdm')}"
