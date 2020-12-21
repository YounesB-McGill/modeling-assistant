/**
 */
package classdiagram.impl;

import classdiagram.Association;
import classdiagram.AssociationEnd;
import classdiagram.ClassdiagramPackage;
import classdiagram.Classifier;
import classdiagram.ReferenceType;
import classdiagram.Type;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.impl.AssociationEndImpl#isNavigable <em>Navigable</em>}</li>
 *   <li>{@link classdiagram.impl.AssociationEndImpl#getAssoc <em>Assoc</em>}</li>
 *   <li>{@link classdiagram.impl.AssociationEndImpl#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link classdiagram.impl.AssociationEndImpl#getQualifier <em>Qualifier</em>}</li>
 *   <li>{@link classdiagram.impl.AssociationEndImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link classdiagram.impl.AssociationEndImpl#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link classdiagram.impl.AssociationEndImpl#getReferenceType <em>Reference Type</em>}</li>
 *   <li>{@link classdiagram.impl.AssociationEndImpl#isOrdered <em>Ordered</em>}</li>
 *   <li>{@link classdiagram.impl.AssociationEndImpl#isUnique <em>Unique</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssociationEndImpl extends StructuralFeatureImpl implements AssociationEnd {
  /**
   * The default value of the '{@link #isNavigable() <em>Navigable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNavigable()
   * @generated
   * @ordered
   */
  protected static final boolean NAVIGABLE_EDEFAULT = true;

  /**
   * The cached value of the '{@link #isNavigable() <em>Navigable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNavigable()
   * @generated
   * @ordered
   */
  protected boolean navigable = NAVIGABLE_EDEFAULT;

  /**
   * The cached value of the '{@link #getAssoc() <em>Assoc</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssoc()
   * @generated
   * @ordered
   */
  protected Association assoc;

  /**
   * The cached value of the '{@link #getQualifier() <em>Qualifier</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualifier()
   * @generated
   * @ordered
   */
  protected Type qualifier;

  /**
   * The default value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLowerBound()
   * @generated
   * @ordered
   */
  protected static final int LOWER_BOUND_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLowerBound()
   * @generated
   * @ordered
   */
  protected int lowerBound = LOWER_BOUND_EDEFAULT;

  /**
   * The default value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpperBound()
   * @generated
   * @ordered
   */
  protected static final int UPPER_BOUND_EDEFAULT = 1;

  /**
   * The cached value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpperBound()
   * @generated
   * @ordered
   */
  protected int upperBound = UPPER_BOUND_EDEFAULT;

  /**
   * The default value of the '{@link #getReferenceType() <em>Reference Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferenceType()
   * @generated
   * @ordered
   */
  protected static final ReferenceType REFERENCE_TYPE_EDEFAULT = ReferenceType.REGULAR;

  /**
   * The cached value of the '{@link #getReferenceType() <em>Reference Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferenceType()
   * @generated
   * @ordered
   */
  protected ReferenceType referenceType = REFERENCE_TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #isOrdered() <em>Ordered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOrdered()
   * @generated
   * @ordered
   */
  protected static final boolean ORDERED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isOrdered() <em>Ordered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOrdered()
   * @generated
   * @ordered
   */
  protected boolean ordered = ORDERED_EDEFAULT;

  /**
   * The default value of the '{@link #isUnique() <em>Unique</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUnique()
   * @generated
   * @ordered
   */
  protected static final boolean UNIQUE_EDEFAULT = true;

  /**
   * The cached value of the '{@link #isUnique() <em>Unique</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUnique()
   * @generated
   * @ordered
   */
  protected boolean unique = UNIQUE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssociationEndImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ClassdiagramPackage.Literals.ASSOCIATION_END;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isNavigable() {
    return navigable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNavigable(boolean newNavigable) {
    boolean oldNavigable = navigable;
    navigable = newNavigable;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.ASSOCIATION_END__NAVIGABLE, oldNavigable, navigable));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Association getAssoc() {
    if (assoc != null && assoc.eIsProxy()) {
      InternalEObject oldAssoc = (InternalEObject)assoc;
      assoc = (Association)eResolveProxy(oldAssoc);
      if (assoc != oldAssoc) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassdiagramPackage.ASSOCIATION_END__ASSOC, oldAssoc, assoc));
      }
    }
    return assoc;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Association basicGetAssoc() {
    return assoc;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAssoc(Association newAssoc, NotificationChain msgs) {
    Association oldAssoc = assoc;
    assoc = newAssoc;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.ASSOCIATION_END__ASSOC, oldAssoc, newAssoc);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssoc(Association newAssoc) {
    if (newAssoc != assoc) {
      NotificationChain msgs = null;
      if (assoc != null)
        msgs = ((InternalEObject)assoc).eInverseRemove(this, ClassdiagramPackage.ASSOCIATION__ENDS, Association.class, msgs);
      if (newAssoc != null)
        msgs = ((InternalEObject)newAssoc).eInverseAdd(this, ClassdiagramPackage.ASSOCIATION__ENDS, Association.class, msgs);
      msgs = basicSetAssoc(newAssoc, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.ASSOCIATION_END__ASSOC, newAssoc, newAssoc));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Classifier getClassifier() {
    if (eContainerFeatureID() != ClassdiagramPackage.ASSOCIATION_END__CLASSIFIER) return null;
    return (Classifier)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetClassifier(Classifier newClassifier, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newClassifier, ClassdiagramPackage.ASSOCIATION_END__CLASSIFIER, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassifier(Classifier newClassifier) {
    if (newClassifier != eInternalContainer() || (eContainerFeatureID() != ClassdiagramPackage.ASSOCIATION_END__CLASSIFIER && newClassifier != null)) {
      if (EcoreUtil.isAncestor(this, newClassifier))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newClassifier != null)
        msgs = ((InternalEObject)newClassifier).eInverseAdd(this, ClassdiagramPackage.CLASSIFIER__ASSOCIATION_ENDS, Classifier.class, msgs);
      msgs = basicSetClassifier(newClassifier, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.ASSOCIATION_END__CLASSIFIER, newClassifier, newClassifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getQualifier() {
    if (qualifier != null && qualifier.eIsProxy()) {
      InternalEObject oldQualifier = (InternalEObject)qualifier;
      qualifier = (Type)eResolveProxy(oldQualifier);
      if (qualifier != oldQualifier) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassdiagramPackage.ASSOCIATION_END__QUALIFIER, oldQualifier, qualifier));
      }
    }
    return qualifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type basicGetQualifier() {
    return qualifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQualifier(Type newQualifier) {
    Type oldQualifier = qualifier;
    qualifier = newQualifier;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.ASSOCIATION_END__QUALIFIER, oldQualifier, qualifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getLowerBound() {
    return lowerBound;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLowerBound(int newLowerBound) {
    int oldLowerBound = lowerBound;
    lowerBound = newLowerBound;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.ASSOCIATION_END__LOWER_BOUND, oldLowerBound, lowerBound));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getUpperBound() {
    return upperBound;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUpperBound(int newUpperBound) {
    int oldUpperBound = upperBound;
    upperBound = newUpperBound;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.ASSOCIATION_END__UPPER_BOUND, oldUpperBound, upperBound));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferenceType getReferenceType() {
    return referenceType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReferenceType(ReferenceType newReferenceType) {
    ReferenceType oldReferenceType = referenceType;
    referenceType = newReferenceType == null ? REFERENCE_TYPE_EDEFAULT : newReferenceType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.ASSOCIATION_END__REFERENCE_TYPE, oldReferenceType, referenceType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isOrdered() {
    return ordered;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOrdered(boolean newOrdered) {
    boolean oldOrdered = ordered;
    ordered = newOrdered;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.ASSOCIATION_END__ORDERED, oldOrdered, ordered));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isUnique() {
    return unique;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnique(boolean newUnique) {
    boolean oldUnique = unique;
    unique = newUnique;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.ASSOCIATION_END__UNIQUE, oldUnique, unique));
  }

  /**
   * The cached invocation delegate for the '{@link #getOppositeEnd() <em>Get Opposite End</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOppositeEnd()
   * @generated
   * @ordered
   */
  protected static final EOperation.Internal.InvocationDelegate GET_OPPOSITE_END__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassdiagramPackage.Literals.ASSOCIATION_END___GET_OPPOSITE_END).getInvocationDelegate();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssociationEnd getOppositeEnd() {
    try {
      return (AssociationEnd)GET_OPPOSITE_END__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
    }
    catch (InvocationTargetException ite) {
      throw new WrappedException(ite);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ClassdiagramPackage.ASSOCIATION_END__ASSOC:
        if (assoc != null)
          msgs = ((InternalEObject)assoc).eInverseRemove(this, ClassdiagramPackage.ASSOCIATION__ENDS, Association.class, msgs);
        return basicSetAssoc((Association)otherEnd, msgs);
      case ClassdiagramPackage.ASSOCIATION_END__CLASSIFIER:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetClassifier((Classifier)otherEnd, msgs);
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
      case ClassdiagramPackage.ASSOCIATION_END__ASSOC:
        return basicSetAssoc(null, msgs);
      case ClassdiagramPackage.ASSOCIATION_END__CLASSIFIER:
        return basicSetClassifier(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
    switch (eContainerFeatureID()) {
      case ClassdiagramPackage.ASSOCIATION_END__CLASSIFIER:
        return eInternalContainer().eInverseRemove(this, ClassdiagramPackage.CLASSIFIER__ASSOCIATION_ENDS, Classifier.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ClassdiagramPackage.ASSOCIATION_END__NAVIGABLE:
        return isNavigable();
      case ClassdiagramPackage.ASSOCIATION_END__ASSOC:
        if (resolve) return getAssoc();
        return basicGetAssoc();
      case ClassdiagramPackage.ASSOCIATION_END__CLASSIFIER:
        return getClassifier();
      case ClassdiagramPackage.ASSOCIATION_END__QUALIFIER:
        if (resolve) return getQualifier();
        return basicGetQualifier();
      case ClassdiagramPackage.ASSOCIATION_END__LOWER_BOUND:
        return getLowerBound();
      case ClassdiagramPackage.ASSOCIATION_END__UPPER_BOUND:
        return getUpperBound();
      case ClassdiagramPackage.ASSOCIATION_END__REFERENCE_TYPE:
        return getReferenceType();
      case ClassdiagramPackage.ASSOCIATION_END__ORDERED:
        return isOrdered();
      case ClassdiagramPackage.ASSOCIATION_END__UNIQUE:
        return isUnique();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case ClassdiagramPackage.ASSOCIATION_END__NAVIGABLE:
        setNavigable((Boolean)newValue);
        return;
      case ClassdiagramPackage.ASSOCIATION_END__ASSOC:
        setAssoc((Association)newValue);
        return;
      case ClassdiagramPackage.ASSOCIATION_END__CLASSIFIER:
        setClassifier((Classifier)newValue);
        return;
      case ClassdiagramPackage.ASSOCIATION_END__QUALIFIER:
        setQualifier((Type)newValue);
        return;
      case ClassdiagramPackage.ASSOCIATION_END__LOWER_BOUND:
        setLowerBound((Integer)newValue);
        return;
      case ClassdiagramPackage.ASSOCIATION_END__UPPER_BOUND:
        setUpperBound((Integer)newValue);
        return;
      case ClassdiagramPackage.ASSOCIATION_END__REFERENCE_TYPE:
        setReferenceType((ReferenceType)newValue);
        return;
      case ClassdiagramPackage.ASSOCIATION_END__ORDERED:
        setOrdered((Boolean)newValue);
        return;
      case ClassdiagramPackage.ASSOCIATION_END__UNIQUE:
        setUnique((Boolean)newValue);
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
      case ClassdiagramPackage.ASSOCIATION_END__NAVIGABLE:
        setNavigable(NAVIGABLE_EDEFAULT);
        return;
      case ClassdiagramPackage.ASSOCIATION_END__ASSOC:
        setAssoc((Association)null);
        return;
      case ClassdiagramPackage.ASSOCIATION_END__CLASSIFIER:
        setClassifier((Classifier)null);
        return;
      case ClassdiagramPackage.ASSOCIATION_END__QUALIFIER:
        setQualifier((Type)null);
        return;
      case ClassdiagramPackage.ASSOCIATION_END__LOWER_BOUND:
        setLowerBound(LOWER_BOUND_EDEFAULT);
        return;
      case ClassdiagramPackage.ASSOCIATION_END__UPPER_BOUND:
        setUpperBound(UPPER_BOUND_EDEFAULT);
        return;
      case ClassdiagramPackage.ASSOCIATION_END__REFERENCE_TYPE:
        setReferenceType(REFERENCE_TYPE_EDEFAULT);
        return;
      case ClassdiagramPackage.ASSOCIATION_END__ORDERED:
        setOrdered(ORDERED_EDEFAULT);
        return;
      case ClassdiagramPackage.ASSOCIATION_END__UNIQUE:
        setUnique(UNIQUE_EDEFAULT);
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
      case ClassdiagramPackage.ASSOCIATION_END__NAVIGABLE:
        return navigable != NAVIGABLE_EDEFAULT;
      case ClassdiagramPackage.ASSOCIATION_END__ASSOC:
        return assoc != null;
      case ClassdiagramPackage.ASSOCIATION_END__CLASSIFIER:
        return getClassifier() != null;
      case ClassdiagramPackage.ASSOCIATION_END__QUALIFIER:
        return qualifier != null;
      case ClassdiagramPackage.ASSOCIATION_END__LOWER_BOUND:
        return lowerBound != LOWER_BOUND_EDEFAULT;
      case ClassdiagramPackage.ASSOCIATION_END__UPPER_BOUND:
        return upperBound != UPPER_BOUND_EDEFAULT;
      case ClassdiagramPackage.ASSOCIATION_END__REFERENCE_TYPE:
        return referenceType != REFERENCE_TYPE_EDEFAULT;
      case ClassdiagramPackage.ASSOCIATION_END__ORDERED:
        return ordered != ORDERED_EDEFAULT;
      case ClassdiagramPackage.ASSOCIATION_END__UNIQUE:
        return unique != UNIQUE_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case ClassdiagramPackage.ASSOCIATION_END___GET_OPPOSITE_END:
        return getOppositeEnd();
    }
    return super.eInvoke(operationID, arguments);
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
    result.append(" (navigable: ");
    result.append(navigable);
    result.append(", lowerBound: ");
    result.append(lowerBound);
    result.append(", upperBound: ");
    result.append(upperBound);
    result.append(", referenceType: ");
    result.append(referenceType);
    result.append(", ordered: ");
    result.append(ordered);
    result.append(", unique: ");
    result.append(unique);
    result.append(')');
    return result.toString();
  }

} //AssociationEndImpl
