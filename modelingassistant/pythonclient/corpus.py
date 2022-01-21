"""
Initializes and provides access to the Learning Corpus at runtime.
"""

from corpus_definition import (corpus as corpus_def, mts_by_priority as mts_by_priority_def, extra_generalization,
    subclass_should_be_enum_pr_pattern, wrong_superclass, missing_enum, full_pr_pattern_should_be_subclass,
    class_should_be_assoc_class, bad_enum_name_spelling, lowercase_class_name, extra_assoc_class, extra_enum_item,
    non_differentiated_subclass, assoc_should_be_full_pr_pattern, missing_assoc_class, enum_should_be_full_pr_pattern,
    full_pr_pattern_should_be_assoc, enum_should_be_subclass_pr_pattern, assoc_should_be_enum_pr_pattern,
    subclass_should_be_assoc_pr_pattern, plural_class_name, missing_ao_pattern, wrong_class_name,
    assoc_should_be_subclass_pr_pattern, subclass_should_be_full_pr_pattern, bad_enum_item_spelling, extra_enum,
    incomplete_ao_pattern, missing_generalization, extra_class, incomplete_containment_tree,
    assoc_class_should_be_class, incomplete_pr_pattern, software_engineering_term, bad_class_name_spelling,
    missing_enum_item, full_pr_pattern_should_be_enum, missing_class, enum_should_be_assoc_pr_pattern,
    composed_part_contained_in_more_than_one_parent, using_attribute_instead_of_assoc, plural_attribute,
    extra_attribute, uppercase_attribute_name, attribute_duplicated, attribute_should_not_be_static,
    attribute_should_be_static, attribute_misplaced_in_generalization_hierarchy, attribute_misplaced,
    wrong_attribute_type, missing_attribute, bad_attribute_name_spelling, extra_association, missing_association,
    missing_composition, missing_aggregation, extra_composition, wrong_role_name, using_assoc_instead_of_composition,
    using_composition_instead_of_assoc, bad_role_name_spelling, using_composition_instead_of_aggregation,
    using_directed_relationship_instead_of_undirected, wrong_multiplicity, infinite_recursive_dependency,
    using_undirected_relationship_instead_of_directed, role_should_be_static, using_assoc_instead_of_aggregation,
    using_aggregation_instead_of_composition, role_should_not_be_static)
from learningcorpus import LearningItem, ResourceResponse
from utils import _mtc_subcats

corpus = corpus_def
mts_by_priority = mts_by_priority_def

domain_modeling = LearningItem(name="DomainModeling", learningCorpus=corpus, mistakeTypes=[software_engineering_term])

class_ = LearningItem(name="Class", learningCorpus=corpus, mistakeTypes=[
    extra_generalization, subclass_should_be_enum_pr_pattern, wrong_superclass, missing_enum,
    full_pr_pattern_should_be_subclass, class_should_be_assoc_class, bad_enum_name_spelling, lowercase_class_name,
    extra_assoc_class, extra_enum_item, non_differentiated_subclass, assoc_should_be_full_pr_pattern,
    missing_assoc_class, enum_should_be_full_pr_pattern, full_pr_pattern_should_be_assoc,
    enum_should_be_subclass_pr_pattern, assoc_should_be_enum_pr_pattern, subclass_should_be_assoc_pr_pattern,
    plural_class_name, missing_ao_pattern, wrong_class_name, assoc_should_be_subclass_pr_pattern,
    subclass_should_be_full_pr_pattern, bad_enum_item_spelling, extra_enum, incomplete_ao_pattern,
    missing_generalization, extra_class, incomplete_containment_tree, assoc_class_should_be_class,
    incomplete_pr_pattern, software_engineering_term, bad_class_name_spelling, missing_enum_item,
    full_pr_pattern_should_be_enum, missing_class, enum_should_be_assoc_pr_pattern,
    composed_part_contained_in_more_than_one_parent])
attribute = LearningItem(name="Attribute", learningCorpus=corpus, mistakeTypes=[
    using_attribute_instead_of_assoc, plural_attribute, subclass_should_be_enum_pr_pattern, extra_attribute,
    assoc_should_be_enum_pr_pattern, uppercase_attribute_name, attribute_duplicated, attribute_should_not_be_static,
    attribute_should_be_static, attribute_misplaced_in_generalization_hierarchy, attribute_misplaced,
    wrong_attribute_type, missing_attribute, full_pr_pattern_should_be_enum, bad_attribute_name_spelling])
association = LearningItem(name="Association", learningCorpus=corpus, mistakeTypes=[
    extra_association, missing_association, missing_composition, missing_aggregation, extra_composition])
associationend = LearningItem(name="AssociationEnd", learningCorpus=corpus, mistakeTypes=[
    wrong_role_name, using_assoc_instead_of_composition, using_composition_instead_of_assoc, bad_role_name_spelling,
    using_composition_instead_of_aggregation, assoc_should_be_enum_pr_pattern, subclass_should_be_assoc_pr_pattern,
    using_directed_relationship_instead_of_undirected, assoc_should_be_subclass_pr_pattern, wrong_multiplicity,
    infinite_recursive_dependency, using_undirected_relationship_instead_of_directed, assoc_should_be_full_pr_pattern,
    role_should_be_static, using_assoc_instead_of_aggregation, using_aggregation_instead_of_composition,
    enum_should_be_assoc_pr_pattern, role_should_not_be_static, full_pr_pattern_should_be_assoc])

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
