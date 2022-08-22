
from .learningcorpus import getEClassifier, eClassifiers
from .learningcorpus import name, nsURI, nsPrefix, eClass
from .learningcorpus import Time, LearningItem, MistakeType, Feedback, TextResponse, ParametrizedResponse, ResourceResponse, LearningResource, Reference, Tutorial, Example, Quiz, NamedElement, MistakeTypeCategory, LearningCorpus, ElementType, MistakeElement


from . import learningcorpus

__all__ = ['Time', 'LearningItem', 'MistakeType', 'Feedback', 'TextResponse', 'ParametrizedResponse', 'ResourceResponse', 'LearningResource',
           'Reference', 'Tutorial', 'Example', 'Quiz', 'NamedElement', 'MistakeTypeCategory', 'LearningCorpus', 'ElementType', 'MistakeElement']

eSubpackages = []
eSuperPackage = None
learningcorpus.eSubpackages = eSubpackages
learningcorpus.eSuperPackage = eSuperPackage

MistakeType.studentElements.eType = MistakeElement
MistakeType.instructorElements.eType = MistakeElement
LearningItem.learningResources.eType = LearningResource
LearningItem.mistakeTypes.eType = MistakeType
LearningItem.learningCorpus.eType = LearningCorpus
MistakeType.learningItem.eType = LearningItem
MistakeType.learningItem.eOpposite = LearningItem.mistakeTypes
MistakeType.feedbacks.eType = Feedback
MistakeType.mistakeTypeCategory.eType = MistakeTypeCategory
Feedback.mistakeType.eType = MistakeType
Feedback.mistakeType.eOpposite = MistakeType.feedbacks
Feedback.learningCorpus.eType = LearningCorpus
ResourceResponse.learningResources.eType = LearningResource
LearningResource.learningItem.eType = LearningItem
LearningResource.learningItem.eOpposite = LearningItem.learningResources
LearningResource.resourceResponses.eType = ResourceResponse
LearningResource.resourceResponses.eOpposite = ResourceResponse.learningResources
LearningResource.learningCorpus.eType = LearningCorpus
MistakeTypeCategory.mistakeTypes.eType = MistakeType
MistakeTypeCategory.mistakeTypes.eOpposite = MistakeType.mistakeTypeCategory
MistakeTypeCategory.supercategory.eType = MistakeTypeCategory
MistakeTypeCategory.subcategories.eType = MistakeTypeCategory
MistakeTypeCategory.subcategories.eOpposite = MistakeTypeCategory.supercategory
MistakeTypeCategory.learningCorpus.eType = LearningCorpus
LearningCorpus.mistakeTypeCategories.eType = MistakeTypeCategory
LearningCorpus.mistakeTypeCategories.eOpposite = MistakeTypeCategory.learningCorpus
LearningCorpus.feedbacks.eType = Feedback
LearningCorpus.feedbacks.eOpposite = Feedback.learningCorpus
LearningCorpus.learningItems.eType = LearningItem
LearningCorpus.learningItems.eOpposite = LearningItem.learningCorpus
LearningCorpus.learningResources.eType = LearningResource
LearningCorpus.learningResources.eOpposite = LearningResource.learningCorpus

otherClassifiers = [Time, ElementType]

for classif in otherClassifiers:
    eClassifiers[classif.name] = classif
    classif.ePackage = eClass

for classif in eClassifiers.values():
    eClass.eClassifiers.append(classif.eClass)

for subpack in eSubpackages:
    eClass.eSubpackages.append(subpack.eClass)
