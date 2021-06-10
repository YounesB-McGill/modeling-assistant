/**
 */
package classdiagram;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Reference Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see classdiagram.ClassdiagramPackage#getReferenceType()
 * @model
 * @generated
 */
public enum ReferenceType implements Enumerator {
  /**
   * The '<em><b>Composition</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #COMPOSITION_VALUE
   * @generated
   * @ordered
   */
  COMPOSITION(0, "Composition", "Composition"),

  /**
   * The '<em><b>Aggregation</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #AGGREGATION_VALUE
   * @generated
   * @ordered
   */
  AGGREGATION(1, "Aggregation", "Aggregation"),

  /**
   * The '<em><b>Regular</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #REGULAR_VALUE
   * @generated
   * @ordered
   */
  REGULAR(2, "Regular", "Regular"),

  /**
   * The '<em><b>Qualified</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #QUALIFIED_VALUE
   * @generated
   * @ordered
   */
  QUALIFIED(3, "Qualified", "Qualified");

  /**
   * The '<em><b>Composition</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #COMPOSITION
   * @model name="Composition"
   * @generated
   * @ordered
   */
  public static final int COMPOSITION_VALUE = 0;

  /**
   * The '<em><b>Aggregation</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #AGGREGATION
   * @model name="Aggregation"
   * @generated
   * @ordered
   */
  public static final int AGGREGATION_VALUE = 1;

  /**
   * The '<em><b>Regular</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #REGULAR
   * @model name="Regular"
   * @generated
   * @ordered
   */
  public static final int REGULAR_VALUE = 2;

  /**
   * The '<em><b>Qualified</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #QUALIFIED
   * @model name="Qualified"
   * @generated
   * @ordered
   */
  public static final int QUALIFIED_VALUE = 3;

  /**
   * An array of all the '<em><b>Reference Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final ReferenceType[] VALUES_ARRAY =
    new ReferenceType[] {
      COMPOSITION,
      AGGREGATION,
      REGULAR,
      QUALIFIED,
    };

  /**
   * A public read-only list of all the '<em><b>Reference Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<ReferenceType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Reference Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ReferenceType get(String literal) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      ReferenceType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Reference Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ReferenceType getByName(String name) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      ReferenceType result = VALUES_ARRAY[i];
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Reference Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ReferenceType get(int value) {
    switch (value) {
      case COMPOSITION_VALUE: return COMPOSITION;
      case AGGREGATION_VALUE: return AGGREGATION;
      case REGULAR_VALUE: return REGULAR;
      case QUALIFIED_VALUE: return QUALIFIED;
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
  private ReferenceType(int value, String name, String literal) {
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
  
} //ReferenceType
