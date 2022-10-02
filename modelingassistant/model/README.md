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
   - The metamodel is visually appealing and consistent. This is especially
     important if you will use it in a demo, presentation, or publication.
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
