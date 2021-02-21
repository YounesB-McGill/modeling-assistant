package ca.mcgill.sel.mistakedetection;

import modelingassistant.MistakeType;
import modelingassistant.ModelingassistantFactory;

public class MistakeTypes {

  public static final ModelingassistantFactory MAF = ModelingassistantFactory.eINSTANCE;
  
  public static final MistakeType PLURAL_CLASS_NAME = MAF.createMistakeType();
  
  public static final MistakeType SOFTWARE_ENGINEERING_TERM = MAF.createMistakeType(); // map.get("SOFTWARE_ENGINEERING_TERM")
  
  static {
    PLURAL_CLASS_NAME.setName("Class name is plural");
    PLURAL_CLASS_NAME.setAtomic(true);
    
    SOFTWARE_ENGINEERING_TERM.setName("Class name contains software engineering term");
    SOFTWARE_ENGINEERING_TERM.setAtomic(true);
  }
  
}
