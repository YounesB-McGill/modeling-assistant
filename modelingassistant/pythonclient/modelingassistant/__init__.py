
from .modelingassistant import getEClassifier, eClassifiers
from .modelingassistant import name, nsURI, nsPrefix, eClass
from .modelingassistant import Time, ModelingAssistant, Student, ProblemStatement, ProblemStatementElement, Solution, SolutionElement, StudentKnowledge, Mistake, NamedElement, FeedbackItem

from learningcorpus import MistakeType, Feedback
from classdiagram import NamedElement, ClassDiagram

from . import modelingassistant

__all__ = ['Time', 'ModelingAssistant', 'Student', 'ProblemStatement', 'ProblemStatementElement',
           'Solution', 'SolutionElement', 'StudentKnowledge', 'Mistake', 'NamedElement', 'FeedbackItem']

eSubpackages = []
eSuperPackage = None
modelingassistant.eSubpackages = eSubpackages
modelingassistant.eSuperPackage = eSuperPackage

Student.currentSolution.eType = Solution
Solution.classDiagram.eType = ClassDiagram
Solution.currentMistake.eType = Mistake
SolutionElement.element.eType = NamedElement
StudentKnowledge.mistakeType.eType = MistakeType
Mistake.mistakeType.eType = MistakeType
FeedbackItem.feedback.eType = Feedback
ModelingAssistant.problemStatements.eType = ProblemStatement
ModelingAssistant.solutions.eType = Solution
ModelingAssistant.students.eType = Student
ModelingAssistant.studentKnowledges.eType = StudentKnowledge
ModelingAssistant.feedbackItems.eType = FeedbackItem
Student.modelingAssistant.eType = ModelingAssistant
Student.modelingAssistant.eOpposite = ModelingAssistant.students
Student.solutions.eType = Solution
Student.studentKnowledges.eType = StudentKnowledge
ProblemStatement.problemStatementElements.eType = ProblemStatementElement
ProblemStatement.modelingAssistant.eType = ModelingAssistant
ProblemStatement.modelingAssistant.eOpposite = ModelingAssistant.problemStatements
ProblemStatement.studentSolution.eType = Solution
ProblemStatement.instructorSolution.eType = Solution
ProblemStatementElement.problemStatement.eType = ProblemStatement
ProblemStatementElement.problemStatement.eOpposite = ProblemStatement.problemStatementElements
ProblemStatementElement.solutionElements.eType = SolutionElement
Solution.modelingAssistant.eType = ModelingAssistant
Solution.modelingAssistant.eOpposite = ModelingAssistant.solutions
Solution.student.eType = Student
Solution.student.eOpposite = Student.solutions
Solution.solutionElements.eType = SolutionElement
Solution.mistakes.eType = Mistake
Solution.studentProblemStatement.eType = ProblemStatement
Solution.studentProblemStatement.eOpposite = ProblemStatement.studentSolution
Solution.instructorProblemStatement.eType = ProblemStatement
Solution.instructorProblemStatement.eOpposite = ProblemStatement.instructorSolution
SolutionElement.problemStatementElements.eType = ProblemStatementElement
SolutionElement.problemStatementElements.eOpposite = ProblemStatementElement.solutionElements
SolutionElement.solution.eType = Solution
SolutionElement.solution.eOpposite = Solution.solutionElements
SolutionElement.studentElementMistakes.eType = Mistake
SolutionElement.instructorElementMistakes.eType = Mistake
StudentKnowledge.student.eType = Student
StudentKnowledge.student.eOpposite = Student.studentKnowledges
StudentKnowledge.modelingAssistant.eType = ModelingAssistant
StudentKnowledge.modelingAssistant.eOpposite = ModelingAssistant.studentKnowledges
Mistake.studentElements.eType = SolutionElement
Mistake.studentElements.eOpposite = SolutionElement.studentElementMistakes
Mistake.lastFeedback.eType = FeedbackItem
Mistake.instructorElements.eType = SolutionElement
Mistake.instructorElements.eOpposite = SolutionElement.instructorElementMistakes
Mistake.studentSolution.eType = Solution
Mistake.studentSolution.eOpposite = Solution.mistakes
FeedbackItem.mistakes.eType = Mistake
FeedbackItem.mistakes.eOpposite = Mistake.lastFeedback
FeedbackItem.modelingAssistant.eType = ModelingAssistant
FeedbackItem.modelingAssistant.eOpposite = ModelingAssistant.feedbackItems

otherClassifiers = [Time]

for classif in otherClassifiers:
    eClassifiers[classif.name] = classif
    classif.ePackage = eClass

for classif in eClassifiers.values():
    eClass.eClassifiers.append(classif.eClass)

for subpack in eSubpackages:
    eClass.eSubpackages.append(subpack.eClass)
