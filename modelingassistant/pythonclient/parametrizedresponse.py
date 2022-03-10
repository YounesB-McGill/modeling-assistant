"""
Logic to handle parametrized responses.
"""

import re
from string import Formatter

from cdmmetatypes import CDM_METATYPES
from utils import MistakeDetectionFormat, warn
from classdiagram import NamedElement
from learningcorpus import MistakeType, ParametrizedResponse
from modelingassistant import Mistake


MAX_VARARG_SEQUENCE_LENGTH = float("inf")  # The maximum number of vararg elements for a parameter

_MAX_PARSE_DEPTH = 15  # Maximum depth of parse tree, eg, A.B.C... cannot have more (\.\*\d) than this

# CDM metamodel shorthands
SHORTHANDS: dict[str, str] = {
    "cls": "classifier",
    "end": "ends",
    "opposite": "oppositeEnd",
}

_formatter = Formatter()


def parametrize_response(response: ParametrizedResponse, mistake: Mistake) -> str:
    """
    Return the filled-in parametrized response text for the given response and mistake.
    """
    options = {}
    resp_text: str = response.text.replace("$", "")  # remove all $ from the response text
    mdf_items_to_mistake_elems = get_mdf_items_to_mistake_elem_dict(mistake)
    params = extract_params(resp_text)
    param_roots = param_parts_before_dot(params)
    for param, param_root in zip(params, param_roots):
        start_elem = mdf_items_to_mistake_elems.get(param_root)
        if start_elem is None:
            warn(f"parametrizedresponse.parametrize_response(): Parameter {param} not found for mistake {mistake}")
            continue
        options[param] = parse(param, start_elem)
    return resp_text.format(**options)


def parse(s: str, start_elem: NamedElement) -> str:
    """
    Recursively parse a parameter from a parametrized response string, as applied on the input starting element.
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
    # base cases
    if re.match(r"^[A-Za-z_]+$", s):  # simplest case, only a metatype
        return getattr(start_elem, "name", str(start_elem))
    if re.match(r"^[A-Za-z_]+\*$", s):  # simple varargs list of metatypes
        return comma_seperated_with_and(start_elem)
    if idx := re.match(r".*?(\d+)$", s).group(1):  # index
        if hasattr(start_elem, "__getitem__") and int(idx) < len(start_elem):
            return start_elem[int(idx)]
        warn(f"""parametrizedresponse.parse(): Attempted to access element {start_elem} at index {idx
              }, but the element is not a sequence or has no such index, so returning the element itself""")
        return getattr(start_elem, "name", str(start_elem))

    # Dot-separated properties are in the form a.b.c.d...
    dot_sep_elems = s.split(".")
    a = dot_sep_elems[0]
    b = dot_sep_elems[1]
    if b == "length":  # special case
        if hasattr(start_elem, "__len__"):
            return len(start_elem)
        warn(f"""parametrizedresponse.parse(): Attempted to get length of element {start_elem
              }, but the element is not a sequence, so returning the element itself""")
        return getattr(start_elem, "name", str(start_elem))
    cd = dot_sep_elems[2:]
    a_dot_b = getattr(a, SHORTHANDS.get(b, b), a)
    return parse(f"{b}.{'.'.join(cd)}", a_dot_b)  # recurse to next dot-separated element


def get_mdf_items_to_mistake_elem_dict(mistake: Mistake) -> dict[str, NamedElement | list[NamedElement]]:
    """
    Return a dict of mistake detection format items to mistake elements.
    """
    mdf_items_to_elems = {}
    mdf: MistakeDetectionFormat = mistake.mistakeType.md_format
    for stud_key, elem in zip(mdf.stud[:-1], mistake.studentElements[:-1]):
        mdf_items_to_elems[f"stud_{stud_key}"] = elem.element
    for inst_key, elem in zip(mdf.inst[:-1], mistake.instructorElements[:-1]):
        mdf_items_to_elems[f"inst_{inst_key}"] = elem.element

    # handle the last element separately
    if mdf.stud:
        if mdf.stud[-1].endswith("*"):
            # varargs: last student element is a list of elements, eg,
            # mdf = ([A, B, C*], [])
            # studentElems = [a, b, c1, c2, c3, ...]
            # want studentElems[2:], which corresponds to the last MDF element (there are 2 elems before C*)
            mdf_items_to_elems[f"stud_{mdf.stud[-1]}"] = [
                e.element for e in mistake.studentElements[len(mdf.stud) - 1:]]
        else:
            # no varargs: last student element is a single element
            mdf_items_to_elems[f"stud_{mdf.stud[-1]}"] = mistake.studentElements[-1].element
    if mdf.inst:
        if mdf.inst[-1].endswith("*"):
            mdf_items_to_elems[f"inst_{mdf.inst[-1]}"] = [
                e.element for e in mistake.instructorElements[len(mdf.inst) - 1:]]
        else:
            mdf_items_to_elems[f"inst_{mdf.inst[-1]}"] = mistake.instructorElements[-1].element
    return mdf_items_to_elems


def extract_params(pr_text: str) -> list[str]:
    "Return a list of parametrized response parameters."
    params = re.findall(r"\$\{(?P<param>.*?)\}", pr_text)
    for param in params:
        if not param_valid(param):
            raise ValueError(f"Invalid parametrized response parameter: {param}")
    return params


def param_parts_before_dot(params: list[str]) -> list[str]:
    """
    Return the list defined as

    ```js
    params.map(param => param.split(".")[0])
    ```
    """
    return [param.split(".")[0] for param in params]


def comma_seperated_with_and(elems: list[NamedElement]) -> str:
    """
    Return a comma-seperated string of the names of the elements, with "and" before the last element.
    """
    if not hasattr(elems, "__getitem__"):
        warn(f"comma_seperated_with_and(): {elems} is not a sequence, returning elems.name")
        return getattr(elems, "name", str(elems))
    if len(elems) == 0:
        warn("comma_seperated_with_and(): elems is empty, returning empty string")
        return ""
    if len(elems) == 1:
        return elems[0].name
    if len(elems) == 2:
        return f"{elems[0].name} and {elems[1].name}"
    return f"{', '.join(e.name for e in elems[:-1])}, and {elems[-1].name}"


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
