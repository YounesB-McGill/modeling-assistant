 
# Linking metamodels
 
1. Open the destination metamodel ecore file (in this case, modelingassistant.ecore) in the Eclipse Ecore Model editor.
1. Right-click the top level element ("platform:...modelingassistant.ecore") and select Load Resource > Browse
Workspace, and select the source ecore file (eg, classdiagram.ecore).
1. Expand Solution and add a classDiagram reference to it of EType ClassDiagram.
1. Expand SolutionElement and add an element reference to it of EType NamedElement.
1. Select File > New > Other > EMF Generator Model and follow the steps. Select both modelingassistant and classdiagram as the root classes.
