/**
 */
package learningcorpus.provider;


import java.util.Collection;
import java.util.List;

import learningcorpus.LearningCorpus;
import learningcorpus.LearningcorpusFactory;
import learningcorpus.LearningcorpusPackage;

import modelingassistant.provider.ModelingassistantEditPlugin;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link learningcorpus.LearningCorpus} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LearningCorpusItemProvider 
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
  public LearningCorpusItemProvider(AdapterFactory adapterFactory) {
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
      childrenFeatures.add(LearningcorpusPackage.Literals.LEARNING_CORPUS__MISTAKE_TYPE_CATEGORIES);
      childrenFeatures.add(LearningcorpusPackage.Literals.LEARNING_CORPUS__FEEDBACKS);
      childrenFeatures.add(LearningcorpusPackage.Literals.LEARNING_CORPUS__LEARNING_ITEMS);
      childrenFeatures.add(LearningcorpusPackage.Literals.LEARNING_CORPUS__LEARNING_RESOURCES);
      childrenFeatures.add(LearningcorpusPackage.Literals.LEARNING_CORPUS__UML_ELEMENTS);
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
   * This returns LearningCorpus.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/LearningCorpus"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {
    return getString("_UI_LearningCorpus_type");
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

    switch (notification.getFeatureID(LearningCorpus.class)) {
      case LearningcorpusPackage.LEARNING_CORPUS__MISTAKE_TYPE_CATEGORIES:
      case LearningcorpusPackage.LEARNING_CORPUS__FEEDBACKS:
      case LearningcorpusPackage.LEARNING_CORPUS__LEARNING_ITEMS:
      case LearningcorpusPackage.LEARNING_CORPUS__LEARNING_RESOURCES:
      case LearningcorpusPackage.LEARNING_CORPUS__UML_ELEMENTS:
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
        (LearningcorpusPackage.Literals.LEARNING_CORPUS__MISTAKE_TYPE_CATEGORIES,
         LearningcorpusFactory.eINSTANCE.createMistakeTypeCategory()));

    newChildDescriptors.add
      (createChildParameter
        (LearningcorpusPackage.Literals.LEARNING_CORPUS__FEEDBACKS,
         LearningcorpusFactory.eINSTANCE.createFeedback()));

    newChildDescriptors.add
      (createChildParameter
        (LearningcorpusPackage.Literals.LEARNING_CORPUS__FEEDBACKS,
         LearningcorpusFactory.eINSTANCE.createTextResponse()));

    newChildDescriptors.add
      (createChildParameter
        (LearningcorpusPackage.Literals.LEARNING_CORPUS__FEEDBACKS,
         LearningcorpusFactory.eINSTANCE.createParametrizedResponse()));

    newChildDescriptors.add
      (createChildParameter
        (LearningcorpusPackage.Literals.LEARNING_CORPUS__FEEDBACKS,
         LearningcorpusFactory.eINSTANCE.createResourceResponse()));

    newChildDescriptors.add
      (createChildParameter
        (LearningcorpusPackage.Literals.LEARNING_CORPUS__LEARNING_ITEMS,
         LearningcorpusFactory.eINSTANCE.createLearningItem()));

    newChildDescriptors.add
      (createChildParameter
        (LearningcorpusPackage.Literals.LEARNING_CORPUS__LEARNING_RESOURCES,
         LearningcorpusFactory.eINSTANCE.createLearningResource()));

    newChildDescriptors.add
      (createChildParameter
        (LearningcorpusPackage.Literals.LEARNING_CORPUS__LEARNING_RESOURCES,
         LearningcorpusFactory.eINSTANCE.createReference()));

    newChildDescriptors.add
      (createChildParameter
        (LearningcorpusPackage.Literals.LEARNING_CORPUS__LEARNING_RESOURCES,
         LearningcorpusFactory.eINSTANCE.createTutorial()));

    newChildDescriptors.add
      (createChildParameter
        (LearningcorpusPackage.Literals.LEARNING_CORPUS__LEARNING_RESOURCES,
         LearningcorpusFactory.eINSTANCE.createExample()));

    newChildDescriptors.add
      (createChildParameter
        (LearningcorpusPackage.Literals.LEARNING_CORPUS__LEARNING_RESOURCES,
         LearningcorpusFactory.eINSTANCE.createQuiz()));

    newChildDescriptors.add
      (createChildParameter
        (LearningcorpusPackage.Literals.LEARNING_CORPUS__UML_ELEMENTS,
         LearningcorpusFactory.eINSTANCE.createUmlElement()));
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