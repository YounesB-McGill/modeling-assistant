"""Definition of meta model 'learningcorpus'."""
from functools import partial
import pyecore.ecore as Ecore
from pyecore.ecore import *


name = 'learningcorpus'
nsURI = 'http://cs.mcgill.ca/sel/modelingassistant/learningcorpus/1.0'
nsPrefix = 'learningcorpus'

eClass = EPackage(name=name, nsURI=nsURI, nsPrefix=nsPrefix)

eClassifiers = {}
getEClassifier = partial(Ecore.getEClassifier, searchspace=eClassifiers)

Time = EDataType('Time', instanceClassName='java.sql.Time')


class UmlElement(EObject, metaclass=MetaEClass):

    learningItems = EReference(ordered=True, unique=True,
                               containment=False, derived=False, upper=-1)
    learningCorpus = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, learningItems=None, learningCorpus=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if learningItems:
            self.learningItems.extend(learningItems)

        if learningCorpus is not None:
            self.learningCorpus = learningCorpus


class Feedback(EObject, metaclass=MetaEClass):

    level = EAttribute(eType=EInt, unique=True, derived=False, changeable=True)
    congratulatory = EAttribute(eType=EBoolean, unique=True, derived=False, changeable=True)
    usefulness = EAttribute(eType=EDouble, unique=True, derived=False, changeable=True)
    highlightProblem = EAttribute(eType=EBoolean, unique=True, derived=False, changeable=True)
    highlightSolution = EAttribute(eType=EBoolean, unique=True, derived=False, changeable=True)
    text = EAttribute(eType=EString, unique=True, derived=False, changeable=True)
    mistakeType = EReference(ordered=True, unique=True, containment=False, derived=False)
    learningCorpus = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, level=None, congratulatory=None, usefulness=None, highlightProblem=None, highlightSolution=None, mistakeType=None, text=None, learningCorpus=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if level is not None:
            self.level = level

        if congratulatory is not None:
            self.congratulatory = congratulatory

        if usefulness is not None:
            self.usefulness = usefulness

        if highlightProblem is not None:
            self.highlightProblem = highlightProblem

        if highlightSolution is not None:
            self.highlightSolution = highlightSolution

        if text is not None:
            self.text = text

        if mistakeType is not None:
            self.mistakeType = mistakeType

        if learningCorpus is not None:
            self.learningCorpus = learningCorpus


@abstract
class NamedElement(EObject, metaclass=MetaEClass):

    name = EAttribute(eType=EString, unique=True, derived=False, changeable=True)

    def __init__(self, *, name=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if name is not None:
            self.name = name


class LearningCorpus(EObject, metaclass=MetaEClass):

    mistakeTypeCategories = EReference(ordered=True, unique=True,
                                       containment=True, derived=False, upper=-1)
    feedbacks = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    learningItems = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    learningResources = EReference(ordered=True, unique=True,
                                   containment=True, derived=False, upper=-1)
    umlElements = EReference(ordered=True, unique=True, containment=True, derived=False)

    def __init__(self, *, mistakeTypeCategories=None, feedbacks=None, learningItems=None, learningResources=None, umlElements=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if mistakeTypeCategories:
            self.mistakeTypeCategories.extend(mistakeTypeCategories)

        if feedbacks:
            self.feedbacks.extend(feedbacks)

        if learningItems:
            self.learningItems.extend(learningItems)

        if learningResources:
            self.learningResources.extend(learningResources)

        if umlElements is not None:
            self.umlElements = umlElements


class LearningItem(NamedElement):

    description = EAttribute(eType=EString, unique=True, derived=False, changeable=True)
    umlElements = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
    learningResources = EReference(ordered=True, unique=True,
                                   containment=False, derived=False, upper=-1)
    mistakeTypes = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
    learningCorpus = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, umlElements=None, learningResources=None, mistakeTypes=None, description=None, learningCorpus=None, **kwargs):

        super().__init__(**kwargs)

        if description is not None:
            self.description = description

        if umlElements:
            self.umlElements.extend(umlElements)

        if learningResources:
            self.learningResources.extend(learningResources)

        if mistakeTypes:
            self.mistakeTypes.extend(mistakeTypes)

        if learningCorpus is not None:
            self.learningCorpus = learningCorpus


class MistakeType(NamedElement):

    atomic = EAttribute(eType=EBoolean, unique=True, derived=False, changeable=True)
    timeToAddress = EAttribute(eType=Time, unique=True, derived=False, changeable=True)
    numStepsBeforeNotification = EAttribute(eType=EInt, unique=True, derived=False, changeable=True)
    learningItem = EReference(ordered=True, unique=True, containment=False, derived=False)
    feedbacks = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
    mistakeTypeCategory = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, atomic=None, timeToAddress=None, numStepsBeforeNotification=None, learningItem=None, feedbacks=None, mistakeTypeCategory=None, **kwargs):

        super().__init__(**kwargs)

        if atomic is not None:
            self.atomic = atomic

        if timeToAddress is not None:
            self.timeToAddress = timeToAddress

        if numStepsBeforeNotification is not None:
            self.numStepsBeforeNotification = numStepsBeforeNotification

        if learningItem is not None:
            self.learningItem = learningItem

        if feedbacks:
            self.feedbacks.extend(feedbacks)

        if mistakeTypeCategory is not None:
            self.mistakeTypeCategory = mistakeTypeCategory


class TextResponse(Feedback):

    def __init__(self, **kwargs):

        super().__init__(**kwargs)


class ParametrizedResponse(Feedback):

    def __init__(self, **kwargs):

        super().__init__(**kwargs)


class ResourceResponse(Feedback):

    learningResources = EReference(ordered=True, unique=True,
                                   containment=False, derived=False, upper=-1)

    def __init__(self, *, learningResources=None, **kwargs):

        super().__init__(**kwargs)

        if learningResources:
            self.learningResources.extend(learningResources)


class LearningResource(NamedElement):

    content = EAttribute(eType=EJavaObject, unique=True, derived=False, changeable=True)
    learningItem = EReference(ordered=True, unique=True, containment=False, derived=False)
    resourceResponses = EReference(ordered=True, unique=True,
                                   containment=False, derived=False, upper=-1)
    learningCorpus = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, learningItem=None, resourceResponses=None, content=None, learningCorpus=None, **kwargs):

        super().__init__(**kwargs)

        if content is not None:
            self.content = content

        if learningItem is not None:
            self.learningItem = learningItem

        if resourceResponses:
            self.resourceResponses.extend(resourceResponses)

        if learningCorpus is not None:
            self.learningCorpus = learningCorpus


class MistakeTypeCategory(NamedElement):

    mistakeTypes = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    supercategory = EReference(ordered=True, unique=True, containment=False, derived=False)
    subcategories = EReference(ordered=True, unique=True,
                               containment=False, derived=False, upper=-1)
    learningCorpus = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, mistakeTypes=None, supercategory=None, subcategories=None, learningCorpus=None, **kwargs):

        super().__init__(**kwargs)

        if mistakeTypes:
            self.mistakeTypes.extend(mistakeTypes)

        if supercategory is not None:
            self.supercategory = supercategory

        if subcategories:
            self.subcategories.extend(subcategories)

        if learningCorpus is not None:
            self.learningCorpus = learningCorpus


class Reference(LearningResource):

    def __init__(self, **kwargs):

        super().__init__(**kwargs)


class Tutorial(LearningResource):

    def __init__(self, **kwargs):

        super().__init__(**kwargs)


class Example(LearningResource):

    def __init__(self, **kwargs):

        super().__init__(**kwargs)


class Quiz(LearningResource):

    def __init__(self, **kwargs):

        super().__init__(**kwargs)
