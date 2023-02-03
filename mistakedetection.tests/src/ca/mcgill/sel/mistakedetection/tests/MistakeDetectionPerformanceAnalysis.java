package ca.mcgill.sel.mistakedetection.tests;

import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.instructorSolutionFromClassDiagram;
import static ca.mcgill.sel.mistakedetection.tests.MistakeDetectionTest.studentSolutionFromClassDiagram;
import static modelingassistant.util.ClassDiagramUtils.getClassFromClassDiagram;
import static modelingassistant.util.ResourceHelper.cdmFromFile;
import static modelingassistant.util.SynonymUtils.setSynonymToAttribInClassInClassDiag;
import static modelingassistant.util.SynonymUtils.setSynonymToClassInClassDiag;
import static modelingassistant.util.SynonymUtils.setSynonymToRoleInClassInClassDiag;
import static modelingassistant.util.TagUtils.setAbstractionTagToClassInClassDiag;
import static modelingassistant.util.TagUtils.setOccurrenceTagToClassInClassDiag;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ca.mcgill.sel.classdiagram.Attribute;
import ca.mcgill.sel.classdiagram.ClassDiagram;
import ca.mcgill.sel.mistakedetection.Comparison;
import ca.mcgill.sel.mistakedetection.MistakeDetection;
import modelingassistant.Mistake;
import modelingassistant.ModelingassistantFactory;
import modelingassistant.Solution;
import modelingassistant.TagGroup;
import modelingassistant.util.ResourceHelper;

/**
 * This class is used to collect the performance data (e.g time of execution, number and types of
 * mistakes detected) of the mistake detection algorithm run on the domain models created by
 * students.
 *
 * Note that due to student privacy reasons, the dataset is not made public here, but you may obtain
 * a copy under certain conditions from the professors responsible for the project. In that case,
 * add the student solutions to some location(s) on your disk and change the constants below to point to them.
 * Never commit these solutions to the public repo!
 *
 * @author Prabhsimran Singh
 * @author Younes Boubekeur
 */
//@Disabled("Tests with real student solutions are disabled in public version of this repo. Please contact a professor "
//    + "from the McGill Software Engineering Lab to see if you can obtain access.")
public class MistakeDetectionPerformanceAnalysis extends MistakeDetectionBaseTest {

  /** The folder where student solutions are located. */
  private static final String HOTEL_STUDENT_SOLUTION_DIR = "../mistakedetection/realModels/studentSolution";

  /** The common prefix for each student solution folder name. */
  private static final String HOTEL_STUDENT_SOLUTION_DIR_NAME_PREFIX = "studentDomainModel_";

  /** The file containing the synonyms for the hotel domain model. */
  private static final String HOTEL_SYNONYMS_FILE = "hotel-synonyms.properties";

  /** The standard Class Diagram Model file path for each student solution. */
  private static final String CDM_PATH = "Class Diagram/StudentDomainModel.domain_model.cdm";

  /** The number of hotel instructor solution elements. */
  private static final int NUM_HOTEL_INST_SOL_ELEMS = 102;

  /** The output location of produceExcelSheet(). */
  private static final String HOTEL_OUTPUT_SPREADSHEET_LOC = "<path-to-output-loc>";

  /** The path where student submissions from the final exam dataset are located. */
  private static final String FINAL_EXAM_SUBMISSIONS_PATH = "<path-to-cdm-files>";

  private static final String WRONG_ROLE_NAME = "Wrong role name";

  private static final String WRONG_MULTIPLICTY = "Wrong multiplicity";

  /** The ModelingassistantFactory instance. */
  private static final ModelingassistantFactory maf = ModelingassistantFactory.eINSTANCE;

  // TODO To be completed in near future. The functions below are incomplete
  private static ClassDiagram instructorClassDiagram;
  private static Solution instructorSolution;

  @BeforeAll
  public static void setup() {
    instructorClassDiagram = cdmFromFile(
        "../mistakedetection/realModels/instructorSolution/instructorSolution2/Class Diagram/InstructorSolution2.domain_model.cdm");
    instructorSolution = instructorSolutionFromClassDiagram(instructorClassDiagram);
    TagGroup tagGroup = setAbstractionTagToClassInClassDiag("RoomType", instructorClassDiagram, instructorSolution);
    setOccurrenceTagToClassInClassDiag("Room", tagGroup, instructorClassDiagram);

    // set synonyms based on properties file
    var props = new Properties();
    try (var fis = new FileInputStream(HOTEL_SYNONYMS_FILE)) {
      props.load(fis);
      props.entrySet().forEach(e -> {
        var name = (String) e.getKey();
        var syns = Arrays.stream(((String) e.getValue()).split(",")).map(String::trim)
            .collect(Collectors.toUnmodifiableList());
        if (!name.contains(".")) {
          setSynonymToClassInClassDiag(name, syns, instructorClassDiagram, instructorSolution);
        } else {
          var splitName = name.split("\\.");
          var className = splitName[0];
          var propertyName = splitName[1];
          var cls = getClassFromClassDiagram(className, instructorClassDiagram);
          if (cls.getAttributes().stream().map(Attribute::getName).anyMatch(n -> n.equals(propertyName))) {
            setSynonymToAttribInClassInClassDiag(cls, propertyName, syns, instructorClassDiagram, instructorSolution);
          } else {
            setSynonymToRoleInClassInClassDiag(cls, propertyName, syns, instructorClassDiagram, instructorSolution);
          }
        }
      });
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /** Combines 30 unit tests for the hotel dataset into one compound test. */
  @Test public void testHotelStudentSolutions() {
    // 1-indexed list of student solutions numbered 1-30, ten per line
    List<String> solutionIds = List.of("",
         "G12_1", "G12_5", "G12_9", "G12_11", "G13_3", "G13_7", "G13_10", "G14_4", "G14_8", "G14_15",
         "G15_3", "G15_7", "G15_16", "G16_9", "G16_11", "G16_12", "G17_5", "G17_8", "G17_12", "G17_25",
         "G12_3", "G12_14", "G13_5", "G13_9", "G13_15", "G14_2", "G14_7", "G14_12", "G15_5", "G15_9");
    // list of solutions that should be (re)evaluated by (re)generating a spreadsheet for them
    List<String> idsToEvaluate = List.of("G15_9"); // or List.copyOf(solutionIds)
    // solutions not found on the local filesystem, which can be ignored
    List<String> notFoundIds = new ArrayList<>();
    // existing solutions that caused the MDS to crash
    List<String> failedIds = new ArrayList<>();

    solutionIds.stream().filter(Predicate.not(String::isEmpty)).forEach(solutionId -> {
      try {
        var studentClassDiagram = getStudentClassDiagram(solutionId);
        if (studentClassDiagram == null) {
          notFoundIds.add(solutionId);
        } else {
          var studentSolution = studentSolutionFromClassDiagram(studentClassDiagram);
          var comparison = MistakeDetection.compare(instructorSolution, studentSolution, true);
          assertNotNull(comparison);
          if (idsToEvaluate.contains(solutionId)) {
            produceExcelSheet(comparison, solutionId, HOTEL_OUTPUT_SPREADSHEET_LOC);
          }
        }
      } catch (Exception e) {
        System.err.println("Could not detect mistakes for solution " + solutionId + " due to error:");
        e.printStackTrace();
        failedIds.add(solutionId);
      }
    });
    if (!notFoundIds.isEmpty()) {
      System.err.println("Could not find cdm files for " + notFoundIds.size() + " solutions: " + notFoundIds);
    }
    if (!failedIds.isEmpty()) {
      fail("Could not detect mistakes for " + failedIds.size() + " solutions: " + failedIds);
    }
  }

  /** Tests that the MDS runs without errors on the submissions from the final exam dataset. */
  @Test public void testThatMdsRunsOnFinalExamStudentSolutions() {
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
      Map<String, Integer> solutionsToNumMistakes = new HashMap<>();
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
          assertNotNull(comparison);
          solutionsToNumMistakes.put(cdmName, comparison.newMistakes.size());
          validCdms.add(cdmName);
        } catch (Exception e) {
          System.err.println("Could not detect mistakes for " + cdmName + ".cdm due to error:");
          e.printStackTrace();
          invalidCdms.add(cdmName);
        }
      });
      System.out.println("Valid cdms (" + validCdms.size() + "): " + validCdms
          + "\nInvalid cdms (" + invalidCdms.size() + "): " + invalidCdms
          + "\n\nStudent solution,Number of mistakes");
      solutionsToNumMistakes.forEach((id, num) -> System.out.println(id + "," + num));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Tests that the MDS runs without errors on a submission from the final exam dataset.
   * This is a convenience method to help debug the test above.
   */
  @Test public void testThatMdsRunsOnSingleFinalExamStudentSolution() {
    var ma = maf.createModelingAssistant();
    var instSolution = maf.createSolution();
    instSolution.setModelingAssistant(ma);
    instSolution.setClassDiagram(cdmFromFile(Paths.get(FINAL_EXAM_SUBMISSIONS_PATH, "0.cdm")));
    var studentCdm = cdmFromFile(Paths.get(FINAL_EXAM_SUBMISSIONS_PATH, "20.cdm"));
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
      assertNotNull(comparison);
    } catch (Exception e) {
      System.err.println("Could not detect mistakes for " + cdmName + ".cdm due to error:");
      e.printStackTrace();
    }
  }

  public static void produceExcelSheet(Comparison comparison, String name, String location) {
    var sortedMistakes = comparison.getSortedMistakeList();
    List<Mistake> extraMistakes = new ArrayList<>();
    List<Mistake> notExtraMistakes = new ArrayList<>();

    for (Mistake m : sortedMistakes) {
      if (m.getMistakeType().getName().startsWith("Extra")) {
        extraMistakes.add(m);
      } else {
        notExtraMistakes.add(m);
      }
    }

    try (var workbook = new XSSFWorkbook()) {
      var sheet = new SpreadsheetWrapper(workbook.createSheet(name));
      int id = 1;
      var numMtRows = 1;
      sheet.addRow("Instructor Element", "Student Elements", "Mistake Type", "Actually a Mistake", "MDS Result",
          "MDS vs Actual Mistake", "Comments");
      List<String> printedToExcel = new ArrayList<>();
      for (Mistake m : notExtraMistakes) {
        int count = 1;
        var instElem = getConcatNames(m.getInstructorElementNames());
      var studElem = getConcatNames(m.getStudentElementNames());

      var mistakeType = m.getMistakeType().getName();
      for (Mistake m1 : notExtraMistakes) {
        if (m != m1) {
          var instElem1 = getConcatNames(m1.getInstructorElementNames());
          var studElem1 = getConcatNames(m1.getStudentElementNames());
          var mistakeType1Name = m.getMistakeType().getName();
          var mistakeType2Name = m1.getMistakeType().getName();

          if (instElem.equals(instElem1) && studElem.equals(studElem1)
              && !(mistakeType1Name.equals(WRONG_MULTIPLICTY) && mistakeType2Name.equals(WRONG_ROLE_NAME))
              && !(mistakeType1Name.equals(WRONG_ROLE_NAME) && mistakeType2Name.equals(WRONG_MULTIPLICTY))) {
            mistakeType += ", " + m1.getMistakeType().getName();
            count++;
          }
        }
      }
      var fnlString = instElem + studElem;
      if (!printedToExcel.contains(fnlString) || mistakeType.equals(WRONG_ROLE_NAME)
          || mistakeType.equals(WRONG_MULTIPLICTY)) {
          id++;
          sheet.addRow(instElem, studElem, mistakeType, "", count, "=D" + sheet.rowNumber + "=E" + sheet.rowNumber);
          numMtRows++;
          printedToExcel.add(fnlString);
        }
    }
    int instructorElems = id - 1;
    int extraElemsStart = id;
    printedToExcel = new ArrayList<>();
    for (Mistake m : extraMistakes) {
      int count = 1;
      var instElem = getConcatNames(m.getInstructorElementNames());
      var studElem = getConcatNames(m.getStudentElementNames());

      var mistakeType = m.getMistakeType().getName();
      for (Mistake m1 : extraMistakes) {
        if (m != m1) {
          var instElem1 = getConcatNames(m1.getInstructorElementNames());
          var studElem1 = getConcatNames(m1.getStudentElementNames());
          var mistakeType1Name = m.getMistakeType().getName();
          var mistakeType2Name = m1.getMistakeType().getName();
          if (instElem.equals(instElem1) && studElem.equals(studElem1)
              && !(mistakeType1Name.equals(WRONG_MULTIPLICTY) && mistakeType2Name.equals(WRONG_ROLE_NAME))
              && !(mistakeType1Name.equals(WRONG_ROLE_NAME) && mistakeType2Name.equals(WRONG_MULTIPLICTY))) {
            mistakeType += ", " + m1.getMistakeType().getName();
            count++;
          }
        }
      }
      var fnlString = instElem + studElem;
      if (!printedToExcel.contains(fnlString) || mistakeType.equals(WRONG_ROLE_NAME)
            || mistakeType.equals(WRONG_MULTIPLICTY)) {
          sheet.addRow(instElem, studElem, mistakeType, "", count, "=D" + sheet.rowNumber + "=E" + sheet.rowNumber);
          numMtRows++;
          id++;
          printedToExcel.add(fnlString);
        }
      }

      System.out.println("numMtRows: " + numMtRows);

      var mainTableLastRow = sheet.rowNumber;
      sheet.addRow()
          .addRow()
          .addRow("Total Mistakes", "", "", "=SUM(D2:D" + mainTableLastRow + ")", "=SUM(E2:E" + mainTableLastRow + ")")
          .addRow("MDS vs Actual Decision", "", "", "", "", "=COUNTIF(F2:F" + mainTableLastRow + ",\"False\")");

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

      sheet.addRow("Total number of instructor elements", NUM_HOTEL_INST_SOL_ELEMS)
          .addRow("Instructor elements present", "=COUNT(E2:E" + instructorElems + ")")
          .addRow("Extra Elements", sumOfMaximumsFormula("D", extraElemsStart, "E", id))
          .addRow("Additional false negatives", 0)
          .addRow("Additional false positive", 0)
          .addRow("Total elements",
              "=B" + totalInstElemsIndex + "+B" + studExtraIndex + "+B" + addFalseNegIndex + "+B" + addFalsePosIndex)
          .addRow("Total number of verdicts",
              sumOfPlaceholdersFormula("IF(D%=2,1,IF(E%=2,1,0))", 2, instructorElems) + " + B" + totalElemsIndex)
          .addRow("TN+TP+FP+FN", "=SUM(C" + tnIndex + ":C" + fnIndex + ")")
          .addRow()
          .addRow("", "", "Actual Vs MDS")
          .addRow("Correct Identification % (mistakes)", "", "=C" + tpIndex + "/E" + totalMistakeindex + "*100")
          .addRow("Correct Identification % (verdicts)", "",
              "=((B" + totalNumbVerdictsIndex + "-F" + MDSvsActualIndex + ")/B" + totalNumbVerdictsIndex + ")*100")
          .addRow("True Negative", "", sumOfPlaceholdersFormula("IF(D%=0,IF(E%=0,1,0),0)", 2, instructorElems) + " + ("
              + NUM_HOTEL_INST_SOL_ELEMS + " - B" + instElemsIndex + ")")
          .addRow("True Positive", "", sumOfPlaceholdersFormula("IF(D%>0,IF(D%>E%,E%,D%),0)", 2, id))
          .addRow("False Positive", "", sumOfPlaceholdersFormula("MAX(E%-D%,0)", 2, id) + " + B" + addFalsePosIndex)
          .addRow("False Negative", "", sumOfPlaceholdersFormula("MAX(D%-E%,0)", 2, id) + " + B" + addFalseNegIndex)
          .addRow("Recall (TP / (TP + FN))", "", "=(C" + tpIndex + "/(C" + tpIndex + "+C" + fnIndex + "))")
          .addRow("Precision (TP / (TP + FP))", "", "=(C" + tpIndex + "/(C" + tpIndex + "+C" + fpIndex + "))")
          .addRow("F1 (2 * Precision * Recall / (Precision + Recall))", "",
              "=(2*C" + precisionIndex + "*C" + recallIndex + ")/(C" + precisionIndex + "+C" + recallIndex + ")")
          .addRow("F2 (5 * Precision * Recall) / (4 * Precision + Recall)", "",
              "=(5*C" + precisionIndex + "*C" + recallIndex + ")/(4*C" + precisionIndex + "+C" + recallIndex + ")");

      var filename = "GroundTruth_" + name + ".xlsx";
      try (var out = new FileOutputStream(Paths.get(location, filename).toAbsolutePath().toString())) {
        workbook.write(out);
        System.out.println(filename + " created");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String getConcatNames(List<String> elems) {
    return String.join(", ", elems);
  }

  /** Returns a formula in the form "=MAX(A1:C1)+MAX(A2:C2)+...", where the parameters are inclusive. */
  private static String sumOfMaximumsFormula(String startCol, int startRow, String endCol, int endRow) {
    return sumOfPlaceholdersFormula("MAX(" + startCol + "%:" + endCol + "%)", startRow, endRow);
  }

  /** Returns a sum of the placeholder formula, with the "%" sign is replaced by the row number, inclusive. */
  private static String sumOfPlaceholdersFormula(String placeholder, int startRow, int endRow) {
    var sb = new StringBuilder("=");
    for (int row = startRow; row <= endRow; row++) {
      sb.append(placeholder.replace("%", Integer.toString(row)));
      if (row < endRow) {
        sb.append("+");
      }
    }
    return sb.toString();
  }

  /** Returns the student class diagram with the given identifier. */
  private static ClassDiagram getStudentClassDiagram(String id) {
    return cdmFromFile(Paths.get(HOTEL_STUDENT_SOLUTION_DIR, HOTEL_STUDENT_SOLUTION_DIR_NAME_PREFIX + id, CDM_PATH));
  }

  /** Wrapper class for an Apache POI XSSFSheet with automatic row management. */
  static class SpreadsheetWrapper {
    XSSFSheet sheet;
    int rowNumber = 0;

    public SpreadsheetWrapper(XSSFSheet sheet) {
      this.sheet = sheet;
    }

    /**
     * Adds a row with the following cells to the spreadsheet wrapper and returns the wrapper class to allow for
     * chained invocations.
     */
    public SpreadsheetWrapper addRow(Object... cellItems) {
      if (cellItems == null || cellItems.length == 0) {
        cellItems = new Object[] {""};
      }
      XSSFRow row = sheet.createRow(rowNumber);
      for (int i = 0; i < cellItems.length; i++) {
        XSSFCell cell = row.createCell(i);
        var item = cellItems[i];
        if (item instanceof String) {
          var itemStr = (String) item;
          if (itemStr.startsWith("=")) {
            itemStr = itemStr.replaceFirst("=", "");
            cell.setCellFormula(itemStr);
          } else {
            cell.setCellValue(itemStr);
          }
        } else if (item instanceof Integer) {
          cell.setCellValue((int) item);
        }
      }
      rowNumber++;
      return this;
    }
  }

}
