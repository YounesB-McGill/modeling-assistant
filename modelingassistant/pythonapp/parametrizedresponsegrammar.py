#!/usr/bin/env python3

"""
Grammar for parametrized responses. The textual (EBNF) and diagram representations are currently separate and so is
the parse logic in parametrizedresponse.py. All need to updated if the grammar changes, unless these rules are
otherwise unified (future work).
"""

from textwrap import dedent

from railroad import Choice, Diagram, OneOrMore, Sequence, Skip


PRG_DIAGRAM_SVG_FILE = "modelingassistant/model/parametrized_response_grammar.svg"


def get_prg_grammar():
    """
    Return an EBNF representation of the grammar for a parametrized response parameter, where:

    - elementtype is a CDM metatype.
    - description is a string that provides more information about the parameter, eg, inst_super_cls.
    It is needed whenever there is more than one parameter with the same person (stud/inst) and the same type
    - index is an integer, used to get the nth element of a sequence where applicable, eg, inst_assocend0
    - elementproperty is a property (field) defined on an element at the metamodel level
    or a predefined shorthand for it like 'cls'. The shorthands are defined in parametrizedresponse.SHORTHANDS.

    In the future, this should be unified with the visual representation and the parse logic in parametrizedresponse.py.
    """
    return dedent("""\
        parameter: person, '_', description?, elementtype, star_or_index?, dereference*
        person: 'stud' | 'inst'
        description: identifier
        elementtype: 
            | 'aggr' | 'assoc' | 'assocend' | 'attr' | 'cls' | 'compos' | 'enum' | 'enumitem'
            | 'qualassoc' | 'rel' | 'role'
        star_or_index: '*' | number
        dereference: '.', elementproperty, star_or_index?
        elementproperty: identifier
        """)


def create_prg_diagram() -> Diagram:
    "Create the parametrized response grammar diagram."
    d = Diagram(Choice(0, "'stud'", "'inst'"), Sequence("'_'"), Choice(1, "description", Skip()),
                Sequence("elementtype"), star_or_num := Choice(2, "'*'", "number", Skip()),
                Choice(1, OneOrMore(Sequence("'.'", "elementproperty", star_or_num)), Skip()),
                type="complex")
    print(f"Created parametrized response grammar diagram:\n{d}")
    return d


def save_prg_svg_diagram(filename: str):
    "Save the parametrized response grammar diagram to a file."
    with open(filename, "w", encoding="utf-8") as f:
        create_prg_diagram().writeSvg(f.write)


if __name__ == "__main__":
    """
    Main entry point. Uncomment the line below to update the parametrized response grammar diagram file.
    Note that this will overwrite the file!
    """
    # save_prg_svg_diagram(PRG_DIAGRAM_SVG_FILE)
