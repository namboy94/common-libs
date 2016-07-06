# Puffotter

Puffotter is a python library containing various helper methods and classes to streamline
other project's code.

This library does not offer any kind of stable API, everything is subject to change.
Most use cases will be rather specific, or can easily be implemented by itself.

For example:

```python
import os

def ensure_directory_exists(directory):

    if not os.path.isdir(directory):
        os.makedirs(directory)
```

This can easily be implemented on its own, but if this kind of call is very common
in a project, it might make sense to use this method as a means to avoid cluttering the
code base with unnecessarily verbose code.
