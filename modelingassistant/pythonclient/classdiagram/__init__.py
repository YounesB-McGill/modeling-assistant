
from .classdiagram import getEClassifier, eClassifiers
from .classdiagram import name, nsURI, nsPrefix, eClass
from .classdiagram import NamedElement, TypedElement, Parameter, Attribute, StructuralFeature, Type, ObjectType, PrimitiveType, Classifier, VisibilityType, Operation, OperationType, Class, TypeParameter, ReferenceType, Association, AssociationEnd, ClassDiagram, ImplementationClass, Note, ElementMap, Layout, LayoutElement, ContainerMap, CDBoolean, CDDouble, CDInt, CDLong, CDString, CDByte, CDFloat, CDArray, CDChar, CDEnum, CDEnumLiteral, CDAny, CDVoid, CDCollection, CDSet, CDSequence

from pyecore.ecore import EObject

from . import classdiagram

__all__ = ['NamedElement', 'TypedElement', 'Parameter', 'Attribute', 'StructuralFeature', 'Type', 'ObjectType', 'PrimitiveType', 'Classifier', 'VisibilityType', 'Operation', 'OperationType', 'Class', 'TypeParameter', 'ReferenceType', 'Association', 'AssociationEnd', 'ClassDiagram',
           'ImplementationClass', 'Note', 'ElementMap', 'Layout', 'LayoutElement', 'ContainerMap', 'CDBoolean', 'CDDouble', 'CDInt', 'CDLong', 'CDString', 'CDByte', 'CDFloat', 'CDArray', 'CDChar', 'CDEnum', 'CDEnumLiteral', 'CDAny', 'CDVoid', 'CDCollection', 'CDSet', 'CDSequence']

eSubpackages = []
eSuperPackage = None
classdiagram.eSubpackages = eSubpackages
classdiagram.eSuperPackage = eSuperPackage

TypedElement.type.eType = Type
Classifier.superTypes.eType = Classifier
Classifier.operations.eType = Operation
Classifier.typeParameters.eType = TypeParameter
Classifier.attributes.eType = Attribute
Operation.returnType.eType = Type
Operation.parameters.eType = Parameter
TypeParameter.genericType.eType = ObjectType
Association.associationClass.eType = Class
AssociationEnd.qualifier.eType = Type
ClassDiagram.classes.eType = Classifier
ClassDiagram.types.eType = Type
ClassDiagram.associations.eType = Association
ClassDiagram.notes.eType = Note
ClassDiagram.layout.eType = Layout
Note.notedElement.eType = NamedElement
ElementMap.key.eType = EObject
ElementMap.value.eType = LayoutElement
Layout.containers.eType = ContainerMap
ContainerMap.key.eType = EObject
ContainerMap.value.eType = ElementMap
CDArray.type.eType = Type
CDCollection.type.eType = Type
Classifier.associationEnds.eType = AssociationEnd
Association.ends.eType = AssociationEnd
AssociationEnd.assoc.eType = Association
AssociationEnd.assoc.eOpposite = Association.ends
AssociationEnd.classifier.eType = Classifier
AssociationEnd.classifier.eOpposite = Classifier.associationEnds
CDEnum.literals.eType = CDEnumLiteral
CDEnumLiteral.enum.eType = CDEnum
CDEnumLiteral.enum.eOpposite = CDEnum.literals

otherClassifiers = [VisibilityType, OperationType, ReferenceType]

for classif in otherClassifiers:
    eClassifiers[classif.name] = classif
    classif.ePackage = eClass

for classif in eClassifiers.values():
    eClass.eClassifiers.append(classif.eClass)

for subpack in eSubpackages:
    eClass.eSubpackages.append(subpack.eClass)
