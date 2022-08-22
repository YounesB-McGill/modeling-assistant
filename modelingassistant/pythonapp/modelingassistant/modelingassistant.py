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
TagType = EEnum('TagType', literals=['Abstraction', 'Occurrence', 'Player', 'Role'])
Time = EDataType('Time', instanceClassName='java.sql.Time')

class ModelingAssistant(EObject, metaclass=MetaEClass):
    problemStatements = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    solutions = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    students = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    studentKnowledges = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)

    def __init__(self, *, problemStatements=None, solutions=None, students=None, studentKnowledges=None):
        super().__init__()
        if problemStatements:
            self.problemStatements.extend(problemStatements)
        if solutions:
            self.solutions.extend(solutions)
        if students:
            self.students.extend(students)
        if studentKnowledges:
            self.studentKnowledges.extend(studentKnowledges)
    classDiagramsToSolutions: dict = {}

class Solution(EObject, metaclass=MetaEClass):
    modelingAssistant = EReference(ordered=True, unique=True, containment=False, derived=False)
    student = EReference(ordered=True, unique=True, containment=False, derived=False)
    solutionElements = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    classDiagram = EReference(ordered=True, unique=True, containment=False, derived=False)
    mistakes = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    tagGroups = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    problemStatement = EReference(ordered=True, unique=True, containment=False, derived=False)
    feedbackItems = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)

    def __init__(self, *, modelingAssistant=None, student=None, solutionElements=None, classDiagram=None, mistakes=None, tagGroups=None, problemStatement=None, feedbackItems=None):
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
        if tagGroups:
            self.tagGroups.extend(tagGroups)
        if problemStatement is not None:
            self.problemStatement = problemStatement
        if feedbackItems:
            self.feedbackItems.extend(feedbackItems)

class SolutionElement(EObject, metaclass=MetaEClass):
    problemStatementElements = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
    solution = EReference(ordered=True, unique=True, containment=False, derived=False)
    studentElementMistakes = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
    element = EReference(ordered=True, unique=True, containment=False, derived=False)
    instructorElementMistakes = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
    tags = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    synonyms = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)

    def __init__(self, *, problemStatementElements=None, solution=None, studentElementMistakes=None, element=None, instructorElementMistakes=None, tags=None, synonyms=None):
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
        if tags:
            self.tags.extend(tags)
        if synonyms:
            self.synonyms.extend(synonyms)

class StudentKnowledge(EObject, metaclass=MetaEClass):
    levelOfKnowledge = EAttribute(eType=EDouble, unique=True, derived=False, changeable=True, default_value=5.0)
    student = EReference(ordered=True, unique=True, containment=False, derived=False)
    modelingAssistant = EReference(ordered=True, unique=True, containment=False, derived=False)
    mistakeType = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, levelOfKnowledge=None, student=None, modelingAssistant=None, mistakeType=None):
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
    resolvedByStudent = EAttribute(eType=EBoolean, unique=True, derived=False, changeable=True)
    timeToAddress = EAttribute(eType=Time, unique=True, derived=False, changeable=True)
    numStepsBeforeNotification = EAttribute(eType=EInt, unique=True, derived=False, changeable=True)
    numDetections = EAttribute(eType=EInt, unique=True, derived=False, changeable=True)
    numSinceResolved = EAttribute(eType=EInt, unique=True, derived=False, changeable=True)
    studentElements = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
    lastFeedback = EReference(ordered=True, unique=True, containment=False, derived=False)
    instructorElements = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
    solution = EReference(ordered=True, unique=True, containment=False, derived=False)
    mistakeType = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, resolvedByStudent=None, timeToAddress=None, numStepsBeforeNotification=None, studentElements=None, lastFeedback=None, instructorElements=None, solution=None, numDetections=None, numSinceResolved=None, mistakeType=None):
        super().__init__()
        if resolvedByStudent is not None:
            self.resolvedByStudent = resolvedByStudent
        if timeToAddress is not None:
            self.timeToAddress = timeToAddress
        if numStepsBeforeNotification is not None:
            self.numStepsBeforeNotification = numStepsBeforeNotification
        if numDetections is not None:
            self.numDetections = numDetections
        if numSinceResolved is not None:
            self.numSinceResolved = numSinceResolved
        if studentElements:
            self.studentElements.extend(studentElements)
        if lastFeedback is not None:
            self.lastFeedback = lastFeedback
        if instructorElements:
            self.instructorElements.extend(instructorElements)
        if solution is not None:
            self.solution = solution
        if mistakeType is not None:
            self.mistakeType = mistakeType

@abstract
class NamedElement(EObject, metaclass=MetaEClass):
    name = EAttribute(eType=EString, unique=True, derived=False, changeable=True)

    def __init__(self, *, name=None):
        super().__init__()
        if name is not None:
            self.name = name

class FeedbackItem(EObject, metaclass=MetaEClass):
    usefulness = EAttribute(eType=EDouble, unique=True, derived=False, changeable=True)
    text = EAttribute(eType=EString, unique=True, derived=False, changeable=True)
    mistake = EReference(ordered=True, unique=True, containment=False, derived=False)
    feedback = EReference(ordered=True, unique=True, containment=False, derived=False)
    solution = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, mistake=None, usefulness=None, feedback=None, solution=None, text=None):
        super().__init__()
        if usefulness is not None:
            self.usefulness = usefulness
        if text is not None:
            self.text = text
        if mistake is not None:
            self.mistake = mistake
        if feedback is not None:
            self.feedback = feedback
        if solution is not None:
            self.solution = solution

class Tag(EObject, metaclass=MetaEClass):
    tagType = EAttribute(eType=TagType, unique=True, derived=False, changeable=True)
    solutionElement = EReference(ordered=True, unique=True, containment=False, derived=False)
    tagGroup = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, solutionElement=None, tagGroup=None, tagType=None):
        super().__init__()
        if tagType is not None:
            self.tagType = tagType
        if solutionElement is not None:
            self.solutionElement = solutionElement
        if tagGroup is not None:
            self.tagGroup = tagGroup

class TagGroup(EObject, metaclass=MetaEClass):
    tags = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
    solution = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, tags=None, solution=None):
        super().__init__()
        if tags:
            self.tags.extend(tags)
        if solution is not None:
            self.solution = solution

class Student(NamedElement):
    id = EAttribute(eType=EString, unique=True, derived=False, changeable=True)
    modelingAssistant = EReference(ordered=True, unique=True, containment=False, derived=False)
    solutions = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
    studentKnowledges = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
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
    problemStatementElements = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    modelingAssistant = EReference(ordered=True, unique=True, containment=False, derived=False)
    studentSolutions = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
    instructorSolution = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, problemStatementElements=None, modelingAssistant=None, studentSolutions=None, instructorSolution=None, **kwargs):
        super().__init__(**kwargs)
        if problemStatementElements:
            self.problemStatementElements.extend(problemStatementElements)
        if modelingAssistant is not None:
            self.modelingAssistant = modelingAssistant
        if studentSolutions:
            self.studentSolutions.extend(studentSolutions)
        if instructorSolution is not None:
            self.instructorSolution = instructorSolution

class ProblemStatementElement(NamedElement):
    problemStatement = EReference(ordered=True, unique=True, containment=False, derived=False)
    solutionElements = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)

    def __init__(self, *, problemStatement=None, solutionElements=None, **kwargs):
        super().__init__(**kwargs)
        if problemStatement is not None:
            self.problemStatement = problemStatement
        if solutionElements:
            self.solutionElements.extend(solutionElements)

class Synonym(NamedElement):
    solutionElement = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, solutionElement=None, **kwargs):
        super().__init__(**kwargs)
        if solutionElement is not None:
            self.solutionElement = solutionElement

def override_pyecorevalue_check(self, value, _isinstance=isinstance):
    """
    Overriden version of PyEcoreValue.check() to accept both static and dynamic classes.
    """
    import inspect
    import classdiagram
    import learningcorpus
    feature = self.feature
    etype = self.generic_type or feature._eType
    if not etype:
        try:
            etype = feature.eGenericType.eRawType
            self.generic_type = etype
        except Exception as root_cause:
            raise AttributeError(f'Feature {feature} has no type nor generic') from root_cause
    if not _isinstance(value, etype):
        if etype in (EPackage, EClassifier, EString) or isinstance(value, EProxy) or value.eClass.name == etype.__name__:
            return True
        for _module in [classdiagram, learningcorpus, __import__(__name__)]:
            for (name, cls) in inspect.getmembers(_module, inspect.isclass):
                if name == value.eClass.name and etype.name in (c.__name__ for c in cls.__bases__):
                    return True
        raise BadValueError(got=value, expected=etype, feature=feature)
    return True

from pyecore.valuecontainer import PyEcoreValue
PyEcoreValue.check = override_pyecorevalue_check
