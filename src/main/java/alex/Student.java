package alex;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Student {
    private String name;
    private String surname;
    private Group group;
    private List<Exam> exam = new ArrayList<>();

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public int getMaxAssessment(ExamName examName) {
        int count = 0;
        for (Exam i : exam) {
            if (i.getExamName() == examName) {
                if (count < i.getAssessment()) {
                    count = i.getAssessment();
                }
            }
        }
        return count;
    }

    public boolean addAssessment(ExamName examName, int assessment, LocalDate localDate) {
        Exam b = new Exam(examName, assessment, localDate);
        if (b.setLocalDate(localDate)) {
            exam.add(b);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteAssessment(ExamName examName, LocalDate localDate) {
        try {
            for (Exam i : exam) {
                if (examName == i.getExamName() && localDate.equals(i.getLocalDate())) {
                    i.setAssessment(0);
                    return true;
                } else if (examName == i.getExamName() && !(localDate.equals(i.getLocalDate()))) {
                    System.out.println("This student on this day did not pass the exam\n");
                    return false;
                }
            }
            throw new TheExamDidNotGiveUp();
        } catch (TheExamDidNotGiveUp ex) {
            System.out.println("This student did not pass such an exam\n");
            return false;
        }
    }

    public int getNumberOfExamsWithThisGrade(int assessment) {
        int count = 0;
        for (Exam i : exam) {
            if (assessment == 1 || assessment == 2) {
                if (i.getAssessment() >= 0 && i.getAssessment() <= 60) {
                    count++;
                }
            } else if (assessment == 3) {
                if (i.getAssessment() >= 61 && i.getAssessment() <= 74) {
                    count++;
                }
            } else if (assessment == 4) {
                if (i.getAssessment() >= 75 && i.getAssessment() <= 90) {
                    count++;
                }
            } else if (assessment == 5) {
                if (i.getAssessment() >= 91 && i.getAssessment() <= 100) {
                    count++;
                }
            } else if (assessment > 5) {
                System.out.println("Enter correct assessment from 1 to 5");
                return 0;
            }
        }
        return count;
    }

    public double getAverageAssessment(int semester) {
        if (semester > 0 && semester <= 4) {
            int count = 0;
            int count2 = 0;
            for (Exam e : exam) {
                if (semester == e.getSemester()) {
                    count2++;
                    count += e.getAssessment();
                    return (double) count / count2;
                }
            }
        }
        System.out.println("Enter semester from 1 to 4");
        return 0;
    }
}