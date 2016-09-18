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
import sqlite3


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


def ensure_directory_exists(directory_path: str) -> None:
    """
    Ensures that a directory exists, and creates it if it does not

    :param directory_path: the path to the directory to ensure the existence of.
    :return: None
    """
    if not os.path.isdir(directory_path):
        os.makedirs(directory_path)


def ensure_file_exists(file_path: str) -> None:
    """
    Ensures that a file exists, and creates it if it does not

    :param file_path: the path to the file to ensure the existence of.
    :return: None
    """
    if not os.path.isfile(file_path):
        open(file_path, 'w').close()


def ensure_sqlite3_db_exists(database_path: str, initialization: str = None, delete_existing_file: bool = False) -> None:
    """
    Ensures that an SQLite 3 database exists
    :param database_path: the path to the database file
    :param initialization: The initialization command of the database
    :param delete_existing_file: If there is already a file at that location, this can be set to replace
            the existing file with an SQLite database
    :return: None
    """
    file_exists_and_is_not_database = False

    if os.path.isfile(database_path):
        try:
            with open(database_path, 'rb') as database:
                header = database.read(100)
                file_exists_and_is_not_database = header[:16] != b'SQLite format 3\x00'
        except IndexError:
            file_exists_and_is_not_database = True

    if file_exists_and_is_not_database and delete_existing_file:
        os.remove(database_path)

    if not os.path.isfile(database_path):
        sql = sqlite3.connect(database_path)

        if initialization is not None:
            sql.execute(initialization)
            sql.commit()

        sql.close()


def sanitize_filename(filename: str) -> str:
    """
    Sanitizes a filename to avoid file system errors

    :param filename: the filename to sanitize
    :return:         the sanitized filename
    """
    sanitized = filename
    illegal_characters = ['/', '\\', '?', '<', '>', ':', '*', '|', "\"", '^']
    for illegal_character in illegal_characters:
        sanitized = sanitized.replace(illegal_character, "")
    return sanitized
