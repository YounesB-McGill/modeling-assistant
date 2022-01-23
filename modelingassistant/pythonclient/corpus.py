"""
Initializes and provides access to the Learning Corpus at runtime.
"""
# pylint: disable=invalid-name

from corpus_definition import (corpus as corpus_def, mts_by_priority as mts_by_priority_def,
    composed_part_contained_in_more_than_one_parent, assoc_should_be_subclass_pr_pattern, class_should_be_assoc_class,
    non_differentiated_subclass, incomplete_pr_pattern, bad_enum_name_spelling, subclass_should_be_full_pr_pattern,
    plural_class_name, full_pr_pattern_should_be_enum, extra_generalization, extra_enum_item, extra_assoc_class,
    missing_enum, bad_class_name_spelling, assoc_class_should_be_class, incomplete_ao_pattern, wrong_superclass,
    assoc_should_be_enum_pr_pattern, enum_should_be_assoc_pr_pattern, extra_enum, full_pr_pattern_should_be_subclass,
    subclass_should_be_assoc_pr_pattern, missing_assoc_class, assoc_should_be_full_pr_pattern,
    enum_should_be_subclass_pr_pattern, software_engineering_term, enum_should_be_full_pr_pattern,
    subclass_should_be_enum_pr_pattern, missing_enum_item, missing_class, missing_generalization, extra_class,
    missing_ao_pattern, wrong_class_name, bad_enum_item_spelling, full_pr_pattern_should_be_assoc,
    incomplete_containment_tree, lowercase_class_name, extra_attribute, bad_attribute_name_spelling,
    wrong_attribute_type, missing_attribute, attribute_misplaced, attribute_duplicated,
    using_attribute_instead_of_assoc, plural_attribute, attribute_should_not_be_static,
    attribute_misplaced_in_generalization_hierarchy, attribute_should_be_static, uppercase_attribute_name,
    extra_association, missing_association, missing_aggregation, using_undirected_relationship_instead_of_directed,
    using_composition_instead_of_aggregation, wrong_multiplicity, using_assoc_instead_of_aggregation,
    using_composition_instead_of_assoc, using_directed_relationship_instead_of_undirected, role_should_be_static,
    role_should_not_be_static, bad_role_name_spelling, using_aggregation_instead_of_composition,
    infinite_recursive_dependency, wrong_role_name, using_assoc_instead_of_composition, missing_composition,
    extra_composition)
from constants import USE_CONTEXTUAL_CAPITALIZATION
from learningcorpus import LearningItem, ResourceResponse, ParametrizedResponse
from utils import _mtc_subcats, warn


WARN_ABOUT_MISTAKE_TYPES_WITHOUT_PARAM_RESP = False

CL = "Capital Letter"
UL = "Uppercase Letter"

corpus = corpus_def
mts_by_priority = mts_by_priority_def

domain_modeling = LearningItem(name="DomainModeling", learningCorpus=corpus)

class_ = LearningItem(name="Class", learningCorpus=corpus, mistakeTypes=[
    composed_part_contained_in_more_than_one_parent, assoc_should_be_subclass_pr_pattern, class_should_be_assoc_class,
    non_differentiated_subclass, incomplete_pr_pattern, bad_enum_name_spelling, subclass_should_be_full_pr_pattern,
    plural_class_name, full_pr_pattern_should_be_enum, extra_generalization, extra_enum_item, extra_assoc_class,
    missing_enum, bad_class_name_spelling, assoc_class_should_be_class, incomplete_ao_pattern, wrong_superclass,
    assoc_should_be_enum_pr_pattern, enum_should_be_assoc_pr_pattern, extra_enum, full_pr_pattern_should_be_subclass,
    subclass_should_be_assoc_pr_pattern, missing_assoc_class, assoc_should_be_full_pr_pattern,
    enum_should_be_subclass_pr_pattern, software_engineering_term, enum_should_be_full_pr_pattern,
    subclass_should_be_enum_pr_pattern, missing_enum_item, missing_class, missing_generalization, extra_class,
    missing_ao_pattern, wrong_class_name, bad_enum_item_spelling, full_pr_pattern_should_be_assoc,
    incomplete_containment_tree, lowercase_class_name])
attribute = LearningItem(name="Attribute", learningCorpus=corpus, mistakeTypes=[
    extra_attribute, bad_attribute_name_spelling, wrong_attribute_type, missing_attribute, attribute_misplaced,
    attribute_duplicated, full_pr_pattern_should_be_enum, subclass_should_be_enum_pr_pattern,
    using_attribute_instead_of_assoc, plural_attribute, attribute_should_not_be_static,
    attribute_misplaced_in_generalization_hierarchy, attribute_should_be_static, assoc_should_be_enum_pr_pattern,
    uppercase_attribute_name])
association = LearningItem(name="Association", learningCorpus=corpus, mistakeTypes=[
    extra_association, missing_association, missing_aggregation])
associationend = LearningItem(name="AssociationEnd", learningCorpus=corpus, mistakeTypes=[
    using_undirected_relationship_instead_of_directed, assoc_should_be_subclass_pr_pattern,
    assoc_should_be_full_pr_pattern, using_composition_instead_of_aggregation, wrong_multiplicity,
    using_assoc_instead_of_aggregation, using_composition_instead_of_assoc,
    using_directed_relationship_instead_of_undirected, role_should_be_static, role_should_not_be_static,
    assoc_should_be_enum_pr_pattern, bad_role_name_spelling, enum_should_be_assoc_pr_pattern,
    full_pr_pattern_should_be_assoc, using_aggregation_instead_of_composition, infinite_recursive_dependency,
    wrong_role_name, using_assoc_instead_of_composition, subclass_should_be_assoc_pr_pattern])
composition = LearningItem(name="Composition", learningCorpus=corpus, mistakeTypes=[
    missing_composition, extra_composition])


for supercat, subcats in _mtc_subcats.items():
    for subcat in subcats:
        subcat.supercategory = supercat
        subcat.learningCorpus = corpus

for _mt in corpus.mistakeTypes():
    has_param_resp = False
    for feedback in _mt.feedbacks:
        feedback.learningCorpus = corpus
        if isinstance(feedback, ResourceResponse):
            for lr in feedback.learningResources:
                lr.learningCorpus = corpus
        if isinstance(feedback, ParametrizedResponse):
            has_param_resp = True
    if WARN_ABOUT_MISTAKE_TYPES_WITHOUT_PARAM_RESP and not has_param_resp:
        warn(f'Mistake type "{_mt.name}" has no parametrized response')

for i, _mt in enumerate(mts_by_priority, start=1):
    _mt.priority = i


def effectuate_contextual_capitalization(use_caps: bool = None):
    "Enable or disable contextual capitalization in the feedback texts."
    if use_caps is None:
        use_caps = USE_CONTEXTUAL_CAPITALIZATION
    for fb in corpus.feedbacks:
        if fb.text:
            if use_caps:
                fb.text = fb.text.replace(CL.lower(), CL).replace(UL.lower(), UL)
            else:
                fb.text = fb.text.replace(CL, CL.lower()).replace(UL, UL.lower())


effectuate_contextual_capitalization()
