import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class StudentTest {

    Exam b = new Exam(ExamName.HIGHER_MATHEMATICS,90, LocalDate.of(2018,10,28));

    @Test
    public void getMaxAssessment() {
        System.out.println(b);

    }

    @Test
    public void setName() {
    }

    @Test
    public void setSurname() {
    }

    @Test
    public void setGroup() {
    }

    @Test
    public void setExam() {

    }
}