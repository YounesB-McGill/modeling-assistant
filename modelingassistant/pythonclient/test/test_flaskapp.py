#!/usr/bin/env python3

import json

def test_helloworld(app, client):
    "Simple test for the helloworld dummy endpoint to ensure the REST service is working."
    res = client.get("/helloworld/alice")
    assert res.status_code == 200
    expected = {"hello": "alice"}
    assert expected == json.loads(res.get_data(as_text=True))


if __name__ == "__main__":
    "Main entry point."
