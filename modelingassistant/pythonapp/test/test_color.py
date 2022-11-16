#!/usr/bin/env python3
"""
Module for color tests.
"""
# pylint: disable=wrong-import-position, wrong-import-order, missing-function-docstring

import sys
import os

import numpy as np

# this line is needed to be able to call this test directly, for debugging purposes
sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from color import Color


def test_color_init():
    assert Color("#ff0000") == Color("ff0000") == Color([1, 0, 0]) == Color((255, 0, 0)) == Color.RED


def test_color_to_hex():
    assert Color.RED.to_hex() == "#ff0000"
    assert Color((0, 1, 1)).to_hex() == "#00ffff"
    assert Color([186, 85, 211]).to_hex() == "#ba55d3"


def test_color_to_rgb():
    assert Color.RED.to_rgb() == (255, 0, 0)
    assert Color((0, 1, 1)).to_rgb() == (0, 255, 255)
    assert Color([186, 85, 211]).to_rgb() == (186, 85, 211)


def test_color_to_rgb1():
    assert np.isclose(Color.RED.to_rgb1(), (1.0, 0.0, 0.0)).all()
    assert np.isclose(Color((0, 1, 1)).to_rgb1(), (0.0, 1.0, 1.0)).all()
    assert np.isclose(Color([186, 85, 211]).to_rgb1(), (0.729411764705882, 0.333333333333333, 0.827450980392156)).all()


def test_color_call():
    esc8, esc16 = "\033", "\x1B"
    assert Color.RED("test")  in [f"{esc8}[91mtest{esc8}[0m", f"{esc16}[91mtest{esc16}[0m"]
    assert Color.CYAN("test") in [f"{esc8}[96mtest{esc8}[0m", f"{esc16}[96mtest{esc16}[0m"]
