"""
Application-wide constants for the Python app.
"""

# Metamodel paths
MM_PATH = "modelingassistant/model"
CLASS_DIAGRAM_MM = "ca.mcgill.sel.classdiagram/model/classdiagram.ecore"
LEARNING_CORPUS_MM = f"{MM_PATH}/learningcorpus.ecore"
MODELING_ASSISTANT_MM = f"{MM_PATH}/modelingassistant.ecore"

# Model paths
LEARNING_CORPUS_PATH = "modelingassistant/learningcorpusinstances/default.learningcorpus"
DEFAULT_MODELING_ASSISTANT_PATH = "modelingassistant/instances/default.modelingassistant"

# Web endpoints
WEBCORE_ENDPOINT = "http://localhost:8080"

# Learning corpus configuration
USE_CONTEXTUAL_CAPITALIZATION = False  # When True, capitalize feedback Capital/Uppercase Letter occurrences in the text
MULTIPLE_FEEDBACKS_PER_LEVEL = False  # Allow multiple context-specific written feedbacks per level (future work)
