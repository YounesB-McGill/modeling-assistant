"""
Configuration for pytests.
"""
import pytest
from flaskapp import app as flask_app

@pytest.fixture
def app():
    "Return the Flask app instance."
    yield flask_app


@pytest.fixture
def client(app):
    "Return the result of the app's client test."
    return app.test_client()
