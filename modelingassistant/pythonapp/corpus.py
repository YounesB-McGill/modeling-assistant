"""
Initializes and provides access to the Learning Corpus at runtime.
"""
# pylint: disable=invalid-name

from corpus_definition import (corpus as corpus_def, mts_by_priority as mts_by_priority_def,
    enum_should_be_subclass_pr_pattern, missing_generalization, incomplete_pr_pattern, bad_enum_item_spelling,
    full_pr_pattern_should_be_enum, extra_enum, wrong_class_name, bad_class_name_spelling,
    enum_should_be_full_pr_pattern, incomplete_containment_tree, missing_ao_pattern, missing_enum,
    subclass_should_be_enum_pr_pattern, full_pr_pattern_should_be_assoc, assoc_class_should_be_class,
    class_should_be_enum, extra_assoc_class, software_engineering_term, assoc_should_be_full_pr_pattern,
    assoc_should_be_subclass_pr_pattern, extra_enum_item, subclass_should_be_full_pr_pattern,
    non_differentiated_subclass, extra_class, enum_should_be_assoc_pr_pattern, bad_assoc_class_name_spelling,
    bad_enum_name_spelling, missing_enum_item, lowercase_class_name, full_pr_pattern_should_be_subclass,
    class_should_be_assoc_class, wrong_superclass, reversed_generalization_direction, missing_assoc_class,
    plural_class_name, subclass_should_be_assoc_pr_pattern, assoc_should_be_enum_pr_pattern,
    generalization_should_be_assoc_ao_pattern, missing_class, enum_should_be_class, incomplete_ao_pattern,
    composed_part_contained_in_more_than_one_parent, extra_generalization, attribute_should_not_be_static,
    attribute_misplaced_in_generalization_hierarchy, using_attribute_instead_of_assoc, plural_attribute,
    missing_attribute, uppercase_attribute_name, extra_attribute, attribute_should_be_static, attribute_duplicated,
    bad_attribute_name_spelling, wrong_attribute_type, attribute_misplaced, extra_aggregation, missing_aggregation,
    extra_association, missing_association, role_should_not_be_static, bad_role_name_spelling,
    using_composition_instead_of_assoc, using_directed_relationship_instead_of_undirected,
    using_composition_instead_of_aggregation, wrong_role_name, infinite_recursive_dependency,
    using_aggregation_instead_of_composition, missing_role_name, wrong_multiplicity,
    using_assoc_instead_of_composition, role_should_be_static, using_undirected_relationship_instead_of_directed,
    representing_action_with_assoc, using_assoc_instead_of_aggregation, extra_composition, missing_composition)
from constants import USE_CONTEXTUAL_CAPITALIZATION
from learningcorpus import LearningItem, MistakeType, ResourceResponse, ParametrizedResponse
from utils import _mtc_subcats, warn


WARN_ABOUT_MISTAKE_TYPES_WITHOUT_PARAM_RESP = False

CL = "Capital Letter"
UL = "Uppercase Letter"

corpus = corpus_def
mts_by_priority = [mt for mt in mts_by_priority_def if isinstance(mt, MistakeType)]

domain_modeling = LearningItem(name="DomainModeling", learningCorpus=corpus)

class_ = LearningItem(name="Class", learningCorpus=corpus, mistakeTypes=[
    enum_should_be_subclass_pr_pattern, missing_generalization, incomplete_pr_pattern, bad_enum_item_spelling,
    full_pr_pattern_should_be_enum, extra_enum, wrong_class_name, bad_class_name_spelling,
    enum_should_be_full_pr_pattern, incomplete_containment_tree, missing_ao_pattern, missing_enum,
    subclass_should_be_enum_pr_pattern, full_pr_pattern_should_be_assoc, assoc_class_should_be_class,
    class_should_be_enum, extra_assoc_class, software_engineering_term, assoc_should_be_full_pr_pattern,
    assoc_should_be_subclass_pr_pattern, extra_enum_item, subclass_should_be_full_pr_pattern,
    non_differentiated_subclass, extra_class, enum_should_be_assoc_pr_pattern, bad_assoc_class_name_spelling,
    bad_enum_name_spelling, missing_enum_item, lowercase_class_name, full_pr_pattern_should_be_subclass,
    class_should_be_assoc_class, wrong_superclass, reversed_generalization_direction, missing_assoc_class,
    plural_class_name, subclass_should_be_assoc_pr_pattern, assoc_should_be_enum_pr_pattern,
    generalization_should_be_assoc_ao_pattern, missing_class, enum_should_be_class, incomplete_ao_pattern,
    composed_part_contained_in_more_than_one_parent, extra_generalization])
attribute = LearningItem(name="Attribute", learningCorpus=corpus, mistakeTypes=[
    attribute_should_not_be_static, attribute_misplaced_in_generalization_hierarchy, using_attribute_instead_of_assoc,
    plural_attribute, missing_attribute, full_pr_pattern_should_be_enum, uppercase_attribute_name, extra_attribute,
    attribute_should_be_static, attribute_duplicated, subclass_should_be_enum_pr_pattern,
    assoc_should_be_enum_pr_pattern, bad_attribute_name_spelling, wrong_attribute_type, attribute_misplaced])
association = LearningItem(name="Association", learningCorpus=corpus, mistakeTypes=[
    extra_aggregation, missing_aggregation, extra_association, missing_association])
associationend = LearningItem(name="AssociationEnd", learningCorpus=corpus, mistakeTypes=[
    role_should_not_be_static, using_attribute_instead_of_assoc, assoc_should_be_subclass_pr_pattern,
    bad_role_name_spelling, using_composition_instead_of_assoc, enum_should_be_assoc_pr_pattern,
    using_directed_relationship_instead_of_undirected, using_composition_instead_of_aggregation, wrong_role_name,
    infinite_recursive_dependency, using_aggregation_instead_of_composition, missing_role_name, wrong_multiplicity,
    using_assoc_instead_of_composition, subclass_should_be_assoc_pr_pattern, assoc_should_be_enum_pr_pattern,
    role_should_be_static, using_undirected_relationship_instead_of_directed, full_pr_pattern_should_be_assoc,
    representing_action_with_assoc, using_assoc_instead_of_aggregation, assoc_should_be_full_pr_pattern])
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
