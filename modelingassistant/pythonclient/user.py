"""
Module to manage users.
"""

from __future__ import annotations

import random
import secrets
from string import ascii_lowercase
from time import time

import requests

from constants import WEBCORE_ENDPOINT

USER_REGISTER_ENDPOINT = f"{WEBCORE_ENDPOINT}/user/public/register"

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
        self.student = None  # to be linked to 0 or 1 Student metamodel instances in the future
        users[name] = self

    def get_token(self):
        "Get the user's token."
        response = requests.put(USER_REGISTER_ENDPOINT, json={"username": self.name, "password": self.password})
        if not response.ok:
            raise ValueError(f"Could not get token for user {self.name}.\nError: {response.text}")
        return response.text.strip().removeprefix("User registered. Your authorization token is '").removesuffix(
            "'. Please embed this token in the header as 'Authorization : Bearer <token>' for the subsequent requests.")

    @staticmethod
    def create_random_user():
        "Create a user with a random name and password, useful for testing."
        # fully ensure unique name for new user by using current timestamp
        name = f"{random.sample(ascii_lowercase, _USERNAME_PREFIX_LENGTH)}{int(time())}"
        password = secrets.token_urlsafe(16)
        return User(name, password)
