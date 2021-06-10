/**
 */
package learningcorpus;

import java.sql.Time;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mistake Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link learningcorpus.MistakeType#isAtomic <em>Atomic</em>}</li>
 *   <li>{@link learningcorpus.MistakeType#getTimeToAddress <em>Time To Address</em>}</li>
 *   <li>{@link learningcorpus.MistakeType#getNumStepsBeforeNotification <em>Num Steps Before Notification</em>}</li>
 *   <li>{@link learningcorpus.MistakeType#getLearningItem <em>Learning Item</em>}</li>
 *   <li>{@link learningcorpus.MistakeType#getFeedbacks <em>Feedbacks</em>}</li>
 *   <li>{@link learningcorpus.MistakeType#getMistakeTypeCategory <em>Mistake Type Category</em>}</li>
 * </ul>
 *
 * @see learningcorpus.LearningcorpusPackage#getMistakeType()
 * @model
 * @generated
 */
public interface MistakeType extends NamedElement {
  /**
   * Returns the value of the '<em><b>Atomic</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Atomic</em>' attribute.
   * @see #setAtomic(boolean)
   * @see learningcorpus.LearningcorpusPackage#getMistakeType_Atomic()
   * @model
   * @generated
   */
  boolean isAtomic();

  /**
   * Sets the value of the '{@link learningcorpus.MistakeType#isAtomic <em>Atomic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Atomic</em>' attribute.
   * @see #isAtomic()
   * @generated
   */
  void setAtomic(boolean value);

  /**
   * Returns the value of the '<em><b>Time To Address</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Time To Address</em>' attribute.
   * @see #setTimeToAddress(Time)
   * @see learningcorpus.LearningcorpusPackage#getMistakeType_TimeToAddress()
   * @model dataType="learningcorpus.Time"
   * @generated
   */
  Time getTimeToAddress();

  /**
   * Sets the value of the '{@link learningcorpus.MistakeType#getTimeToAddress <em>Time To Address</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Time To Address</em>' attribute.
   * @see #getTimeToAddress()
   * @generated
   */
  void setTimeToAddress(Time value);

  /**
   * Returns the value of the '<em><b>Num Steps Before Notification</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Num Steps Before Notification</em>' attribute.
   * @see #setNumStepsBeforeNotification(int)
   * @see learningcorpus.LearningcorpusPackage#getMistakeType_NumStepsBeforeNotification()
   * @model
   * @generated
   */
  int getNumStepsBeforeNotification();

  /**
   * Sets the value of the '{@link learningcorpus.MistakeType#getNumStepsBeforeNotification <em>Num Steps Before Notification</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Num Steps Before Notification</em>' attribute.
   * @see #getNumStepsBeforeNotification()
   * @generated
   */
  void setNumStepsBeforeNotification(int value);

  /**
   * Returns the value of the '<em><b>Learning Item</b></em>' reference.
   * It is bidirectional and its opposite is '{@link learningcorpus.LearningItem#getMistakeTypes <em>Mistake Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Learning Item</em>' reference.
   * @see #setLearningItem(LearningItem)
   * @see learningcorpus.LearningcorpusPackage#getMistakeType_LearningItem()
   * @see learningcorpus.LearningItem#getMistakeTypes
   * @model opposite="mistakeTypes" required="true"
   * @generated
   */
  LearningItem getLearningItem();

  /**
   * Sets the value of the '{@link learningcorpus.MistakeType#getLearningItem <em>Learning Item</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Learning Item</em>' reference.
   * @see #getLearningItem()
   * @generated
   */
  void setLearningItem(LearningItem value);

  /**
   * Returns the value of the '<em><b>Feedbacks</b></em>' reference list.
   * The list contents are of type {@link learningcorpus.Feedback}.
   * It is bidirectional and its opposite is '{@link learningcorpus.Feedback#getMistakeType <em>Mistake Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feedbacks</em>' reference list.
   * @see learningcorpus.LearningcorpusPackage#getMistakeType_Feedbacks()
   * @see learningcorpus.Feedback#getMistakeType
   * @model opposite="mistakeType"
   * @generated
   */
  EList<Feedback> getFeedbacks();

  /**
   * Returns the value of the '<em><b>Mistake Type Category</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link learningcorpus.MistakeTypeCategory#getMistakeTypes <em>Mistake Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mistake Type Category</em>' container reference.
   * @see #setMistakeTypeCategory(MistakeTypeCategory)
   * @see learningcorpus.LearningcorpusPackage#getMistakeType_MistakeTypeCategory()
   * @see learningcorpus.MistakeTypeCategory#getMistakeTypes
   * @model opposite="mistakeTypes" required="true" transient="false"
   * @generated
   */
  MistakeTypeCategory getMistakeTypeCategory();

  /**
   * Sets the value of the '{@link learningcorpus.MistakeType#getMistakeTypeCategory <em>Mistake Type Category</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mistake Type Category</em>' container reference.
   * @see #getMistakeTypeCategory()
   * @generated
   */
  void setMistakeTypeCategory(MistakeTypeCategory value);

} // MistakeType
