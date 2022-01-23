
from .learningcorpusquiz import getEClassifier, eClassifiers
from .learningcorpusquiz import name, nsURI, nsPrefix, eClass
from .learningcorpusquiz import FillInTheBlanksQuiz, ListMultipleChoiceQuiz, TableMultipleChoiceQuiz, FillInTheBlanksQuizStatement, FillInTheBlanksQuizStatementComponent, NonBlank, Blank, Choice, TableMcqEntry, TableMcqRowItem, TableMcqColumnItem


from . import learningcorpusquiz

__all__ = ['FillInTheBlanksQuiz', 'ListMultipleChoiceQuiz', 'TableMultipleChoiceQuiz', 'FillInTheBlanksQuizStatement',
           'FillInTheBlanksQuizStatementComponent', 'NonBlank', 'Blank', 'Choice', 'TableMcqEntry', 'TableMcqRowItem', 'TableMcqColumnItem']

eSubpackages = []
eSuperPackage = None
learningcorpusquiz.eSubpackages = eSubpackages
learningcorpusquiz.eSuperPackage = eSuperPackage

ListMultipleChoiceQuiz.correctChoices.eType = Choice
FillInTheBlanksQuiz.statements.eType = FillInTheBlanksQuizStatement
ListMultipleChoiceQuiz.choices.eType = Choice
TableMultipleChoiceQuiz.rowItems.eType = TableMcqRowItem
TableMultipleChoiceQuiz.columnItems.eType = TableMcqColumnItem
TableMultipleChoiceQuiz.entries.eType = TableMcqEntry
FillInTheBlanksQuizStatement.quiz.eType = FillInTheBlanksQuiz
FillInTheBlanksQuizStatement.quiz.eOpposite = FillInTheBlanksQuiz.statements
FillInTheBlanksQuizStatement.statements.eType = FillInTheBlanksQuizStatementComponent
FillInTheBlanksQuizStatementComponent.statement.eType = FillInTheBlanksQuizStatement
FillInTheBlanksQuizStatementComponent.statement.eOpposite = FillInTheBlanksQuizStatement.statements
Choice.quiz.eType = ListMultipleChoiceQuiz
Choice.quiz.eOpposite = ListMultipleChoiceQuiz.choices
TableMcqEntry.quiz.eType = TableMultipleChoiceQuiz
TableMcqEntry.quiz.eOpposite = TableMultipleChoiceQuiz.entries
TableMcqEntry.columnItem.eType = TableMcqColumnItem
TableMcqEntry.rowitem.eType = TableMcqRowItem
TableMcqRowItem.quiz.eType = TableMultipleChoiceQuiz
TableMcqRowItem.quiz.eOpposite = TableMultipleChoiceQuiz.rowItems
TableMcqRowItem.entries.eType = TableMcqEntry
TableMcqRowItem.entries.eOpposite = TableMcqEntry.rowitem
TableMcqColumnItem.quiz.eType = TableMultipleChoiceQuiz
TableMcqColumnItem.quiz.eOpposite = TableMultipleChoiceQuiz.columnItems
TableMcqColumnItem.entries.eType = TableMcqEntry
TableMcqColumnItem.entries.eOpposite = TableMcqEntry.columnItem

otherClassifiers = []

for classif in otherClassifiers:
    eClassifiers[classif.name] = classif
    classif.ePackage = eClass

for classif in eClassifiers.values():
    eClass.eClassifiers.append(classif.eClass)

for subpack in eSubpackages:
    eClass.eSubpackages.append(subpack.eClass)
