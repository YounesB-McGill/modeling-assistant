
from .learningcorpusquiz import getEClassifier, eClassifiers
from .learningcorpusquiz import name, nsURI, nsPrefix, eClass
from .learningcorpusquiz import FillInTheBlanksQuiz, ListMultipleChoiceQuiz, TableMultipleChoiceQuiz, FillInTheBlanksQuizStatement, FillInTheBlanksQuizStatementComponent, NonBlank, Blank, Choice, TableMcqCorrectEntry, TableMcqRowItem, TableMcqColumnItem


from . import learningcorpusquiz

__all__ = ['FillInTheBlanksQuiz', 'ListMultipleChoiceQuiz', 'TableMultipleChoiceQuiz', 'FillInTheBlanksQuizStatement',
           'FillInTheBlanksQuizStatementComponent', 'NonBlank', 'Blank', 'Choice', 'TableMcqCorrectEntry', 'TableMcqRowItem', 'TableMcqColumnItem']

eSubpackages = []
eSuperPackage = None
learningcorpusquiz.eSubpackages = eSubpackages
learningcorpusquiz.eSuperPackage = eSuperPackage

ListMultipleChoiceQuiz.correctChoices.eType = Choice
FillInTheBlanksQuiz.statements.eType = FillInTheBlanksQuizStatement
ListMultipleChoiceQuiz.choices.eType = Choice
TableMultipleChoiceQuiz.rowItems.eType = TableMcqRowItem
TableMultipleChoiceQuiz.columnItems.eType = TableMcqColumnItem
TableMultipleChoiceQuiz.correctEntries.eType = TableMcqCorrectEntry
FillInTheBlanksQuizStatement.quiz.eType = FillInTheBlanksQuiz
FillInTheBlanksQuizStatement.quiz.eOpposite = FillInTheBlanksQuiz.statements
FillInTheBlanksQuizStatement.components.eType = FillInTheBlanksQuizStatementComponent
FillInTheBlanksQuizStatementComponent.statement.eType = FillInTheBlanksQuizStatement
FillInTheBlanksQuizStatementComponent.statement.eOpposite = FillInTheBlanksQuizStatement.components
Choice.quiz.eType = ListMultipleChoiceQuiz
Choice.quiz.eOpposite = ListMultipleChoiceQuiz.choices
TableMcqCorrectEntry.quiz.eType = TableMultipleChoiceQuiz
TableMcqCorrectEntry.quiz.eOpposite = TableMultipleChoiceQuiz.correctEntries
TableMcqCorrectEntry.columnItem.eType = TableMcqColumnItem
TableMcqCorrectEntry.rowitem.eType = TableMcqRowItem
TableMcqRowItem.quiz.eType = TableMultipleChoiceQuiz
TableMcqRowItem.quiz.eOpposite = TableMultipleChoiceQuiz.rowItems
TableMcqRowItem.correctEntries.eType = TableMcqCorrectEntry
TableMcqRowItem.correctEntries.eOpposite = TableMcqCorrectEntry.rowitem
TableMcqColumnItem.quiz.eType = TableMultipleChoiceQuiz
TableMcqColumnItem.quiz.eOpposite = TableMultipleChoiceQuiz.columnItems
TableMcqColumnItem.correctEntries.eType = TableMcqCorrectEntry
TableMcqColumnItem.correctEntries.eOpposite = TableMcqCorrectEntry.columnItem

otherClassifiers = []

for classif in otherClassifiers:
    eClassifiers[classif.name] = classif
    classif.ePackage = eClass

for classif in eClassifiers.values():
    eClass.eClassifiers.append(classif.eClass)

for subpack in eSubpackages:
    eClass.eSubpackages.append(subpack.eClass)
