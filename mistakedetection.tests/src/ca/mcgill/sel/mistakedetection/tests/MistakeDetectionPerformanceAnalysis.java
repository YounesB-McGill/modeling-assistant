package ca.mcgill.sel.mistakedetection.tests;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.commons.collections4.map.LinkedMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
import static ca.mcgill.sel.mistakedetection.Comparison.getSortedMistakeList;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentSolutionFromClassDiagram;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import static modelingassistant.util.SynonymUtils.setSynonymToAttribInClassInClassDiag;
import static modelingassistant.util.SynonymUtils.setSynonymToClassInClassDiag;
import static modelingassistant.util.SynonymUtils.setSynonymToRoleInClassInClassDiag;
import static modelingassistant.util.TagUtils.setAbstractionTagToClassInClassDiag;
import static modelingassistant.util.TagUtils.setOccurrenceTagToClassInClassDiag;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.classdiagram.Association;
import ca.mcgill.sel.classdiagram.AssociationEnd;
import ca.mcgill.sel.classdiagram.Attribute;
import ca.mcgill.sel.classdiagram.CDEnum;
import ca.mcgill.sel.classdiagram.CDEnumLiteral;
import ca.mcgill.sel.classdiagram.ClassDiagram;
import ca.mcgill.sel.classdiagram.Classifier;
import ca.mcgill.sel.classdiagram.Type;
import ca.mcgill.sel.mistakedetection.Comparison;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import modelingassistant.Mistake;
import modelingassistant.Solution;
import modelingassistant.TagGroup;

/**
 * This class is used to collect the performance data (e.g time of execution, number and types of
 * mistakes detected) of the mistake detection algorithm run on the domain models created by
 * students.
 *
 * Note that due to student privacy reasons, the dataset is not made public here, but you may obtain
 * a copy under certain conditions from the professors responsible for the project. In that case,
 * add the student solutions to the STUDENT_SOLUTION_DIR below, or change it to point to their
 * location on your disk. Never commit these solutions to the public repo!
 *
 * @author Prabhsimran Singh
 */
// @Disabled("Tests with real student solutions are disabled in public version of this repo. Please
// contact a professor "
// + "from the McGill Software Engineering Lab to see if you can obtain access.")
public class MistakeDetectionPerformanceAnalysis extends MistakeDetectionBaseTest {

  /** The folder where student solutions are located. */
  private static final String STUDENT_SOLUTION_DIR = "../mistakedetection/realModels/studentSolution";

  /** The common prefix for each student solution folder name. */
  private static final String STUDENT_SOLUTION_DIR_NAME_PREFIX = "studentDomainModel_";

  /** The standard Class Diagram Model file path for each student solution. */
  private static final String CDM_PATH = "Class Diagram/StudentDomainModel.domain_model.cdm";

  private static final String OUTPUT_LOC =
      "C:\\Users\\prabh\\Desktop\\R work\\GroundTruth\\Class Diagrams\\Hotel\\RandomStudentSolutions\\1_NEW\\10\\";

  private static String WROMG_ROLE_NAME = "Wrong role name";

  private static String WROMG_MULTIPLICTY = "Wrong multiplicity";

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


  public void testPrintInstructorElements() {
    var instClasses = instructorClassDiagram.getClasses();
    List<String> instElements = new ArrayList<String>();
    for (Classifier cls : instClasses) {
      instElements.add(cls.getName());
      for (Attribute atr : cls.getAttributes()) {
        instElements.add(atr.getName());
      }
      for (AssociationEnd assocEnd : cls.getAssociationEnds()) {
        instElements.add(assocEnd.getName() + " role name");
        instElements.add(assocEnd.getName() + " multiplicity");
      }
    }
    for (Association assoc : instructorClassDiagram.getAssociations()) {
      instElements.add(assoc.getName());
    }
    for (Type type : instructorClassDiagram.getTypes()) {

      if (type instanceof CDEnum) {
        CDEnum enumClass = (CDEnum) type;
        instElements.add(enumClass.getName());
        for (CDEnumLiteral enumLiteral : enumClass.getLiterals()) {
          instElements.add(enumLiteral.getName());
        }
      }
    }
    System.out.println(instElements.size());
    for (String t : instElements) {
      System.out.println(t);
    }
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
  public void testStudentSolution3() throws Exception {
    var name = "G12_9";
    var studentClassDiagram = getStudentClassDiagram(name);
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
    produceExcelSheet(comparison, name, OUTPUT_LOC);
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
  public void testStudentSolution6() throws Exception {
    var name = "G13_7";
    var studentClassDiagram = getStudentClassDiagram(name);
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

  @Test
  public void testStudentSolution21() throws Exception {
    var name = "G12_3";
    var studentClassDiagram = getStudentClassDiagram(name);
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
     

  }

  @Test
  public void testStudentSolution22() throws Exception {
    var name = "G12_14";
    var studentClassDiagram = getStudentClassDiagram(name);
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
     

  }

  @Test
  public void testStudentSolution23() throws Exception {
    var name = "G13_5";
    var studentClassDiagram = getStudentClassDiagram(name);
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
     

  }

  @Test
  public void testStudentSolution24() throws Exception {
    var name = "G13_9";
    var studentClassDiagram = getStudentClassDiagram(name);
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
     

  }

  @Test
  public void testStudentSolution25() throws Exception {
    var name = "G13_15";
    var studentClassDiagram = getStudentClassDiagram(name);
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
     

  }

  @Test
  public void testStudentSolution26() throws Exception {
    var name = "G14_2";
    var studentClassDiagram = getStudentClassDiagram(name);
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
     

  }

  @Test
  public void testStudentSolution27() throws Exception {
    var name = "G14_7";
    var studentClassDiagram = getStudentClassDiagram(name);
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
     

  }

  @Test
  public void testStudentSolution28() throws Exception {
    var name = "G14_12";
    var studentClassDiagram = getStudentClassDiagram(name);
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
     
  }

  @Test
  public void testStudentSolution29() throws Exception {
    var name = "G15_5";
    var studentClassDiagram = getStudentClassDiagram(name);
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
     
  }

  @Test
  public void testStudentSolution30() throws Exception {
    var name = "G15_9";
    var studentClassDiagram = getStudentClassDiagram(name);
    var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);

    var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
     
  }

  public static void produceExcelSheet(Comparison comparison, String name, String location) throws Exception {
    var sortedMistakes = getSortedMistakeList(comparison.newMistakes);
    List<Mistake> extraMistakes = new ArrayList<>();
    List<Mistake> notExtraMistakes = new ArrayList<>();

    for (Mistake m : sortedMistakes) {
      var instElems = m.getInstructorElementNames();
      String instElem = "";
      for (String n : instElems) {
        instElem += n;
      }
      var studElems = m.getStudentElementNames();
      String studElem = "";
      for (String n : studElems) {
        studElem += n;
      }  
      if (m.getMistakeType().getName().startsWith("Extra")) {
        extraMistakes.add(m);
      } else {
        notExtraMistakes.add(m);
      }
    }
    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet spreadsheet = workbook.createSheet(name);
    XSSFRow row;
    LinkedHashMap<String, Object[]> studentData = new LinkedHashMap<String, Object[]>();
    int id = 1;
    studentData.put(String.valueOf(id), new Object[] {"Instructor Element", "Student Elements", "Mistake Type",
        "Actually a Mistake", "MDS Result", "MDS vs Actual Mistake", "Comments"});
    ArrayList<String> rendered = new ArrayList<>();
    for (Mistake m : notExtraMistakes) {
      int count = 1;
      var instElem = getConcatNames(m.getInstructorElementNames());    
      var studElem = getConcatNames(m.getStudentElementNames());

      var mistakeType = m.getMistakeType().getName();
      for (Mistake m1 : notExtraMistakes) {
        if (m != m1) {
          var instElem1 = getConcatNames(m1.getInstructorElementNames());          
          var studElem1 = getConcatNames(m1.getStudentElementNames());
         
          if (instElem.equals(instElem1) && studElem.equals(studElem1)
              && !(m.getMistakeType().getName().equals(WROMG_MULTIPLICTY)
                  && m1.getMistakeType().getName().equals(WROMG_ROLE_NAME))
              && !(m.getMistakeType().getName().equals(WROMG_ROLE_NAME)
                  && m1.getMistakeType().getName().equals(WROMG_MULTIPLICTY))) {
            mistakeType += ", " + m1.getMistakeType().getName();
            count++;
          }
        }
      }
      var fnlString = instElem + studElem;
      if (!rendered.contains(fnlString) || mistakeType.equals(WROMG_ROLE_NAME) || mistakeType.equals(WROMG_MULTIPLICTY)) {
        id++;
        studentData.put(String.valueOf(id),
            new Object[] {instElem, studElem, mistakeType, "", count, "=D" + id + "=E" + id, ""});
        rendered.add(fnlString);
      }
    }
    int instructorElems = id - 1;
    int extraElemsStart = id;
    rendered = new ArrayList<>();
    for (Mistake m : extraMistakes) {
      int count = 1;
      var instElem = getConcatNames(m.getInstructorElementNames());    
      var studElem = getConcatNames(m.getStudentElementNames());
      
      var mistakeType = m.getMistakeType().getName();
      for (Mistake m1 : extraMistakes) {
        if (m != m1) {
          var instElem1 = getConcatNames(m1.getInstructorElementNames());    
          var studElem1 = getConcatNames(m1.getStudentElementNames());
          if (instElem.equals(instElem1) && studElem.equals(studElem1)
              && !(m.getMistakeType().getName().equals(WROMG_MULTIPLICTY)
                  && m1.getMistakeType().getName().equals(WROMG_ROLE_NAME))
              && !(m.getMistakeType().getName().equals(WROMG_ROLE_NAME)
                  && m1.getMistakeType().getName().equals(WROMG_MULTIPLICTY))) {
            mistakeType += ", " + m1.getMistakeType().getName();
            count++;
          }
        }
      }
      var fnlString = instElem + studElem;
      if (!rendered.contains(fnlString) || mistakeType.equals(WROMG_ROLE_NAME) || mistakeType.equals(WROMG_MULTIPLICTY)) {
        studentData.put(String.valueOf(id),
            new Object[] {instElem, studElem, mistakeType, "", count, "=D" + id + "=E" + id, ""});
        id++;
        rendered.add(fnlString);
      }
    }

    int nId = id;
    studentData.put(String.valueOf(nId++), new Object[] {"", "", "", "", "", "", ""});
    studentData.put(String.valueOf(nId++), new Object[] {"", "", "", "", "", "", ""});
    studentData.put(String.valueOf(nId++),
        new Object[] {"Total Mistakes", "", "", "=SUM(D2:D" + --id + ")", "=SUM(E2:E" + id + ")", "", ""});

    studentData.put(String.valueOf(nId++),
        new Object[] {"MDS vs Actual Decision", "", "", "", "", "=COUNTIF(F2:F" + id + ",\"False\")", ""});
    
    // Important for formula calculations
    var totalMistakeindex = id + 3;
    var MDSvsActualIndex = totalMistakeindex + 1;
    var totalInstElemsIndex = MDSvsActualIndex + 1;
    var instElemsIndex = totalInstElemsIndex + 1;
    var studExtraIndex = instElemsIndex + 1;
    var addFalseNegIndex = studExtraIndex + 1;
    var addFalsePosIndex = addFalseNegIndex + 1;
    var totalElemsIndex = addFalsePosIndex + 1;
    var totalNumbVerdictsIndex = totalElemsIndex + 1;
    var tnIndex = totalNumbVerdictsIndex + 6;
    var tpIndex = tnIndex + 1;
    var fpIndex = tpIndex + 1;
    var fnIndex = fpIndex + 1;
    var recallIndex = fnIndex + 1;
    var precisionIndex = recallIndex + 1;
    studentData.put(String.valueOf(nId++), new Object[] {"Total number of instructor elements", 102});
    studentData.put(String.valueOf(nId++),
        new Object[] {"Instructor elements present", "=COUNT(E2:E" + instructorElems + ")"});
    studentData.put(String.valueOf(nId++),
        new Object[] {"Extra Elements", "=SUM(IF(D" + extraElemsStart + ":D" + id + ">E" + extraElemsStart + ":E" + id
            + ",D" + extraElemsStart + ":D" + id + ",E" + extraElemsStart + ":E" + id + "))"});
    studentData.put(String.valueOf(nId++), new Object[] {"Additional false negatives", 0});
    studentData.put(String.valueOf(nId++), new Object[] {"Additional false positive", 0});
    studentData.put(String.valueOf(nId++), new Object[] {"Total elements",
        "=B" + totalInstElemsIndex + "+B" + studExtraIndex + "+B" + addFalseNegIndex + "+B" + addFalsePosIndex});
    studentData.put(String.valueOf(nId++), new Object[] {"Total number of verdicts",
        "=SUM(IF(D2:D" + instructorElems + "=2, 1, IF(E2:E" + instructorElems + "=2, 1,0))) + B" + totalElemsIndex});
    studentData.put(String.valueOf(nId++), new Object[] {"TN+TP+FP+FN", "=SUM(C" + tnIndex + ":C" + fnIndex + ")"});

    studentData.put(String.valueOf(nId++), new Object[] {""});
    studentData.put(String.valueOf(nId++), new Object[] {"", "", "Actual Vs MDS"});

    studentData.put(String.valueOf(nId++),
        new Object[] {"Correct Identification % (mistakes)", "", "=C" + tpIndex + "/E" + totalMistakeindex + "*100"});
    studentData.put(String.valueOf(nId++), new Object[] {"Correct Identification % (verdicts)", "",
        "=((B" + totalNumbVerdictsIndex + "-F" + MDSvsActualIndex + ")/B" + totalNumbVerdictsIndex + ")*100"});
    studentData.put(String.valueOf(nId++), new Object[] {"True Negative", "", "=SUM(IF(D2:D" + instructorElems
        + "=0, IF(E2:E" + instructorElems + "=0, 1,0), 0 )) + (102 - B" + instElemsIndex + ")"});
    studentData.put(String.valueOf(nId++), new Object[] {"True Positive", "",
        "=SUM(IF(D2:D" + id + ">0, IF(D2:D" + id + "> E2:E" + id + ", E2:E" + id + ", D2:D" + id + "), 0 ))"});
    studentData.put(String.valueOf(nId++), new Object[] {"False Positive", "",
        "=SUM(IF(E2:E" + id + "> D2:D" + id + ", E2:E" + id + " -D2:D" + id + "), 0 )+B" + addFalsePosIndex});
    studentData.put(String.valueOf(nId++), new Object[] {"False Negative", "",
        "=SUM(IF(D2:D" + id + ">E2:E" + id + ", D2:D" + id + " - E2:E" + id + "), 0 )+B" + addFalseNegIndex});
    studentData.put(String.valueOf(nId++),
        new Object[] {"Recall (TP / (TP + FN))", "", "=(C" + tpIndex + "/(C" + tpIndex + "+C" + fnIndex + "))"});
    studentData.put(String.valueOf(nId++),
        new Object[] {"Precision (TP / (TP + FP))", "", "=(C" + tpIndex + "/(C" + tpIndex + "+C" + fpIndex + "))"});
    
    studentData.put(String.valueOf(nId++),
        new Object[] {"F1 (2 * Precision * Recall / (Precision + Recall))", "", "=(2*C"+precisionIndex+"*C"+recallIndex+")/(C"+precisionIndex+"+C"+recallIndex+")"});
    studentData.put(String.valueOf(nId++),
        new Object[] {"F2 (5 * Precision * Recall) / (4 * Precision + Recall)", "", "=(5*C"+precisionIndex+"*C"+recallIndex+")/(4*C"+precisionIndex+"+C"+recallIndex+")"});
    

    Set<String> keyid = studentData.keySet();
    int rowid = 0;

    for (String key : keyid) {
      row = spreadsheet.createRow(rowid++);
      Object[] objectArr = studentData.get(key);
      int cellid = 0;
      for (Object obj : objectArr) {
        Cell cell = row.createCell(cellid++);
        if (obj instanceof String) {
          String sObj = (String) obj;
          if (sObj.startsWith("=")) {
            sObj = sObj.replaceFirst("=", "");
            cell.setCellFormula(sObj);
          } else {
            cell.setCellValue(sObj);
          }
        } else {
          cell.setCellValue((int) obj);
        }
      }
    }
    FileOutputStream out = new FileOutputStream(new File(OUTPUT_LOC + "GroundTruth_" + name + ".xlsx"));

    workbook.write(out);
    out.close();
    System.out.println(name + " excel created");

  }
  
  public static String getConcatNames(List<String> elems) {
    String elem = "";
    for (String n : elems) {
      elem += n + ", ";
    }
    return elem;
  }

  /** Returns the student class diagram with the given identifier. */
  private static ClassDiagram getStudentClassDiagram(String id) {
    return cdmFromFile(Paths.get(STUDENT_SOLUTION_DIR, STUDENT_SOLUTION_DIR_NAME_PREFIX + id, CDM_PATH));
  }

}
