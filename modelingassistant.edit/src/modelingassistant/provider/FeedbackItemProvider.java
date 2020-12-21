/**
 */
package modelingassistant.provider;


import java.util.Collection;
import java.util.List;

import modelingassistant.Feedback;
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
 * This is the item provider adapter for a {@link modelingassistant.Feedback} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FeedbackItemProvider 
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
  public FeedbackItemProvider(AdapterFactory adapterFactory) {
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

      addLevelPropertyDescriptor(object);
      addCongratulatoryPropertyDescriptor(object);
      addUsefulnessPropertyDescriptor(object);
      addHighlightProblemPropertyDescriptor(object);
      addHighlightSolutionPropertyDescriptor(object);
      addModelingAssistantPropertyDescriptor(object);
      addMistakeTypePropertyDescriptor(object);
      addMistakesPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Level feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addLevelPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Feedback_level_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Feedback_level_feature", "_UI_Feedback_type"),
         ModelingassistantPackage.Literals.FEEDBACK__LEVEL,
         true,
         false,
         false,
         ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Congratulatory feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addCongratulatoryPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Feedback_congratulatory_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Feedback_congratulatory_feature", "_UI_Feedback_type"),
         ModelingassistantPackage.Literals.FEEDBACK__CONGRATULATORY,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Usefulness feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addUsefulnessPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Feedback_usefulness_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Feedback_usefulness_feature", "_UI_Feedback_type"),
         ModelingassistantPackage.Literals.FEEDBACK__USEFULNESS,
         true,
         false,
         false,
         ItemPropertyDescriptor.REAL_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Highlight Problem feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addHighlightProblemPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Feedback_highlightProblem_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Feedback_highlightProblem_feature", "_UI_Feedback_type"),
         ModelingassistantPackage.Literals.FEEDBACK__HIGHLIGHT_PROBLEM,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Highlight Solution feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addHighlightSolutionPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Feedback_highlightSolution_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Feedback_highlightSolution_feature", "_UI_Feedback_type"),
         ModelingassistantPackage.Literals.FEEDBACK__HIGHLIGHT_SOLUTION,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
         getString("_UI_Feedback_modelingAssistant_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Feedback_modelingAssistant_feature", "_UI_Feedback_type"),
         ModelingassistantPackage.Literals.FEEDBACK__MODELING_ASSISTANT,
         true,
         false,
         true,
         null,
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
         getString("_UI_Feedback_mistakeType_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Feedback_mistakeType_feature", "_UI_Feedback_type"),
         ModelingassistantPackage.Literals.FEEDBACK__MISTAKE_TYPE,
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
         getString("_UI_Feedback_mistakes_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Feedback_mistakes_feature", "_UI_Feedback_type"),
         ModelingassistantPackage.Literals.FEEDBACK__MISTAKES,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This returns Feedback.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/Feedback"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {
    Feedback feedback = (Feedback)object;
    return getString("_UI_Feedback_type") + " " + feedback.getLevel();
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

    switch (notification.getFeatureID(Feedback.class)) {
      case ModelingassistantPackage.FEEDBACK__LEVEL:
      case ModelingassistantPackage.FEEDBACK__CONGRATULATORY:
      case ModelingassistantPackage.FEEDBACK__USEFULNESS:
      case ModelingassistantPackage.FEEDBACK__HIGHLIGHT_PROBLEM:
      case ModelingassistantPackage.FEEDBACK__HIGHLIGHT_SOLUTION:
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
