/**
 */
package classdiagram.impl;

import classdiagram.Association;
import classdiagram.ClassDiagram;
import classdiagram.ClassdiagramPackage;
import classdiagram.Classifier;
import classdiagram.Layout;
import classdiagram.Note;
import classdiagram.Type;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link classdiagram.impl.ClassDiagramImpl#getClasses <em>Classes</em>}</li>
 *   <li>{@link classdiagram.impl.ClassDiagramImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link classdiagram.impl.ClassDiagramImpl#getAssociations <em>Associations</em>}</li>
 *   <li>{@link classdiagram.impl.ClassDiagramImpl#getNotes <em>Notes</em>}</li>
 *   <li>{@link classdiagram.impl.ClassDiagramImpl#getLayout <em>Layout</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassDiagramImpl extends NamedElementImpl implements ClassDiagram {
  /**
   * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClasses()
   * @generated
   * @ordered
   */
  protected EList<Classifier> classes;

  /**
   * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypes()
   * @generated
   * @ordered
   */
  protected EList<Type> types;

  /**
   * The cached value of the '{@link #getAssociations() <em>Associations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssociations()
   * @generated
   * @ordered
   */
  protected EList<Association> associations;

  /**
   * The cached value of the '{@link #getNotes() <em>Notes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNotes()
   * @generated
   * @ordered
   */
  protected EList<Note> notes;

  /**
   * The cached value of the '{@link #getLayout() <em>Layout</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLayout()
   * @generated
   * @ordered
   */
  protected Layout layout;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassDiagramImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ClassdiagramPackage.Literals.CLASS_DIAGRAM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Classifier> getClasses() {
    if (classes == null) {
      classes = new EObjectContainmentEList<Classifier>(Classifier.class, this, ClassdiagramPackage.CLASS_DIAGRAM__CLASSES);
    }
    return classes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Type> getTypes() {
    if (types == null) {
      types = new EObjectContainmentEList<Type>(Type.class, this, ClassdiagramPackage.CLASS_DIAGRAM__TYPES);
    }
    return types;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Association> getAssociations() {
    if (associations == null) {
      associations = new EObjectContainmentEList<Association>(Association.class, this, ClassdiagramPackage.CLASS_DIAGRAM__ASSOCIATIONS);
    }
    return associations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Note> getNotes() {
    if (notes == null) {
      notes = new EObjectContainmentEList<Note>(Note.class, this, ClassdiagramPackage.CLASS_DIAGRAM__NOTES);
    }
    return notes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Layout getLayout() {
    return layout;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLayout(Layout newLayout, NotificationChain msgs) {
    Layout oldLayout = layout;
    layout = newLayout;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.CLASS_DIAGRAM__LAYOUT, oldLayout, newLayout);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLayout(Layout newLayout) {
    if (newLayout != layout) {
      NotificationChain msgs = null;
      if (layout != null)
        msgs = ((InternalEObject)layout).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassdiagramPackage.CLASS_DIAGRAM__LAYOUT, null, msgs);
      if (newLayout != null)
        msgs = ((InternalEObject)newLayout).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ClassdiagramPackage.CLASS_DIAGRAM__LAYOUT, null, msgs);
      msgs = basicSetLayout(newLayout, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.CLASS_DIAGRAM__LAYOUT, newLayout, newLayout));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ClassdiagramPackage.CLASS_DIAGRAM__CLASSES:
        return ((InternalEList<?>)getClasses()).basicRemove(otherEnd, msgs);
      case ClassdiagramPackage.CLASS_DIAGRAM__TYPES:
        return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
      case ClassdiagramPackage.CLASS_DIAGRAM__ASSOCIATIONS:
        return ((InternalEList<?>)getAssociations()).basicRemove(otherEnd, msgs);
      case ClassdiagramPackage.CLASS_DIAGRAM__NOTES:
        return ((InternalEList<?>)getNotes()).basicRemove(otherEnd, msgs);
      case ClassdiagramPackage.CLASS_DIAGRAM__LAYOUT:
        return basicSetLayout(null, msgs);
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
      case ClassdiagramPackage.CLASS_DIAGRAM__CLASSES:
        return getClasses();
      case ClassdiagramPackage.CLASS_DIAGRAM__TYPES:
        return getTypes();
      case ClassdiagramPackage.CLASS_DIAGRAM__ASSOCIATIONS:
        return getAssociations();
      case ClassdiagramPackage.CLASS_DIAGRAM__NOTES:
        return getNotes();
      case ClassdiagramPackage.CLASS_DIAGRAM__LAYOUT:
        return getLayout();
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
      case ClassdiagramPackage.CLASS_DIAGRAM__CLASSES:
        getClasses().clear();
        getClasses().addAll((Collection<? extends Classifier>)newValue);
        return;
      case ClassdiagramPackage.CLASS_DIAGRAM__TYPES:
        getTypes().clear();
        getTypes().addAll((Collection<? extends Type>)newValue);
        return;
      case ClassdiagramPackage.CLASS_DIAGRAM__ASSOCIATIONS:
        getAssociations().clear();
        getAssociations().addAll((Collection<? extends Association>)newValue);
        return;
      case ClassdiagramPackage.CLASS_DIAGRAM__NOTES:
        getNotes().clear();
        getNotes().addAll((Collection<? extends Note>)newValue);
        return;
      case ClassdiagramPackage.CLASS_DIAGRAM__LAYOUT:
        setLayout((Layout)newValue);
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
      case ClassdiagramPackage.CLASS_DIAGRAM__CLASSES:
        getClasses().clear();
        return;
      case ClassdiagramPackage.CLASS_DIAGRAM__TYPES:
        getTypes().clear();
        return;
      case ClassdiagramPackage.CLASS_DIAGRAM__ASSOCIATIONS:
        getAssociations().clear();
        return;
      case ClassdiagramPackage.CLASS_DIAGRAM__NOTES:
        getNotes().clear();
        return;
      case ClassdiagramPackage.CLASS_DIAGRAM__LAYOUT:
        setLayout((Layout)null);
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
      case ClassdiagramPackage.CLASS_DIAGRAM__CLASSES:
        return classes != null && !classes.isEmpty();
      case ClassdiagramPackage.CLASS_DIAGRAM__TYPES:
        return types != null && !types.isEmpty();
      case ClassdiagramPackage.CLASS_DIAGRAM__ASSOCIATIONS:
        return associations != null && !associations.isEmpty();
      case ClassdiagramPackage.CLASS_DIAGRAM__NOTES:
        return notes != null && !notes.isEmpty();
      case ClassdiagramPackage.CLASS_DIAGRAM__LAYOUT:
        return layout != null;
    }
    return super.eIsSet(featureID);
  }

} //ClassDiagramImpl
