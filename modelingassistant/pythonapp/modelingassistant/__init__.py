
from .modelingassistant import getEClassifier, eClassifiers
from .modelingassistant import name, nsURI, nsPrefix, eClass
from .modelingassistant import Time, ModelingAssistant, Student, ProblemStatement, ProblemStatementElement, Solution, SolutionElement, StudentKnowledge, Mistake, NamedElement, FeedbackItem, Tag, TagGroup, TagType, Synonym

from classdiagram import ClassDiagram, NamedElement
from learningcorpus import Feedback, MistakeType

from . import modelingassistant

__all__ = ['Time', 'ModelingAssistant', 'Student', 'ProblemStatement', 'ProblemStatementElement', 'Solution',
           'SolutionElement', 'StudentKnowledge', 'Mistake', 'NamedElement', 'FeedbackItem', 'Tag', 'TagGroup', 'TagType', 'Synonym']

eSubpackages = []
eSuperPackage = None
modelingassistant.eSubpackages = eSubpackages
modelingassistant.eSuperPackage = eSuperPackage

Student.currentSolution.eType = Solution
ProblemStatement.studentSolutions.eType = Solution
ProblemStatement.instructorSolution.eType = Solution
Solution.classDiagram.eType = ClassDiagram
Solution.problemStatement.eType = ProblemStatement
SolutionElement.element.eType = NamedElement
StudentKnowledge.mistakeType.eType = MistakeType
Mistake.mistakeType.eType = MistakeType
FeedbackItem.feedback.eType = Feedback
ModelingAssistant.problemStatements.eType = ProblemStatement
ModelingAssistant.solutions.eType = Solution
ModelingAssistant.students.eType = Student
ModelingAssistant.studentKnowledges.eType = StudentKnowledge
Student.modelingAssistant.eType = ModelingAssistant
Student.modelingAssistant.eOpposite = ModelingAssistant.students
Student.solutions.eType = Solution
Student.studentKnowledges.eType = StudentKnowledge
ProblemStatement.problemStatementElements.eType = ProblemStatementElement
ProblemStatement.modelingAssistant.eType = ModelingAssistant
ProblemStatement.modelingAssistant.eOpposite = ModelingAssistant.problemStatements
ProblemStatementElement.problemStatement.eType = ProblemStatement
ProblemStatementElement.problemStatement.eOpposite = ProblemStatement.problemStatementElements
ProblemStatementElement.solutionElements.eType = SolutionElement
Solution.modelingAssistant.eType = ModelingAssistant
Solution.modelingAssistant.eOpposite = ModelingAssistant.solutions
Solution.student.eType = Student
Solution.student.eOpposite = Student.solutions
Solution.solutionElements.eType = SolutionElement
Solution.mistakes.eType = Mistake
Solution.tagGroups.eType = TagGroup
Solution.feedbackItems.eType = FeedbackItem
SolutionElement.problemStatementElements.eType = ProblemStatementElement
SolutionElement.problemStatementElements.eOpposite = ProblemStatementElement.solutionElements
SolutionElement.solution.eType = Solution
SolutionElement.solution.eOpposite = Solution.solutionElements
SolutionElement.studentElementMistakes.eType = Mistake
SolutionElement.instructorElementMistakes.eType = Mistake
SolutionElement.tags.eType = Tag
SolutionElement.synonyms.eType = Synonym
StudentKnowledge.student.eType = Student
StudentKnowledge.student.eOpposite = Student.studentKnowledges
StudentKnowledge.modelingAssistant.eType = ModelingAssistant
StudentKnowledge.modelingAssistant.eOpposite = ModelingAssistant.studentKnowledges
Mistake.studentElements.eType = SolutionElement
Mistake.studentElements.eOpposite = SolutionElement.studentElementMistakes
Mistake.lastFeedback.eType = FeedbackItem
Mistake.instructorElements.eType = SolutionElement
Mistake.instructorElements.eOpposite = SolutionElement.instructorElementMistakes
Mistake.solution.eType = Solution
Mistake.solution.eOpposite = Solution.mistakes
FeedbackItem.mistake.eType = Mistake
FeedbackItem.mistake.eOpposite = Mistake.lastFeedback
FeedbackItem.solution.eType = Solution
FeedbackItem.solution.eOpposite = Solution.feedbackItems
Tag.solutionElement.eType = SolutionElement
Tag.solutionElement.eOpposite = SolutionElement.tags
Tag.tagGroup.eType = TagGroup
TagGroup.tags.eType = Tag
TagGroup.tags.eOpposite = Tag.tagGroup
TagGroup.solution.eType = Solution
TagGroup.solution.eOpposite = Solution.tagGroups
Synonym.solutionElement.eType = SolutionElement
Synonym.solutionElement.eOpposite = SolutionElement.synonyms

otherClassifiers = [Time, TagType]

for classif in otherClassifiers:
    eClassifiers[classif.name] = classif
    classif.ePackage = eClass

for classif in eClassifiers.values():
    eClass.eClassifiers.append(classif.eClass)

for subpack in eSubpackages:
    eClass.eSubpackages.append(subpack.eClass)
