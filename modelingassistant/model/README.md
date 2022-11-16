# Metamodels

This folder contains the Ecore metamodels used in this application.
A metamodel is a class diagram model of a model. Metamodel instances are models,
eg, the `AirlineSystem` class diagram created by the instructor.
An `.ecore` metamodel can be defined across one or multiple class diagrams using
the AIRD editor in Eclipse.

You must use a version of EMF (Eclipse Modeling Framework) which is compatible
with the version used to create the metamodels and also used by the rest of
the team. In other words, if one of you upgrades Eclipse, you will force
everyone else to upgrade as well.

If you are new to metamodeling, consult the tutorials by
[Schoettle](https://github.com/mschoettle/emf-tutorial) and
[Vogella](https://www.vogella.com/tutorials/EclipseEMF/article.html).

Three metamodels are defined in this folder: `learningcorpus`,
`learningcorpusquiz`, and `modelingassistant`, which depends on the first two.
For convenience, a (slightly modified) copy of the TouchCORE
[`classdiagram`](https://bitbucket.org/mcgillram/touchram/src/master/ca.mcgill.sel.classdiagram/model/)
metamodel is retained in this repo.

## Class Diagram Metamodel

Also known as the "cdm metamodel" due to its `.cdm` filename extensions,
this metamodel provides a simple way to represent class diagrams, including
domain models (used in this application) and design class diagrams.
It is developed by the CORE team led by
[Prof Jörg Kienzle](https://cs.mcgill.ca/~joerg/).

![Class Diagram Metamodel](classdiagram.jpg)

![Class Diagram Metamodel Types](classdiagramtypes.jpg)


## Learning Corpus Metamodel

This metamodel defines the structure of the Learning Corpus. It depends only
on the `classdiagram` metamodel.

![Learning Corpus Metamodel](learningcorpus.jpg)


## Learning Corpus Quiz Metamodel

This metamodel defines the structure of the a `Quiz` in the Learning Corpus.
It depends on the `learningcorpus` metamodel, which means it also depends on
the `classdiagram` metamodel transitively.

![Learning Corpus Quiz Metamodel](learningcorpusquiz.jpg)


## Modeling Assistant Metamodel

This is the main metamodel for this application. It depends on all the other
metamodels mentioned above.

![Modeling Assistant Metamodel](modelingassistant.jpg)


## Updating the Metamodel(s)

Before making any changes, keep the following in mind:

**Changing the metamodel is a big deal!** It is akin to changing the database schema
in a relational database and is not something to be done lightly.

- All existing models, eg, `*.modelingassistant` files, may be invalidated and
require migration to the new metamodel
- A lot of code (in multiple programming languages) will need to be updated to
reflect the changes in the metamodel, including the unit tests, and updates
may be required in other repositories as well, eg, the frontend
- All outstanding pull requests will need to be closed or updated with the new
changes, so discuss this with the authors ahead of time
- There are existing publications on the project that use certain metamodel
conventions, so do not needlessly break them 

If a change is indeed warranted, these are the steps that need to be followed
every time one of the app's Ecore metamodels is updated.

<!-- Note to README authors: use "1." as the numbering for all steps to avoid multiple
     edits if the steps need to change in the future. The correct number order (1, 2, 3, ...)
     will still be shown in Markdown visualizers such as GitHub.com -->

1. Make the changes in the metamodel ecore file(s), eg,
   [`learningcorpus.ecore`](modelingassistant/model/learningcorpus.ecore),
   via the [`representations.aird`](modelingassistant/representations.aird) file.
   **Double-check that the modifications are correct and complete!** In particular, check that:
   - No model elements have errors (shown in red)
   - Every metaclass is contained (directly or indirectly) in the root metaclass,
     other than the root metaclass itself
   - There are no dummy temporary elements. These can help with layout and style,
     but should be removed before committing
   - The metamodel is visually appealing and consistent. This is especially
     important if you will use it in a demo, presentation, or publication
1. Export the metamodel to image (jpg **and** svg) files using the :camera: icon, eg,
   [`learningcorpus.jpg`](modelingassistant/model/learningcorpus.jpg).
1. Run the [`create_model_pdfs.sh`](create_model_pdfs.sh) script to create the
   metamodel PDF files.
1. Autogenerate the Java code in Eclipse by opening the
   [`modelingassistant.genmodel`](modelingassistant/model/modelingassistant.genmodel)
   file, right-clicking `Modelingassistant`, and selecting the `Generate All` option.
   Make sure the code compiles.
1. Autogenerate the Python code and docs using the command
   ```bash
   python modelingassistant/pythonapp/generatepythoncode.py && \
   python modelingassistant/pythonapp/generatepythonappdocs.py
   ```
   Run this from the repo root in an active virtual environment.
   Activating the virtual environment is automatically done in Visual Studio Code
   after a one-time setup.
1. Run the Java and Python tests and make sure they all pass
   (There may be failures the first time the tests are run.
   In that case, run them again).
1. Commit the changes to the repo as a separate commit. In the commit message,
   specify the changes made to the metamodel.

### Linking to another metamodel

:warning: These instructions may vary in future versions of Eclipse. Consult the
documentation as needed.
 
1. Open the ecore file (eg, `modelingassistant.ecore`) for the importing metamodel 
   in the Eclipse Ecore Model editor
1. Right-click the top level element ("platform:...modelingassistant.ecore")
   and select Load Resource > Browse Workspace, and select the source ecore file
   (eg, `classdiagram.ecore` from the imported TouchCORE project)
1. Expand a class in the importing metamodel (eg, `Solution`) and add a reference to
   the imported metamodel (eg, `classDiagram` of EType `ClassDiagram`).
   Repeat this as needed for other references.
1. Select File > New > Other > EMF Generator Model and follow the steps.
   Select both the importing and imported metamodels (eg, `modelingassistant` and
   `classdiagram` as the root classes)
