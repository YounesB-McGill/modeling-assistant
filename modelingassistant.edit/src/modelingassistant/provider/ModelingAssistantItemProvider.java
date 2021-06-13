/**
 */
package modelingassistant.provider;


import java.util.Collection;
import java.util.List;

import modelingassistant.ModelingAssistant;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.ModelingassistantPackage;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link modelingassistant.ModelingAssistant} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelingAssistantItemProvider 
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
  public ModelingAssistantItemProvider(AdapterFactory adapterFactory) {
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

      addProblemStatementsPropertyDescriptor(object);
      addSolutionsPropertyDescriptor(object);
      addStudentsPropertyDescriptor(object);
      addFeedbackItemsPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Problem Statements feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addProblemStatementsPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_ModelingAssistant_problemStatements_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_ModelingAssistant_problemStatements_feature", "_UI_ModelingAssistant_type"),
         ModelingassistantPackage.Literals.MODELING_ASSISTANT__PROBLEM_STATEMENTS,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Solutions feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addSolutionsPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_ModelingAssistant_solutions_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_ModelingAssistant_solutions_feature", "_UI_ModelingAssistant_type"),
         ModelingassistantPackage.Literals.MODELING_ASSISTANT__SOLUTIONS,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Students feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addStudentsPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_ModelingAssistant_students_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_ModelingAssistant_students_feature", "_UI_ModelingAssistant_type"),
         ModelingassistantPackage.Literals.MODELING_ASSISTANT__STUDENTS,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Feedback Items feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addFeedbackItemsPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_ModelingAssistant_feedbackItems_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_ModelingAssistant_feedbackItems_feature", "_UI_ModelingAssistant_type"),
         ModelingassistantPackage.Literals.MODELING_ASSISTANT__FEEDBACK_ITEMS,
         true,
         false,
         true,
         null,
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
      childrenFeatures.add(ModelingassistantPackage.Literals.MODELING_ASSISTANT__PROBLEM_STATEMENTS);
      childrenFeatures.add(ModelingassistantPackage.Literals.MODELING_ASSISTANT__SOLUTIONS);
      childrenFeatures.add(ModelingassistantPackage.Literals.MODELING_ASSISTANT__STUDENTS);
      childrenFeatures.add(ModelingassistantPackage.Literals.MODELING_ASSISTANT__STUDENT_KNOWLEDGES);
      childrenFeatures.add(ModelingassistantPackage.Literals.MODELING_ASSISTANT__FEEDBACK_ITEMS);
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
   * This returns ModelingAssistant.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/ModelingAssistant"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {
    return getString("_UI_ModelingAssistant_type");
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

    switch (notification.getFeatureID(ModelingAssistant.class)) {
      case ModelingassistantPackage.MODELING_ASSISTANT__PROBLEM_STATEMENTS:
      case ModelingassistantPackage.MODELING_ASSISTANT__SOLUTIONS:
      case ModelingassistantPackage.MODELING_ASSISTANT__STUDENTS:
      case ModelingassistantPackage.MODELING_ASSISTANT__STUDENT_KNOWLEDGES:
      case ModelingassistantPackage.MODELING_ASSISTANT__FEEDBACK_ITEMS:
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
        (ModelingassistantPackage.Literals.MODELING_ASSISTANT__PROBLEM_STATEMENTS,
         ModelingassistantFactory.eINSTANCE.createProblemStatement()));

    newChildDescriptors.add
      (createChildParameter
        (ModelingassistantPackage.Literals.MODELING_ASSISTANT__SOLUTIONS,
         ModelingassistantFactory.eINSTANCE.createSolution()));

    newChildDescriptors.add
      (createChildParameter
        (ModelingassistantPackage.Literals.MODELING_ASSISTANT__STUDENTS,
         ModelingassistantFactory.eINSTANCE.createStudent()));

    newChildDescriptors.add
      (createChildParameter
        (ModelingassistantPackage.Literals.MODELING_ASSISTANT__STUDENT_KNOWLEDGES,
         ModelingassistantFactory.eINSTANCE.createStudentKnowledge()));

    newChildDescriptors.add
      (createChildParameter
        (ModelingassistantPackage.Literals.MODELING_ASSISTANT__FEEDBACK_ITEMS,
         ModelingassistantFactory.eINSTANCE.createFeedbackItem()));
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
