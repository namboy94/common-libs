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
    BLUE = '\033[94m'

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