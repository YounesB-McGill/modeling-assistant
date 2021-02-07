def main():
    cdm_mm_file = "modelingassistant/model/classdiagram.ecore"
    rset = ResourceSet()
    mm_root = rset.get_resource(URI(cdm_mm_file)).contents[0]
    rset.metamodel_registry[mm_root.nsURI] = mm_root  # ecore is loaded in the 'rset' as a metamodel here

    # Open a class diagram instance
    cdm_path = "modelingassistant/testmodels"
    cdm_file = f"{cdm_path}/car.domain_model.cdm"
    resource = rset.get_resource(URI(cdm_file))
    class_diagram = resource.contents[0]
    class_diagram.__class__ = ClassDiagram



if __name__ == "__main__":
    "Main entry point."
    main()
