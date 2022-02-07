"""
Initializes and provides access to the Learning Corpus at runtime.
"""
# pylint: disable=invalid-name

from corpus_definition import (corpus as corpus_def, mts_by_priority as mts_by_priority_def, bad_enum_item_spelling,
    assoc_should_be_subclass_pr_pattern, wrong_superclass, incomplete_ao_pattern, class_should_be_assoc_class,
    class_should_be_enum, subclass_should_be_full_pr_pattern, full_pr_pattern_should_be_enum,
    bad_assoc_class_name_spelling, incomplete_pr_pattern, non_differentiated_subclass, extra_assoc_class,
    wrong_generalization_direction, missing_enum, wrong_class_name, assoc_class_should_be_class,
    bad_enum_name_spelling, assoc_should_be_enum_pr_pattern, enum_should_be_assoc_pr_pattern,
    incomplete_containment_tree, full_pr_pattern_should_be_subclass, subclass_should_be_assoc_pr_pattern,
    extra_enum_item, generalization_should_be_assoc_ao_pattern, assoc_should_be_full_pr_pattern,
    enum_should_be_subclass_pr_pattern, software_engineering_term, enum_should_be_full_pr_pattern,
    subclass_should_be_enum_pr_pattern, enum_should_be_class, missing_enum_item, bad_class_name_spelling,
    missing_class, missing_assoc_class, lowercase_class_name, plural_class_name, extra_enum, extra_class,
    missing_ao_pattern, full_pr_pattern_should_be_assoc, missing_generalization,
    composed_part_contained_in_more_than_one_parent, extra_generalization, bad_attribute_name_spelling,
    extra_attribute, wrong_attribute_type, missing_attribute, attribute_misplaced, attribute_duplicated,
    attribute_should_not_be_static, plural_attribute, attribute_misplaced_in_generalization_hierarchy,
    using_attribute_instead_of_assoc, attribute_should_be_static, uppercase_attribute_name, extra_aggregation,
    missing_aggregation, missing_association, extra_association, infinite_recursive_dependency,
    using_assoc_instead_of_aggregation, using_directed_relationship_instead_of_undirected, wrong_multiplicity,
    missing_role_names, using_aggregation_instead_of_composition, using_assoc_instead_of_composition,
    role_should_not_be_static, bad_role_name_spelling, role_should_be_static, using_composition_instead_of_assoc,
    using_undirected_relationship_instead_of_directed, using_composition_instead_of_aggregation,
    representing_action_with_assoc, wrong_role_name, extra_composition, missing_composition)
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
    bad_enum_item_spelling, assoc_should_be_subclass_pr_pattern, wrong_superclass, incomplete_ao_pattern,
    class_should_be_assoc_class, class_should_be_enum, subclass_should_be_full_pr_pattern,
    full_pr_pattern_should_be_enum, bad_assoc_class_name_spelling, incomplete_pr_pattern, non_differentiated_subclass,
    extra_assoc_class, wrong_generalization_direction, missing_enum, wrong_class_name, assoc_class_should_be_class,
    bad_enum_name_spelling, assoc_should_be_enum_pr_pattern, enum_should_be_assoc_pr_pattern,
    incomplete_containment_tree, full_pr_pattern_should_be_subclass, subclass_should_be_assoc_pr_pattern,
    extra_enum_item, generalization_should_be_assoc_ao_pattern, assoc_should_be_full_pr_pattern,
    enum_should_be_subclass_pr_pattern, software_engineering_term, enum_should_be_full_pr_pattern,
    subclass_should_be_enum_pr_pattern, enum_should_be_class, missing_enum_item, bad_class_name_spelling,
    missing_class, missing_assoc_class, lowercase_class_name, plural_class_name, extra_enum, extra_class,
    missing_ao_pattern, full_pr_pattern_should_be_assoc, missing_generalization,
    composed_part_contained_in_more_than_one_parent, extra_generalization])
attribute = LearningItem(name="Attribute", learningCorpus=corpus, mistakeTypes=[
    bad_attribute_name_spelling, extra_attribute, wrong_attribute_type, missing_attribute, attribute_misplaced,
    attribute_duplicated, full_pr_pattern_should_be_enum, subclass_should_be_enum_pr_pattern,
    attribute_should_not_be_static, plural_attribute, attribute_misplaced_in_generalization_hierarchy,
    using_attribute_instead_of_assoc, attribute_should_be_static, assoc_should_be_enum_pr_pattern,
    uppercase_attribute_name])
association = LearningItem(name="Association", learningCorpus=corpus, mistakeTypes=[
    extra_aggregation, missing_aggregation, missing_association, extra_association])
associationend = LearningItem(name="AssociationEnd", learningCorpus=corpus, mistakeTypes=[
    infinite_recursive_dependency, assoc_should_be_subclass_pr_pattern, using_assoc_instead_of_aggregation,
    assoc_should_be_full_pr_pattern, using_directed_relationship_instead_of_undirected, wrong_multiplicity,
    missing_role_names, using_aggregation_instead_of_composition, using_assoc_instead_of_composition,
    role_should_not_be_static, bad_role_name_spelling, role_should_be_static, using_composition_instead_of_assoc,
    using_undirected_relationship_instead_of_directed, using_composition_instead_of_aggregation,
    assoc_should_be_enum_pr_pattern, enum_should_be_assoc_pr_pattern, full_pr_pattern_should_be_assoc,
    representing_action_with_assoc, wrong_role_name, subclass_should_be_assoc_pr_pattern])
composition = LearningItem(name="Composition", learningCorpus=corpus, mistakeTypes=[
    extra_composition, missing_composition])


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
