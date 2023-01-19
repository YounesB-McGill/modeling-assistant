package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentSolutionFromClassDiagram;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import static modelingassistant.util.SynonymUtils.setSynonymToAttribInClassInClassDiag;
import static modelingassistant.util.SynonymUtils.setSynonymToClassInClassDiag;
import static modelingassistant.util.SynonymUtils.setSynonymToRoleInClassInClassDiag;
import static modelingassistant.util.TagUtils.setAbstractionTagToClassInClassDiag;
import static modelingassistant.util.TagUtils.setOccurrenceTagToClassInClassDiag;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.classdiagram.ClassDiagram;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.Solution;
import modelingassistant.TagGroup;
import modelingassistant.util.ResourceHelper;

/**
 * This class is used to collect the performance data (e.g time of execution, number and types of mistakes detected) of
 * the mistake detection algorithm run on the domain models created by students.
 *
 * Note that due to student privacy reasons, the dataset is not made public here, but you may obtain a copy under
 * certain conditions from the professors responsible for the project. In that case, add the student solutions
 * to the STUDENT_SOLUTION_DIR below, or change it to point to their location on your disk. Never commit these solutions
 * to the public repo!
 *
 * @author Prabhsimran Singh
 */
//@Disabled("Tests with real student solutions are disabled in public version of this repo. Please contact a professor "
//    + "from the McGill Software Engineering Lab to see if you can obtain access.")
public class MistakeDetectionPerformanceAnalysis extends MistakeDetectionBaseTest {

  /** The folder where student solutions are located. */
  private static final String STUDENT_SOLUTION_DIR = "../mistakedetection/realModels/studentSolution";

  /** The common prefix for each student solution folder name. */
  private static final String STUDENT_SOLUTION_DIR_NAME_PREFIX = "studentDomainModel_";

  /** The standard Class Diagram Model file path for each student solution. */
  private static final String CDM_PATH = "Class Diagram/StudentDomainModel.domain_model.cdm";

  /** The path where student submissions from the final exam dataset are located. */
  private static final String FINAL_EXAM_SUBMISSIONS_PATH = "<path-to-cdm-files>";

  /** The ModelingassistantFactory instance. */
  private static final ModelingassistantFactory maf = ModelingassistantFactory.eINSTANCE;


  // TODO To be completed in near future. The functions below are incomplete
  ClassDiagram instructorClassDiagram;
  Solution instructorSolution;

  MistakeDetectionPerformanceAnalysis() {
    instructorClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/instructorSolution/instructorSolution2/Class Diagram/InstructorSolution2.domain_model.cdm");
    instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);
    TagGroup tagGroup = setAbstractionTagToClassInClassDiag("RoomType", instructorClassDiagram, instructorSolution);
    setOccurrenceTagToClassInClassDiag("Room", tagGroup, instructorClassDiagram);

    // Assigning synonyms to classes
    setSynonymToClassInClassDiag("Person", List.of("Guest"), instructorClassDiagram, instructorSolution);
    setSynonymToClassInClassDiag("Booking", List.of("Reservation", "RoomReservation"), instructorClassDiagram,
        instructorSolution);
    setSynonymToClassInClassDiag("Hotel", List.of("HotelSocs", "SOCSHotel", "HotelSystem"), instructorClassDiagram,
        instructorSolution);

    // Assigning synonyms to attributes
    setSynonymToAttribInClassInClassDiag("RoomType", "maxDailyRate", List.of("maxRate", "maximumDailyRate"),
        instructorClassDiagram, instructorSolution);
    setSynonymToAttribInClassInClassDiag("RoomType", "qualityLevel", List.of("quality", "level"),
        instructorClassDiagram, instructorSolution);
    setSynonymToAttribInClassInClassDiag("Room", "roomNumber", List.of("number"), instructorClassDiagram,
        instructorSolution);
    setSynonymToAttribInClassInClassDiag("Room", "status", List.of("smokingStatus", "smoking"), instructorClassDiagram,
        instructorSolution);
    setSynonymToAttribInClassInClassDiag("Bed", "type", List.of("bedKind", "bedType"), instructorClassDiagram,
        instructorSolution);
    setSynonymToAttribInClassInClassDiag("Person", "phoneNumber", List.of("telephone", "phone", "telephoneNumber"),
        instructorClassDiagram, instructorSolution);
    setSynonymToAttribInClassInClassDiag("Person", "creditcard", List.of("card", "cardNumber", "creditCardNumber"),
        instructorClassDiagram, instructorSolution);
    setSynonymToAttribInClassInClassDiag("Stay", "checkinDate", List.of("checkin", "date"), instructorClassDiagram,
        instructorSolution);
    setSynonymToAttribInClassInClassDiag("Stay", "numberOfNights", List.of("nights", "duration", "length"),
        instructorClassDiagram, instructorSolution);
    setSynonymToAttribInClassInClassDiag("Stay", "dailyRate", List.of("nightlyRate", "rate", "price", "currentRate"),
        instructorClassDiagram, instructorSolution);
    setSynonymToAttribInClassInClassDiag("Booking", "startDate", List.of("start", "date"), instructorClassDiagram,
        instructorSolution);
    setSynonymToAttribInClassInClassDiag("Booking", "bookedDailyRate", List.of("dailyRate"), instructorClassDiagram,
        instructorSolution);

    // Assigning synonyms to assoc ends
    setSynonymToRoleInClassInClassDiag("Hotel", "bookings", List.of("reservations", "myReservations"),
        instructorClassDiagram, instructorSolution);
    setSynonymToRoleInClassInClassDiag("Room", "bookings", List.of("reservations", "myReservations"),
        instructorClassDiagram, instructorSolution);
    setSynonymToRoleInClassInClassDiag("Room", "hotel", List.of("myHotelSystem", "inHotel", "mySOCSHotel"),
        instructorClassDiagram, instructorSolution);
    setSynonymToRoleInClassInClassDiag("Person", "bookings",
        List.of("reservations", "myReservations", "myRoomReservations"), instructorClassDiagram, instructorSolution);
    setSynonymToRoleInClassInClassDiag("Person", "hotel", List.of("myHotelSystem", "inHotel", "mySOCSHotel"),
        instructorClassDiagram, instructorSolution);
    setSynonymToRoleInClassInClassDiag("Booking", "bookedRooms", List.of("reservedRooms"), instructorClassDiagram,
        instructorSolution);
    setSynonymToRoleInClassInClassDiag("Booking", "By", List.of("reservedBy"), instructorClassDiagram,
        instructorSolution);
    setSynonymToRoleInClassInClassDiag("Booking", "hotel", List.of("myHotelSystem", "inHotel", "mySOCSHotel"),
        instructorClassDiagram, instructorSolution);
  }

  @Test
  public void testStudentSolution1() {
    var studentClassDiagram = getStudentClassDiagram("G12_1");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution2() {
    var studentClassDiagram = getStudentClassDiagram("G12_5");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution3() {
    var studentClassDiagram = getStudentClassDiagram("G12_9");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution4() {
    var studentClassDiagram = getStudentClassDiagram("G12_11");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution5() {
    var studentClassDiagram = getStudentClassDiagram("G13_3");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution6() {
    var studentClassDiagram = getStudentClassDiagram("G13_7");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution7() {
    var studentClassDiagram = getStudentClassDiagram("G13_10");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);

  }

  @Test
  public void testStudentSolution8() {
    var studentClassDiagram = getStudentClassDiagram("G14_4");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution9() {
    var studentClassDiagram = getStudentClassDiagram("G14_8");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution10() {
    var studentClassDiagram = getStudentClassDiagram("G14_15");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution11() {
    var studentClassDiagram = getStudentClassDiagram("G15_3");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution12() {
    var studentClassDiagram = getStudentClassDiagram("G15_7");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution13() {
    var studentClassDiagram = getStudentClassDiagram("G15_16");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution14() {
    var studentClassDiagram = getStudentClassDiagram("G16_9");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution15() {
    var studentClassDiagram = getStudentClassDiagram("G16_11");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution16() {
    var studentClassDiagram = getStudentClassDiagram("G16_12");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution17() {
    var studentClassDiagram = getStudentClassDiagram("G17_5");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution18() {
    var studentClassDiagram = getStudentClassDiagram("G17_8");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution19() {
    var studentClassDiagram = getStudentClassDiagram("G17_12");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  @Test
  public void testStudentSolution20() {
    var studentClassDiagram = getStudentClassDiagram("G17_25");
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
  }

  /** Tests that the MDS runs without errors on the submissions from the final exam dataset. */
  @Test
  public void testThatMdsRunsOnFinalExamStudentSolutions() {
    var ma = maf.createModelingAssistant();
    var instSolution = maf.createSolution();
    instSolution.setModelingAssistant(ma);
    instSolution.setClassDiagram(cdmFromFile(Paths.get(FINAL_EXAM_SUBMISSIONS_PATH, "0.cdm")));
    try (var files = Files.walk(Paths.get(FINAL_EXAM_SUBMISSIONS_PATH), 2)) {
      List<String> validCdms = new ArrayList<>();
      List<String> invalidCdms = new ArrayList<>();
      var filenamePattern = Pattern.compile("\\d+\\.cdm");
      var studentCdms = files
          .filter(file ->
              !Files.isDirectory(file) && filenamePattern.matcher(file.getFileName().toString()).matches()
              && !file.endsWith("0.cdm"))
          .map(file -> {
            var cdm = ResourceHelper.cdmFromFile(file);
            cdm.setName(file.getFileName().toString().replace(".cdm", ""));
            return cdm;
          });
      studentCdms.forEach(cdm -> {
        var cdmName = cdm.getName();
        var student = maf.createStudent();
        student.setModelingAssistant(ma);
        student.setName("Student" + cdmName); // Student1 and so on
        var studSolution = maf.createSolution();
        studSolution.setModelingAssistant(ma);
        studSolution.setStudent(student);
        studSolution.setClassDiagram(cdm);
        try {
          System.out.println("Detecting mistakes for " + cdmName + ".cdm");
          var comparison = MistakeDetection.compare(instSolution, studSolution).log();
          //assertNotNull(comparison);
          validCdms.add(cdmName);
        } catch (Exception e) {
          System.err.println("Could not detect mistakes for " + cdmName + ".cdm due to error:");
          //e.printStackTrace();
          invalidCdms.add(cdmName);
        }
      });
      System.out.println("Valid cdms: " + validCdms);
      System.out.println("Invalid cdms: " + invalidCdms);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Tests that the MDS runs without errors on a submission from the final exam dataset.
   * This is a convenience method to help debug the test above.
   */
  @Test
  public void testThatMdsRunsOnSingleFinalExamStudentSolution() {
    var ma = maf.createModelingAssistant();
    var instSolution = maf.createSolution();
    instSolution.setModelingAssistant(ma);
    instSolution.setClassDiagram(cdmFromFile(Paths.get(FINAL_EXAM_SUBMISSIONS_PATH, "0.cdm")));
    var studentCdm = cdmFromFile(Paths.get(FINAL_EXAM_SUBMISSIONS_PATH, "1.cdm"));
    var cdmName = studentCdm.getName();
    var student = maf.createStudent();
    student.setModelingAssistant(ma);
    student.setName("Student" + cdmName); // Student1 and so on
    var studSolution = maf.createSolution();
    studSolution.setModelingAssistant(ma);
    studSolution.setStudent(student);
    studSolution.setClassDiagram(studentCdm);
    try {
      System.out.println("Detecting mistakes for " + cdmName + ".cdm");
      var comparison = MistakeDetection.compare(instSolution, studSolution).log();
      //assertNotNull(comparison);
    } catch (Exception e) {
      System.err.println("Could not detect mistakes for " + cdmName + ".cdm due to error:");
      e.printStackTrace();
    }
  }

  /** Returns the student class diagram with the given identifier. */
  private static ClassDiagram getStudentClassDiagram(String id) {
    return cdmFromFile(Paths.get(STUDENT_SOLUTION_DIR, STUDENT_SOLUTION_DIR_NAME_PREFIX + id, CDM_PATH));
  }

}
