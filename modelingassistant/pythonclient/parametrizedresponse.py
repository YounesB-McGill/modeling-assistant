"""
Logic to handle parametrized responses.
"""

from learningcorpus import ParametrizedResponse
from modelingassistant import Mistake

def parametrize_response(response: ParametrizedResponse, mistake: Mistake) -> str:
    """
    Return the filled-in parametrized response text for the given response and mistake.
    """
    options = {}
    # Use itertools.zip_longest here?
    for stud_key, elem in zip(response.mistakeType.md_format.stud, mistake.studentElements):
        options[f"stud_{stud_key}"] = elem.element.name
    for inst_key, elem in zip(response.mistakeType.md_format.inst, mistake.instructorElements):
        options[f"inst_{inst_key}"] = elem.element.name
    return response.text.format(**options).replace("$", "")
