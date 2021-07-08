/**
 */
package learningcorpus;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Element Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see learningcorpus.LearningcorpusPackage#getElementType()
 * @model
 * @generated
 */
public enum ElementType implements Enumerator {
  /**
   * The '<em><b>Class</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CLASS_VALUE
   * @generated
   * @ordered
   */
  CLASS(0, "Class", "Class"),

  /**
   * The '<em><b>Attribute</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ATTRIBUTE_VALUE
   * @generated
   * @ordered
   */
  ATTRIBUTE(1, "Attribute", "Attribute"),

  /**
   * The '<em><b>Association</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ASSOCIATION_VALUE
   * @generated
   * @ordered
   */
  ASSOCIATION(2, "Association", "Association"),

  /**
   * The '<em><b>Association End</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ASSOCIATION_END_VALUE
   * @generated
   * @ordered
   */
  ASSOCIATION_END(3, "AssociationEnd", "AssociationEnd"),

  /**
   * The '<em><b>Composition</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #COMPOSITION_VALUE
   * @generated
   * @ordered
   */
  COMPOSITION(4, "Composition", "Composition"),

  /**
   * The '<em><b>Generalization</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #GENERALIZATION_VALUE
   * @generated
   * @ordered
   */
  GENERALIZATION(5, "Generalization", "Generalization"),

  /**
   * The '<em><b>Player Role Pattern</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PLAYER_ROLE_PATTERN_VALUE
   * @generated
   * @ordered
   */
  PLAYER_ROLE_PATTERN(6, "PlayerRolePattern", "PlayerRolePattern"),

  /**
   * The '<em><b>Abstraction Occurrence Pattern</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ABSTRACTION_OCCURRENCE_PATTERN_VALUE
   * @generated
   * @ordered
   */
  ABSTRACTION_OCCURRENCE_PATTERN(7, "AbstractionOccurrencePattern", "AbstractionOccurrencePattern");

  /**
   * The '<em><b>Class</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CLASS
   * @model name="Class"
   * @generated
   * @ordered
   */
  public static final int CLASS_VALUE = 0;

  /**
   * The '<em><b>Attribute</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ATTRIBUTE
   * @model name="Attribute"
   * @generated
   * @ordered
   */
  public static final int ATTRIBUTE_VALUE = 1;

  /**
   * The '<em><b>Association</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ASSOCIATION
   * @model name="Association"
   * @generated
   * @ordered
   */
  public static final int ASSOCIATION_VALUE = 2;

  /**
   * The '<em><b>Association End</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ASSOCIATION_END
   * @model name="AssociationEnd"
   * @generated
   * @ordered
   */
  public static final int ASSOCIATION_END_VALUE = 3;

  /**
   * The '<em><b>Composition</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #COMPOSITION
   * @model name="Composition"
   * @generated
   * @ordered
   */
  public static final int COMPOSITION_VALUE = 4;

  /**
   * The '<em><b>Generalization</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #GENERALIZATION
   * @model name="Generalization"
   * @generated
   * @ordered
   */
  public static final int GENERALIZATION_VALUE = 5;

  /**
   * The '<em><b>Player Role Pattern</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PLAYER_ROLE_PATTERN
   * @model name="PlayerRolePattern"
   * @generated
   * @ordered
   */
  public static final int PLAYER_ROLE_PATTERN_VALUE = 6;

  /**
   * The '<em><b>Abstraction Occurrence Pattern</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ABSTRACTION_OCCURRENCE_PATTERN
   * @model name="AbstractionOccurrencePattern"
   * @generated
   * @ordered
   */
  public static final int ABSTRACTION_OCCURRENCE_PATTERN_VALUE = 7;

  /**
   * An array of all the '<em><b>Element Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final ElementType[] VALUES_ARRAY =
    new ElementType[] {
      CLASS,
      ATTRIBUTE,
      ASSOCIATION,
      ASSOCIATION_END,
      COMPOSITION,
      GENERALIZATION,
      PLAYER_ROLE_PATTERN,
      ABSTRACTION_OCCURRENCE_PATTERN,
    };

  /**
   * A public read-only list of all the '<em><b>Element Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<ElementType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Element Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ElementType get(String literal) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      ElementType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Element Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ElementType getByName(String name) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      ElementType result = VALUES_ARRAY[i];
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Element Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ElementType get(int value) {
    switch (value) {
      case CLASS_VALUE: return CLASS;
      case ATTRIBUTE_VALUE: return ATTRIBUTE;
      case ASSOCIATION_VALUE: return ASSOCIATION;
      case ASSOCIATION_END_VALUE: return ASSOCIATION_END;
      case COMPOSITION_VALUE: return COMPOSITION;
      case GENERALIZATION_VALUE: return GENERALIZATION;
      case PLAYER_ROLE_PATTERN_VALUE: return PLAYER_ROLE_PATTERN;
      case ABSTRACTION_OCCURRENCE_PATTERN_VALUE: return ABSTRACTION_OCCURRENCE_PATTERN;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private ElementType(int value, String name, String literal) {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getValue() {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getLiteral() {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    return literal;
  }
  
} //ElementType
