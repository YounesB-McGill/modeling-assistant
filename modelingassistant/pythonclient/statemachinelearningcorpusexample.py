"""
State machine learning corpus example, used for MODELS 2022 paper.

The example is based on the Umple state machine metamodel, where:

- A State has multiple transitions.
- A Transition (which we give the shorthand "trans") has a fromState and a toState.

Example instance:

Instructor solution: A -> B
Student solution: A -> C; B exists

Parametrized response: The transition from A to C should point towards B instead.
"""

from learningcorpus import ParametrizedResponse, ResourceResponse, TextResponse
from utils import fbs, mdf, mt, HighlightSolution


state_machine_reference = "dummy"  # pylint: disable=invalid-name


transition_to_wrong_state = mt(n="Transition with correct event to wrong target state", feedbacks=fbs({
    1: HighlightSolution(),  # highlight the transition
    2: TextResponse(text="Double check this transition."),
    3: ParametrizedResponse(text="The transition from ${stud_from_state} to ${stud_to_state} should point towards "
                                 "${inst_to_state} instead."),
    # 4: Add a 2D quiz with from/to states
    5: ResourceResponse(learningResources=[state_machine_reference]),
}))

# priority of this mistake is not explicit defined, but this can be omitted given the context

# for this example, use `mistake_elems` instead of `md_format` (stud, inst elems)
transition_to_wrong_state.mistake_elems = mdf(["trans", "from_state", "to_state"], ["trans", "from_state", "to_state"])

"""
Other possible mistake types in a state machine:

- Missing/extra elements (trivial)
- Bad state name
- Bad state nesting
- Bad action
- Bad guard condition
"""
