
from .modelingassistant import getEClassifier, eClassifiers
from .modelingassistant import name, nsURI, nsPrefix, eClass
from .modelingassistant import Time, ModelingAssistant, Student, ProblemStatement, ProblemStatementElement, UmlElement, Solution, SolutionElement, LearningItem, StudentKnowledge, MistakeType, Mistake, Feedback, TextResponse, ParametrizedResponse, ResourceResponse, LearningResource, Reference, Tutorial, Example, Quiz, NamedElement, MistakeTypeCategory

from classdiagram import NamedElement, ClassDiagram

from . import modelingassistant

__all__ = ['Time', 'ModelingAssistant', 'Student', 'ProblemStatement', 'ProblemStatementElement', 'UmlElement', 'Solution', 'SolutionElement', 'LearningItem', 'StudentKnowledge', 'MistakeType',
           'Mistake', 'Feedback', 'TextResponse', 'ParametrizedResponse', 'ResourceResponse', 'LearningResource', 'Reference', 'Tutorial', 'Example', 'Quiz', 'NamedElement', 'MistakeTypeCategory']

eSubpackages = []
eSuperPackage = None
modelingassistant.eSubpackages = eSubpackages
modelingassistant.eSuperPackage = eSuperPackage

Solution.classDiagram.eType = ClassDiagram
Solution.currentMistake.eType = Mistake
SolutionElement.element.eType = NamedElement
ModelingAssistant.learningItems.eType = LearningItem
ModelingAssistant.learningResources.eType = LearningResource
ModelingAssistant.problemStatements.eType = ProblemStatement
ModelingAssistant.solutions.eType = Solution
ModelingAssistant.umlElements.eType = UmlElement
ModelingAssistant.students.eType = Student
ModelingAssistant.feedbacks.eType = Feedback
ModelingAssistant.mistakeTypes.eType = MistakeType
ModelingAssistant.studentKnowledges.eType = StudentKnowledge
ModelingAssistant.mistakeTypeCategories.eType = MistakeTypeCategory
Student.modelingAssistant.eType = ModelingAssistant
Student.modelingAssistant.eOpposite = ModelingAssistant.students
Student.solutions.eType = Solution
Student.studentKnowledges.eType = StudentKnowledge
Student.currentSolution.eType = Solution
ProblemStatement.problemStatementElements.eType = ProblemStatementElement
ProblemStatement.modelingAssistant.eType = ModelingAssistant
ProblemStatement.modelingAssistant.eOpposite = ModelingAssistant.problemStatements
ProblemStatement.studentSolution.eType = Solution
ProblemStatement.instructorSolution.eType = Solution
ProblemStatementElement.problemStatement.eType = ProblemStatement
ProblemStatementElement.problemStatement.eOpposite = ProblemStatement.problemStatementElements
ProblemStatementElement.solutionElements.eType = SolutionElement
UmlElement.modelingAssistant.eType = ModelingAssistant
UmlElement.modelingAssistant.eOpposite = ModelingAssistant.umlElements
UmlElement.learningItems.eType = LearningItem
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
Solution.currentStudent.eType = Student
Solution.currentStudent.eOpposite = Student.currentSolution
SolutionElement.problemStatementElements.eType = ProblemStatementElement
SolutionElement.problemStatementElements.eOpposite = ProblemStatementElement.solutionElements
SolutionElement.solution.eType = Solution
SolutionElement.solution.eOpposite = Solution.solutionElements
SolutionElement.studentElementMistakes.eType = Mistake
SolutionElement.instructorElementMistakes.eType = Mistake
LearningItem.modelingAssistant.eType = ModelingAssistant
LearningItem.modelingAssistant.eOpposite = ModelingAssistant.learningItems
LearningItem.umlElements.eType = UmlElement
LearningItem.umlElements.eOpposite = UmlElement.learningItems
LearningItem.learningResources.eType = LearningResource
LearningItem.mistakeTypes.eType = MistakeType
StudentKnowledge.student.eType = Student
StudentKnowledge.student.eOpposite = Student.studentKnowledges
StudentKnowledge.mistakeType.eType = MistakeType
StudentKnowledge.modelingAssistant.eType = ModelingAssistant
StudentKnowledge.modelingAssistant.eOpposite = ModelingAssistant.studentKnowledges
MistakeType.modelingAssistant.eType = ModelingAssistant
MistakeType.modelingAssistant.eOpposite = ModelingAssistant.mistakeTypes
MistakeType.learningItem.eType = LearningItem
MistakeType.learningItem.eOpposite = LearningItem.mistakeTypes
MistakeType.studentKnowledges.eType = StudentKnowledge
MistakeType.studentKnowledges.eOpposite = StudentKnowledge.mistakeType
MistakeType.mistakes.eType = Mistake
MistakeType.feedbacks.eType = Feedback
MistakeType.mistakeTypeCategory.eType = MistakeTypeCategory
Mistake.studentElements.eType = SolutionElement
Mistake.studentElements.eOpposite = SolutionElement.studentElementMistakes
Mistake.mistakeType.eType = MistakeType
Mistake.mistakeType.eOpposite = MistakeType.mistakes
Mistake.lastFeedback.eType = Feedback
Mistake.instructorElements.eType = SolutionElement
Mistake.instructorElements.eOpposite = SolutionElement.instructorElementMistakes
Mistake.studentSolution.eType = Solution
Mistake.studentSolution.eOpposite = Solution.mistakes
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
MistakeTypeCategory.mistakeTypes.eType = MistakeType
MistakeTypeCategory.mistakeTypes.eOpposite = MistakeType.mistakeTypeCategory
MistakeTypeCategory.supercategory.eType = MistakeTypeCategory
MistakeTypeCategory.subcategories.eType = MistakeTypeCategory
MistakeTypeCategory.subcategories.eOpposite = MistakeTypeCategory.supercategory
MistakeTypeCategory.modelingAssistant.eType = ModelingAssistant
MistakeTypeCategory.modelingAssistant.eOpposite = ModelingAssistant.mistakeTypeCategories

otherClassifiers = [Time]

for classif in otherClassifiers:
    eClassifiers[classif.name] = classif
    classif.ePackage = eClass

for classif in eClassifiers.values():
    eClass.eClassifiers.append(classif.eClass)

for subpack in eSubpackages:
    eClass.eSubpackages.append(subpack.eClass)
