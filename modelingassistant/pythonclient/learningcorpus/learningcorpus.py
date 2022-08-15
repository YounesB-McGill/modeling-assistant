"""Definition of meta model 'learningcorpus'."""
from __future__ import annotations
from functools import partial
import pyecore.ecore as Ecore
from pyecore.ecore import *
name = 'learningcorpus'
nsURI = 'http://cs.mcgill.ca/sel/modelingassistant/learningcorpus/1.0'
nsPrefix = 'learningcorpus'
eClass = EPackage(name=name, nsURI=nsURI, nsPrefix=nsPrefix)
eClassifiers = {}
getEClassifier = partial(Ecore.getEClassifier, searchspace=eClassifiers)
ElementType = EEnum('ElementType', literals=['Class', 'Attribute', 'Association', 'AssociationEnd', 'Aggregation', 'Composition', 'Generalization', 'PlayerRolePattern', 'AbstractionOccurrencePattern'])
Time = EDataType('Time', instanceClassName='java.sql.Time')

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
        super().__init__()
        if name is not None:
            self.name = name

class LearningCorpus(EObject, metaclass=MetaEClass):
    mistakeTypeCategories = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    feedbacks = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    learningItems = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    learningResources = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)

    def __init__(self, *, mistakeTypeCategories=None, feedbacks=None, learningItems=None, learningResources=None):
        super().__init__()
        if mistakeTypeCategories:
            self.mistakeTypeCategories.extend(mistakeTypeCategories)
        if feedbacks:
            self.feedbacks.extend(feedbacks)
        if learningItems:
            self.learningItems.extend(learningItems)
        if learningResources:
            self.learningResources.extend(learningResources)

    def mistakeTypes(self) -> list[MistakeType]:
        """Custom function to return all the mistake types from their categories."""
        import itertools
        return list(itertools.chain(*[mtc.mistakeTypes for mtc in self.mistakeTypeCategories]))

    def topLevelMistakeTypeCategories(self) -> list[MistakeTypeCategory]:
        """
        Custom function to return all the top-level mistake type categories,
        ie, those that do not have a supercategory.
        """
        return [mtc for mtc in self.mistakeTypeCategories if not mtc.supercategory]

class LearningItem(NamedElement):
    description = EAttribute(eType=EString, unique=True, derived=False, changeable=True)
    elementType = EAttribute(eType=ElementType, unique=True, derived=False, changeable=True)
    learningResources = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
    mistakeTypes = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
    learningCorpus = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, learningResources=None, mistakeTypes=None, description=None, learningCorpus=None, elementType=None, **kwargs):
        super().__init__(**kwargs)
        if description is not None:
            self.description = description
        if elementType is not None:
            self.elementType = elementType
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
    priority = EAttribute(eType=EInt, unique=True, derived=False, changeable=True)
    description = EAttribute(eType=EString, unique=True, derived=False, changeable=True)
    learningItem = EReference(ordered=True, unique=True, containment=False, derived=False)
    feedbacks = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
    mistakeTypeCategory = EReference(ordered=True, unique=True, containment=False, derived=False)
    studentElements = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    instructorElements = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)

    def __init__(self, *, atomic=None, timeToAddress=None, numStepsBeforeNotification=None, learningItem=None, feedbacks=None, mistakeTypeCategory=None, priority=None, description=None, studentElements=None, instructorElements=None, **kwargs):
        super().__init__(**kwargs)
        if atomic is not None:
            self.atomic = atomic
        if timeToAddress is not None:
            self.timeToAddress = timeToAddress
        if numStepsBeforeNotification is not None:
            self.numStepsBeforeNotification = numStepsBeforeNotification
        if priority is not None:
            self.priority = priority
        if description is not None:
            self.description = description
        if learningItem is not None:
            self.learningItem = learningItem
        if feedbacks:
            self.feedbacks.extend(feedbacks)
        if mistakeTypeCategory is not None:
            self.mistakeTypeCategory = mistakeTypeCategory
        if studentElements:
            self.studentElements.extend(studentElements)
        if instructorElements:
            self.instructorElements.extend(instructorElements)

    def parametrized_responses(self) -> list[ParametrizedResponse]:
        """Custom function to return all the parametrized responses for this mistake type."""
        return [fb for fb in self.feedbacks if fb.__class__.__name__ == 'ParametrizedResponse']

    @property
    def md_format(self):
        from collections import namedtuple
        Mdf = namedtuple('MDF', 'stud inst')
        return Mdf([e.name for e in self.studentElements], [e.name for e in self.instructorElements])

class TextResponse(Feedback):

    def __init__(self, **kwargs):
        super().__init__(**kwargs)

class ParametrizedResponse(Feedback):

    def __init__(self, **kwargs):
        super().__init__(**kwargs)

class ResourceResponse(Feedback):
    learningResources = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)

    def __init__(self, *, learningResources=None, **kwargs):
        super().__init__(**kwargs)
        if learningResources:
            self.learningResources.extend(learningResources)

class LearningResource(NamedElement):
    content = EAttribute(eType=EString, unique=True, derived=False, changeable=True)
    learningItem = EReference(ordered=True, unique=True, containment=False, derived=False)
    resourceResponses = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
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
    subcategories = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
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

class MistakeElement(NamedElement):
    many = EAttribute(eType=EBoolean, unique=True, derived=False, changeable=True)
    type = EAttribute(eType=EString, unique=True, derived=False, changeable=True)

    def __init__(self, *, many=None, type=None, **kwargs):
        super().__init__(**kwargs)
        if many is not None:
            self.many = many
        if type is not None:
            self.type = type

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