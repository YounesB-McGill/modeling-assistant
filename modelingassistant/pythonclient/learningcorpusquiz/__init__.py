
from .learningcorpusquiz import getEClassifier, eClassifiers
from .learningcorpusquiz import name, nsURI, nsPrefix, eClass
from .learningcorpusquiz import FillInTheBlanksQuiz


from . import learningcorpusquiz

__all__ = ['FillInTheBlanksQuiz']

eSubpackages = []
eSuperPackage = None
learningcorpusquiz.eSubpackages = eSubpackages
learningcorpusquiz.eSuperPackage = eSuperPackage


otherClassifiers = []

for classif in otherClassifiers:
    eClassifiers[classif.name] = classif
    classif.ePackage = eClass

for classif in eClassifiers.values():
    eClass.eClassifiers.append(classif.eClass)

for subpack in eSubpackages:
    eClass.eSubpackages.append(subpack.eClass)
