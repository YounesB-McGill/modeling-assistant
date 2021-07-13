/**
 */
package learningcorpus.provider;

import java.util.ArrayList;
import java.util.Collection;

import learningcorpus.util.LearningcorpusAdapterFactory;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LearningcorpusItemProviderAdapterFactory extends LearningcorpusAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
  /**
   * This keeps track of the root adapter factory that delegates to this adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ComposedAdapterFactory parentAdapterFactory;

  /**
   * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IChangeNotifier changeNotifier = new ChangeNotifier();

  /**
   * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Collection<Object> supportedTypes = new ArrayList<Object>();

  /**
   * This constructs an instance.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LearningcorpusItemProviderAdapterFactory() {
    supportedTypes.add(IEditingDomainItemProvider.class);
    supportedTypes.add(IStructuredItemContentProvider.class);
    supportedTypes.add(ITreeItemContentProvider.class);
    supportedTypes.add(IItemLabelProvider.class);
    supportedTypes.add(IItemPropertySource.class);
  }

  /**
   * This keeps track of the one adapter used for all {@link learningcorpus.LearningItem} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LearningItemItemProvider learningItemItemProvider;

  /**
   * This creates an adapter for a {@link learningcorpus.LearningItem}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createLearningItemAdapter() {
    if (learningItemItemProvider == null) {
      learningItemItemProvider = new LearningItemItemProvider(this);
    }

    return learningItemItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link learningcorpus.MistakeType} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MistakeTypeItemProvider mistakeTypeItemProvider;

  /**
   * This creates an adapter for a {@link learningcorpus.MistakeType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createMistakeTypeAdapter() {
    if (mistakeTypeItemProvider == null) {
      mistakeTypeItemProvider = new MistakeTypeItemProvider(this);
    }

    return mistakeTypeItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link learningcorpus.Feedback} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FeedbackItemProvider feedbackItemProvider;

  /**
   * This creates an adapter for a {@link learningcorpus.Feedback}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createFeedbackAdapter() {
    if (feedbackItemProvider == null) {
      feedbackItemProvider = new FeedbackItemProvider(this);
    }

    return feedbackItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link learningcorpus.TextResponse} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TextResponseItemProvider textResponseItemProvider;

  /**
   * This creates an adapter for a {@link learningcorpus.TextResponse}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createTextResponseAdapter() {
    if (textResponseItemProvider == null) {
      textResponseItemProvider = new TextResponseItemProvider(this);
    }

    return textResponseItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link learningcorpus.ParametrizedResponse} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ParametrizedResponseItemProvider parametrizedResponseItemProvider;

  /**
   * This creates an adapter for a {@link learningcorpus.ParametrizedResponse}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createParametrizedResponseAdapter() {
    if (parametrizedResponseItemProvider == null) {
      parametrizedResponseItemProvider = new ParametrizedResponseItemProvider(this);
    }

    return parametrizedResponseItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link learningcorpus.ResourceResponse} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ResourceResponseItemProvider resourceResponseItemProvider;

  /**
   * This creates an adapter for a {@link learningcorpus.ResourceResponse}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createResourceResponseAdapter() {
    if (resourceResponseItemProvider == null) {
      resourceResponseItemProvider = new ResourceResponseItemProvider(this);
    }

    return resourceResponseItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link learningcorpus.LearningResource} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LearningResourceItemProvider learningResourceItemProvider;

  /**
   * This creates an adapter for a {@link learningcorpus.LearningResource}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createLearningResourceAdapter() {
    if (learningResourceItemProvider == null) {
      learningResourceItemProvider = new LearningResourceItemProvider(this);
    }

    return learningResourceItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link learningcorpus.Reference} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReferenceItemProvider referenceItemProvider;

  /**
   * This creates an adapter for a {@link learningcorpus.Reference}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createReferenceAdapter() {
    if (referenceItemProvider == null) {
      referenceItemProvider = new ReferenceItemProvider(this);
    }

    return referenceItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link learningcorpus.Tutorial} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TutorialItemProvider tutorialItemProvider;

  /**
   * This creates an adapter for a {@link learningcorpus.Tutorial}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createTutorialAdapter() {
    if (tutorialItemProvider == null) {
      tutorialItemProvider = new TutorialItemProvider(this);
    }

    return tutorialItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link learningcorpus.Example} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExampleItemProvider exampleItemProvider;

  /**
   * This creates an adapter for a {@link learningcorpus.Example}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createExampleAdapter() {
    if (exampleItemProvider == null) {
      exampleItemProvider = new ExampleItemProvider(this);
    }

    return exampleItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link learningcorpus.Quiz} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected QuizItemProvider quizItemProvider;

  /**
   * This creates an adapter for a {@link learningcorpus.Quiz}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createQuizAdapter() {
    if (quizItemProvider == null) {
      quizItemProvider = new QuizItemProvider(this);
    }

    return quizItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link learningcorpus.MistakeTypeCategory} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MistakeTypeCategoryItemProvider mistakeTypeCategoryItemProvider;

  /**
   * This creates an adapter for a {@link learningcorpus.MistakeTypeCategory}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createMistakeTypeCategoryAdapter() {
    if (mistakeTypeCategoryItemProvider == null) {
      mistakeTypeCategoryItemProvider = new MistakeTypeCategoryItemProvider(this);
    }

    return mistakeTypeCategoryItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link learningcorpus.LearningCorpus} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LearningCorpusItemProvider learningCorpusItemProvider;

  /**
   * This creates an adapter for a {@link learningcorpus.LearningCorpus}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createLearningCorpusAdapter() {
    if (learningCorpusItemProvider == null) {
      learningCorpusItemProvider = new LearningCorpusItemProvider(this);
    }

    return learningCorpusItemProvider;
  }

  /**
   * This returns the root adapter factory that contains this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ComposeableAdapterFactory getRootAdapterFactory() {
    return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
  }

  /**
   * This sets the composed adapter factory that contains this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
    this.parentAdapterFactory = parentAdapterFactory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object type) {
    return supportedTypes.contains(type) || super.isFactoryForType(type);
  }

  /**
   * This implementation substitutes the factory itself as the key for the adapter.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter adapt(Notifier notifier, Object type) {
    return super.adapt(notifier, this);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object adapt(Object object, Object type) {
    if (isFactoryForType(type)) {
      Object adapter = super.adapt(object, type);
      if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
        return adapter;
      }
    }

    return null;
  }

  /**
   * This adds a listener.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void addListener(INotifyChangedListener notifyChangedListener) {
    changeNotifier.addListener(notifyChangedListener);
  }

  /**
   * This removes a listener.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void removeListener(INotifyChangedListener notifyChangedListener) {
    changeNotifier.removeListener(notifyChangedListener);
  }

  /**
   * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void fireNotifyChanged(Notification notification) {
    changeNotifier.fireNotifyChanged(notification);

    if (parentAdapterFactory != null) {
      parentAdapterFactory.fireNotifyChanged(notification);
    }
  }

  /**
   * This disposes all of the item providers created by this factory. 
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void dispose() {
    if (learningItemItemProvider != null) learningItemItemProvider.dispose();
    if (mistakeTypeItemProvider != null) mistakeTypeItemProvider.dispose();
    if (feedbackItemProvider != null) feedbackItemProvider.dispose();
    if (textResponseItemProvider != null) textResponseItemProvider.dispose();
    if (parametrizedResponseItemProvider != null) parametrizedResponseItemProvider.dispose();
    if (resourceResponseItemProvider != null) resourceResponseItemProvider.dispose();
    if (learningResourceItemProvider != null) learningResourceItemProvider.dispose();
    if (referenceItemProvider != null) referenceItemProvider.dispose();
    if (tutorialItemProvider != null) tutorialItemProvider.dispose();
    if (exampleItemProvider != null) exampleItemProvider.dispose();
    if (quizItemProvider != null) quizItemProvider.dispose();
    if (mistakeTypeCategoryItemProvider != null) mistakeTypeCategoryItemProvider.dispose();
    if (learningCorpusItemProvider != null) learningCorpusItemProvider.dispose();
  }

}
