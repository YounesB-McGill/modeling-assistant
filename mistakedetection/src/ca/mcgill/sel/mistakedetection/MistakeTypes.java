package ca.mcgill.sel.mistakedetection;

import modelingassistant.MistakeType;
import modelingassistant.ModelingassistantFactory;

public class MistakeTypes {

  public static final ModelingassistantFactory MAF = ModelingassistantFactory.eINSTANCE;
  
  public static final MistakeType PLURAL_CLASS_NAME = MAF.createMistakeType();
  
  static {
    PLURAL_CLASS_NAME.setName("Class name is plural");
    PLURAL_CLASS_NAME.setAtomic(true);
  }
  
}
