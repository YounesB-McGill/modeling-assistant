#!/usr/bin/env python3

"""
Module containing feedback algorithm for modeling assistant.
"""

from collections.abc import Iterable
from dataclasses import dataclass, field
from functools import cache
import logging

from ordered_set import OrderedSet

from classdiagram import ClassDiagram, NamedElement
from color import Color
from modelingassistantapp import DEBUG_MODE, MODELING_ASSISTANT, get_mistakes
from parametrizedresponse import comma_seperated_with_and, parametrize_response
from serdes import set_static_class_for
from stringserdes import str_to_cdm
from utils import quote, warn
from learningcorpus import Feedback, LearningResource, ParametrizedResponse, ResourceResponse, TextResponse
from modelingassistant import (ModelingAssistant, Student, ProblemStatement, FeedbackItem, Mistake, Solution,
                               SolutionElement, StudentKnowledge)


logger = logging.getLogger(__name__)
logger.setLevel(logging.DEBUG)

MAX_STUDENT_LEVEL_OF_KNOWLEDGE = 10.0
BEGINNER_LEVEL_OF_KNOWLEDGE = 7.0


DEFAULT_HIGHLIGHT_COLOR = Color.LIGHT_YELLOW

_empty_resource = LearningResource(name="Empty", content="")


@dataclass
class FeedbackTO:
    """
    Feedback transfer object class. An explicit class is used to allow for lint and compile-time type checking.

    When transformed to JSON, this object will have the following structure:

    ```json
    {
        "grade": 0.0,
        "problemStatementElements": {"#fffacd": ["7", "8", "9"]},
        "solutionElements": {"#add8e6": [ "1", "2", "3", "4"]},
        "writtenFeedback": "The hex strings above refer to the colors used to highlight the diagram elements."
    }
    ```
    """
    # pylint: disable=invalid-name
    solutionElements: dict[str, list[str]] = field(default_factory=dict)  # includes generalizations
    problemStatementElements: dict[str, list[str]] = field(default_factory=dict)
    grade: float = 0.0
    writtenFeedback: str = ""

    # custom __init__ for correct JSON (de)serialization
    def __init__(self, solutionElements: dict[str, list[str]] = field(default_factory=dict),
                 problemStatementElements: dict[str, list[str]] = field(default_factory=dict),
                 grade: float = 0.0, writtenFeedback: str = "", feedback: FeedbackItem = None):

        def make_highlighted_elems(
            elems: Iterable[str] | Iterable[NamedElement] | Iterable[SolutionElement]
                 | dict[str, list[str] | list[NamedElement] | list[SolutionElement]]) -> dict[str, list[str]]:
            def id_for(e: str | NamedElement | SolutionElement) -> str:
                if not isinstance(e, str | NamedElement | SolutionElement):
                    raise TypeError(f"Expected str, NamedElement, or SolutionElement but got {e} of type {type(e)}")
                return e.element._internal_id if isinstance(e, SolutionElement) else (
                    e._internal_id if isinstance(e, NamedElement) else e)
            if not elems:
                return {}
            if isinstance(elems, list | OrderedSet):
                return {DEFAULT_HIGHLIGHT_COLOR.to_hex(): [id_for(e) for e in elems]}
            if isinstance(elems, dict):
                return {color: [id_for(e) for e in elems[color]] for color in elems}
            raise TypeError(f"Unexpected type elems type: {type(elems)}")

        def get_ids(elems: dict[str, list[str]]) -> list[str]:
            result = set()
            for ids in elems.values():
                result.update(ids)
            return list(result)

        if feedback:
            solutionElements: OrderedSet[SolutionElement] = feedback.mistake.studentElements
            problemStatementElements: OrderedSet[SolutionElement] = feedback.mistake.instructorElements
            writtenFeedback = (feedback.text or feedback.feedback.text
                               or getattr(feedback.feedback, "learningResources", [_empty_resource])[0].content)
        self.solutionElements = make_highlighted_elems(solutionElements)
        self.solutionElementIds = get_ids(self.solutionElements)
        self.problemStatementElements = make_highlighted_elems(problemStatementElements)
        self.problemStatementElementIds = get_ids(self.problemStatementElements)
        self.grade = grade
        self.writtenFeedback = writtenFeedback


def give_feedback(student_solution: Solution) -> FeedbackItem | list[FeedbackItem]:
    "Give feedback on the given student solution."
    if student_solution is not student_solution.student.currentSolution:
        pass  # return None  # do not give feedback for other unrelated solutions
    if not student_solution.mistakes:
        # emoji to test serdes
        return FeedbackItem(feedback=TextResponse(text="All good, no mistakes found! 🎉"), solution=student_solution)

    # sort mistakes by priority and filter out mistakes which are already resolved
    mistake_priority = lambda m: m.mistakeType.priority
    unresolved_mistakes: list[Mistake] = [m for m in sorted(student_solution.mistakes, key=mistake_priority)
                                          if not m.resolvedByStudent]

    # update student knowledge for each unresolved mistake type
    for m in unresolved_mistakes:
        student_knowledge_for(m).levelOfKnowledge = MAX_STUDENT_LEVEL_OF_KNOWLEDGE - m.numDetections

    # sort highest priority mistakes based on number of detections (start with those detected the most times)
    highest_priority = unresolved_mistakes[0].mistakeType.priority
    highest_priority_mistakes = sorted([m for m in unresolved_mistakes if m.mistakeType.priority == highest_priority],
                                       key=lambda m: m.numDetections, reverse=True)

    result: list[FeedbackItem] = []

    for m in highest_priority_mistakes:
        #student_solution.currentMistake = m  # TODO
        result.append(fb := next_feedback(m))
        # decide whether student is beginner overall
        if student_knowledge_for(m).levelOfKnowledge < BEGINNER_LEVEL_OF_KNOWLEDGE:
            break

    resolved_mistakes: list[Mistake] = [m for m in student_solution.mistakes if m.resolvedByStudent]
    for m in resolved_mistakes:
        if sk := student_knowledge_for(m):
            if m.lastFeedback: # ignore mistakes which have been resolved before feedback was given on them
                sk.levelOfKnowledge += m.lastFeedback.feedback.level / 2

    return result[0] if len(result) == 1 else result


def next_feedback(mistake: Mistake) -> FeedbackItem:
    """
    Return the feedback item at the next level for the given mistake, eg,

        next_feedback(mistake with lastFeedback.level = 2) = feedback at level 3
    """
    target_level = mistake.lastFeedback.feedback.level + 1 if mistake.lastFeedback else 1
    next_fb: Feedback = set_static_class_for(
        next(fb for fb in mistake.mistakeType.feedbacks if fb.level == target_level))
    fb_text = next_fb.text
    if isinstance(next_fb, ParametrizedResponse):
        fb_text = parametrize_response(next_fb, mistake)
    return FeedbackItem(text=fb_text, feedback=next_fb, solution=mistake.solution, mistake=mistake)


def student_knowledge_for(mistake: Mistake) -> StudentKnowledge:
    """
    Return the student knowledge object for the given mistake (a mistake is made by a specific student).
    If not found, create a new one.
    """
    # pylint: disable=protected-access
    # TODO Cache studentknowledges or redesign metamodel to access them in O(1) time instead of O(n)
    student = mistake.solution.student
    # print statements for debugging, will be cleaned up later
    #print("Student knowledges for", student.name, "Mistake", mistake.mistakeType.name,mistake.mistakeType._internal_id)
    for sk in student.studentKnowledges:
        #print(">>>", sk.mistakeType.name, sk.mistakeType._internal_id, sk.levelOfKnowledge)
        if sk.mistakeType._internal_id == mistake.mistakeType._internal_id:
            #print("--- Returning existing SK\n")
            return sk
    #print(f"** Creating new SK for mistake type {mistake.mistakeType.name} ({mistake.mistakeType._internal_id}) **\n")
    return StudentKnowledge(student=student, mistakeType=mistake.mistakeType, levelOfKnowledge=5.0,
                            modelingAssistant=mistake.solution.modelingAssistant)


def give_feedback_for_student_cdm(username: str, student_cdm: ClassDiagram | str, ma: ModelingAssistant = None
    ) -> FeedbackTO | tuple[FeedbackTO, ModelingAssistant]:
    "Give feedback given a student class diagram."
    # pylint: disable=protected-access
    use_local_ma = bool(ma)
    ma = ma or MODELING_ASSISTANT.instance

    if isinstance(student_cdm, str):
        student_cdm = str_to_cdm(student_cdm)

    instructor_cdm = instructor_solution_for(student_cdm, ma).classDiagram
    student_solution = student_solution_for(username, student_cdm, ma)  # useful line to create solution, do not remove

    cdms2sols = ma.classDiagramsToSolutions
    ma = get_mistakes(ma, instructor_cdm, student_cdm)
    if not ma.classDiagramsToSolutions:
        ma.classDiagramsToSolutions = cdms2sols
    if not use_local_ma:
        MODELING_ASSISTANT.instance = ma
    student_solution = student_solution_for(username, student_cdm, ma)
    fb_s = give_feedback(student_solution)
    fb = fb_s if isinstance(fb_s, FeedbackItem) else fb_s[0]  # only one feedback item for now

    if not fb.mistake:
        return FeedbackTO()
    feedback = FeedbackTO(feedback=fb)
    return (feedback, ma) if use_local_ma else feedback


@cache
def instructor_solution_for(student_cdm: ClassDiagram, ma: ModelingAssistant = None) -> Solution:
    "Return the instructor solution for the given student class diagram."
    # TODO Assume only one problem statement for now
    ma = ma or MODELING_ASSISTANT.instance
    return next(sol for sol in ma.solutions if not sol.student)


def student_solution_for(username: str, student_cdm: ClassDiagram, ma: ModelingAssistant) -> Solution:
    "Return the student solution for the given student class diagram."
    # pylint: disable=protected-access
    student = next((s for s in ma.students if s.name == username), None) or Student(name=username, modelingAssistant=ma)
    ps: ProblemStatement = ma.problemStatements[0]  # TODO Assume only one problem statement for now
    stud_sol = (next((sol for sol in ma.solutions if sol.student and sol.student.name == username
                      and sol.classDiagram._internal_id == student_cdm._internal_id), None)
                or Solution(student=student, classDiagram=student_cdm, modelingAssistant=ma, problemStatement=ps))
    stud_sol.classDiagram = student_cdm
    old_sol = None
    for sol in ps.studentSolutions:
        if sol.student.name == username and sol.classDiagram._internal_id == student_cdm._internal_id:
            old_sol = sol
            break
    if old_sol:
        ps.studentSolutions.remove(old_sol)
    ps.studentSolutions.append(stud_sol)
    return stud_sol


def verbalize_feedback_description(feedback: FeedbackItem) -> str:
    """
    Verbalize the feedback description of the given feedback item.

    When debug mode is on, return a description string for highlighted problem statement and solution elements, to
    make it easier to work on the frontend.

    For all text feedback, perform the following changes:
    - If the student is a beginner, include the text [within square brackets] in the feedback, without the square
      brackets themselves. Otherwise, omit this text entirely
    - If an indefinite article (A|a) is found in the text and the following word starts with a vowel, replace with
      (An|an). In the future, use a NLP package to correctly handle cases like "a university".

    For resource responses, indicate the resource type and the contents if no dedicated transformation is available.
    """
    if not feedback:
        warn("verbalize_feedback_description(): input feedback is None")
        return ""
    highlight_info = verbalize_highlight_description(feedback)
    resource_info = verbalize_resource_description(feedback)
    written_feedback = ""
    if isinstance(feedback.feedback, TextResponse | ParametrizedResponse):
        written_feedback = feedback.text or feedback.feedback.text
    sep = "\n\n" if highlight_info else ""
    result = f"{written_feedback}{resource_info}{sep}{highlight_info}"
    result = process_optional_text(result)  # TODO handle intermediate and advanced students later
    result = process_indefinite_articles(result)
    return result


def verbalize_highlight_description(feedback: FeedbackItem) -> str:
    """
    When debug mode is on, return a description string for highlighted problem statement and solution elements, to
    make it easier to work on the frontend.
    """
    if not DEBUG_MODE:
        return ""
    fb_item, fb_template = feedback, feedback.feedback
    mistake: Mistake = fb_item.mistake
    color = fb_template.text if (fb_template.text or "").startswith("#") else str(DEFAULT_HIGHLIGHT_COLOR)
    prefix = "Highlight "
    result = ""
    if fb_template.highlightProblem:
        fragments = [" ".join(map(lambda e: e.name, ie.problemStatementElements)) for ie in mistake.instructorElements]
        suffix = f" in the problem statement in {color}"
        if (n := len(fragments)) == 0:
            warn("verbalize_highlight_description(): no problem statement elements found for Feedback with "
                 "highlightProblem=True")
        elif n == 1:
            result = f'{prefix}"{fragments[0]}"{suffix}'
        elif n == 2:
            result = f'{prefix}"{fragments[0]}" and "{fragments[1]}"{suffix}'
        else:
            result = f'{prefix}{", ".join(quote(f) for f in fragments[:-1])}, and {fragments[-1]}{suffix}'
    if fb_template.highlightSolution:
        stud_elems = [e.element for e in mistake.studentElements]
        sep = "\n\n" if result else ""
        result = f"{result}{sep}{prefix}{comma_seperated_with_and(stud_elems)} in the solution in {color}"
    return result


def verbalize_resource_description(feedback: FeedbackItem | Feedback) -> str:
    """
    If the feedback is or has a resource response, return a description of the resource. Otherwise, return an empty
    string.
    """
    feedback: Feedback = feedback.feedback if isinstance(feedback, FeedbackItem) else feedback
    if isinstance(feedback, ResourceResponse):
        return "\n".join(f"{type(r).__name__}: {r.content}" for r in feedback.learningResources)
    return ""


def process_optional_text(text: str, is_beginner: bool = True) -> str:
    """
    Return the given text, but if is_beginner is True (the default), include text [within square brackets] without the
    square brackets themselves. Otherwise, omit the text within entirely. In either case, preserve Markdown links and
    images.
    """
    if not text:
        return ""
    if text.startswith("["):
        text = f" {text}"
    text_chunks = text.split("[")
    result = ""
    for chunk in text_chunks:
        if "](" in chunk:
            result += f"[{chunk}"  # preserve markdown links and images
        elif "]" in chunk:
            if is_beginner:
                result += chunk.replace("]", "")  # include chunk without the closing bracket
            else:
                result += chunk.split("]", 1)[1]
        else:
            result += chunk
    return result.strip()


def process_indefinite_articles(text: str) -> str:
    """
    If an indefinite article (A|a) is found in the text and the following word starts with a vowel, replace with
    (An|an). In the future, use a NLP package to correctly handle cases like "a university".
    """
    for v in "aeiouAEIOU":
        text = text.replace(f" a {v}", f" an {v}").replace(f"A {v}", f"An {v}")
    return text


if __name__ == '__main__':
    "Main entry point (used for debugging)."
