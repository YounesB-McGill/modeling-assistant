/**
 */
package modelingassistant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Tag Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see modelingassistant.ModelingassistantPackage#getTagType()
 * @model
 * @generated
 */
public enum TagType implements Enumerator {
  /**
   * The '<em><b>Abstraction</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ABSTRACTION_VALUE
   * @generated
   * @ordered
   */
  ABSTRACTION(0, "Abstraction", "Abstraction"),

  /**
   * The '<em><b>Occurrencce</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OCCURRENCCE_VALUE
   * @generated
   * @ordered
   */
  OCCURRENCCE(1, "Occurrencce", "Occurrencce"),

  /**
   * The '<em><b>Player</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PLAYER_VALUE
   * @generated
   * @ordered
   */
  PLAYER(2, "Player", "Player"),

  /**
   * The '<em><b>Role</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ROLE_VALUE
   * @generated
   * @ordered
   */
  ROLE(3, "Role", "Role");

  /**
   * The '<em><b>Abstraction</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ABSTRACTION
   * @model name="Abstraction"
   * @generated
   * @ordered
   */
  public static final int ABSTRACTION_VALUE = 0;

  /**
   * The '<em><b>Occurrencce</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OCCURRENCCE
   * @model name="Occurrencce"
   * @generated
   * @ordered
   */
  public static final int OCCURRENCCE_VALUE = 1;

  /**
   * The '<em><b>Player</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PLAYER
   * @model name="Player"
   * @generated
   * @ordered
   */
  public static final int PLAYER_VALUE = 2;

  /**
   * The '<em><b>Role</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ROLE
   * @model name="Role"
   * @generated
   * @ordered
   */
  public static final int ROLE_VALUE = 3;

  /**
   * An array of all the '<em><b>Tag Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final TagType[] VALUES_ARRAY =
    new TagType[] {
      ABSTRACTION,
      OCCURRENCCE,
      PLAYER,
      ROLE,
    };

  /**
   * A public read-only list of all the '<em><b>Tag Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<TagType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Tag Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static TagType get(String literal) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      TagType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Tag Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static TagType getByName(String name) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      TagType result = VALUES_ARRAY[i];
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Tag Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static TagType get(int value) {
    switch (value) {
      case ABSTRACTION_VALUE: return ABSTRACTION;
      case OCCURRENCCE_VALUE: return OCCURRENCCE;
      case PLAYER_VALUE: return PLAYER;
      case ROLE_VALUE: return ROLE;
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
  private TagType(int value, String name, String literal) {
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
  
} //TagType
