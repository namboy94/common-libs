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


class Colors(object):
    """
    Class that offers the ANSI Color code escape sequences
    """
    # Foregrounds
    DEFAULT_FG = '\033[39m'
    BLACK_FG = '\033[30m'
    RED_FG = '\033[31m'
    GREEN_FG = '\033[32m'
    YELLOW_FG = '\033[33m'
    BLUE_FG = '\033[34m'
    MAGENTA_FG = '\033[35m'
    CYAN_FG = '\033[36m'
    LIGHT_GRAY_FG = '\033[37m'
    DARK_GRAY_FG = '\033[90m'
    LIGHT_RED_FG = '\033[91m'
    LIGHT_GREEN_FG = '\033[92m'
    LIGHT_YELLOW_FG = '\033[93m'
    LIGHT_BLUE_FG = '\033[94m'
    LIGHT_MAGENTA_FG = '\033[95m'
    LIGHT_CYAN_FG = '\033[96m'
    WHITE_FG = '\033[97m'

    # Backgrounds
    DEFAULT_BG = '\033[49m'
    BLACK_BG = '\033[40m'
    RED_BG = '\033[41m'
    GREEN_BG = '\033[42m'
    YELLOW_BG = '\033[43m'
    BLUE_BG = '\033[44m'
    MAGENTA_BG = '\033[45m'
    CYAN_BG = '\033[46m'
    LIGHT_GRAY_BG = '\033[47m'
    DARK_GRAY_BG = '\033[100m'
    LIGHT_RED_BG = '\033[101m'
    LIGHT_GREEN_BG = '\033[102m'
    LIGHT_YELLOW_BG = '\033[103m'
    LIGHT_BLUE_BG = '\033[104m'
    LIGHT_MAGENTA_BG = '\033[105m'
    LIGHT_CYAN_BG = '\033[106m'
    WHITE_BG = '\033[107m'

escape = '\033[0m'
"""
The ANSI escape sequence that stops the colorizing
"""


def print_string_in_color(string: str, color: str) -> None:
    """
    Prints a string in a specified color
    :param string: the string to print
    :param color: the color to use. Uses an ANSI escape sequence to colorize the text in Unix-like
                    terminals and also on MS Windows if ansi.sys is enabled
    :return: None
    """
    print(color + string + escape)
