# Modeling Assistant

Interactive domain modeling assistant.

## Setup Instructions

### Prerequisites

* Recent version of
[Eclipse Modeling Tools](https://www.eclipse.org/downloads/packages/).
* [TouchCORE](https://bitbucket.org/mcgillram/touchram/src/master/)
sources on your local machine.

### Setup

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

## Updating the Metamodel(s)

These are the steps that need to be followed every time one of the app's metamodels is updated.

_(The rest of this README is out of date, and will be edited in a future commit.)_

1. Make the changes in the metamodel ecore file(s), eg,
[`learningcorpus.ecore`](modelingassistant/model/learningcorpus.ecore),
via the [`representations.aird`](modelingassistant/representations.aird) file.
1. Export the metamodel to image files using the :camera: icon, eg,
[`learningcorpus.jpg`](modelingassistant/model/learningcorpus.jpg).
**Double-check that the modifications are correct and complete!**
1. Autogenerate the Java code in Eclipse by opening the [`modelingassistant.genmodel`](modelingassistant/model/modelingassistant.genmodel)
file, right-clicking `Modelingassistant`, and selecting the `Generate All` option.
Make sure the code compiles.
1. Autogenerate the Python code using the command
   ```bash
   python3 modelingassistant/pythonclient/generatepythoncode.py
   ```
   Run this from the repo root in an active virtual environment.
   Activating the virtual environment is automatically done in Visual Studio Code
   after a one-time setup.
1. Run the Java and Python tests and make sure they all pass
(There may be failures the first time the tests are run.
In that case, run them again).
1. Commit the changes to the repo in a separate commit. In the commit message,
specify the changes made to the metamodel.