"""
Logic to handle parametrized responses.
"""

import re
from collections.abc import Iterable
from string import Formatter

from pyecore.ecore import EClass

from metatypes import CDM_METATYPES, Metatype
from utils import MistakeDetectionFormat, warn
from classdiagram import Association, AssociationEnd, Attribute, CDEnumLiteral, Classifier, NamedElement
from learningcorpus import MistakeType, ParametrizedResponse
from modelingassistant import Mistake


MAX_VARARG_SEQUENCE_LENGTH = float("inf")  # The maximum number of vararg elements for a parameter

_MAX_PARSE_DEPTH = 15  # Maximum depth of parse tree, eg, A.B.C... cannot have more (\.\*\d) than this

_MAX_INDEX = 15  # Maximum value of a sequence index, eg, inst_assocend1

# CDM metamodel shorthands
SHORTHANDS: dict[str, str] = {
    "cls": "classifier",
    "cls*": "ends",  # fallback
    "end": "ends",
    "refcls": "oppositeEnd",  # fallback
    "opposite": "oppositeEnd",
}

_formatter = Formatter()


def parametrize_response(response: ParametrizedResponse, mistake: Mistake) -> str:
    """
    Return the filled-in parametrized response text for the given response and mistake.

    This function uses the following approach to determing the returned text:

    1. Map MistakeDetectionFormat items to mistake elements
    2. Extract parameter template strings from parametrized response text, eg, ${stud_attr.cls}
    3. Get parameter part before dot, eg, stud_attr. This is the start element, passed into the parse() function
    4. Populate the options dictionary with (original parameter, replacement) pairs
    5. Use the Python string formatter to replace the parameter template strings with the corresponding values

    Example execution (Python-like pseudocode):

    ```
    Given MistakeType WRONG_CLASS_NAME with student element cls and instructor element cls:
    parametrize_response(resp="${stud_cls} should be ${inst_cls}.", mistake={mt: WRONG_CLASS_NAME, se: [sc], ie: [ic]}):
        1. Establish mapping {stud_cls: sc, inst_cls: ic}
        2. Extract parameters: stud_cls, inst_cls
        3. Get part before dot: stud_cls, inst_cls (no change for this example)
        4. Populate options by calling parse() for each one: {stud_cls: sc, inst_cls: ic}
        5. Return resulting string with replacements: "sc should be ic."
    ```

    For other more interesting examples, see the unit tests.
    """
    options: dict[str, str] = {}
    mdf_items_to_mistake_elems = get_mapping_from_mistake_elem_descriptions_to_actual_mistake_elems(mistake)
    params = extract_params(response.text)
    param_roots = param_parts_before_dot(params)
    for param, param_root in zip(params, param_roots):
        start_elem = mdf_items_to_mistake_elems.get(param_root)
        if start_elem is None:
            warn(f"parametrizedresponse.parametrize_response(): Parameter {param} not found for mistake {mistake}")
            continue
        options[param] = parse(param, start_elem)
    # print(f"parametrizedresponse.parametrize_response(): {options = }")  # TODO remove later
    resp_text: str = response.text.replace("$", "")  # remove all $ from the response text
    for t in _formatter.parse(resp_text):  # not to be confused with the parse() function defined below
        # print(f"parametrizedresponse.parametrize_response(): {t = }")  # TODO remove later
        if t[1] is not None:
            resp_text = resp_text.replace(f"{{{t[1]}}}", options[t[1]], 1)
    return resp_text


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
    return _parse(s, start_elem)  # call internal helper function to do actual parsing


def _parse(s: str, start_elem: NamedElement | Iterable, depth: int = 0) -> str:
    # pylint: disable=too-many-return-statements
    # print(f"parametrizedresponse.parse({s = }, {start_elem = }) called")  # TODO remove later
    if depth > _MAX_PARSE_DEPTH:
        raise ValueError(f"parametrizedresponse.parse(): reached max parse depth ({_MAX_PARSE_DEPTH})")

    # base cases
    if re.match(r"^[A-Za-z_]+$", s):  # simplest case, only a metatype
        if isinstance(start_elem, Association):  # do not rely on TouchCORE assoc naming since it is an internal detail
            return "_".join((ae.classifier.name for ae in start_elem.ends))
        return getattr(start_elem, "name", str(start_elem))
    if re.match(r"^[A-Za-z_]+\*$", s):  # simple varargs list of metatypes
        # special case for n-ary associations
        if isinstance(start_elem, Iterable) and all(isinstance(e, AssociationEnd) for e in start_elem) and s == "cls*":
            return comma_seperated_with_and([ae.classifier for ae in start_elem])
        # special case for Player-Role pattern roles
        if s.endswith("role*"):
            return comma_seperated_with_and(get_role_named_elems(start_elem))
        return comma_seperated_with_and(start_elem)
    if (match_ := re.match(r".*?(\d+)$", s)) and ((idx := int(match_.group(1))) in range(_MAX_INDEX + 1)):  # index
        if hasattr(start_elem, "__getitem__") and idx < len(start_elem):
            return getattr(start_elem[idx], "name", str(start_elem[idx]))
        warn(f"""parametrizedresponse.parse(): Attempted to access element {start_elem} at index {idx
              }, but the element is not a sequence or has no such index, so returning the element itself""")
        return getattr(start_elem, "name", str(start_elem))

    # Dot-separated properties are in the form a.b.c.d...
    # print(f"parametrizedresponse.parse(): non base case s: {s}")  # TODO remove later
    dot_sep_elems = s.split(".")
    # if valid list and index, use the list element, eg, assocend0.cls means get classifier of zeroth association end
    if (isinstance(start_elem, Iterable) and (match_ := re.match(r".*?(\d+)$", dot_sep_elems[0])) and (
            idx := int(match_.group(1))) < len(start_elem) and idx in range(_MAX_INDEX + 1)):
        a = start_elem[idx]
    else:
        a = start_elem
    b = dot_sep_elems[1]
    if b == "length":  # special case
        if hasattr(a, "__len__"):
            return str(len(a))
        warn(f"""parametrizedresponse.parse(): Attempted to get length of element {a
              }, but the element is not a sequence, so returning the element name or string representation""")
        return getattr(a, "name", str(a))
    cd = dot_sep_elems[2:]
    a_dot_b = resolve_attribute(a, b)
    # print(f"parametrizedresponse.parse(): [{b = }], [{'.'.join(cd) = }], [{a_dot_b = }]")  # TODO remove later
    return _parse(f"{b}{'.' if cd else ''}{'.'.join(cd)}", a_dot_b, depth + 1)  # recurse to next dot-separated element


def resolve_attribute(elem, attr_name: str):
    """
    Return the value of the attribute for the given element. Attribute is used here in the programmatic sense, not in
    the class diagram sense.
    """
    # special cases
    match elem:
        case Association() if (match_ := re.match(r"ends?(\d+)$", attr_name)):
            return elem.ends[int(match_.group(1))]
        case AssociationEnd() if attr_name in ("lowerBound", "upperBound"):
            bound = getattr(elem, attr_name)
            return "*" if bound == -1 else str(bound)
        case AssociationEnd() if attr_name == "refcls":
            return elem.oppositeEnd.classifier
        case Attribute() if attr_name == "cls":
            return elem.eContainer()
        case Attribute() if attr_name == "type":
            return elem.type.name.removeprefix("CD")

    # general case
    return getattr(elem, SHORTHANDS.get(attr_name, attr_name), elem)


def get_mapping_from_mistake_elem_descriptions_to_actual_mistake_elems(mistake: Mistake
    ) -> dict[str, NamedElement | list[NamedElement]]:
    """
    Return a dict of mistake element string descriptions to actual mistake elements.
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
            mdf_items_to_elems[
                f"inst_{mdf.inst[-1]}"
                ] = (
                    mistake.instructorElements[-1].element)
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
    if len(elems) > MAX_VARARG_SEQUENCE_LENGTH:
        elems = elems[:MAX_VARARG_SEQUENCE_LENGTH]
    return f"{', '.join(e.name for e in elems[:-1])}, and {elems[-1].name}"


def get_role_named_elems(start_elem: NamedElement | Iterable) -> list[NamedElement]:
    "Return a list of all Player-Role pattern roles to be displayed."
    if isinstance(start_elem, NamedElement):
        return [get_role_named_elem(start_elem)]
    roles = []
    if (isinstance(start_elem, Iterable) and not isinstance(start_elem, str)):
        for elem in start_elem:
            roles.append(get_role_named_elem(elem))
    return roles


def get_role_named_elem(start_elem: AssociationEnd | CDEnumLiteral | Classifier) -> CDEnumLiteral | Classifier:
    "Return a single Player-Role pattern role to be displayed."
    if isinstance(start_elem, AssociationEnd):
        return start_elem.getOppositeEnd().classifier
    return start_elem


def param_start_elem_type(param: str, as_type: type = None) -> str | Metatype | EClass:
    """
    Return the CDM metatype of the starting element (part before dot) of the given parametrized response parameter.

    ```
    param_start_elem_type("stud_cls") -> metatypes.cls.eClass = classdiagram.Class  # default
    param_start_elem_type("stud_cls", as_type=str) -> metatypes.cls.short_name = "cls"
    param_start_elem_type("inst_attr.type", as_type=CdmMetatype) -> metatypes.attr
    ```
    """
    part_before_dot = param.split(".")[0]
    type_name = re.sub(r"[\d]+$", "*", part_before_dot.split("_")[-1])
    if as_type == str:
        return type_name
    if as_type == Metatype:
        return CDM_METATYPES.get(type_name, None)
    if as_type not in (None, EClass, type):
        warn(f"param_start_elem_type(): {as_type = } is not a valid type")
    # default return value is CDM_METATYPES[type_name].eClass if it exists
    return getattr(CDM_METATYPES.get(type_name, None), "eClass", None)


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

    if not param_start_elem_type(param):
        raise ValueError(f"{prp} must be a valid CDM metatype: {param}")

    return True
