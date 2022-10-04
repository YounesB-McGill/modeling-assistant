"""
Utility module to provide color conversions and colors for highlighting elements in a diagram and for printing colorful
debug output. 🌈
"""
# pylint: disable=multiple-statements

from __future__ import annotations

import re


class Color:
    "Class to represent colors in various formats."
    _MAX_VAL = 255  # 2^8 - 1
    _ENDC = "\033[0m"
    from_name: dict[str, Color] = {}

    # declare the color constants here for linting purposes
    VIOLET: Color; BLUE: Color; CYAN: Color; GREEN: Color; YELLOW: Color; ORANGE: Color; RED: Color
    LIGHT_BLUE: Color; LEMON_CHIFFON: Color; PEACH_PUFF: Color; PINK: Color
    LIGHT_YELLOW: Color; LIGHT_ORANGE: Color; LIGHT_RED: Color

    def __init__(self, value: str | list[int] | tuple[int, int, int] | list[float] | tuple[float, float, float],
                 name: str = "", ansi_code: str = ""):
        match value:
            case str():
                value = value.removeprefix("#")
                if not re.fullmatch(r"[0-9a-fA-F]{6}", value):
                    raise ValueError(f'Invalid color hex value: {value}, expected 6 hex digits in the form "#RRGGBB"')
                # change from hexadecimal (base 16) to decimal, eg, 0xff -> 255
                self.r, self.g, self.b = int(value[0:2], 16), int(value[2:4], 16), int(value[4:6], 16)
            case (r, g, b) | [r, g, b]:
                if not all(0 <= c <= Color._MAX_VAL for c in (r, g, b)):
                    raise ValueError(f"Invalid color RGB value: {value}, expected 3 integers in the range [0, 255] or "
                                      "3 floats in the range [0.0, 1.0]")
                if max(r, g, b) > 1:
                    self.r, self.g, self.b = int(r), int(g), int(b)
                else:
                    self.r, self.g, self.b = int(Color._MAX_VAL * r), int(Color._MAX_VAL * g), int(Color._MAX_VAL * b)
            case _:
                raise ValueError(f'Invalid color value: {value}, allowed formats are "#RRGGBB", (r, g, b), [r, g, b]')
        self.ansi_code = ansi_code
        self.name = name
        if name:
            Color.from_name[name] = self

    def to_hex(self) -> str:
        'Return the color as a hexadecimal string in the form "#RRGGBB".'
        return f"#{self.r:02x}{self.g:02x}{self.b:02x}"

    def to_rgb(self) -> tuple[int, int, int]:
        "Return the color as an RGB tuple, with each value in the range [0, 255]."
        return self.r, self.g, self.b

    def to_rgb1(self) -> tuple[float, float, float]:
        "Return the color as an RGB tuple, with each value in the range [0.0, 1.0]."
        return self.r / Color._MAX_VAL, self.g / Color._MAX_VAL, self.b / Color._MAX_VAL

    def __call__(self, text: str) -> str:
        """
        Return the text with the ANSI color code prepended and the reset code appended, useful for printing to console.

        Example: Color.RED("This text will be red")
        """
        if not self.ansi_code:
            return text
        return f"{self.ansi_code}{text}{Color._ENDC}"

    def __repr__(self) -> str:
        if self in Color.from_name.values():
            return self.name
        return f"Color({self.r}, {self.g}, {self.b})"

    def __eq__(self, __o: object) -> bool:
        if not isinstance(__o, Color):
            return False
        return self.r == __o.r and self.g == __o.g and self.b == __o.b


# Standard colors, where the names match the HTML color names
Color.VIOLET = Color("#ee82ee", "violet", "\033[95m")
Color.BLUE   = Color("#0000ff", "blue",   "\033[94m")
Color.CYAN   = Color("#00ffff", "cyan",   "\033[96m")
Color.GREEN  = Color("#008000", "green",  "\033[92m")
Color.YELLOW = Color("#ffff00", "yellow", "\033[93m")
Color.ORANGE = Color("#ffa500", "orange", "\u001b[31;1m")
Color.RED    = Color("#ff0000", "red",    "\033[91m")

# Lighter colors, used for highlighting items on a light background
Color.LIGHT_BLUE    = Color("#add8e6", "lightblue")
Color.LEMON_CHIFFON = Color("#fffacd", "lemonchiffon")
Color.PEACH_PUFF    = Color("#ffdab9", "peachpuff")
Color.PINK          = Color("#ffc0cb", "pink")

# Aliases for better readability
Color.LIGHT_YELLOW = Color.LEMON_CHIFFON
Color.LIGHT_ORANGE = Color.PEACH_PUFF
Color.LIGHT_RED    = Color.PINK
