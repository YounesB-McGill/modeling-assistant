# Updating the Metamodel(s)

These are the steps that need to be followed every time one of the app's Ecore metamodels is updated.

1. Make the changes in the metamodel ecore file(s), eg,
   [`learningcorpus.ecore`](modelingassistant/model/learningcorpus.ecore),
   via the [`representations.aird`](modelingassistant/representations.aird) file.
   **Double-check that the modifications are correct and complete!** In particular, check that:
   - No model elements have errors (shown in red)
   - Every metaclass is contained (directly or indirectly) in the root metaclass,
     other than the root metaclass itself
   - There are no dummy temporary elements. These can help with layout and style,
     but should be removed before committing
1. Export the metamodel to image (jpg **and** svg) files using the :camera: icon, eg,
   [`learningcorpus.jpg`](modelingassistant/model/learningcorpus.jpg).
1. Run the [`create_model_pdfs.sh`](create_model_pdfs.sh) script to create the
   metamodel PDF files.
1. Autogenerate the Java code in Eclipse by opening the
   [`modelingassistant.genmodel`](modelingassistant/model/modelingassistant.genmodel)
   file, right-clicking `Modelingassistant`, and selecting the `Generate All` option.
   Make sure the code compiles.
1. Autogenerate the Python code using the command
   ```bash
   python3 modelingassistant/pythonapp/generatepythoncode.py
   ```
   Run this from the repo root in an active virtual environment.
   Activating the virtual environment is automatically done in Visual Studio Code
   after a one-time setup.
1. Run the Java and Python tests and make sure they all pass
   (There may be failures the first time the tests are run.
   In that case, run them again).
1. Commit the changes to the repo as a separate commit. In the commit message,
   specify the changes made to the metamodel.
