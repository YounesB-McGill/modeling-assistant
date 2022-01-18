"""
Initializes and provides access to the Learning Corpus at runtime.
"""

from corpus_definition import (corpus as corpus_def, mts_by_priority as mts_by_priority_def, lowercase_class_name,
    missing_class, non_differentiated_subclass, subclass_should_be_full_pr_pattern, incomplete_pr_pattern,
    incomplete_ao_pattern, bad_enum_name_spelling, bad_class_name_spelling, assoc_should_be_subclass_pr_pattern,
    missing_enum_item, enum_should_be_assoc_pr_pattern, missing_generalization, missing_enum,
    subclass_should_be_enum_pr_pattern, software_engineering_term, subclass_should_be_assoc_pr_pattern,
    assoc_should_be_full_pr_pattern, extra_class, composed_part_contained_in_more_than_one_parent, missing_ao_pattern,
    extra_enum_item, enum_should_be_full_pr_pattern, full_pr_pattern_should_be_subclass, assoc_class_should_be_class,
    bad_enum_item_spelling, enum_should_be_subclass_pr_pattern, missing_assoc_class, class_should_be_assoc_class,
    wrong_class_name, extra_enum, full_pr_pattern_should_be_enum, full_pr_pattern_should_be_assoc,
    assoc_should_be_enum_pr_pattern, extra_assoc_class, wrong_superclass, incomplete_containment_tree,
    plural_class_name, plural_attribute, uppercase_attribute_name, wrong_attribute_type, extra_attribute,
    attribute_should_not_be_static, missing_attribute, attribute_should_be_static, bad_attribute_name_spelling,
    missing_aggregation, missing_association, extra_association, missing_composition, extra_composition,
    using_composition_instead_of_aggregation, using_composition_instead_of_assoc,
    using_aggregation_instead_of_composition, using_directed_relationship_instead_of_undirected,
    role_should_be_static, wrong_multiplicity, role_should_not_be_static, bad_role_name_spelling, wrong_role_name,
    using_undirected_relationship_instead_of_directed, using_assoc_instead_of_composition,
    using_assoc_instead_of_aggregation)
from learningcorpus import LearningItem, ResourceResponse
from utils import _mtc_subcats

corpus = corpus_def
mts_by_priority = mts_by_priority_def

domain_modeling = LearningItem(name="DomainModeling", learningCorpus=corpus, mistakeTypes=[software_engineering_term])

class_ = LearningItem(name="Class", learningCorpus=corpus, mistakeTypes=[
    composed_part_contained_in_more_than_one_parent, extra_enum_item, full_pr_pattern_should_be_assoc, extra_enum,
    missing_generalization, extra_assoc_class, bad_enum_item_spelling, lowercase_class_name,
    software_engineering_term, enum_should_be_assoc_pr_pattern, wrong_class_name, class_should_be_assoc_class,
    missing_enum_item, bad_enum_name_spelling, enum_should_be_subclass_pr_pattern, enum_should_be_full_pr_pattern,
    full_pr_pattern_should_be_subclass, extra_class, wrong_superclass, incomplete_containment_tree,
    bad_class_name_spelling, missing_class, missing_ao_pattern, non_differentiated_subclass, missing_assoc_class,
    subclass_should_be_enum_pr_pattern, plural_class_name, missing_enum, assoc_class_should_be_class,
    assoc_should_be_subclass_pr_pattern, subclass_should_be_full_pr_pattern, incomplete_pr_pattern,
    full_pr_pattern_should_be_enum, incomplete_ao_pattern, assoc_should_be_enum_pr_pattern,
    assoc_should_be_full_pr_pattern, subclass_should_be_assoc_pr_pattern])
attribute = LearningItem(name="Attribute", learningCorpus=corpus, mistakeTypes=[
    plural_attribute, wrong_attribute_type, extra_attribute, attribute_should_be_static,
    subclass_should_be_enum_pr_pattern, missing_attribute, full_pr_pattern_should_be_enum,
    attribute_should_not_be_static, bad_attribute_name_spelling, assoc_should_be_enum_pr_pattern,
    uppercase_attribute_name])
association = LearningItem(name="Association", learningCorpus=corpus, mistakeTypes=[
    extra_association, missing_association, extra_composition, missing_aggregation, missing_composition])
associationend = LearningItem(name="AssociationEnd", learningCorpus=corpus, mistakeTypes=[
    wrong_multiplicity, bad_role_name_spelling, role_should_not_be_static, full_pr_pattern_should_be_assoc,
    using_assoc_instead_of_composition, using_aggregation_instead_of_composition,
    using_composition_instead_of_aggregation, assoc_should_be_subclass_pr_pattern,
    using_undirected_relationship_instead_of_directed, using_directed_relationship_instead_of_undirected,
    using_assoc_instead_of_aggregation, enum_should_be_assoc_pr_pattern, role_should_be_static, wrong_role_name,
    using_composition_instead_of_assoc, assoc_should_be_enum_pr_pattern, assoc_should_be_full_pr_pattern,
    subclass_should_be_assoc_pr_pattern])

for supercat, subcats in _mtc_subcats.items():
    for subcat in subcats:
        subcat.supercategory = supercat
        subcat.learningCorpus = corpus

for _mt in corpus.mistakeTypes():
    for feedback in _mt.feedbacks:
        feedback.learningCorpus = corpus
        if isinstance(feedback, ResourceResponse):
            for lr in feedback.learningResources:
                lr.learningCorpus = corpus

for i, _mt in enumerate(mts_by_priority, start=1):
    _mt.priority = i
