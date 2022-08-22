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


class FillInTheBlanksQuizStatement(EObject, metaclass=MetaEClass):

    quiz = EReference(ordered=True, unique=True, containment=False, derived=False)
    components = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)

    def __init__(self, *, quiz=None, components=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if quiz is not None:
            self.quiz = quiz

        if components:
            self.components.extend(components)


class FillInTheBlanksQuizStatementComponent(EObject, metaclass=MetaEClass):

    statement = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, statement=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if statement is not None:
            self.statement = statement


class Choice(EObject, metaclass=MetaEClass):

    text = EAttribute(eType=EString, unique=True, derived=False, changeable=True)
    quiz = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, quiz=None, text=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if text is not None:
            self.text = text

        if quiz is not None:
            self.quiz = quiz


class TableMcqCorrectEntry(EObject, metaclass=MetaEClass):

    quiz = EReference(ordered=True, unique=True, containment=False, derived=False)
    columnItem = EReference(ordered=True, unique=True, containment=False, derived=False)
    rowitem = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, quiz=None, columnItem=None, rowitem=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if quiz is not None:
            self.quiz = quiz

        if columnItem is not None:
            self.columnItem = columnItem

        if rowitem is not None:
            self.rowitem = rowitem


class TableMcqRowItem(EObject, metaclass=MetaEClass):

    text = EAttribute(eType=EString, unique=True, derived=False, changeable=True)
    quiz = EReference(ordered=True, unique=True, containment=False, derived=False)
    correctEntries = EReference(ordered=True, unique=True,
                                containment=False, derived=False, upper=-1)

    def __init__(self, *, text=None, quiz=None, correctEntries=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if text is not None:
            self.text = text

        if quiz is not None:
            self.quiz = quiz

        if correctEntries:
            self.correctEntries.extend(correctEntries)


class TableMcqColumnItem(EObject, metaclass=MetaEClass):

    text = EAttribute(eType=EString, unique=True, derived=False, changeable=True)
    quiz = EReference(ordered=True, unique=True, containment=False, derived=False)
    correctEntries = EReference(ordered=True, unique=True,
                                containment=False, derived=False, upper=-1)

    def __init__(self, *, text=None, quiz=None, correctEntries=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if text is not None:
            self.text = text

        if quiz is not None:
            self.quiz = quiz

        if correctEntries:
            self.correctEntries.extend(correctEntries)


class NonBlank(FillInTheBlanksQuizStatementComponent):

    text = EAttribute(eType=EString, unique=True, derived=False, changeable=True)

    def __init__(self, *, text=None, **kwargs):

        super().__init__(**kwargs)

        if text is not None:
            self.text = text


class Blank(FillInTheBlanksQuizStatementComponent):

    correctAnswer = EAttribute(eType=EString, unique=True, derived=False, changeable=True)

    def __init__(self, *, correctAnswer=None, **kwargs):

        super().__init__(**kwargs)

        if correctAnswer is not None:
            self.correctAnswer = correctAnswer


class FillInTheBlanksQuiz(Quiz):

    statements = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)

    def __init__(self, *, statements=None, **kwargs):

        super().__init__(**kwargs)

        if statements:
            self.statements.extend(statements)


class ListMultipleChoiceQuiz(Quiz):

    choices = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    correctChoices = EReference(ordered=True, unique=True,
                                containment=False, derived=False, upper=-1)

    def __init__(self, *, choices=None, correctChoices=None, **kwargs):

        super().__init__(**kwargs)

        if choices:
            self.choices.extend(choices)

        if correctChoices:
            self.correctChoices.extend(correctChoices)


class TableMultipleChoiceQuiz(Quiz):

    rowItems = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    columnItems = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    correctEntries = EReference(ordered=True, unique=True,
                                containment=True, derived=False, upper=-1)

    def __init__(self, *, rowItems=None, columnItems=None, correctEntries=None, **kwargs):

        super().__init__(**kwargs)

        if rowItems:
            self.rowItems.extend(rowItems)

        if columnItems:
            self.columnItems.extend(columnItems)

        if correctEntries:
            self.correctEntries.extend(correctEntries)
