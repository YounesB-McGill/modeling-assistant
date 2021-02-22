
from .modelingassistant import getEClassifier, eClassifiers
from .modelingassistant import name, nsURI, nsPrefix, eClass
from .modelingassistant import int, boolean, Time, double, ModelingAssistant, Student, ProblemStatement, ProblemStatementElement, UmlElement, Solution, SolutionElement, LearningItem, StudentKnowledge, MistakeType, Mistake, Feedback, TextResponse, ParametrizedResponse, ResourceResponse, LearningResource, Reference, Tutorial, Example, Quiz

from classdiagram import ClassDiagram, NamedElement

from . import modelingassistant

__all__ = ['int', 'boolean', 'Time', 'double', 'ModelingAssistant', 'Student', 'ProblemStatement', 'ProblemStatementElement', 'UmlElement', 'Solution', 'SolutionElement', 'LearningItem',
           'StudentKnowledge', 'MistakeType', 'Mistake', 'Feedback', 'TextResponse', 'ParametrizedResponse', 'ResourceResponse', 'LearningResource', 'Reference', 'Tutorial', 'Example', 'Quiz']

eSubpackages = []
eSuperPackage = None
modelingassistant.eSubpackages = eSubpackages
modelingassistant.eSuperPackage = eSuperPackage

Solution.classDiagram.eType = ClassDiagram
SolutionElement.element.eType = NamedElement
ModelingAssistant.learningItems.eType = LearningItem
ModelingAssistant.learningResources.eType = LearningResource
ModelingAssistant.problemStatements.eType = ProblemStatement
ModelingAssistant.solutions.eType = Solution
ModelingAssistant.umlElements.eType = UmlElement
ModelingAssistant.students.eType = Student
ModelingAssistant.feedbacks.eType = Feedback
ModelingAssistant.mistakes.eType = Mistake
ModelingAssistant.mistakeTypes.eType = MistakeType
ModelingAssistant.studentknowledge.eType = StudentKnowledge
Student.modelingAssistant.eType = ModelingAssistant
Student.modelingAssistant.eOpposite = ModelingAssistant.students
Student.mistakes.eType = Mistake
Student.currentMistake.eType = Mistake
Student.solutions.eType = Solution
Student.studentKnowledges.eType = StudentKnowledge
ProblemStatement.modelingAssistant.eType = ModelingAssistant
ProblemStatement.modelingAssistant.eOpposite = ModelingAssistant.problemStatements
ProblemStatement.problemStatementElements.eType = ProblemStatementElement
ProblemStatementElement.problemStatement.eType = ProblemStatement
ProblemStatementElement.problemStatement.eOpposite = ProblemStatement.problemStatementElements
ProblemStatementElement.solutionElements.eType = SolutionElement
UmlElement.modelingAssistant.eType = ModelingAssistant
UmlElement.modelingAssistant.eOpposite = ModelingAssistant.umlElements
UmlElement.solutionElements.eType = SolutionElement
UmlElement.learningItems.eType = LearningItem
Solution.modelingAssistant.eType = ModelingAssistant
Solution.modelingAssistant.eOpposite = ModelingAssistant.solutions
Solution.student.eType = Student
Solution.student.eOpposite = Student.solutions
Solution.solutionElements.eType = SolutionElement
SolutionElement.problemStatementElements.eType = ProblemStatementElement
SolutionElement.problemStatementElements.eOpposite = ProblemStatementElement.solutionElements
SolutionElement.type.eType = UmlElement
SolutionElement.type.eOpposite = UmlElement.solutionElements
SolutionElement.solution.eType = Solution
SolutionElement.solution.eOpposite = Solution.solutionElements
SolutionElement.mistakes.eType = Mistake
LearningItem.modelingAssistant.eType = ModelingAssistant
LearningItem.modelingAssistant.eOpposite = ModelingAssistant.learningItems
LearningItem.umlElements.eType = UmlElement
LearningItem.umlElements.eOpposite = UmlElement.learningItems
LearningItem.learningResources.eType = LearningResource
LearningItem.mistakeTypes.eType = MistakeType
StudentKnowledge.student.eType = Student
StudentKnowledge.student.eOpposite = Student.studentKnowledges
StudentKnowledge.mistakeType.eType = MistakeType
StudentKnowledge.modelingassistant.eType = ModelingAssistant
StudentKnowledge.modelingassistant.eOpposite = ModelingAssistant.studentknowledge
MistakeType.modelingAssistant.eType = ModelingAssistant
MistakeType.modelingAssistant.eOpposite = ModelingAssistant.mistakeTypes
MistakeType.learningItem.eType = LearningItem
MistakeType.learningItem.eOpposite = LearningItem.mistakeTypes
MistakeType.studentKnowledges.eType = StudentKnowledge
MistakeType.studentKnowledges.eOpposite = StudentKnowledge.mistakeType
MistakeType.mistakes.eType = Mistake
MistakeType.feedbacks.eType = Feedback
Mistake.modelingAssistant.eType = ModelingAssistant
Mistake.modelingAssistant.eOpposite = ModelingAssistant.mistakes
Mistake.mistakeStudent.eType = Student
Mistake.mistakeStudent.eOpposite = Student.mistakes
Mistake.currentMistakeStudent.eType = Student
Mistake.currentMistakeStudent.eOpposite = Student.currentMistake
Mistake.solutionElements.eType = SolutionElement
Mistake.solutionElements.eOpposite = SolutionElement.mistakes
Mistake.mistakeType.eType = MistakeType
Mistake.mistakeType.eOpposite = MistakeType.mistakes
Mistake.lastFeedback.eType = Feedback
Feedback.modelingAssistant.eType = ModelingAssistant
Feedback.modelingAssistant.eOpposite = ModelingAssistant.feedbacks
Feedback.mistakeType.eType = MistakeType
Feedback.mistakeType.eOpposite = MistakeType.feedbacks
Feedback.mistakes.eType = Mistake
Feedback.mistakes.eOpposite = Mistake.lastFeedback
ResourceResponse.learningResources.eType = LearningResource
LearningResource.modelingAssistant.eType = ModelingAssistant
LearningResource.modelingAssistant.eOpposite = ModelingAssistant.learningResources
LearningResource.learningItem.eType = LearningItem
LearningResource.learningItem.eOpposite = LearningItem.learningResources
LearningResource.resourceResponses.eType = ResourceResponse
LearningResource.resourceResponses.eOpposite = ResourceResponse.learningResources

otherClassifiers = [int, boolean, Time, double]

for classif in otherClassifiers:
    eClassifiers[classif.name] = classif
    classif.ePackage = eClass

for classif in eClassifiers.values():
    eClass.eClassifiers.append(classif.eClass)

for subpack in eSubpackages:
    eClass.eSubpackages.append(subpack.eClass)
