/**
 */
package classdiagram;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Operation Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see classdiagram.ClassdiagramPackage#getOperationType()
 * @model
 * @generated
 */
public enum OperationType implements Enumerator {
  /**
   * The '<em><b>Normal</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NORMAL_VALUE
   * @generated
   * @ordered
   */
  NORMAL(0, "Normal", "Normal"),

  /**
   * The '<em><b>Constructor</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CONSTRUCTOR_VALUE
   * @generated
   * @ordered
   */
  CONSTRUCTOR(1, "Constructor", "Constructor"),

  /**
   * The '<em><b>Destructor</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DESTRUCTOR_VALUE
   * @generated
   * @ordered
   */
  DESTRUCTOR(2, "Destructor", "Destructor");

  /**
   * The '<em><b>Normal</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NORMAL
   * @model name="Normal"
   * @generated
   * @ordered
   */
  public static final int NORMAL_VALUE = 0;

  /**
   * The '<em><b>Constructor</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CONSTRUCTOR
   * @model name="Constructor"
   * @generated
   * @ordered
   */
  public static final int CONSTRUCTOR_VALUE = 1;

  /**
   * The '<em><b>Destructor</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DESTRUCTOR
   * @model name="Destructor"
   * @generated
   * @ordered
   */
  public static final int DESTRUCTOR_VALUE = 2;

  /**
   * An array of all the '<em><b>Operation Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final OperationType[] VALUES_ARRAY =
    new OperationType[] {
      NORMAL,
      CONSTRUCTOR,
      DESTRUCTOR,
    };

  /**
   * A public read-only list of all the '<em><b>Operation Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<OperationType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Operation Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static OperationType get(String literal) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      OperationType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Operation Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static OperationType getByName(String name) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      OperationType result = VALUES_ARRAY[i];
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Operation Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static OperationType get(int value) {
    switch (value) {
      case NORMAL_VALUE: return NORMAL;
      case CONSTRUCTOR_VALUE: return CONSTRUCTOR;
      case DESTRUCTOR_VALUE: return DESTRUCTOR;
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
  private OperationType(int value, String name, String literal) {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue() {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName() {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
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
  
} //OperationType
