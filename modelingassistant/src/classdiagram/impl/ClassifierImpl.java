/**
 */
package classdiagram.impl;

import classdiagram.AssociationEnd;
import classdiagram.Attribute;
import classdiagram.ClassdiagramPackage;
import classdiagram.Classifier;
import classdiagram.Operation;
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
 * An implementation of the model object '<em><b>Classifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.impl.ClassifierImpl#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link classdiagram.impl.ClassifierImpl#isDataType <em>Data Type</em>}</li>
 *   <li>{@link classdiagram.impl.ClassifierImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link classdiagram.impl.ClassifierImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link classdiagram.impl.ClassifierImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link classdiagram.impl.ClassifierImpl#getTypeParameters <em>Type Parameters</em>}</li>
 *   <li>{@link classdiagram.impl.ClassifierImpl#getAssociationEnds <em>Association Ends</em>}</li>
 *   <li>{@link classdiagram.impl.ClassifierImpl#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ClassifierImpl extends ObjectTypeImpl implements Classifier {
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassifierImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ClassdiagramPackage.Literals.CLASSIFIER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Classifier> getSuperTypes() {
    if (superTypes == null) {
      superTypes = new EObjectResolvingEList<Classifier>(Classifier.class, this, ClassdiagramPackage.CLASSIFIER__SUPER_TYPES);
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
      eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.CLASSIFIER__DATA_TYPE, oldDataType, dataType));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.CLASSIFIER__ABSTRACT, oldAbstract, abstract_));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.CLASSIFIER__VISIBILITY, oldVisibility, visibility));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Operation> getOperations() {
    if (operations == null) {
      operations = new EObjectContainmentEList<Operation>(Operation.class, this, ClassdiagramPackage.CLASSIFIER__OPERATIONS);
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
      typeParameters = new EObjectContainmentEList<TypeParameter>(TypeParameter.class, this, ClassdiagramPackage.CLASSIFIER__TYPE_PARAMETERS);
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
      associationEnds = new EObjectContainmentWithInverseEList<AssociationEnd>(AssociationEnd.class, this, ClassdiagramPackage.CLASSIFIER__ASSOCIATION_ENDS, ClassdiagramPackage.ASSOCIATION_END__CLASSIFIER);
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
      attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, ClassdiagramPackage.CLASSIFIER__ATTRIBUTES);
    }
    return attributes;
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
      case ClassdiagramPackage.CLASSIFIER__ASSOCIATION_ENDS:
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
      case ClassdiagramPackage.CLASSIFIER__OPERATIONS:
        return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
      case ClassdiagramPackage.CLASSIFIER__TYPE_PARAMETERS:
        return ((InternalEList<?>)getTypeParameters()).basicRemove(otherEnd, msgs);
      case ClassdiagramPackage.CLASSIFIER__ASSOCIATION_ENDS:
        return ((InternalEList<?>)getAssociationEnds()).basicRemove(otherEnd, msgs);
      case ClassdiagramPackage.CLASSIFIER__ATTRIBUTES:
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
      case ClassdiagramPackage.CLASSIFIER__SUPER_TYPES:
        return getSuperTypes();
      case ClassdiagramPackage.CLASSIFIER__DATA_TYPE:
        return isDataType();
      case ClassdiagramPackage.CLASSIFIER__ABSTRACT:
        return isAbstract();
      case ClassdiagramPackage.CLASSIFIER__VISIBILITY:
        return getVisibility();
      case ClassdiagramPackage.CLASSIFIER__OPERATIONS:
        return getOperations();
      case ClassdiagramPackage.CLASSIFIER__TYPE_PARAMETERS:
        return getTypeParameters();
      case ClassdiagramPackage.CLASSIFIER__ASSOCIATION_ENDS:
        return getAssociationEnds();
      case ClassdiagramPackage.CLASSIFIER__ATTRIBUTES:
        return getAttributes();
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
      case ClassdiagramPackage.CLASSIFIER__SUPER_TYPES:
        getSuperTypes().clear();
        getSuperTypes().addAll((Collection<? extends Classifier>)newValue);
        return;
      case ClassdiagramPackage.CLASSIFIER__DATA_TYPE:
        setDataType((Boolean)newValue);
        return;
      case ClassdiagramPackage.CLASSIFIER__ABSTRACT:
        setAbstract((Boolean)newValue);
        return;
      case ClassdiagramPackage.CLASSIFIER__VISIBILITY:
        setVisibility((VisibilityType)newValue);
        return;
      case ClassdiagramPackage.CLASSIFIER__OPERATIONS:
        getOperations().clear();
        getOperations().addAll((Collection<? extends Operation>)newValue);
        return;
      case ClassdiagramPackage.CLASSIFIER__TYPE_PARAMETERS:
        getTypeParameters().clear();
        getTypeParameters().addAll((Collection<? extends TypeParameter>)newValue);
        return;
      case ClassdiagramPackage.CLASSIFIER__ASSOCIATION_ENDS:
        getAssociationEnds().clear();
        getAssociationEnds().addAll((Collection<? extends AssociationEnd>)newValue);
        return;
      case ClassdiagramPackage.CLASSIFIER__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends Attribute>)newValue);
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
      case ClassdiagramPackage.CLASSIFIER__SUPER_TYPES:
        getSuperTypes().clear();
        return;
      case ClassdiagramPackage.CLASSIFIER__DATA_TYPE:
        setDataType(DATA_TYPE_EDEFAULT);
        return;
      case ClassdiagramPackage.CLASSIFIER__ABSTRACT:
        setAbstract(ABSTRACT_EDEFAULT);
        return;
      case ClassdiagramPackage.CLASSIFIER__VISIBILITY:
        setVisibility(VISIBILITY_EDEFAULT);
        return;
      case ClassdiagramPackage.CLASSIFIER__OPERATIONS:
        getOperations().clear();
        return;
      case ClassdiagramPackage.CLASSIFIER__TYPE_PARAMETERS:
        getTypeParameters().clear();
        return;
      case ClassdiagramPackage.CLASSIFIER__ASSOCIATION_ENDS:
        getAssociationEnds().clear();
        return;
      case ClassdiagramPackage.CLASSIFIER__ATTRIBUTES:
        getAttributes().clear();
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
      case ClassdiagramPackage.CLASSIFIER__SUPER_TYPES:
        return superTypes != null && !superTypes.isEmpty();
      case ClassdiagramPackage.CLASSIFIER__DATA_TYPE:
        return dataType != DATA_TYPE_EDEFAULT;
      case ClassdiagramPackage.CLASSIFIER__ABSTRACT:
        return abstract_ != ABSTRACT_EDEFAULT;
      case ClassdiagramPackage.CLASSIFIER__VISIBILITY:
        return visibility != VISIBILITY_EDEFAULT;
      case ClassdiagramPackage.CLASSIFIER__OPERATIONS:
        return operations != null && !operations.isEmpty();
      case ClassdiagramPackage.CLASSIFIER__TYPE_PARAMETERS:
        return typeParameters != null && !typeParameters.isEmpty();
      case ClassdiagramPackage.CLASSIFIER__ASSOCIATION_ENDS:
        return associationEnds != null && !associationEnds.isEmpty();
      case ClassdiagramPackage.CLASSIFIER__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
    }
    return super.eIsSet(featureID);
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
    result.append(')');
    return result.toString();
  }

} //ClassifierImpl
