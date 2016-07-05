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
from setuptools import setup, find_packages
import puffotter.metadata as metadata


def readme() -> str:
    """
    Reads the readme file.

    :return: the readme file as a string
    """
    try:
        # noinspection PyPackageRequirements
        import pypandoc
        with open('README.md') as f:
            # Convert markdown file to rst
            markdown = f.read()
            rst = pypandoc.convert(markdown, 'rst', format='md')
            return rst
    except (OSError, ImportError):
        # If pandoc is not installed, just return the raw markdown text
        with open('README.md') as f:
            return f.read()


setup(name=metadata.project_name,
      version=metadata.version_number,
      description=metadata.project_description,
      long_description=readme(),
      classifiers=[metadata.development_status,
                   metadata.audience,
                   metadata.license_identifier,
                   metadata.programming_language,
                   metadata.topic,
                   metadata.language,
                   metadata.compatible_os,
                   metadata.environment
                   ],
      url=metadata.project_url,
      download_url=metadata.download_url,
      author=metadata.author_name,
      author_email=metadata.author_email,
      license=metadata.license_type,
      packages=find_packages(),
      install_requires=metadata.python3_requirements,
      dependency_links=[],
      test_suite='nose.collector',
      tests_require=['nose'],
      scripts=[],
      zip_safe=False)
