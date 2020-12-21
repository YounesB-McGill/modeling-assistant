/**
 */
package classdiagram.impl;

import classdiagram.AssociationEnd;
import classdiagram.Attribute;
import classdiagram.ClassdiagramPackage;
import classdiagram.Classifier;
import classdiagram.ImplementationClass;
import classdiagram.Operation;
import classdiagram.PrimitiveType;
import classdiagram.TypeParameter;
import classdiagram.VisibilityType;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.impl.PrimitiveTypeImpl#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link classdiagram.impl.PrimitiveTypeImpl#isDataType <em>Data Type</em>}</li>
 *   <li>{@link classdiagram.impl.PrimitiveTypeImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link classdiagram.impl.PrimitiveTypeImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link classdiagram.impl.PrimitiveTypeImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link classdiagram.impl.PrimitiveTypeImpl#getTypeParameters <em>Type Parameters</em>}</li>
 *   <li>{@link classdiagram.impl.PrimitiveTypeImpl#getAssociationEnds <em>Association Ends</em>}</li>
 *   <li>{@link classdiagram.impl.PrimitiveTypeImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link classdiagram.impl.PrimitiveTypeImpl#getInstanceClassName <em>Instance Class Name</em>}</li>
 *   <li>{@link classdiagram.impl.PrimitiveTypeImpl#isInterface <em>Interface</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PrimitiveTypeImpl extends ObjectTypeImpl implements PrimitiveType {
  /**
   * The cached value of the '{@link #getSuperTypes() <em>Super Types</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuperTypes()
   * @generated
   * @ordered
   */
  protected EList<Classifier> superTypes;

  /**
   * The default value of the '{@link #isDataType() <em>Data Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDataType()
   * @generated
   * @ordered
   */
  protected static final boolean DATA_TYPE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDataType() <em>Data Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDataType()
   * @generated
   * @ordered
   */
  protected boolean dataType = DATA_TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected static final boolean ABSTRACT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected boolean abstract_ = ABSTRACT_EDEFAULT;

  /**
   * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVisibility()
   * @generated
   * @ordered
   */
  protected static final VisibilityType VISIBILITY_EDEFAULT = VisibilityType.PACKAGE;

  /**
   * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVisibility()
   * @generated
   * @ordered
   */
  protected VisibilityType visibility = VISIBILITY_EDEFAULT;

  /**
   * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperations()
   * @generated
   * @ordered
   */
  protected EList<Operation> operations;

  /**
   * The cached value of the '{@link #getTypeParameters() <em>Type Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeParameters()
   * @generated
   * @ordered
   */
  protected EList<TypeParameter> typeParameters;

  /**
   * The cached value of the '{@link #getAssociationEnds() <em>Association Ends</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssociationEnds()
   * @generated
   * @ordered
   */
  protected EList<AssociationEnd> associationEnds;

  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<Attribute> attributes;

  /**
   * The default value of the '{@link #getInstanceClassName() <em>Instance Class Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInstanceClassName()
   * @generated
   * @ordered
   */
  protected static final String INSTANCE_CLASS_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getInstanceClassName() <em>Instance Class Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInstanceClassName()
   * @generated
   * @ordered
   */
  protected String instanceClassName = INSTANCE_CLASS_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #isInterface() <em>Interface</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isInterface()
   * @generated
   * @ordered
   */
  protected static final boolean INTERFACE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isInterface() <em>Interface</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isInterface()
   * @generated
   * @ordered
   */
  protected boolean interface_ = INTERFACE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PrimitiveTypeImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ClassdiagramPackage.Literals.PRIMITIVE_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Classifier> getSuperTypes() {
    if (superTypes == null) {
      superTypes = new EObjectResolvingEList<Classifier>(Classifier.class, this, ClassdiagramPackage.PRIMITIVE_TYPE__SUPER_TYPES);
    }
    return superTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDataType() {
    return dataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDataType(boolean newDataType) {
    boolean oldDataType = dataType;
    dataType = newDataType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.PRIMITIVE_TYPE__DATA_TYPE, oldDataType, dataType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAbstract() {
    return abstract_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAbstract(boolean newAbstract) {
    boolean oldAbstract = abstract_;
    abstract_ = newAbstract;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.PRIMITIVE_TYPE__ABSTRACT, oldAbstract, abstract_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VisibilityType getVisibility() {
    return visibility;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVisibility(VisibilityType newVisibility) {
    VisibilityType oldVisibility = visibility;
    visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.PRIMITIVE_TYPE__VISIBILITY, oldVisibility, visibility));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Operation> getOperations() {
    if (operations == null) {
      operations = new EObjectContainmentEList<Operation>(Operation.class, this, ClassdiagramPackage.PRIMITIVE_TYPE__OPERATIONS);
    }
    return operations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TypeParameter> getTypeParameters() {
    if (typeParameters == null) {
      typeParameters = new EObjectContainmentEList<TypeParameter>(TypeParameter.class, this, ClassdiagramPackage.PRIMITIVE_TYPE__TYPE_PARAMETERS);
    }
    return typeParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AssociationEnd> getAssociationEnds() {
    if (associationEnds == null) {
      associationEnds = new EObjectContainmentWithInverseEList<AssociationEnd>(AssociationEnd.class, this, ClassdiagramPackage.PRIMITIVE_TYPE__ASSOCIATION_ENDS, ClassdiagramPackage.ASSOCIATION_END__CLASSIFIER);
    }
    return associationEnds;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Attribute> getAttributes() {
    if (attributes == null) {
      attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, ClassdiagramPackage.PRIMITIVE_TYPE__ATTRIBUTES);
    }
    return attributes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getInstanceClassName() {
    return instanceClassName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInstanceClassName(String newInstanceClassName) {
    String oldInstanceClassName = instanceClassName;
    instanceClassName = newInstanceClassName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.PRIMITIVE_TYPE__INSTANCE_CLASS_NAME, oldInstanceClassName, instanceClassName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isInterface() {
    return interface_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInterface(boolean newInterface) {
    boolean oldInterface = interface_;
    interface_ = newInterface;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.PRIMITIVE_TYPE__INTERFACE, oldInterface, interface_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ClassdiagramPackage.PRIMITIVE_TYPE__ASSOCIATION_ENDS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssociationEnds()).basicAdd(otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ClassdiagramPackage.PRIMITIVE_TYPE__OPERATIONS:
        return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
      case ClassdiagramPackage.PRIMITIVE_TYPE__TYPE_PARAMETERS:
        return ((InternalEList<?>)getTypeParameters()).basicRemove(otherEnd, msgs);
      case ClassdiagramPackage.PRIMITIVE_TYPE__ASSOCIATION_ENDS:
        return ((InternalEList<?>)getAssociationEnds()).basicRemove(otherEnd, msgs);
      case ClassdiagramPackage.PRIMITIVE_TYPE__ATTRIBUTES:
        return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ClassdiagramPackage.PRIMITIVE_TYPE__SUPER_TYPES:
        return getSuperTypes();
      case ClassdiagramPackage.PRIMITIVE_TYPE__DATA_TYPE:
        return isDataType();
      case ClassdiagramPackage.PRIMITIVE_TYPE__ABSTRACT:
        return isAbstract();
      case ClassdiagramPackage.PRIMITIVE_TYPE__VISIBILITY:
        return getVisibility();
      case ClassdiagramPackage.PRIMITIVE_TYPE__OPERATIONS:
        return getOperations();
      case ClassdiagramPackage.PRIMITIVE_TYPE__TYPE_PARAMETERS:
        return getTypeParameters();
      case ClassdiagramPackage.PRIMITIVE_TYPE__ASSOCIATION_ENDS:
        return getAssociationEnds();
      case ClassdiagramPackage.PRIMITIVE_TYPE__ATTRIBUTES:
        return getAttributes();
      case ClassdiagramPackage.PRIMITIVE_TYPE__INSTANCE_CLASS_NAME:
        return getInstanceClassName();
      case ClassdiagramPackage.PRIMITIVE_TYPE__INTERFACE:
        return isInterface();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case ClassdiagramPackage.PRIMITIVE_TYPE__SUPER_TYPES:
        getSuperTypes().clear();
        getSuperTypes().addAll((Collection<? extends Classifier>)newValue);
        return;
      case ClassdiagramPackage.PRIMITIVE_TYPE__DATA_TYPE:
        setDataType((Boolean)newValue);
        return;
      case ClassdiagramPackage.PRIMITIVE_TYPE__ABSTRACT:
        setAbstract((Boolean)newValue);
        return;
      case ClassdiagramPackage.PRIMITIVE_TYPE__VISIBILITY:
        setVisibility((VisibilityType)newValue);
        return;
      case ClassdiagramPackage.PRIMITIVE_TYPE__OPERATIONS:
        getOperations().clear();
        getOperations().addAll((Collection<? extends Operation>)newValue);
        return;
      case ClassdiagramPackage.PRIMITIVE_TYPE__TYPE_PARAMETERS:
        getTypeParameters().clear();
        getTypeParameters().addAll((Collection<? extends TypeParameter>)newValue);
        return;
      case ClassdiagramPackage.PRIMITIVE_TYPE__ASSOCIATION_ENDS:
        getAssociationEnds().clear();
        getAssociationEnds().addAll((Collection<? extends AssociationEnd>)newValue);
        return;
      case ClassdiagramPackage.PRIMITIVE_TYPE__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends Attribute>)newValue);
        return;
      case ClassdiagramPackage.PRIMITIVE_TYPE__INSTANCE_CLASS_NAME:
        setInstanceClassName((String)newValue);
        return;
      case ClassdiagramPackage.PRIMITIVE_TYPE__INTERFACE:
        setInterface((Boolean)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case ClassdiagramPackage.PRIMITIVE_TYPE__SUPER_TYPES:
        getSuperTypes().clear();
        return;
      case ClassdiagramPackage.PRIMITIVE_TYPE__DATA_TYPE:
        setDataType(DATA_TYPE_EDEFAULT);
        return;
      case ClassdiagramPackage.PRIMITIVE_TYPE__ABSTRACT:
        setAbstract(ABSTRACT_EDEFAULT);
        return;
      case ClassdiagramPackage.PRIMITIVE_TYPE__VISIBILITY:
        setVisibility(VISIBILITY_EDEFAULT);
        return;
      case ClassdiagramPackage.PRIMITIVE_TYPE__OPERATIONS:
        getOperations().clear();
        return;
      case ClassdiagramPackage.PRIMITIVE_TYPE__TYPE_PARAMETERS:
        getTypeParameters().clear();
        return;
      case ClassdiagramPackage.PRIMITIVE_TYPE__ASSOCIATION_ENDS:
        getAssociationEnds().clear();
        return;
      case ClassdiagramPackage.PRIMITIVE_TYPE__ATTRIBUTES:
        getAttributes().clear();
        return;
      case ClassdiagramPackage.PRIMITIVE_TYPE__INSTANCE_CLASS_NAME:
        setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
        return;
      case ClassdiagramPackage.PRIMITIVE_TYPE__INTERFACE:
        setInterface(INTERFACE_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case ClassdiagramPackage.PRIMITIVE_TYPE__SUPER_TYPES:
        return superTypes != null && !superTypes.isEmpty();
      case ClassdiagramPackage.PRIMITIVE_TYPE__DATA_TYPE:
        return dataType != DATA_TYPE_EDEFAULT;
      case ClassdiagramPackage.PRIMITIVE_TYPE__ABSTRACT:
        return abstract_ != ABSTRACT_EDEFAULT;
      case ClassdiagramPackage.PRIMITIVE_TYPE__VISIBILITY:
        return visibility != VISIBILITY_EDEFAULT;
      case ClassdiagramPackage.PRIMITIVE_TYPE__OPERATIONS:
        return operations != null && !operations.isEmpty();
      case ClassdiagramPackage.PRIMITIVE_TYPE__TYPE_PARAMETERS:
        return typeParameters != null && !typeParameters.isEmpty();
      case ClassdiagramPackage.PRIMITIVE_TYPE__ASSOCIATION_ENDS:
        return associationEnds != null && !associationEnds.isEmpty();
      case ClassdiagramPackage.PRIMITIVE_TYPE__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
      case ClassdiagramPackage.PRIMITIVE_TYPE__INSTANCE_CLASS_NAME:
        return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
      case ClassdiagramPackage.PRIMITIVE_TYPE__INTERFACE:
        return interface_ != INTERFACE_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
    if (baseClass == Classifier.class) {
      switch (derivedFeatureID) {
        case ClassdiagramPackage.PRIMITIVE_TYPE__SUPER_TYPES: return ClassdiagramPackage.CLASSIFIER__SUPER_TYPES;
        case ClassdiagramPackage.PRIMITIVE_TYPE__DATA_TYPE: return ClassdiagramPackage.CLASSIFIER__DATA_TYPE;
        case ClassdiagramPackage.PRIMITIVE_TYPE__ABSTRACT: return ClassdiagramPackage.CLASSIFIER__ABSTRACT;
        case ClassdiagramPackage.PRIMITIVE_TYPE__VISIBILITY: return ClassdiagramPackage.CLASSIFIER__VISIBILITY;
        case ClassdiagramPackage.PRIMITIVE_TYPE__OPERATIONS: return ClassdiagramPackage.CLASSIFIER__OPERATIONS;
        case ClassdiagramPackage.PRIMITIVE_TYPE__TYPE_PARAMETERS: return ClassdiagramPackage.CLASSIFIER__TYPE_PARAMETERS;
        case ClassdiagramPackage.PRIMITIVE_TYPE__ASSOCIATION_ENDS: return ClassdiagramPackage.CLASSIFIER__ASSOCIATION_ENDS;
        case ClassdiagramPackage.PRIMITIVE_TYPE__ATTRIBUTES: return ClassdiagramPackage.CLASSIFIER__ATTRIBUTES;
        default: return -1;
      }
    }
    if (baseClass == ImplementationClass.class) {
      switch (derivedFeatureID) {
        case ClassdiagramPackage.PRIMITIVE_TYPE__INSTANCE_CLASS_NAME: return ClassdiagramPackage.IMPLEMENTATION_CLASS__INSTANCE_CLASS_NAME;
        case ClassdiagramPackage.PRIMITIVE_TYPE__INTERFACE: return ClassdiagramPackage.IMPLEMENTATION_CLASS__INTERFACE;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
    if (baseClass == Classifier.class) {
      switch (baseFeatureID) {
        case ClassdiagramPackage.CLASSIFIER__SUPER_TYPES: return ClassdiagramPackage.PRIMITIVE_TYPE__SUPER_TYPES;
        case ClassdiagramPackage.CLASSIFIER__DATA_TYPE: return ClassdiagramPackage.PRIMITIVE_TYPE__DATA_TYPE;
        case ClassdiagramPackage.CLASSIFIER__ABSTRACT: return ClassdiagramPackage.PRIMITIVE_TYPE__ABSTRACT;
        case ClassdiagramPackage.CLASSIFIER__VISIBILITY: return ClassdiagramPackage.PRIMITIVE_TYPE__VISIBILITY;
        case ClassdiagramPackage.CLASSIFIER__OPERATIONS: return ClassdiagramPackage.PRIMITIVE_TYPE__OPERATIONS;
        case ClassdiagramPackage.CLASSIFIER__TYPE_PARAMETERS: return ClassdiagramPackage.PRIMITIVE_TYPE__TYPE_PARAMETERS;
        case ClassdiagramPackage.CLASSIFIER__ASSOCIATION_ENDS: return ClassdiagramPackage.PRIMITIVE_TYPE__ASSOCIATION_ENDS;
        case ClassdiagramPackage.CLASSIFIER__ATTRIBUTES: return ClassdiagramPackage.PRIMITIVE_TYPE__ATTRIBUTES;
        default: return -1;
      }
    }
    if (baseClass == ImplementationClass.class) {
      switch (baseFeatureID) {
        case ClassdiagramPackage.IMPLEMENTATION_CLASS__INSTANCE_CLASS_NAME: return ClassdiagramPackage.PRIMITIVE_TYPE__INSTANCE_CLASS_NAME;
        case ClassdiagramPackage.IMPLEMENTATION_CLASS__INTERFACE: return ClassdiagramPackage.PRIMITIVE_TYPE__INTERFACE;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (dataType: ");
    result.append(dataType);
    result.append(", abstract: ");
    result.append(abstract_);
    result.append(", visibility: ");
    result.append(visibility);
    result.append(", instanceClassName: ");
    result.append(instanceClassName);
    result.append(", interface: ");
    result.append(interface_);
    result.append(')');
    return result.toString();
  }

} //PrimitiveTypeImpl
