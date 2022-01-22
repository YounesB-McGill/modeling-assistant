"""Definition of meta model 'learningcorpusquiz'."""
from functools import partial
import pyecore.ecore as Ecore
from pyecore.ecore import *
from learningcorpus import Quiz


name = 'learningcorpusquiz'
nsURI = 'http://cs.mcgill.ca/sel/modelingassistant/learningcorpusquiz/1.0'
nsPrefix = 'learningcorpusquiz'

eClass = EPackage(name=name, nsURI=nsURI, nsPrefix=nsPrefix)

eClassifiers = {}
getEClassifier = partial(Ecore.getEClassifier, searchspace=eClassifiers)


class FillInTheBlanksQuiz(Quiz):

    def __init__(self, **kwargs):

        super().__init__(**kwargs)
