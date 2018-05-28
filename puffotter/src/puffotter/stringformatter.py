"""
LICENSE:
Copyright 2016 Hermann Krumrey

This file is part of puffotter.

    puffotter is a python library that includes various helper methods to simplify
    and de-clutter other projects.

    puffotter is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    puffotter is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with puffotter.  If not, see <http://www.gnu.org/licenses/>.
LICENSE
"""

# imports
from typing import List


class ForegroundColors(object):
    """
    Class that offers the ANSI escape sequences for foreground colours
    """

    DEFAULT = '\033[39m'
    BLACK = '\033[30m'
    RED = '\033[31m'
    GREEN = '\033[32m'
    YELLOW = '\033[33m'
    BLUE = '\033[34m'
    MAGENTA = '\033[35m'
    CYAN = '\033[36m'
    LIGHT_GRAY = '\033[37m'
    DARK_GRAY = '\033[90m'
    LIGHT_RED = '\033[91m'
    LIGHT_GREEN = '\033[92m'
    LIGHT_YELLOW = '\033[93m'
    LIGHT_BLUE = '\033[94m'
    LIGHT_MAGENTA = '\033[95m'
    LIGHT_CYAN = '\033[96m'
    WHITE = '\033[97m'


class BackgroundColors(object):
    """
    Class that offers the ANSI escape sequences for foreground colours
    """

    DEFAULT = '\033[49m'
    BLACK = '\033[40m'
    RED = '\033[41m'
    GREEN = '\033[42m'
    YELLOW = '\033[43m'
    BLUE = '\033[44m'
    MAGENTA = '\033[45m'
    CYAN = '\033[46m'
    LIGHT_GRAY = '\033[47m'
    DARK_GRAY = '\033[100m'
    LIGHT_RED = '\033[101m'
    LIGHT_GREEN = '\033[102m'
    LIGHT_YELLOW = '\033[103m'
    LIGHT_BLUE = '\033[104m'
    LIGHT_MAGENTA = '\033[105m'
    LIGHT_CYAN = '\033[106m'
    WHITE = '\033[107m'


class GeneralFormatting(object):
    """
    class that offers the ANSI escape sequences for standard formatting stuff like bold text
    Also contains the END escape sequence used to end the formatting
    """

    END = '\033[0m'


def print_formatted_string(string: str, formatting: List[str] or str) -> None:
    """
    Prints a formatted string
    :param string: the string to print
    :param formatting: a list of ANSI escape sequences to be applied to th
    :return: None
    """
    start = ""
    end = ""
    if isinstance(formatting, list):
        for ansi_escape_sequence in formatting:
            start += ansi_escape_sequence
            end += GeneralFormatting.END
    else:
        start = formatting
        end = GeneralFormatting.END

    print(start + string + end)
