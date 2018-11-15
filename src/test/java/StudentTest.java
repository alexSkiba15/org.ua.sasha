import alex.Group;
import alex.GroupFacultyName;
import alex.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static alex.ExamName.*;

import java.time.LocalDate;

public class StudentTest {
    private Group b1 = new Group(2, GroupFacultyName.COMPUTER_ENGINEERING);
    private Group b2 = new Group(2, GroupFacultyName.PHILOSOPHY);
    private Group b3 = new Group(2, GroupFacultyName.HISTORICAL);
    private Group b4 = new Group(1, GroupFacultyName.COMPUTER_ENGINEERING);

    private Student student1 = new Student("Alexander1", "Skiba1");
    private Student student2 = new Student("Alexander2", "Skiba2");
    private Student student3 = new Student("Alexander3", "Skiba3");
    private Student student4 = new Student("Alexander4", "Skiba4");

    @Before
    public void add() {
        student1.setGroup(b1);
        student2.setGroup(b2);
        student3.setGroup(b3);
        student4.setGroup(b4);

        student1.addAssessment(ENGLISH, 88, LocalDate.of(2018, 10, 23));
        student1.addAssessment(PHILOSOPHY, 77, LocalDate.of(2018, 10, 23));
        student1.addAssessment(PHILOSOPHY, 77, LocalDate.of(2018, 11, 23));
        student1.addAssessment(HISTORY, 34, LocalDate.of(2018, 10, 23));
        student1.addAssessment(HISTORY, 55, LocalDate.of(2018, 10, 23));
        student2.addAssessment(HISTORY, 55, LocalDate.of(2018, 10, 23));
        student2.addAssessment(HISTORY, 33, LocalDate.of(2018, 10, 23));
        student2.addAssessment(HISTORY, 68, LocalDate.of(2018, 10, 23));
        student3.addAssessment(HISTORY, 67, LocalDate.of(2018, 10, 23));
        student4.addAssessment(ECONOMY, 77, LocalDate.of(2018, 10, 28));
        student4.addAssessment(HISTORY, 44, LocalDate.of(2018, 10, 23));
        student4.addAssessment(HISTORY, 89, LocalDate.of(2018, 10, 23));
        student4.addAssessment(HISTORY, 77, LocalDate.of(2018, 10, 23));
    }

    @Test
    public void addAssessment() {
        try {
            boolean i = student4.addAssessment(COMPUTER_SCIENCE, 68, LocalDate.of(2018, 11, 29));
            Assert.assertEquals(i, true);
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
        try {
            boolean i = student4.addAssessment(COMPUTER_SCIENCE, 68, LocalDate.of(2200, 11, 29));
            Assert.assertEquals(i, false);

        } catch (AssertionError e) {
            System.out.println("Not equal");
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void getMaxAssessment() {
        try {
            Assert.assertEquals(student1.getMaxAssessment(PHILOSOPHY), 77);
        } catch (AssertionError e) {
            System.out.println("Not equal");
            System.out.println(e.getMessage());
            Assert.fail();
        }
        try {
            Assert.assertEquals(student1.getMaxAssessment(COMPUTER_SCIENCE), 0);
        } catch (AssertionError e) {
            System.out.println("Not equal");
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void getMaxAssessmentNotExam() {
        try {
            Assert.assertEquals(student1.getMaxAssessment(HISTORY), 55);
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
        try {
            Assert.assertEquals(student1.getMaxAssessment(ECONOMY), 0);
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void deleteAssessment() {
        try {
            Assert.assertEquals(student4.deleteAssessment(HISTORY, LocalDate.of(2018, 10, 23)), true);
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
        try {
            Assert.assertEquals(student4.deleteAssessment(COMPUTER_SCIENCE, LocalDate.of(2018, 10, 5)), false);
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void getNumberOfExamsWithThisGrade() {
        try {
            Assert.assertEquals(student3.getNumberOfExamsWithThisGrade(3), 1);
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
        try {
            Assert.assertEquals(student3.getNumberOfExamsWithThisGrade(99), 0);
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void getAverageAssessment() {
        try {
            Assert.assertEquals(student1.getAverageAssessment(3),88,0.1);
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            Assert.fail();
        }
        try {
            Assert.assertEquals(student1.getAverageAssessment(55),0,0.1);
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }
}