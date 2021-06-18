# Modeling Assistant

Interactive domain modeling assistant.

## Modeling Assistant Visualization Instructions

### Prerequisites

* Recent version of
[Eclipse Modeling Tools](https://www.eclipse.org/downloads/packages/).
* [Sirius](https://www.eclipse.org/sirius/) version compatible with
your Eclipse version.
* [Acceleo](https://www.eclipse.org/acceleo/).
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
2. Import the following Modeling Assistant projects into 
the same Eclipse workspace:
   * modelingassistant
   * modelingassistant.edit
   * modelingassistant.editor
   * modelingassistant.visualization.design
3. Expand the **modelingassistant.editor** project and open
**plugin.xml**, then select :arrow_forward:
**Launch an Eclipse Application**.
This will open a second Eclipse instance.
4. In this second Eclipse instance, import the following projects:
   * modelingassistant
   * modelingassistant.visualization.instances

### Viewing existing instances

1. In the second Eclipse instance, expand the
**modelingassistant.visualization.instances** project and
open the **representations.aird** file.
2. Under **representations**, expand the **modelingassistant** tree to
open a Modeling Assistant diagram, which will open in a custom 
graphical editor.

### Creating new Modeling Assistant instances

1. In the second Eclipse instance, select File > New >
(:mag_right:) Modelingassistant model, give it a name ending with
`.modelingassistant`, and select Modeling Assistant as the Model Object.
2. In the **representations.aird** file, right-click this newly created 
file, select New representation, and enter a diagram name.
3. Add objects to the modeling assistant using the Pallete, and
customize them (eg, set name) in the Properties tab.
4. To add a relationship from A to B:
   1. Select the relationship type in the Pallete.
   2. Select A.
   3. Select B.
5. Remember to save your diagram using the icon or Cmd/Ctrl-S.
The model elements will be serialized to the file created in Step 1
conforming with the `modelingassistant.ecore` metamodel.

**Note:** Depending on your system setup, some of the prerequisite 
projects in the Eclipse workspaces may indicate errors with the :x: 
icon. These errors can often be ignored.
