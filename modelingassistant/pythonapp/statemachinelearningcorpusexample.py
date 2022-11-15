# pylint: disable=anomalous-backslash-in-string

"""
State machine learning corpus example, used for MODELS 2022 paper.

The example is based on the Umple state machine metamodel, where:

- A State has multiple transitions.
- A Transition (which we give the shorthand "trans") has a fromState and a toState.

Example instance of "Transition with correct event to wrong target state" mistake:

Instructor solution: A -> B
Student solution: A -> C; B exists

Parametrized response: The transition from A to C should point towards B instead.

The quiz is based on the following state machine taken from the Lethbridge and Laganière textbook:

```java
class TrafficLight {
  sm {
    RedLight { after 30s -> GreenLight; }
    GreenLight { after 25s -> YellowLight; }
    YellowLight { after 5s -> RedLight; }
  }
}
```

Other possible mistake types in a state machine:

- Missing/extra elements (trivial)
- Bad state name
- Bad state nesting
- Bad action
- Bad guard condition
"""

from __future__ import annotations

from learningcorpus import ParametrizedResponse, Reference, ResourceResponse, TextResponse
from utils import fbs, mt, HighlightSolution, McqFactory


state_machine_reference = Reference()  # pylint: disable=invalid-name
tmcq = McqFactory()
metatypes = {"trans": None, "state": None}

# formatting following what is used in the paper
_ = (
transition_with_correct_event_to_wrong_target_state := mt(
    n="Transition with correct event to wrong target state",
    stud_inst=["trans", "from_state", "to_state"],  # same mistake elements for student and instructor solutions
    feedbacks=fbs({
        1: HighlightSolution(),  # highlight the transition
        2: TextResponse(text="Double check this transition."),
        3: ParametrizedResponse(
            text="The transition from ${stud_from_state} to "
                 "${stud_to_state} should point towards "
                 "${inst_to_state} instead."),
        4: ResourceResponse(learningResources=[tmcq[
            "Complete this table by checking the boxes where "
            "there is a transition from a state to another:",

            "From state\\to state" : "Red | Yellow | Green",
            "Red"                  : "    |        |   √  ",
            "Yellow"               : " √  |        |      ",
            "Green"                : "    |   √    |      ",
        ]]),
        5: ResourceResponse(
            learningResources=[state_machine_reference])}),
    types=metatypes)
)

# priority of this mistake is not explicitly defined, but this can be omitted given the context
