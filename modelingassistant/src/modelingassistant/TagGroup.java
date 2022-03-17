/**
 */
package modelingassistant;

import static modelingassistant.TagType.ABSTRACTION;
import static modelingassistant.TagType.OCCURRENCE;
import static modelingassistant.TagType.PLAYER;
import static modelingassistant.TagType.ROLE;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tag Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modelingassistant.TagGroup#getTags <em>Tags</em>}</li>
 *   <li>{@link modelingassistant.TagGroup#getSolution <em>Solution</em>}</li>
 * </ul>
 *
 * @see modelingassistant.ModelingassistantPackage#getTagGroup()
 * @model
 * @generated
 */
public interface TagGroup extends EObject {
  /**
   * Returns the value of the '<em><b>Tags</b></em>' reference list.
   * The list contents are of type {@link modelingassistant.Tag}.
   * It is bidirectional and its opposite is '{@link modelingassistant.Tag#getTagGroup <em>Tag Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tags</em>' reference list.
   * @see modelingassistant.ModelingassistantPackage#getTagGroup_Tags()
   * @see modelingassistant.Tag#getTagGroup
   * @model opposite="tagGroup"
   * @generated
   */
  EList<Tag> getTags();

  /**
   * Returns the value of the '<em><b>Solution</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link modelingassistant.Solution#getTagGroups <em>Tag Groups</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Solution</em>' container reference.
   * @see #setSolution(Solution)
   * @see modelingassistant.ModelingassistantPackage#getTagGroup_Solution()
   * @see modelingassistant.Solution#getTagGroups
   * @model opposite="tagGroups" required="true" transient="false"
   * @generated
   */
  Solution getSolution();

  /**
   * Sets the value of the '{@link modelingassistant.TagGroup#getSolution <em>Solution</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Solution</em>' container reference.
   * @see #getSolution()
   * @generated
   */
  void setSolution(Solution value);

  /**
   * Returns the Abstraction-Occurrence tags, first the abstractions, then the occurrences.
   *
   * @generated NOT
   */
  default List<Tag> getAOTags() {
    return sortTags(getTags(), ABSTRACTION, OCCURRENCE);
  }

  /**
   * Returns the Player-Role tags, first the abstractions, then the occurrences.
   *
   * @generated NOT
   */
  default List<Tag> getPRTags() {
    return sortTags(getTags(), PLAYER, ROLE);
  }

  /**
   * Sorts elements based on the input predicates, which are functions that describe the elements that go first or last.
   * Elements that do not go first or last end up in the middle.
   *
   * @param <T>
   * @param elements
   * @param elementsThatGoFirst
   * @param elementsThatGoLast
   * @return a list of the sorted elements
   * @generated NOT
   */
  static <T> List<T> sortElements(List<? extends T> elements,
      Predicate<T> elementsThatGoFirst, Predicate<T> elementsThatGoLast) {
    var result = new LinkedList<T>();
    var lastElements = new LinkedList<T>();
    elements.forEach(e -> {
      if (elementsThatGoFirst.test(e)) {
        result.addFirst(e);
      } else if (elementsThatGoLast.test(e)) {
        lastElements.add(e);
      } else {
        result.add(e); // element does not go first or last, so add it to what will become the middle
      }
    });
    result.addAll(lastElements);
    return result;
  }

  /**
   * Sorts the given tags according to their type.
   *
   * @generated NOT
   */
  static List<Tag> sortTags(List<Tag> tags, TagType firstTag, TagType lastTag) {
    return sortElements(tags, t -> t.getTagType() == firstTag, t -> t.getTagType() == lastTag);
  }

} // TagGroup
