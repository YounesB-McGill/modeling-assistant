/**
 */
package modelingassistant.provider;


import java.util.Collection;
import java.util.List;
import learningcorpus.provider.ModelingassistantEditPlugin;
import modelingassistant.ModelingassistantPackage;
import modelingassistant.StudentKnowledge;

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
 * This is the item provider adapter for a {@link modelingassistant.StudentKnowledge} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StudentKnowledgeItemProvider 
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
  public StudentKnowledgeItemProvider(AdapterFactory adapterFactory) {
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

      addLevelOfKnowledgePropertyDescriptor(object);
      addStudentPropertyDescriptor(object);
      addMistakeTypePropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Level Of Knowledge feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addLevelOfKnowledgePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_StudentKnowledge_levelOfKnowledge_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_StudentKnowledge_levelOfKnowledge_feature", "_UI_StudentKnowledge_type"),
         ModelingassistantPackage.Literals.STUDENT_KNOWLEDGE__LEVEL_OF_KNOWLEDGE,
         true,
         false,
         false,
         ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Student feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addStudentPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_StudentKnowledge_student_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_StudentKnowledge_student_feature", "_UI_StudentKnowledge_type"),
         ModelingassistantPackage.Literals.STUDENT_KNOWLEDGE__STUDENT,
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
         getString("_UI_StudentKnowledge_mistakeType_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_StudentKnowledge_mistakeType_feature", "_UI_StudentKnowledge_type"),
         ModelingassistantPackage.Literals.STUDENT_KNOWLEDGE__MISTAKE_TYPE,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This returns StudentKnowledge.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/StudentKnowledge"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {
    StudentKnowledge studentKnowledge = (StudentKnowledge)object;
    return getString("_UI_StudentKnowledge_type") + " " + studentKnowledge.getLevelOfKnowledge();
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

    switch (notification.getFeatureID(StudentKnowledge.class)) {
      case ModelingassistantPackage.STUDENT_KNOWLEDGE__LEVEL_OF_KNOWLEDGE:
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
