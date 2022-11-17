# :snake: Python Upgrade Process

This document describes the process for upgrading the project's Python
version. It was written at the time of the upgrade from Python 3.10 to
3.11 in late 2022, and so it uses these versions as examples, but should be
applicable to future upgrades as well.

To upgrade the Python version, read this entire document, then follow
these steps:

<!-- Note: Every bullet point in the list below starts with zero.
     This is intentional and will appear correctly when rendered in
     Markdown visualizers such as the one on GitHub  -->

0. If you have not already done so, familiarize yourself with the project
   as whole and the Python code in particular by consulting the various
   related publications, project documentation, and the code itself (at 
   least the essential modules)

0. Read up on the changes in the new Python version to understand how the
   upgrade will affect the project. Pay special attention to deprecations
   and removed features. For example, the Python 3.11 changelog can be
   found at
   [docs.python.org/3/whatsnew/3.11.html](https://docs.python.org/3/whatsnew/3.11.html)

0. Make a backup of your virtual environment folder so you can revert
   to it if necessary. You can find this folder by running `pipenv --venv`
   in the repo root. This will save you the trouble of having to set up
   the old Python version again if needed

0. Double check that the app starts correctly and that all tests
   (both :snake: Python and :coffee: Java) pass
   with the current Python version (`pytest`). If not, fix any issues
   before proceeding. Ideally, get rid of all emitted warnings, or at
   least document them

0. Create a new branch dedicated for the upgrade, e.g. `python3.11`

0. Make any required changes due to deprecations and removed features
   **before** upgrading the Python version! For example, if a function
   now takes a mandatory additional argument, do a find-and-replace to
   add that argument to all the locations where that function is called

0. Install the new Python version locally (and on any server if needed).
   On Windows, use the GUI installer downloaded from the Python website.
   On Ubuntu, install the new version by running these commands in a
   terminal:

   ```bash
   sudo add-apt-repository ppa:deadsnakes/ppa  # if not already added
   sudo apt update 
   sudo apt install python3.11
   sudo apt-get install python3.11-distutils
   ```

0. Install `pip` and `pipenv` for the new Python version. Run the 
   following commands in the repo root:

   ```bash
   curl -sS https://bootstrap.pypa.io/get-pip.py | python3.11
   python3.11 -m pip install pipenv
   pipenv --rm
   pipenv install
   ```

   If the above commands fail, close the existing terminal window and run
   them again in a new one

0. Address any new warnings emitted by `pylint`. You can run the command
   manually or use the integration with an IDE such as Visual Studio Code.
   Update the `.pylintrc` file if needed

0. Run the test suite (`pytest`) again and make sure all tests pass.
   Address any new warnings that may have appeared by changing the code
   or tests as needed, but do not needlessly silence warnings or weaken
   tests

0. Stop WebCORE and the Mistake Detection System (MDS) if they are
   running, then run the following scripts (in the order shown below)
   to update the project and ensure that they work correctly with the
   new Python version. In each case, make sure the script runs without
   errors and the output looks correct:

   1. Regenerate the PyEcore model code
      (`python modelingassistant/pythonapp/generatepythoncode.py`)

   1. Regenerate the Learning Corpus
      (`python modelingassistant/pythonapp/createcorpus.py`) 

   1. Regenerate the Python app documentation
      (`python modelingassistant/pythonapp/generatepythonappdocs.py`)

0. Restart WebCORE and MDS and rerun the tests a final time to make sure
   everything continues to work as expected. Commit the files with different
   Learning Corpus XMI IDs to the repo

0. Run the MDS and Java controller tests and make sure they continue to pass 

0. If there is a major change to the upgrade process itself, eg, if
   Python 4 is released and requires different steps, update this document as needed
