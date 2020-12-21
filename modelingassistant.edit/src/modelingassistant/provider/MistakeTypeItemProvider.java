/**
 */
package modelingassistant.provider;


import java.util.Collection;
import java.util.List;

import modelingassistant.MistakeType;
import modelingassistant.ModelingassistantPackage;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link modelingassistant.MistakeType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MistakeTypeItemProvider 
  extends ItemProviderAdapter
  implements
    IEditingDomainItemProvider,
    IStructuredItemContentProvider,
    ITreeItemContentProvider,
    IItemLabelProvider,
    IItemPropertySource {
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MistakeTypeItemProvider(AdapterFactory adapterFactory) {
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

      addNamePropertyDescriptor(object);
      addAtomicPropertyDescriptor(object);
      addTimeToAddressPropertyDescriptor(object);
      addNumStepsBeforeNotificationPropertyDescriptor(object);
      addModelingAssistantPropertyDescriptor(object);
      addLearningItemPropertyDescriptor(object);
      addStudentKnowledgesPropertyDescriptor(object);
      addMistakesPropertyDescriptor(object);
      addFeedbacksPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Name feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addNamePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_MistakeType_name_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_MistakeType_name_feature", "_UI_MistakeType_type"),
         ModelingassistantPackage.Literals.MISTAKE_TYPE__NAME,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Atomic feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addAtomicPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_MistakeType_atomic_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_MistakeType_atomic_feature", "_UI_MistakeType_type"),
         ModelingassistantPackage.Literals.MISTAKE_TYPE__ATOMIC,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Time To Address feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addTimeToAddressPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_MistakeType_timeToAddress_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_MistakeType_timeToAddress_feature", "_UI_MistakeType_type"),
         ModelingassistantPackage.Literals.MISTAKE_TYPE__TIME_TO_ADDRESS,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Num Steps Before Notification feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addNumStepsBeforeNotificationPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_MistakeType_numStepsBeforeNotification_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_MistakeType_numStepsBeforeNotification_feature", "_UI_MistakeType_type"),
         ModelingassistantPackage.Literals.MISTAKE_TYPE__NUM_STEPS_BEFORE_NOTIFICATION,
         true,
         false,
         false,
         ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Modeling Assistant feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addModelingAssistantPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_MistakeType_modelingAssistant_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_MistakeType_modelingAssistant_feature", "_UI_MistakeType_type"),
         ModelingassistantPackage.Literals.MISTAKE_TYPE__MODELING_ASSISTANT,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Learning Item feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addLearningItemPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_MistakeType_learningItem_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_MistakeType_learningItem_feature", "_UI_MistakeType_type"),
         ModelingassistantPackage.Literals.MISTAKE_TYPE__LEARNING_ITEM,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Student Knowledges feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addStudentKnowledgesPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_MistakeType_studentKnowledges_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_MistakeType_studentKnowledges_feature", "_UI_MistakeType_type"),
         ModelingassistantPackage.Literals.MISTAKE_TYPE__STUDENT_KNOWLEDGES,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Mistakes feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addMistakesPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_MistakeType_mistakes_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_MistakeType_mistakes_feature", "_UI_MistakeType_type"),
         ModelingassistantPackage.Literals.MISTAKE_TYPE__MISTAKES,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Feedbacks feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addFeedbacksPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_MistakeType_feedbacks_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_MistakeType_feedbacks_feature", "_UI_MistakeType_type"),
         ModelingassistantPackage.Literals.MISTAKE_TYPE__FEEDBACKS,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This returns MistakeType.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/MistakeType"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {
    String label = ((MistakeType)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_MistakeType_type") :
      getString("_UI_MistakeType_type") + " " + label;
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

    switch (notification.getFeatureID(MistakeType.class)) {
      case ModelingassistantPackage.MISTAKE_TYPE__NAME:
      case ModelingassistantPackage.MISTAKE_TYPE__ATOMIC:
      case ModelingassistantPackage.MISTAKE_TYPE__TIME_TO_ADDRESS:
      case ModelingassistantPackage.MISTAKE_TYPE__NUM_STEPS_BEFORE_NOTIFICATION:
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

  /**
   * Return the resource locator for this item provider's resources.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator() {
    return ModelingassistantEditPlugin.INSTANCE;
  }

}
