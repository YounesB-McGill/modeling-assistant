/**
 */
package learningcorpusquiz.provider;


import java.util.Collection;
import java.util.List;

import learningcorpus.provider.ModelingassistantEditPlugin;
import learningcorpus.provider.QuizItemProvider;

import learningcorpusquiz.LearningcorpusquizFactory;
import learningcorpusquiz.LearningcorpusquizPackage;
import learningcorpusquiz.TableMultipleChoiceQuiz;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link learningcorpusquiz.TableMultipleChoiceQuiz} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TableMultipleChoiceQuizItemProvider extends QuizItemProvider {
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TableMultipleChoiceQuizItemProvider(AdapterFactory adapterFactory) {
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

      addRowItemsPropertyDescriptor(object);
      addColumnItemsPropertyDescriptor(object);
      addEntriesPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Row Items feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addRowItemsPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_TableMultipleChoiceQuiz_rowItems_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_TableMultipleChoiceQuiz_rowItems_feature", "_UI_TableMultipleChoiceQuiz_type"),
         LearningcorpusquizPackage.Literals.TABLE_MULTIPLE_CHOICE_QUIZ__ROW_ITEMS,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Column Items feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addColumnItemsPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_TableMultipleChoiceQuiz_columnItems_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_TableMultipleChoiceQuiz_columnItems_feature", "_UI_TableMultipleChoiceQuiz_type"),
         LearningcorpusquizPackage.Literals.TABLE_MULTIPLE_CHOICE_QUIZ__COLUMN_ITEMS,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Entries feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addEntriesPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_TableMultipleChoiceQuiz_entries_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_TableMultipleChoiceQuiz_entries_feature", "_UI_TableMultipleChoiceQuiz_type"),
         LearningcorpusquizPackage.Literals.TABLE_MULTIPLE_CHOICE_QUIZ__ENTRIES,
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
      childrenFeatures.add(LearningcorpusquizPackage.Literals.TABLE_MULTIPLE_CHOICE_QUIZ__ROW_ITEMS);
      childrenFeatures.add(LearningcorpusquizPackage.Literals.TABLE_MULTIPLE_CHOICE_QUIZ__COLUMN_ITEMS);
      childrenFeatures.add(LearningcorpusquizPackage.Literals.TABLE_MULTIPLE_CHOICE_QUIZ__ENTRIES);
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
   * This returns TableMultipleChoiceQuiz.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/TableMultipleChoiceQuiz"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {
    String label = ((TableMultipleChoiceQuiz)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_TableMultipleChoiceQuiz_type") :
      getString("_UI_TableMultipleChoiceQuiz_type") + " " + label;
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

    switch (notification.getFeatureID(TableMultipleChoiceQuiz.class)) {
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__ROW_ITEMS:
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__COLUMN_ITEMS:
      case LearningcorpusquizPackage.TABLE_MULTIPLE_CHOICE_QUIZ__ENTRIES:
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
        (LearningcorpusquizPackage.Literals.TABLE_MULTIPLE_CHOICE_QUIZ__ROW_ITEMS,
         LearningcorpusquizFactory.eINSTANCE.createTableMcqRowItem()));

    newChildDescriptors.add
      (createChildParameter
        (LearningcorpusquizPackage.Literals.TABLE_MULTIPLE_CHOICE_QUIZ__COLUMN_ITEMS,
         LearningcorpusquizFactory.eINSTANCE.createTableMcqColumnItem()));

    newChildDescriptors.add
      (createChildParameter
        (LearningcorpusquizPackage.Literals.TABLE_MULTIPLE_CHOICE_QUIZ__ENTRIES,
         LearningcorpusquizFactory.eINSTANCE.createTableMcqEntry()));
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
