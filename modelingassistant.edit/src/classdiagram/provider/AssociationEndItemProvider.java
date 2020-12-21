/**
 */
package classdiagram.provider;


import classdiagram.AssociationEnd;
import classdiagram.ClassdiagramPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link classdiagram.AssociationEnd} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AssociationEndItemProvider extends StructuralFeatureItemProvider {
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssociationEndItemProvider(AdapterFactory adapterFactory) {
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

      addNavigablePropertyDescriptor(object);
      addAssocPropertyDescriptor(object);
      addQualifierPropertyDescriptor(object);
      addLowerBoundPropertyDescriptor(object);
      addUpperBoundPropertyDescriptor(object);
      addReferenceTypePropertyDescriptor(object);
      addOrderedPropertyDescriptor(object);
      addUniquePropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Navigable feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addNavigablePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_AssociationEnd_navigable_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_AssociationEnd_navigable_feature", "_UI_AssociationEnd_type"),
         ClassdiagramPackage.Literals.ASSOCIATION_END__NAVIGABLE,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Assoc feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addAssocPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_AssociationEnd_assoc_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_AssociationEnd_assoc_feature", "_UI_AssociationEnd_type"),
         ClassdiagramPackage.Literals.ASSOCIATION_END__ASSOC,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Qualifier feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addQualifierPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_AssociationEnd_qualifier_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_AssociationEnd_qualifier_feature", "_UI_AssociationEnd_type"),
         ClassdiagramPackage.Literals.ASSOCIATION_END__QUALIFIER,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Lower Bound feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addLowerBoundPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_AssociationEnd_lowerBound_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_AssociationEnd_lowerBound_feature", "_UI_AssociationEnd_type"),
         ClassdiagramPackage.Literals.ASSOCIATION_END__LOWER_BOUND,
         true,
         false,
         false,
         ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Upper Bound feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addUpperBoundPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_AssociationEnd_upperBound_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_AssociationEnd_upperBound_feature", "_UI_AssociationEnd_type"),
         ClassdiagramPackage.Literals.ASSOCIATION_END__UPPER_BOUND,
         true,
         false,
         false,
         ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Reference Type feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addReferenceTypePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_AssociationEnd_referenceType_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_AssociationEnd_referenceType_feature", "_UI_AssociationEnd_type"),
         ClassdiagramPackage.Literals.ASSOCIATION_END__REFERENCE_TYPE,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Ordered feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addOrderedPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_AssociationEnd_ordered_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_AssociationEnd_ordered_feature", "_UI_AssociationEnd_type"),
         ClassdiagramPackage.Literals.ASSOCIATION_END__ORDERED,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Unique feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addUniquePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_AssociationEnd_unique_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_AssociationEnd_unique_feature", "_UI_AssociationEnd_type"),
         ClassdiagramPackage.Literals.ASSOCIATION_END__UNIQUE,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This returns AssociationEnd.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/AssociationEnd"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {
    String label = ((AssociationEnd)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_AssociationEnd_type") :
      getString("_UI_AssociationEnd_type") + " " + label;
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

    switch (notification.getFeatureID(AssociationEnd.class)) {
      case ClassdiagramPackage.ASSOCIATION_END__NAVIGABLE:
      case ClassdiagramPackage.ASSOCIATION_END__LOWER_BOUND:
      case ClassdiagramPackage.ASSOCIATION_END__UPPER_BOUND:
      case ClassdiagramPackage.ASSOCIATION_END__REFERENCE_TYPE:
      case ClassdiagramPackage.ASSOCIATION_END__ORDERED:
      case ClassdiagramPackage.ASSOCIATION_END__UNIQUE:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
  }

}
