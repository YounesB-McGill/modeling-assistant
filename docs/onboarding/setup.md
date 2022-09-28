## Setup Instructions

### Prerequisites

* Java 11+. <!-- Exact version TBD after mavenization, 17 in the future -->
* Python. See exact version required in `Pipfile`.
* The [`pipenv`](https://pipenv.pypa.io/) package manager (`pip install --user pipenv`).
  Use the [crude installation option](https://pipenv.pypa.io/en/latest/install/#crude-installation-of-pipenv)
  if the previous command fails.
* Recent version of
[Eclipse Modeling Tools](https://www.eclipse.org/downloads/packages/).
* [TouchCORE](https://bitbucket.org/mcgillram/touchram/src/master/)
sources on your local machine. <!-- To be reviewed after mavenization -->

### Setup

#### Eclipse Development Environment

0. `cd` into your Eclipse workspace and link the following TouchCORE projects to it using the following commands:
   ```bash
   ln -s <TouchCORE-sources-absolute-path>/touchram/ca.mcgill.sel.classdiagram/ ca.mcgill.sel.classdiagram
   ln -s <TouchCORE-sources-absolute-path>/touchram/ca.mcgill.sel.classdiagram.edit/ ca.mcgill.sel.classdiagram.edit
   ln -s <TouchCORE-sources-absolute-path>/touchram/ca.mcgill.sel.classdiagram.tests/ ca.mcgill.sel.classdiagram.tests
   ln -s <TouchCORE-sources-absolute-path>/core/ca.mcgill.sel.commons/ ca.mcgill.sel.commons
   ln -s <TouchCORE-sources-absolute-path>/core/ca.mcgill.sel.core/ ca.mcgill.sel.core
   ln -s <TouchCORE-sources-absolute-path>/core/ca.mcgill.sel.core.controller/ ca.mcgill.sel.core.controller
   ln -s <TouchCORE-sources-absolute-path>/core/ca.mcgill.sel.core.edit/ ca.mcgill.sel.core.edit
   ```

1. Clone or download this repository, which contains several Eclipse projects.
2. Import the following TouchCORE projects into your Eclipse
workspace:
   * ca.mcgill.sel.classdiagram
   * ca.mcgill.sel.classdiagram.edit
   * ca.mcgill.sel.classdiagram.editor
   * ca.mcgill.sel.classdiagram.tests
   * ca.mcgill.sel.commons
   * ca.mcgill.sel.core
   * ca.mcgill.sel.core.controller
   * ca.mcgill.sel.core.edit
3. Import all Modeling Assistant projects from this repo into the same Eclipse workspace.

**Note:** Depending on your system setup, some of the prerequisite 
projects in the Eclipse workspaces may indicate errors with the :x: 
icon. These errors can often be ignored.

Note that a previous version of this application also allowed visualization of
mistake types and their categories in a tree view. This functionality has been
removed from the main repo but can be accessed
[here](https://github.com/YounesB-McGill/modeling-assistant/releases/tag/ma-with-all-mistake-types-and-umple-mm).

#### Python Environment

**One-time setup:** In the repo root, run `pipenv install` to install dependencies.
**To run Python scripts in this repo:** First activate the Python environment. This can be done in an IDE like
Visual Studio Code or by running `pipenv shell` in the terminal. Then run the desired script from the repo root.

Commonly run commands:

```bash
pytest  # This runs all tests for the Python app
python modelingassistant/pythonapp/flaskapp.py  # Run the Modeling Assistant Feedback Mechanism backend
python modelingassistant/pythonapp/createcorpus.py  # updates learning corpus from corpus definition file
```
