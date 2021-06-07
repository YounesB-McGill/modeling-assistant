# Agenda

### Welcome Back Gunter!

___

## Research

### Connecting Modeling Assistant Components

#### New Java-Python Bridge

* It is now possible to read/write a modeling assistant (and associated 
class diagrams) as a string in both Java and Python instead of a file
* Can use REST to send info between Mistake Detection and other parts of
the Modeling Assistant
* Key benefits: potential performance improvement, allow deployment of MDS on a separate machine/container

#### Connection with Unity Web App

* Difficulty: Unity app requires both a frontend and a backend (Microsoft 
IIS or Apache, which we are using), so need to integrate both with Modeling
Assistant, not just frontend (ie, need to make this work with Flask (for
Python) and Spring Framework (for Java))
* Demo app is now running, but quality is not ideal
* More straightforward (and useful) to add REST to WebCore compared with 
debugging 3rd party dependency with its own dependency and version issues
* REST is "cleaner" since it is stateless but is less performant

#### Connection with TouchCORE

##### Problems with current approach

* Duplication of TouchCORE Eclipse projects (`ca.mcgill.sel.classdiagram*`)
* Duplication of `classdiagram.ecore` in `modelingassistant` project, leading to duplicate generated Java and Python code
* Hard to update project every time TouchCORE is updated, since multiple
items must be reduplicated, followed by manual code regeneration

##### Problems with WebCore/Maven

* Maven is used for other dependencies, but not TouchCORE itself
* `classdiagram.ecore` is not in `TouchCORE.jar` (only `core` file is present, and cannot recreate JAR file locally)
* Not clear how to integrate Maven with multiple existing Eclipse 
projects, since its POM (Project Object Model) makes strong assumptions 
about project structure
* TouchCORE is not on Maven Central, so it needs to be managed manually
on local machines, negating the need for Maven

### Feedback Algorithm

* General idea (from April): Which feedback to give for many mistakes, and 
in what order?
* Need to address prerequisites:
  * Missing mistake types and categories
  * Missing API from Xtext language (TBD)
* First prototype will be very simple, sophistication will increase over 
time
  * Consider student knowledge 
* It will be faster to prototype algorithm in Python (can move to Java 
after paper submission if required)
* Learning corpus (show a few complete items)

### Models Paper

* Deadlines:
  * 12 June (Student Research Competition 4-page paper)
  * 18 June (EduSymp Abstract)
  * 25 June (EduSymp 10-page paper)

### Working with Fatma

* Ideally reorganize project before asking her to work on it, to avoid
making her setup everything twice (MDS was recently refactored but project
setup should be simplified)
* Prabhsimran and I have given her intro and are currently helping her with
the EMF Tutorial

## RA/TA Work

* Completed recent Workday forms for Summer RA position
* Plan to apply for ECSE211 and 223 in Fall 2021
* ECSE223 Project should be refactored (and simplified?) for easier 
autograding (both style and implementation logic can be autograded, as was 
done in DPM)
* Other parts of ECSE223 can be updated at the end of summer
* Consider doing ECSE223 grading
