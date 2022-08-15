#!/usr/bin/env python3

# pylint: disable=unused-argument
"""
Tests for the Modeling Assistant REST endpoints.
"""

import json

from modelingassistant import ModelingAssistant
from stringserdes import str_to_modelingassistant


def test_helloworld(app, client):
    "Simple test for the helloworld dummy endpoint to ensure the REST service is working."
    res = client.get("/helloworld/alice")
    assert res.status_code == 200
    expected = {"hello": "alice"}
    assert expected == json.loads(res.get_data(as_text=True))


def test_modelingassistant(app, client):
    "Test the (provisional) modelingassistant endpoint."
    # Test the modeling assistant endpoint.
    res = client.get("/modelingassistant")
    assert res.status_code == 200
    response = json.loads(res.get_data(as_text=True))
    assert "modelingAssistantXmi" in response
    assert "<modelingassistant:ModelingAssistant" in response["modelingAssistantXmi"]
    assert isinstance(str_to_modelingassistant(response["modelingAssistantXmi"]), ModelingAssistant)


if __name__ == "__main__":
    "Main entry point."
