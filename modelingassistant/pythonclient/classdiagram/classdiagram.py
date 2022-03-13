"""Definition of meta model 'classdiagram'."""
from __future__ import annotations
from functools import partial
import pyecore.ecore as Ecore
from pyecore.ecore import *
name = 'classdiagram'
nsURI = 'http://cs.mcgill.ca/sel/cdm/1.0'
nsPrefix = 'classdiagram'
eClass = EPackage(name=name, nsURI=nsURI, nsPrefix=nsPrefix)
eClassifiers = {}
getEClassifier = partial(Ecore.getEClassifier, searchspace=eClassifiers)
VisibilityType = EEnum('VisibilityType', literals=['public', 'protected', 'private', 'package'])
OperationType = EEnum('OperationType', literals=['Normal', 'Constructor', 'Destructor'])
ReferenceType = EEnum('ReferenceType', literals=['Composition', 'Aggregation', 'Regular', 'Qualified'])

@abstract
class NamedElement(EObject, metaclass=MetaEClass):
    name = EAttribute(eType=EString, unique=True, derived=False, changeable=True)

    def __init__(self, *, name=None):
        super().__init__()
        if name is not None:
            self.name = name

    def getName(self) -> str:
        """
        Return the name of this named element.
        """
        return self.name or self.__class__.__name__

class Note(EObject, metaclass=MetaEClass):
    content = EAttribute(eType=EString, unique=True, derived=False, changeable=True)
    notedElement = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)

    def __init__(self, *, notedElement=None, content=None):
        super().__init__()
        if content is not None:
            self.content = content
        if notedElement:
            self.notedElement.extend(notedElement)

class ElementMap(EObject, metaclass=MetaEClass):
    key = EReference(ordered=True, unique=True, containment=False, derived=False)
    value = EReference(ordered=True, unique=True, containment=True, derived=False)

    def __init__(self, *, key=None, value=None):
        super().__init__()
        if key is not None:
            self.key = key
        if value is not None:
            self.value = value

class Layout(EObject, metaclass=MetaEClass):
    containers = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)

    def __init__(self, *, containers=None):
        super().__init__()
        if containers:
            self.containers.extend(containers)

class LayoutElement(EObject, metaclass=MetaEClass):
    x = EAttribute(eType=EFloat, unique=True, derived=False, changeable=True)
    y = EAttribute(eType=EFloat, unique=True, derived=False, changeable=True)

    def __init__(self, *, x=None, y=None):
        super().__init__()
        if x is not None:
            self.x = x
        if y is not None:
            self.y = y

class ContainerMap(EObject, metaclass=MetaEClass):
    key = EReference(ordered=True, unique=True, containment=False, derived=False)
    value = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)

    def __init__(self, *, key=None, value=None):
        super().__init__()
        if key is not None:
            self.key = key
        if value:
            self.value.extend(value)

@abstract
class TypedElement(NamedElement):
    type = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, type=None, **kwargs):
        super().__init__(**kwargs)
        if type is not None:
            self.type = type

@abstract
class Type(NamedElement):

    def __init__(self, **kwargs):
        super().__init__(**kwargs)

class Operation(NamedElement):
    abstract = EAttribute(eType=EBoolean, unique=True, derived=False, changeable=True, default_value=False)
    visibility = EAttribute(eType=VisibilityType, unique=True, derived=False, changeable=True, default_value=VisibilityType.public)
    static = EAttribute(eType=EBoolean, unique=True, derived=False, changeable=True, default_value=False)
    operationType = EAttribute(eType=OperationType, unique=True, derived=False, changeable=True, default_value=OperationType.Normal)
    returnType = EReference(ordered=True, unique=True, containment=False, derived=False)
    parameters = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)

    def __init__(self, *, abstract=None, visibility=None, static=None, operationType=None, returnType=None, parameters=None, **kwargs):
        super().__init__(**kwargs)
        if abstract is not None:
            self.abstract = abstract
        if visibility is not None:
            self.visibility = visibility
        if static is not None:
            self.static = static
        if operationType is not None:
            self.operationType = operationType
        if returnType is not None:
            self.returnType = returnType
        if parameters:
            self.parameters.extend(parameters)

class Association(NamedElement):
    ends = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
    associationClass = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, ends=None, associationClass=None, **kwargs):
        super().__init__(**kwargs)
        if ends:
            self.ends.extend(ends)
        if associationClass is not None:
            self.associationClass = associationClass

class ClassDiagram(NamedElement):
    classes = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    types = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    associations = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    notes = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    layout = EReference(ordered=True, unique=True, containment=True, derived=False)

    def __init__(self, *, classes=None, types=None, associations=None, notes=None, layout=None, **kwargs):
        super().__init__(**kwargs)
        if classes:
            self.classes.extend(classes)
        if types:
            self.types.extend(types)
        if associations:
            self.associations.extend(associations)
        if notes:
            self.notes.extend(notes)
        if layout is not None:
            self.layout = layout

class CDEnumLiteral(NamedElement):
    enum = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, enum=None, **kwargs):
        super().__init__(**kwargs)
        if enum is not None:
            self.enum = enum

class Parameter(TypedElement):

    def __init__(self, **kwargs):
        super().__init__(**kwargs)

@abstract
class StructuralFeature(TypedElement):
    static = EAttribute(eType=EBoolean, unique=True, derived=False, changeable=True, default_value=False)
    visibility = EAttribute(eType=VisibilityType, unique=True, derived=False, changeable=True, default_value=VisibilityType.package)

    def __init__(self, *, static=None, visibility=None, **kwargs):
        super().__init__(**kwargs)
        if static is not None:
            self.static = static
        if visibility is not None:
            self.visibility = visibility

@abstract
class ObjectType(Type):

    def __init__(self, **kwargs):
        super().__init__(**kwargs)
        if not self.name:
            self.name = self.__class__.__name__

class TypeParameter(Type):
    genericType = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, genericType=None, **kwargs):
        super().__init__(**kwargs)
        if genericType is not None:
            self.genericType = genericType

class Attribute(StructuralFeature):

    def __init__(self, **kwargs):
        super().__init__(**kwargs)

@abstract
class Classifier(ObjectType):
    dataType = EAttribute(eType=EBoolean, unique=True, derived=False, changeable=True)
    abstract = EAttribute(eType=EBoolean, unique=True, derived=False, changeable=True)
    visibility = EAttribute(eType=VisibilityType, unique=True, derived=False, changeable=True, default_value=VisibilityType.package)
    superTypes = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
    operations = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    typeParameters = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    associationEnds = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    attributes = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)

    def __init__(self, *, superTypes=None, dataType=None, abstract=None, visibility=None, operations=None, typeParameters=None, associationEnds=None, attributes=None, **kwargs):
        super().__init__(**kwargs)
        if dataType is not None:
            self.dataType = dataType
        if abstract is not None:
            self.abstract = abstract
        if visibility is not None:
            self.visibility = visibility
        if superTypes:
            self.superTypes.extend(superTypes)
        if operations:
            self.operations.extend(operations)
        if typeParameters:
            self.typeParameters.extend(typeParameters)
        if associationEnds:
            self.associationEnds.extend(associationEnds)
        if attributes:
            self.attributes.extend(attributes)

class AssociationEnd(StructuralFeature):
    navigable = EAttribute(eType=EBoolean, unique=True, derived=False, changeable=True, default_value=True)
    lowerBound = EAttribute(eType=EInt, unique=True, derived=False, changeable=True, default_value=0)
    upperBound = EAttribute(eType=EInt, unique=True, derived=False, changeable=True, default_value=1)
    referenceType = EAttribute(eType=ReferenceType, unique=True, derived=False, changeable=True, default_value=ReferenceType.Regular)
    ordered = EAttribute(eType=EBoolean, unique=True, derived=False, changeable=True, default_value=False)
    unique = EAttribute(eType=EBoolean, unique=True, derived=False, changeable=True, default_value=True)
    assoc = EReference(ordered=True, unique=True, containment=False, derived=False)
    classifier = EReference(ordered=True, unique=True, containment=False, derived=False)
    qualifier = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, navigable=None, assoc=None, classifier=None, qualifier=None, lowerBound=None, upperBound=None, referenceType=None, ordered=None, unique=None, **kwargs):
        super().__init__(**kwargs)
        if navigable is not None:
            self.navigable = navigable
        if lowerBound is not None:
            self.lowerBound = lowerBound
        if upperBound is not None:
            self.upperBound = upperBound
        if referenceType is not None:
            self.referenceType = referenceType
        if ordered is not None:
            self.ordered = ordered
        if unique is not None:
            self.unique = unique
        if assoc is not None:
            self.assoc = assoc
        if classifier is not None:
            self.classifier = classifier
        if qualifier is not None:
            self.qualifier = qualifier

    def getOppositeEnd(self) -> AssociationEnd:
        """
        Return the opposite end of this association end.
        This method implements the following OCL code from the metamodel:

        ```ocl
        if (assoc.ends->size() <= 2) then
          self.assoc.ends->select(end : AssociationEnd | end <> self)->at(1)
        else
          null
        endif
        ```
        """
        if len(self.assoc.ends) <= 2:
            return self.assoc.ends[1 if self.assoc.ends[0] is self else 0]
        return None

    @property
    def oppositeEnd(self) -> AssociationEnd:
        """Return the opposite end of this association end."""
        return self.getOppositeEnd()

class CDAny(ObjectType):

    def __init__(self, **kwargs):
        super().__init__(**kwargs)

class CDVoid(ObjectType):

    def __init__(self, **kwargs):
        super().__init__(**kwargs)

class Class(Classifier):

    def __init__(self, **kwargs):
        super().__init__(**kwargs)

class ImplementationClass(Classifier):
    instanceClassName = EAttribute(eType=EString, unique=True, derived=False, changeable=True)
    interface = EAttribute(eType=EBoolean, unique=True, derived=False, changeable=True, default_value=False)

    def __init__(self, *, instanceClassName=None, interface=None, **kwargs):
        super().__init__(**kwargs)
        if instanceClassName is not None:
            self.instanceClassName = instanceClassName
        if interface is not None:
            self.interface = interface

@abstract
class PrimitiveType(ImplementationClass):

    def __init__(self, **kwargs):
        super().__init__(**kwargs)

@abstract
class CDCollection(ImplementationClass):
    type = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, type=None, **kwargs):
        super().__init__(**kwargs)
        if type is not None:
            self.type = type

class CDBoolean(PrimitiveType):

    def __init__(self, **kwargs):
        super().__init__(**kwargs)

    def getInstanceClassName(self):
        raise NotImplementedError('operation getInstanceClassName(...) not yet implemented')

class CDDouble(PrimitiveType):

    def __init__(self, **kwargs):
        super().__init__(**kwargs)

    def getInstanceClassName(self):
        raise NotImplementedError('operation getInstanceClassName(...) not yet implemented')

class CDInt(PrimitiveType):

    def __init__(self, **kwargs):
        super().__init__(**kwargs)

    def getInstanceClassName(self):
        raise NotImplementedError('operation getInstanceClassName(...) not yet implemented')

class CDLong(PrimitiveType):

    def __init__(self, **kwargs):
        super().__init__(**kwargs)

    def getInstanceClassName(self):
        raise NotImplementedError('operation getInstanceClassName(...) not yet implemented')

class CDString(PrimitiveType):

    def __init__(self, **kwargs):
        super().__init__(**kwargs)

    def getInstanceClassName(self):
        raise NotImplementedError('operation getInstanceClassName(...) not yet implemented')

class CDByte(PrimitiveType):

    def __init__(self, **kwargs):
        super().__init__(**kwargs)

    def getInstanceClassName(self):
        raise NotImplementedError('operation getInstanceClassName(...) not yet implemented')

class CDFloat(PrimitiveType):

    def __init__(self, **kwargs):
        super().__init__(**kwargs)

    def getInstanceClassName(self):
        raise NotImplementedError('operation getInstanceClassName(...) not yet implemented')

class CDArray(PrimitiveType):
    size = EAttribute(eType=EInt, unique=True, derived=False, changeable=True, default_value=-1)
    type = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, size=None, type=None, **kwargs):
        super().__init__(**kwargs)
        if size is not None:
            self.size = size
        if type is not None:
            self.type = type

    def getInstanceClassName(self):
        raise NotImplementedError('operation getInstanceClassName(...) not yet implemented')

class CDChar(PrimitiveType):

    def __init__(self, **kwargs):
        super().__init__(**kwargs)

    def getInstanceClassName(self):
        raise NotImplementedError('operation getInstanceClassName(...) not yet implemented')

class CDEnum(PrimitiveType):
    literals = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)

    def __init__(self, *, literals=None, **kwargs):
        super().__init__(**kwargs)
        if literals:
            self.literals.extend(literals)

class CDSet(CDCollection):

    def __init__(self, **kwargs):
        super().__init__(**kwargs)

class CDSequence(CDCollection):

    def __init__(self, **kwargs):
        super().__init__(**kwargs)