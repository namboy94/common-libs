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
import os
import shutil


def move_file(file: str, location: str) -> str:
    """
    Moves a file to a new location, keeping the same file name and extension

    :param location: the new location of the file (This is a file system path to a directory)
    :param file: the file to be moved (This is a file system path to a file)
    :return: the path to the moved file
    """

    file_name = os.path.basename(file)  # Get the file name
    new_file = os.path.join(location, file_name)  # Generate the new file path
    print("Moving " + file_name + " to " + location)  # Print a helpful message to the console
    shutil.move(file, new_file)  # Move the file

    return new_file  # return the new file path so that the caller can process it further


def rename_file(file: str, new_name: str) -> str:
    """
    Renames a file to a new file name, keeping the extension and file path.

    :param file: the file to be renamed
    :param new_name: the new name of the file
    """
    original_file_name = os.path.basename(file)  # Get the original file name (for calc'ing the extension)
    extension = os.path.splitext(original_file_name)[1]  # Get the file extension
    new_file = os.path.join(os.path.dirname(file), new_name + extension)  # Calculate the new file path
    print("renaming file " + file + " to " + new_name)  # Print to console what is happening
    shutil.move(file, new_file)  # Rename the file
    return new_file  # Return the new path to the file
