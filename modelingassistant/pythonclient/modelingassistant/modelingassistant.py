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

Time = EDataType('Time', instanceClassName='java.sql.Time')


class ModelingAssistant(EObject, metaclass=MetaEClass):

    problemStatements = EReference(ordered=True, unique=True,
                                   containment=True, derived=False, upper=-1)
    solutions = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    students = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    studentKnowledges = EReference(ordered=True, unique=True,
                                   containment=True, derived=False, upper=-1)
    feedbackItems = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)

    def __init__(self, *, problemStatements=None, solutions=None, students=None, studentKnowledges=None, feedbackItems=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if problemStatements:
            self.problemStatements.extend(problemStatements)

        if solutions:
            self.solutions.extend(solutions)

        if students:
            self.students.extend(students)

        if studentKnowledges:
            self.studentKnowledges.extend(studentKnowledges)

        if feedbackItems:
            self.feedbackItems.extend(feedbackItems)


class Solution(EObject, metaclass=MetaEClass):

    modelingAssistant = EReference(ordered=True, unique=True, containment=False, derived=False)
    student = EReference(ordered=True, unique=True, containment=False, derived=False)
    solutionElements = EReference(ordered=True, unique=True,
                                  containment=True, derived=False, upper=-1)
    classDiagram = EReference(ordered=True, unique=True, containment=False, derived=False)
    mistakes = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    currentMistake = EReference(ordered=True, unique=True, containment=False, derived=False)
    studentProblemStatement = EReference(
        ordered=True, unique=True, containment=False, derived=False)
    instructorProblemStatement = EReference(
        ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, modelingAssistant=None, student=None, solutionElements=None, classDiagram=None, mistakes=None, currentMistake=None, studentProblemStatement=None, instructorProblemStatement=None):
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

        if mistakes:
            self.mistakes.extend(mistakes)

        if currentMistake is not None:
            self.currentMistake = currentMistake

        if studentProblemStatement is not None:
            self.studentProblemStatement = studentProblemStatement

        if instructorProblemStatement is not None:
            self.instructorProblemStatement = instructorProblemStatement


class SolutionElement(EObject, metaclass=MetaEClass):

    problemStatementElements = EReference(
        ordered=True, unique=True, containment=False, derived=False, upper=-1)
    solution = EReference(ordered=True, unique=True, containment=False, derived=False)
    studentElementMistakes = EReference(
        ordered=True, unique=True, containment=False, derived=False, upper=-1)
    element = EReference(ordered=True, unique=True, containment=False, derived=False)
    instructorElementMistakes = EReference(
        ordered=True, unique=True, containment=False, derived=False, upper=-1)

    def __init__(self, *, problemStatementElements=None, solution=None, studentElementMistakes=None, element=None, instructorElementMistakes=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if problemStatementElements:
            self.problemStatementElements.extend(problemStatementElements)

        if solution is not None:
            self.solution = solution

        if studentElementMistakes:
            self.studentElementMistakes.extend(studentElementMistakes)

        if element is not None:
            self.element = element

        if instructorElementMistakes:
            self.instructorElementMistakes.extend(instructorElementMistakes)


class StudentKnowledge(EObject, metaclass=MetaEClass):

    levelOfKnowledge = EAttribute(eType=EInt, unique=True, derived=False, changeable=True)
    student = EReference(ordered=True, unique=True, containment=False, derived=False)
    modelingAssistant = EReference(ordered=True, unique=True, containment=False, derived=False)
    mistakeType = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, levelOfKnowledge=None, student=None, modelingAssistant=None, mistakeType=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if levelOfKnowledge is not None:
            self.levelOfKnowledge = levelOfKnowledge

        if student is not None:
            self.student = student

        if modelingAssistant is not None:
            self.modelingAssistant = modelingAssistant

        if mistakeType is not None:
            self.mistakeType = mistakeType


class Mistake(EObject, metaclass=MetaEClass):

    resolved = EAttribute(eType=EBoolean, unique=True, derived=False, changeable=True)
    timeToAddress = EAttribute(eType=Time, unique=True, derived=False, changeable=True)
    numStepsBeforeNotification = EAttribute(eType=EInt, unique=True, derived=False, changeable=True)
    numDetection = EAttribute(eType=EInt, unique=True, derived=False, changeable=True)
    numDetectionSinceResolved = EAttribute(eType=EInt, unique=True, derived=False, changeable=True)
    studentElements = EReference(ordered=True, unique=True,
                                 containment=False, derived=False, upper=-1)
    lastFeedback = EReference(ordered=True, unique=True, containment=False, derived=False)
    instructorElements = EReference(ordered=True, unique=True,
                                    containment=False, derived=False, upper=-1)
    studentSolution = EReference(ordered=True, unique=True, containment=False, derived=False)
    mistakeType = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, resolved=None, timeToAddress=None, numStepsBeforeNotification=None, studentElements=None, lastFeedback=None, instructorElements=None, studentSolution=None, numDetection=None, numDetectionSinceResolved=None, mistakeType=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if resolved is not None:
            self.resolved = resolved

        if timeToAddress is not None:
            self.timeToAddress = timeToAddress

        if numStepsBeforeNotification is not None:
            self.numStepsBeforeNotification = numStepsBeforeNotification

        if numDetection is not None:
            self.numDetection = numDetection

        if numDetectionSinceResolved is not None:
            self.numDetectionSinceResolved = numDetectionSinceResolved

        if studentElements:
            self.studentElements.extend(studentElements)

        if lastFeedback is not None:
            self.lastFeedback = lastFeedback

        if instructorElements:
            self.instructorElements.extend(instructorElements)

        if studentSolution is not None:
            self.studentSolution = studentSolution

        if mistakeType is not None:
            self.mistakeType = mistakeType


@abstract
class NamedElement(EObject, metaclass=MetaEClass):

    name = EAttribute(eType=EString, unique=True, derived=False, changeable=True)

    def __init__(self, *, name=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if name is not None:
            self.name = name


class FeedbackItem(EObject, metaclass=MetaEClass):

    usefulness = EAttribute(eType=EDouble, unique=True, derived=False, changeable=True)
    mistakes = EReference(ordered=True, unique=True, containment=False, derived=False)
    modelingAssistant = EReference(ordered=True, unique=True, containment=False, derived=False)
    feedback = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, mistakes=None, modelingAssistant=None, usefulness=None, feedback=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if usefulness is not None:
            self.usefulness = usefulness

        if mistakes is not None:
            self.mistakes = mistakes

        if modelingAssistant is not None:
            self.modelingAssistant = modelingAssistant

        if feedback is not None:
            self.feedback = feedback


class Student(NamedElement):

    id = EAttribute(eType=EString, unique=True, derived=False, changeable=True)
    modelingAssistant = EReference(ordered=True, unique=True, containment=False, derived=False)
    solutions = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
    studentKnowledges = EReference(ordered=True, unique=True,
                                   containment=False, derived=False, upper=-1)
    currentSolution = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, id=None, modelingAssistant=None, solutions=None, studentKnowledges=None, currentSolution=None, **kwargs):

        super().__init__(**kwargs)

        if id is not None:
            self.id = id

        if modelingAssistant is not None:
            self.modelingAssistant = modelingAssistant

        if solutions:
            self.solutions.extend(solutions)

        if studentKnowledges:
            self.studentKnowledges.extend(studentKnowledges)

        if currentSolution is not None:
            self.currentSolution = currentSolution


class ProblemStatement(NamedElement):

    text = EAttribute(eType=EString, unique=True, derived=False, changeable=True)
    problemStatementElements = EReference(
        ordered=True, unique=True, containment=True, derived=False, upper=-1)
    modelingAssistant = EReference(ordered=True, unique=True, containment=False, derived=False)
    studentSolution = EReference(ordered=True, unique=True,
                                 containment=False, derived=False, upper=-1)
    instructorSolution = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, problemStatementElements=None, text=None, modelingAssistant=None, studentSolution=None, instructorSolution=None, **kwargs):

        super().__init__(**kwargs)

        if text is not None:
            self.text = text

        if problemStatementElements:
            self.problemStatementElements.extend(problemStatementElements)

        if modelingAssistant is not None:
            self.modelingAssistant = modelingAssistant

        if studentSolution:
            self.studentSolution.extend(studentSolution)

        if instructorSolution is not None:
            self.instructorSolution = instructorSolution


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
