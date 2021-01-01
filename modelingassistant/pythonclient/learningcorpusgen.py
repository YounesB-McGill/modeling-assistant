#!/usr/bin/env python3

from classdiagram.classdiagram import ClassDiagram, Class
from modelingassistant.modelingassistant import (ModelingAssistant, LearningItem, UmlElement, MistakeType,
    Feedback, TextResponse, ParametrizedResponse, ResourceResponse, Reference, Example)
from pyecore.resources import ResourceSet, URI


def make_modeling_assistant_that_handles_wrong_class_name() -> ModelingAssistant:
    """
    Construct and save a Modeling Assistant that handles mistakes of the type Wrong Class Name. 
    """
    ma = ModelingAssistant()
    correct_class_naming = LearningItem(modelingAssistant=ma, umlElements=[UmlElement(modelingAssistant=ma)])
    software_eng_term = MistakeType(modelingAssistant=ma, name="Software Engineering term", atomic=True,
                                    numStepsBeforeNotification=0, learningItem=correct_class_naming)
    correct_class_naming.mistakeTypes.append(software_eng_term)

    software_eng_term.feedbacks.extend([
        Feedback(modelingAssistant=ma, mistakeType=software_eng_term, level=1, highlightSolution=True),
        TextResponse(modelingAssistant=ma, mistakeType=software_eng_term, level=2, highlightSolution=True,
                     text="Remember that a domain model should not contain software engineering terms."),
        ParametrizedResponse(modelingAssistant=ma, mistakeType=software_eng_term, level=3, highlightSolution=True,
                             text=f"Looks like you used another software engineering term ({{clazz.name}})."),
        # Can add Reference and Example here in a similar manner (some metamodel updates needed)
    ])

    rset = ResourceSet()
    resource = rset.create_resource(URI("modelingassistant/instances/ma_correct_class_naming.xmi"))
    resource.use_uuid = True
    resource.extend([ma, correct_class_naming, software_eng_term, *software_eng_term.feedbacks])
    resource.save()


if __name__ == "__main__":
    make_modeling_assistant_that_handles_wrong_class_name()
    
