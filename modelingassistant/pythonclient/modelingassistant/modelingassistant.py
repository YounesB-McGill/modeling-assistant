"""Definition of meta model 'modelingassistant'."""
from functools import partial
import pyecore.ecore as Ecore
from pyecore.ecore import *


name = 'modelingassistant'
nsURI = 'http://cs.mcgill.ca/sel/modelingassistant/1.0'
nsPrefix = 'modelingassistant'

eClass = EPackage(name=name, nsURI=nsURI, nsPrefix=nsPrefix)

eClassifiers = {}
getEClassifier = partial(Ecore.getEClassifier, searchspace=eClassifiers)

int = EDataType('int', instanceClassName='int')

boolean = EDataType('boolean', instanceClassName='boolean')

Time = EDataType('Time', instanceClassName='java.sql.Time')

double = EDataType('double', instanceClassName='double')


class ModelingAssistant(EObject, metaclass=MetaEClass):

    learningItems = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    learningResources = EReference(ordered=True, unique=True,
                                   containment=True, derived=False, upper=-1)
    problemStatements = EReference(ordered=True, unique=True,
                                   containment=True, derived=False, upper=-1)
    solutions = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    umlElements = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    students = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    feedbacks = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    mistakes = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    mistakeTypes = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    studentknowledge = EReference(ordered=True, unique=True,
                                  containment=True, derived=False, upper=-1)

    def __init__(self, *, learningItems=None, learningResources=None, problemStatements=None, solutions=None, umlElements=None, students=None, feedbacks=None, mistakes=None, mistakeTypes=None, studentknowledge=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if learningItems:
            self.learningItems.extend(learningItems)

        if learningResources:
            self.learningResources.extend(learningResources)

        if problemStatements:
            self.problemStatements.extend(problemStatements)

        if solutions:
            self.solutions.extend(solutions)

        if umlElements:
            self.umlElements.extend(umlElements)

        if students:
            self.students.extend(students)

        if feedbacks:
            self.feedbacks.extend(feedbacks)

        if mistakes:
            self.mistakes.extend(mistakes)

        if mistakeTypes:
            self.mistakeTypes.extend(mistakeTypes)

        if studentknowledge:
            self.studentknowledge.extend(studentknowledge)


class UmlElement(EObject, metaclass=MetaEClass):

    modelingAssistant = EReference(ordered=True, unique=True, containment=False, derived=False)
    solutionElements = EReference(ordered=True, unique=True,
                                  containment=False, derived=False, upper=-1)
    learningItems = EReference(ordered=True, unique=True,
                               containment=False, derived=False, upper=-1)

    def __init__(self, *, modelingAssistant=None, solutionElements=None, learningItems=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if modelingAssistant is not None:
            self.modelingAssistant = modelingAssistant

        if solutionElements:
            self.solutionElements.extend(solutionElements)

        if learningItems:
            self.learningItems.extend(learningItems)


class Solution(EObject, metaclass=MetaEClass):

    modelingAssistant = EReference(ordered=True, unique=True, containment=False, derived=False)
    student = EReference(ordered=True, unique=True, containment=False, derived=False)
    solutionElements = EReference(ordered=True, unique=True,
                                  containment=True, derived=False, upper=-1)
    classDiagram = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, modelingAssistant=None, student=None, solutionElements=None, classDiagram=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if modelingAssistant is not None:
            self.modelingAssistant = modelingAssistant

        if student is not None:
            self.student = student

        if solutionElements:
            self.solutionElements.extend(solutionElements)

        if classDiagram is not None:
            self.classDiagram = classDiagram


class SolutionElement(EObject, metaclass=MetaEClass):

    problemStatementElements = EReference(
        ordered=True, unique=True, containment=False, derived=False, upper=-1)
    type = EReference(ordered=True, unique=True, containment=False, derived=False)
    solution = EReference(ordered=True, unique=True, containment=False, derived=False)
    mistakes = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
    element = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, problemStatementElements=None, type=None, solution=None, mistakes=None, element=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if problemStatementElements:
            self.problemStatementElements.extend(problemStatementElements)

        if type is not None:
            self.type = type

        if solution is not None:
            self.solution = solution

        if mistakes:
            self.mistakes.extend(mistakes)

        if element is not None:
            self.element = element


class StudentKnowledge(EObject, metaclass=MetaEClass):

    levelOfKnowledge = EAttribute(eType=int, unique=True, derived=False, changeable=True)
    student = EReference(ordered=True, unique=True, containment=False, derived=False)
    mistakeType = EReference(ordered=True, unique=True, containment=False, derived=False)
    modelingassistant = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, levelOfKnowledge=None, student=None, mistakeType=None, modelingassistant=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if levelOfKnowledge is not None:
            self.levelOfKnowledge = levelOfKnowledge

        if student is not None:
            self.student = student

        if mistakeType is not None:
            self.mistakeType = mistakeType

        if modelingassistant is not None:
            self.modelingassistant = modelingassistant


class Mistake(EObject, metaclass=MetaEClass):

    resolved = EAttribute(eType=boolean, unique=True, derived=False, changeable=True)
    timeToAddress = EAttribute(eType=Time, unique=True, derived=False, changeable=True)
    numStepsBeforeNotification = EAttribute(eType=int, unique=True, derived=False, changeable=True)
    modelingAssistant = EReference(ordered=True, unique=True, containment=False, derived=False)
    mistakeStudent = EReference(ordered=True, unique=True, containment=False, derived=False)
    currentMistakeStudent = EReference(ordered=True, unique=True, containment=False, derived=False)
    solutionElements = EReference(ordered=True, unique=True,
                                  containment=False, derived=False, upper=-1)
    mistakeType = EReference(ordered=True, unique=True, containment=False, derived=False)
    lastFeedback = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, resolved=None, timeToAddress=None, numStepsBeforeNotification=None, modelingAssistant=None, mistakeStudent=None, currentMistakeStudent=None, solutionElements=None, mistakeType=None, lastFeedback=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if resolved is not None:
            self.resolved = resolved

        if timeToAddress is not None:
            self.timeToAddress = timeToAddress

        if numStepsBeforeNotification is not None:
            self.numStepsBeforeNotification = numStepsBeforeNotification

        if modelingAssistant is not None:
            self.modelingAssistant = modelingAssistant

        if mistakeStudent is not None:
            self.mistakeStudent = mistakeStudent

        if currentMistakeStudent is not None:
            self.currentMistakeStudent = currentMistakeStudent

        if solutionElements:
            self.solutionElements.extend(solutionElements)

        if mistakeType is not None:
            self.mistakeType = mistakeType

        if lastFeedback is not None:
            self.lastFeedback = lastFeedback


class Feedback(EObject, metaclass=MetaEClass):

    level = EAttribute(eType=int, unique=True, derived=False, changeable=True)
    congratulatory = EAttribute(eType=boolean, unique=True, derived=False, changeable=True)
    usefulness = EAttribute(eType=double, unique=True, derived=False, changeable=True)
    highlightProblem = EAttribute(eType=boolean, unique=True, derived=False, changeable=True)
    highlightSolution = EAttribute(eType=boolean, unique=True, derived=False, changeable=True)
    text = EAttribute(eType=EString, unique=True, derived=False, changeable=True)
    modelingAssistant = EReference(ordered=True, unique=True, containment=False, derived=False)
    mistakeType = EReference(ordered=True, unique=True, containment=False, derived=False)
    mistakes = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)

    def __init__(self, *, level=None, congratulatory=None, usefulness=None, highlightProblem=None, highlightSolution=None, modelingAssistant=None, mistakeType=None, mistakes=None, text=None):
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

        if modelingAssistant is not None:
            self.modelingAssistant = modelingAssistant

        if mistakeType is not None:
            self.mistakeType = mistakeType

        if mistakes:
            self.mistakes.extend(mistakes)


@abstract
class NamedElement(EObject, metaclass=MetaEClass):

    name = EAttribute(eType=EString, unique=True, derived=False, changeable=True)

    def __init__(self, *, name=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if name is not None:
            self.name = name


class Student(NamedElement):

    id = EAttribute(eType=EString, unique=True, derived=False, changeable=True)
    modelingAssistant = EReference(ordered=True, unique=True, containment=False, derived=False)
    mistakes = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
    currentMistake = EReference(ordered=True, unique=True, containment=False, derived=False)
    solutions = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
    studentKnowledges = EReference(ordered=True, unique=True,
                                   containment=False, derived=False, upper=-1)

    def __init__(self, *, id=None, modelingAssistant=None, mistakes=None, currentMistake=None, solutions=None, studentKnowledges=None, **kwargs):

        super().__init__(**kwargs)

        if id is not None:
            self.id = id

        if modelingAssistant is not None:
            self.modelingAssistant = modelingAssistant

        if mistakes:
            self.mistakes.extend(mistakes)

        if currentMistake is not None:
            self.currentMistake = currentMistake

        if solutions:
            self.solutions.extend(solutions)

        if studentKnowledges:
            self.studentKnowledges.extend(studentKnowledges)


class ProblemStatement(NamedElement):

    text = EAttribute(eType=EString, unique=True, derived=False, changeable=True)
    problemStatementElements = EReference(
        ordered=True, unique=True, containment=True, derived=False, upper=-1)
    modelingAssistant = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, problemStatementElements=None, text=None, modelingAssistant=None, **kwargs):

        super().__init__(**kwargs)

        if text is not None:
            self.text = text

        if problemStatementElements:
            self.problemStatementElements.extend(problemStatementElements)

        if modelingAssistant is not None:
            self.modelingAssistant = modelingAssistant


class ProblemStatementElement(NamedElement):

    problemStatement = EReference(ordered=True, unique=True, containment=False, derived=False)
    solutionElements = EReference(ordered=True, unique=True,
                                  containment=False, derived=False, upper=-1)

    def __init__(self, *, problemStatement=None, solutionElements=None, **kwargs):

        super().__init__(**kwargs)

        if problemStatement is not None:
            self.problemStatement = problemStatement

        if solutionElements:
            self.solutionElements.extend(solutionElements)


class LearningItem(NamedElement):

    description = EAttribute(eType=EString, unique=True, derived=False, changeable=True)
    modelingAssistant = EReference(ordered=True, unique=True, containment=False, derived=False)
    umlElements = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
    learningResources = EReference(ordered=True, unique=True,
                                   containment=False, derived=False, upper=-1)
    mistakeTypes = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)

    def __init__(self, *, modelingAssistant=None, umlElements=None, learningResources=None, mistakeTypes=None, description=None, **kwargs):

        super().__init__(**kwargs)

        if description is not None:
            self.description = description

        if modelingAssistant is not None:
            self.modelingAssistant = modelingAssistant

        if umlElements:
            self.umlElements.extend(umlElements)

        if learningResources:
            self.learningResources.extend(learningResources)

        if mistakeTypes:
            self.mistakeTypes.extend(mistakeTypes)


class MistakeType(NamedElement):

    atomic = EAttribute(eType=boolean, unique=True, derived=False, changeable=True)
    timeToAddress = EAttribute(eType=Time, unique=True, derived=False, changeable=True)
    numStepsBeforeNotification = EAttribute(eType=int, unique=True, derived=False, changeable=True)
    modelingAssistant = EReference(ordered=True, unique=True, containment=False, derived=False)
    learningItem = EReference(ordered=True, unique=True, containment=False, derived=False)
    studentKnowledges = EReference(ordered=True, unique=True,
                                   containment=False, derived=False, upper=-1)
    mistakes = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
    feedbacks = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)

    def __init__(self, *, atomic=None, timeToAddress=None, numStepsBeforeNotification=None, modelingAssistant=None, learningItem=None, studentKnowledges=None, mistakes=None, feedbacks=None, **kwargs):

        super().__init__(**kwargs)

        if atomic is not None:
            self.atomic = atomic

        if timeToAddress is not None:
            self.timeToAddress = timeToAddress

        if numStepsBeforeNotification is not None:
            self.numStepsBeforeNotification = numStepsBeforeNotification

        if modelingAssistant is not None:
            self.modelingAssistant = modelingAssistant

        if learningItem is not None:
            self.learningItem = learningItem

        if studentKnowledges:
            self.studentKnowledges.extend(studentKnowledges)

        if mistakes:
            self.mistakes.extend(mistakes)

        if feedbacks:
            self.feedbacks.extend(feedbacks)


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
    modelingAssistant = EReference(ordered=True, unique=True, containment=False, derived=False)
    learningItem = EReference(ordered=True, unique=True, containment=False, derived=False)
    resourceResponses = EReference(ordered=True, unique=True,
                                   containment=False, derived=False, upper=-1)

    def __init__(self, *, modelingAssistant=None, learningItem=None, resourceResponses=None, content=None, **kwargs):

        super().__init__(**kwargs)

        if content is not None:
            self.content = content

        if modelingAssistant is not None:
            self.modelingAssistant = modelingAssistant

        if learningItem is not None:
            self.learningItem = learningItem

        if resourceResponses:
            self.resourceResponses.extend(resourceResponses)


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
