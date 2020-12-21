/**
 */
package classdiagram.provider;


import classdiagram.ClassdiagramFactory;
import classdiagram.ClassdiagramPackage;
import classdiagram.PrimitiveType;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link classdiagram.PrimitiveType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PrimitiveTypeItemProvider extends ObjectTypeItemProvider {
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimitiveTypeItemProvider(AdapterFactory adapterFactory) {
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

      addSuperTypesPropertyDescriptor(object);
      addDataTypePropertyDescriptor(object);
      addAbstractPropertyDescriptor(object);
      addVisibilityPropertyDescriptor(object);
      addInstanceClassNamePropertyDescriptor(object);
      addInterfacePropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Super Types feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addSuperTypesPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Classifier_superTypes_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Classifier_superTypes_feature", "_UI_Classifier_type"),
         ClassdiagramPackage.Literals.CLASSIFIER__SUPER_TYPES,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Data Type feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addDataTypePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Classifier_dataType_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Classifier_dataType_feature", "_UI_Classifier_type"),
         ClassdiagramPackage.Literals.CLASSIFIER__DATA_TYPE,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Abstract feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addAbstractPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Classifier_abstract_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Classifier_abstract_feature", "_UI_Classifier_type"),
         ClassdiagramPackage.Literals.CLASSIFIER__ABSTRACT,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Visibility feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addVisibilityPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Classifier_visibility_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Classifier_visibility_feature", "_UI_Classifier_type"),
         ClassdiagramPackage.Literals.CLASSIFIER__VISIBILITY,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Instance Class Name feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addInstanceClassNamePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_ImplementationClass_instanceClassName_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_ImplementationClass_instanceClassName_feature", "_UI_ImplementationClass_type"),
         ClassdiagramPackage.Literals.IMPLEMENTATION_CLASS__INSTANCE_CLASS_NAME,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Interface feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addInterfacePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_ImplementationClass_interface_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_ImplementationClass_interface_feature", "_UI_ImplementationClass_type"),
         ClassdiagramPackage.Literals.IMPLEMENTATION_CLASS__INTERFACE,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
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
      childrenFeatures.add(ClassdiagramPackage.Literals.CLASSIFIER__OPERATIONS);
      childrenFeatures.add(ClassdiagramPackage.Literals.CLASSIFIER__TYPE_PARAMETERS);
      childrenFeatures.add(ClassdiagramPackage.Literals.CLASSIFIER__ASSOCIATION_ENDS);
      childrenFeatures.add(ClassdiagramPackage.Literals.CLASSIFIER__ATTRIBUTES);
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
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {
    String label = ((PrimitiveType)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_PrimitiveType_type") :
      getString("_UI_PrimitiveType_type") + " " + label;
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

    switch (notification.getFeatureID(PrimitiveType.class)) {
      case ClassdiagramPackage.PRIMITIVE_TYPE__DATA_TYPE:
      case ClassdiagramPackage.PRIMITIVE_TYPE__ABSTRACT:
      case ClassdiagramPackage.PRIMITIVE_TYPE__VISIBILITY:
      case ClassdiagramPackage.PRIMITIVE_TYPE__INSTANCE_CLASS_NAME:
      case ClassdiagramPackage.PRIMITIVE_TYPE__INTERFACE:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
      case ClassdiagramPackage.PRIMITIVE_TYPE__OPERATIONS:
      case ClassdiagramPackage.PRIMITIVE_TYPE__TYPE_PARAMETERS:
      case ClassdiagramPackage.PRIMITIVE_TYPE__ASSOCIATION_ENDS:
      case ClassdiagramPackage.PRIMITIVE_TYPE__ATTRIBUTES:
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
        (ClassdiagramPackage.Literals.CLASSIFIER__OPERATIONS,
         ClassdiagramFactory.eINSTANCE.createOperation()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASSIFIER__TYPE_PARAMETERS,
         ClassdiagramFactory.eINSTANCE.createTypeParameter()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASSIFIER__ASSOCIATION_ENDS,
         ClassdiagramFactory.eINSTANCE.createAssociationEnd()));

    newChildDescriptors.add
      (createChildParameter
        (ClassdiagramPackage.Literals.CLASSIFIER__ATTRIBUTES,
         ClassdiagramFactory.eINSTANCE.createAttribute()));
  }

}
