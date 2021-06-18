/**
 */
package modelingassistant.provider;


import java.util.Collection;
import java.util.List;
import modelingassistant.Mistake;
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
 * This is the item provider adapter for a {@link modelingassistant.Mistake} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MistakeItemProvider 
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
  public MistakeItemProvider(AdapterFactory adapterFactory) {
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

      addResolvedPropertyDescriptor(object);
      addTimeToAddressPropertyDescriptor(object);
      addNumStepsBeforeNotificationPropertyDescriptor(object);
      addStudentElementsPropertyDescriptor(object);
      addLastFeedbackPropertyDescriptor(object);
      addInstructorElementsPropertyDescriptor(object);
      addNumDetectionPropertyDescriptor(object);
      addNumDetectionSinceResolvedPropertyDescriptor(object);
      addMistakeTypePropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Resolved feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addResolvedPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Mistake_resolved_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Mistake_resolved_feature", "_UI_Mistake_type"),
         ModelingassistantPackage.Literals.MISTAKE__RESOLVED,
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
         getString("_UI_Mistake_timeToAddress_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Mistake_timeToAddress_feature", "_UI_Mistake_type"),
         ModelingassistantPackage.Literals.MISTAKE__TIME_TO_ADDRESS,
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
         getString("_UI_Mistake_numStepsBeforeNotification_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Mistake_numStepsBeforeNotification_feature", "_UI_Mistake_type"),
         ModelingassistantPackage.Literals.MISTAKE__NUM_STEPS_BEFORE_NOTIFICATION,
         true,
         false,
         false,
         ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Student Elements feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addStudentElementsPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Mistake_studentElements_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Mistake_studentElements_feature", "_UI_Mistake_type"),
         ModelingassistantPackage.Literals.MISTAKE__STUDENT_ELEMENTS,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Last Feedback feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addLastFeedbackPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Mistake_lastFeedback_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Mistake_lastFeedback_feature", "_UI_Mistake_type"),
         ModelingassistantPackage.Literals.MISTAKE__LAST_FEEDBACK,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Instructor Elements feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addInstructorElementsPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Mistake_instructorElements_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Mistake_instructorElements_feature", "_UI_Mistake_type"),
         ModelingassistantPackage.Literals.MISTAKE__INSTRUCTOR_ELEMENTS,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Num Detection feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addNumDetectionPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Mistake_numDetection_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Mistake_numDetection_feature", "_UI_Mistake_type"),
         ModelingassistantPackage.Literals.MISTAKE__NUM_DETECTION,
         true,
         false,
         false,
         ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Num Detection Since Resolved feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addNumDetectionSinceResolvedPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Mistake_numDetectionSinceResolved_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Mistake_numDetectionSinceResolved_feature", "_UI_Mistake_type"),
         ModelingassistantPackage.Literals.MISTAKE__NUM_DETECTION_SINCE_RESOLVED,
         true,
         false,
         false,
         ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Mistake Type feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addMistakeTypePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Mistake_mistakeType_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Mistake_mistakeType_feature", "_UI_Mistake_type"),
         ModelingassistantPackage.Literals.MISTAKE__MISTAKE_TYPE,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This returns Mistake.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/Mistake"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {
    Mistake mistake = (Mistake)object;
    return getString("_UI_Mistake_type") + " " + mistake.isResolved();
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

    switch (notification.getFeatureID(Mistake.class)) {
      case ModelingassistantPackage.MISTAKE__RESOLVED:
      case ModelingassistantPackage.MISTAKE__TIME_TO_ADDRESS:
      case ModelingassistantPackage.MISTAKE__NUM_STEPS_BEFORE_NOTIFICATION:
      case ModelingassistantPackage.MISTAKE__NUM_DETECTION:
      case ModelingassistantPackage.MISTAKE__NUM_DETECTION_SINCE_RESOLVED:
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
