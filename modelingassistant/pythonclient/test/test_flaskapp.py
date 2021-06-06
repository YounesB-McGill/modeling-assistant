#!/usr/bin/env python3

import json

def test_index(app, client):
    res = client.get('/helloworld')
    assert res.status_code == 200
    expected = {'hello': 'world'}
    assert expected == json.loads(res.get_data(as_text=True))


if __name__ == '__main__':
    "Main entry point."
