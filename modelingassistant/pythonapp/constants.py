"""
Application-wide constants for the Python app.
"""

# Metamodel paths
MM_PATH = "modelingassistant/model"
CLASS_DIAGRAM_MM = "ca.mcgill.sel.classdiagram/model/classdiagram.ecore"
LEARNING_CORPUS_MM = f"{MM_PATH}/learningcorpus.ecore"
LEARNING_CORPUS_QUIZ_MM = f"{MM_PATH}/learningcorpusquiz.ecore"
MODELING_ASSISTANT_MM = f"{MM_PATH}/modelingassistant.ecore"

# Model paths
LEARNING_CORPUS_PATH = "modelingassistant/learningcorpusinstances/default.learningcorpus"
DEFAULT_MODELING_ASSISTANT_PATH = "modelingassistant/instances/default.modelingassistant"
MISTAKE_ELEMS_JSON_FILE = "modelingassistant/corpus_descriptions/mistakeelems.json"

# Web endpoints
WEBCORE_ENDPOINT = "http://localhost:8080"

# Learning corpus configuration
USE_CONTEXTUAL_CAPITALIZATION = False  # When True, capitalize feedback Capital/Uppercase Letter occurrences in the text
MULTIPLE_FEEDBACKS_PER_LEVEL = False  # Allow multiple context-specific written feedbacks per level (future work)
CORRECT_QUIZ_ITEM_NOTATIONS = ["true", "t", "√", "1", "7", "correct", "right", "answer"]
T = True  # Not to be confused with T used as a generic type

# TouchCORE conventions
MANY = -1  # the value of -1 is used to indicate a many (*) multiplicity

# Fun stuff
# ASCII art based on patorjk.com/software/taag/#p=display&f=Slant&t=MODELING%20ASSISTANT
# the Ε (greek uppercase ε epsilon) is used instead of a 2nd E in "FEΕDBACK" to allow for easier coloring
# the extra slash between the two Ss in "ASSISTANT" is also intentional
MA_FEEDBACK_ASCII_ART = """\
        __  _______  ____  ________    _____   ________    ___   __________ __________________    _   ________
       /  |/  / __ \/ __ \/ ____/ /   /  _/ | / / ____/   /   | / ___/ ___//  _/ ___/_  __/   |  / | / /_  __/
      / /|_/ / / / / / / / __/ / /    / //  |/ / / __    / /| | \__ \\\__ \ / / \__ \ / / / /| | /  |/ / / /
     / /  / / /_/ / /_/ / /___/ /____/ // /|  / /_/ /   / ___ |___/ /__/ // / ___/ // / / ___ |/ /|  / / /
    /_/  /_/\____/_____/_____/_____/___/_/ |_/\____/   /_/  |_/____/____/___//____//_/ /_/  |_/_/ |_/ /_/

                                                           FFFF  EEEE  ΕΕΕΕ  DD    BBB   A    CCCC  K   K
                                                          F     E     Ε     D  D  B  B  A A  C     K K
                                                         FFFF  EEE   ΕΕΕ   D  D  BBB   AAAA C     KK
                                                        F     E     Ε     D  D  B  B  A   A C    K K
                                                       F     EEEE  ΕΕΕΕ  DDD   BBB   A    A  CC K   K
    """
