"""
Helper module for easy serialization and deserialization of models and metamodels from files.
"""

from pyecore.ecore import EObject
from pyecore.resources.resource import Resource, ResourceSet, URI

from classdiagram import ClassDiagram
from learningcorpus.learningcorpus import LearningCorpus
from modelingassistant import ModelingAssistant

MM_PATH = "modelingassistant/model"
CLASS_DIAGRAM_MM = "ca.mcgill.sel.classdiagram/model/classdiagram.ecore"
LEARNING_CORPUS_MM = f"{MM_PATH}/learningcorpus.ecore"
MODELING_ASSISTANT_MM = f"{MM_PATH}/modelingassistant.ecore"


def load_metamodels(*ecore_files: str) -> ResourceSet:
    """
    Return a ResourceSet loaded with the given metamodels from the ecore file paths.
    """
    rset = ResourceSet()
    for ecore_file in ecore_files:
        mm_root = rset.get_resource(URI(ecore_file)).contents[0]
        rset.metamodel_registry[mm_root.nsURI] = mm_root  # ecore loaded in rset as a metamodel here
    return rset


def load_cdm(cdm_file: str) -> ClassDiagram:
    """
    Open a class diagram instance from the given file.
    """
    if not cdm_file.endswith(".cdm"):
        print(f"Warning: attempting to open {cdm_file} with unexpected extension as a *.cdm file.")
    rset = load_metamodels(CLASS_DIAGRAM_MM)  # TODO Factor out rset if needed for performace reasons
    resource = rset.get_resource(URI(cdm_file))
    class_diagram = resource.contents[0]
    class_diagram.__class__ = ClassDiagram
    return class_diagram


def load_ma(ma_file: str) -> ModelingAssistant:
    """
    Open a modeling assistant instance from the given file.
    """
    if not ma_file.endswith(".modelingassistant"):
        print(f"Warning: attempting to open {ma_file} with unexpected extension as a *.modelingassistant file.")
    rset = load_metamodels(CLASS_DIAGRAM_MM, LEARNING_CORPUS_MM, MODELING_ASSISTANT_MM)
    resource = rset.get_resource(URI(ma_file))
    modeling_assistant = resource.contents[0]
    modeling_assistant.__class__ = ModelingAssistant
    return modeling_assistant


def load_lc(lc_file: str) -> LearningCorpus:
    """
    Open a learning corpus instance from the given file.
    """
    if not lc_file.endswith(".learningcorpus"):
        print(f"Warning: attempting to open {lc_file} with unexpected extension as a *.learningcorpus file.")
    rset = load_metamodels(LEARNING_CORPUS_MM)
    resource = rset.get_resource(URI(lc_file))
    learning_corpus = resource.contents[0]
    learning_corpus.__class__ = LearningCorpus
    return learning_corpus


def save_to_files(items_by_filename: dict[str, list[EObject]]):
    """
    Save the given EObject items to their respective files.
    """
    uri_to_filename = {URI(fn): fn for fn in items_by_filename.keys()}
    filename_to_uri = {fn: uri for uri, fn in uri_to_filename.items()}
    rset = load_metamodels(CLASS_DIAGRAM_MM, LEARNING_CORPUS_MM, MODELING_ASSISTANT_MM)
    resources = []
    for filename in items_by_filename.keys():
        resource: Resource = rset.create_resource(filename_to_uri[filename])
        resource.use_uuid = True
        resources.append(resource)
    for resource in resources:
        resource.extend(items_by_filename[uri_to_filename[resource.uri]])
    for resource in resources:
        resource.save()
