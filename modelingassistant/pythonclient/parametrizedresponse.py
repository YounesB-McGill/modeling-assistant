"""
Logic to handle parametrized responses.
"""

import re

from cdmmetatypes import CDM_METATYPES
from classdiagram import NamedElement
from learningcorpus import ParametrizedResponse
from learningcorpus.learningcorpus import MistakeType
from modelingassistant import Mistake


_MAX_PARSE_DEPTH = 15  # Maximum depth of parse tree, eg, A.B.C... cannot have more (\.\*\d) than this


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


def parse(s: str, start_elem: NamedElement) -> str:
    """
    Parse a parameter from a parametrized response string, as applied on the input starting element.
    The format of the parameter is as follows:

    ```
    ('stud'|'inst')_[description_]elementtype[('*'|index)][.elementproperty[('*'|index)]]*
    ```

    - elementtype is a CDM metatype.
    - description is a string that provides more information about the parameter, eg, inst_super_cls.
    It is needed whenever there is more than one parameter with the same person (stud/inst) and the same type
    - index is an integer, used to get the nth element of a sequence where applicable, eg, inst_assocend0
    - elementproperty is a property (field) defined on an element at the metamodel level
    or a predefined shorthand for it like 'cls'
    """
    if not param_valid(s):
        raise ValueError(f"Invalid parametrized response parameter: {s}")
    return "TODO"


def param_valid(param: str, mt: MistakeType = None) -> bool:
    """
    Validate that the parameter is syntactically correct.
    The optional mistake type is used to provide a more meaningful error message if supplied.
    """
    prp = "Parametrized response parameter"
    if mt:
        prp = f"{prp} for {mt.name}"
    if not isinstance(param, str) or not param:
        raise ValueError(f"{prp} must be a non-empty string: `{param}`")
    if not param.startswith("stud_") and not param.startswith("inst_"):
        raise ValueError(f"{prp} must start with 'stud_' or 'inst_': {param}")
    if "__" in param:
        raise ValueError(f"{prp} cannot contain '__': {param}")
    if param.count("*") > 1:
        raise ValueError(f"{prp} cannot have more than one '*': {param}")
    if (param.count(".") + param.count("*") + sum(c.isdigit() for c in param)) > _MAX_PARSE_DEPTH:
        raise ValueError(f"{prp} cannot exceed the maximum parse depth of {_MAX_PARSE_DEPTH}: {param}")

    part_before_dot = param.split(".")[0]
    type_ = re.sub(r"[\*\d]+$", "", part_before_dot.split("_")[-1])

    if type_ not in CDM_METATYPES:
        raise ValueError(f"{prp} must be a valid CDM metatype: {param}")

    return True
