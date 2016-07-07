from puffotter.metadata import version_number

extensions = [
    'sphinx.ext.autodoc',
    'sphinx.ext.intersphinx',
    'sphinx.ext.todo',
    'sphinx.ext.ifconfig',
    'sphinx.ext.viewcode'
]

templates_path = ['.templates']
source_suffix = '.rst'
master_doc = 'index'

project = 'puffotter'
copyright = '2016, Hermann Krumrey'
author = 'Hermann Krumrey'

version = version_number
release = version_number

language = None
exclude_patterns = []
pygments_style = 'sphinx'
todo_include_todos = False


html_theme = 'alabaster'
html_static_path = ['.static']
htmlhelp_basename = 'puffotterdoc'

latex_elements = {
}
latex_documents = [
    (master_doc, 'puffotter.tex', 'puffotter Documentation',
     'Hermann Krumrey', 'manual'),
]

man_pages = [
    (master_doc, 'puffotter', 'puffotter Documentation',
     [author], 1)
]

texinfo_documents = [
    (master_doc, 'puffotter', 'puffotter Documentation',
     author, 'puffotter', 'One line description of project.',
     'Miscellaneous'),
]

epub_title = project
epub_author = author
epub_publisher = author
epub_copyright = copyright
epub_exclude_files = ['search.html']