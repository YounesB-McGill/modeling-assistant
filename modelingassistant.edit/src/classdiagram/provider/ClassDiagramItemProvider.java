/**
 */
package classdiagram.provider;


import classdiagram.ClassDiagram;
import classdiagram.ClassdiagramFactory;
import classdiagram.ClassdiagramPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link classdiagram.ClassDiagram} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassDiagramItemProvider extends NamedElementItemProvider {
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassDiagramItemProvider(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
    if (itemPropertyDescriptors == null) {
      super.getPropertyDescriptors(object);

    }
    return itemPropertyDescriptors;
  }

  /**
   * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
   * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
   * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
    if (childrenFeatures == null) {
      super.getChildrenFeatures(object);
      childrenFeatures.add(ClassdiagramPackage.Literals.CLASS_DIAGRAM__CLASSES);
      childrenFeatures.add(ClassdiagramPackage.Literals.CLASS_DIAGRAM__TYPES);
      childrenFeatures.add(ClassdiagramPackage.Literals.CLASS_DIAGRAM__ASSOCIATIONS);
      childrenFeatures.add(ClassdiagramPackage.Literals.CLASS_DIAGRAM__NOTES);
      childrenFeatures.add(ClassdiagramPackage.Literals.CLASS_DIAGRAM__LAYOUT);
    }
    return childrenFeatures;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EStructuralFeature getChildFeature(Object object, Object child) {
    // Check the type of the specified child object and return the proper feature to use for
    // adding (see {@link AddCommand}) it as a child.

    return super.getChildFeature(object, child);
  }

  /**
   * This returns ClassDiagram.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/ClassDiagram"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {
    String label = ((ClassDiagram)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_ClassDiagram_type") :
      getString("_UI_ClassDiagram_type") + " " + label;
  }


  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification) {
    updateChildren(notification);

    switch (notification.getFeatureID(ClassDiagram.class)) {
      case ClassdiagramPackage.CLASS_DIAGRAM__CLASSES:
      case ClassdiagramPackage.CLASS_DIAGRAM__TYPES:
      case ClassdiagramPackage.CLASS_DIAGRAM__ASSOCIATIONS:
      case ClassdiagramPackage.CLASS_DIAGRAM__NOTES:
      case ClassdiagramPackage.CLASS_DIAGRAM__LAYOUT:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
        return;
    }
    super.notifyChanged(notification);
  }

  /**
   * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
   * that can be created under this object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
    super.collectNewChildDescriptors(newChildDescriptors, object);

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__CLASSES,
         ClassdiagramFactory.eINSTANCE.createImplementationClass()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__CLASSES,
         ClassdiagramFactory.eINSTANCE.createClass()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__CLASSES,
         ClassdiagramFactory.eINSTANCE.createCDBoolean()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__CLASSES,
         ClassdiagramFactory.eINSTANCE.createCDDouble()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__CLASSES,
         ClassdiagramFactory.eINSTANCE.createCDInt()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__CLASSES,
         ClassdiagramFactory.eINSTANCE.createCDLong()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__CLASSES,
         ClassdiagramFactory.eINSTANCE.createCDString()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__CLASSES,
         ClassdiagramFactory.eINSTANCE.createCDByte()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__CLASSES,
         ClassdiagramFactory.eINSTANCE.createCDFloat()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__CLASSES,
         ClassdiagramFactory.eINSTANCE.createCDArray()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__CLASSES,
         ClassdiagramFactory.eINSTANCE.createCDChar()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__CLASSES,
         ClassdiagramFactory.eINSTANCE.createCDEnum()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__CLASSES,
         ClassdiagramFactory.eINSTANCE.createCDSet()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__CLASSES,
         ClassdiagramFactory.eINSTANCE.createCDSequence()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__TYPES,
         ClassdiagramFactory.eINSTANCE.createImplementationClass()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__TYPES,
         ClassdiagramFactory.eINSTANCE.createClass()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__TYPES,
         ClassdiagramFactory.eINSTANCE.createTypeParameter()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__TYPES,
         ClassdiagramFactory.eINSTANCE.createCDBoolean()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__TYPES,
         ClassdiagramFactory.eINSTANCE.createCDDouble()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__TYPES,
         ClassdiagramFactory.eINSTANCE.createCDInt()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__TYPES,
         ClassdiagramFactory.eINSTANCE.createCDLong()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__TYPES,
         ClassdiagramFactory.eINSTANCE.createCDString()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__TYPES,
         ClassdiagramFactory.eINSTANCE.createCDByte()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__TYPES,
         ClassdiagramFactory.eINSTANCE.createCDFloat()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__TYPES,
         ClassdiagramFactory.eINSTANCE.createCDArray()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__TYPES,
         ClassdiagramFactory.eINSTANCE.createCDChar()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__TYPES,
         ClassdiagramFactory.eINSTANCE.createCDEnum()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__TYPES,
         ClassdiagramFactory.eINSTANCE.createCDAny()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__TYPES,
         ClassdiagramFactory.eINSTANCE.createCDVoid()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__TYPES,
         ClassdiagramFactory.eINSTANCE.createCDSet()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__TYPES,
         ClassdiagramFactory.eINSTANCE.createCDSequence()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__ASSOCIATIONS,
         ClassdiagramFactory.eINSTANCE.createAssociation()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__NOTES,
         ClassdiagramFactory.eINSTANCE.createNote()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASS_DIAGRAM__LAYOUT,
         ClassdiagramFactory.eINSTANCE.createLayout()));
  }

  /**
   * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
    Object childFeature = feature;
    Object childObject = child;

    boolean qualify =
      childFeature == ClassdiagramPackage.Literals.CLASS_DIAGRAM__CLASSES ||
      childFeature == ClassdiagramPackage.Literals.CLASS_DIAGRAM__TYPES;

    if (qualify) {
      return getString
        ("_UI_CreateChild_text2",
         new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
    }
    return super.getCreateChildText(owner, feature, child, selection);
  }

}
