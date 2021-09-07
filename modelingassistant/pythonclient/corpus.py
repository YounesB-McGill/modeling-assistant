"""
Initializes and provides access to the Learning Corpus at runtime.
"""

from corpus_definition import corpus as corpus_def, mts_by_priority as mts_by_priority_def
from learningcorpus import LearningItem, ResourceResponse
from utils import _mtc_subcats

corpus = corpus_def
mts_by_priority = mts_by_priority_def

domain_modeling = LearningItem(name="DomainModeling")
domain_modeling.learningCorpus = corpus

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
