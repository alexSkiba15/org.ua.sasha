import java.time.LocalDate;
public class App {
    public static void main(String[] args) throws TheExamDidNotGiveUp {
        Group b1 = new Group(2,GroupFacultyName.COMPUTER_ENGINEERING);
        Group b2 = new Group(2,GroupFacultyName.PHILOSOPHY);
        Group b3 = new Group(2,GroupFacultyName.HISTORICAL);
        Group b4 = new Group(1,GroupFacultyName.COMPUTER_ENGINEERING);

        Student student1 = new Student("Alexander1","Skiba1");
        Student student2 = new Student("Alexander2","Skiba2");
        Student student3 = new Student("Alexander3","Skiba3");
        Student student4 = new Student("Alexander4","Skiba4");

        student1.setGroup(b1);
        student2.setGroup(b2);
        student3.setGroup(b3);
        student4.setGroup(b4);

        student1.addAssessment(ExamName.ECONOMY,65, LocalDate.of(2018,10,23));
        student1.addAssessment(ExamName.ENGLISH,88, LocalDate.of(2018,10,23));
        student1.addAssessment(ExamName.PHILOSOPHY,77, LocalDate.of(2018,10,23));
        student1.addAssessment(ExamName.PHILOSOPHY,77, LocalDate.of(2018,11,23));
        student1.addAssessment(ExamName.HISTORY,34, LocalDate.of(2018,10,23));
        student1.addAssessment(ExamName.HISTORY,55, LocalDate.of(2018,10,23));
        student2.addAssessment(ExamName.HISTORY,55, LocalDate.of(2018,10,23));
        student2.addAssessment(ExamName.HISTORY,33, LocalDate.of(2018,10,23));
        student2.addAssessment(ExamName.HISTORY,68, LocalDate.of(2018,10,23));
        student3.addAssessment(ExamName.HISTORY,67, LocalDate.of(2018,10,23));
        student4.addAssessment(ExamName.HISTORY,44, LocalDate.of(2018,10,23));
        student4.addAssessment(ExamName.HISTORY,89, LocalDate.of(2018,10,23));
        student4.addAssessment(ExamName.HISTORY,77, LocalDate.of(2018,10,23));

        System.out.println("Max grade in " + ExamName.PHILOSOPHY.toString() + " = " + student1.getMaxAssessment(ExamName.PHILOSOPHY));
        System.out.println(student1 + "\n");
        System.out.println("Max grade in " + ExamName.HISTORY.toString() + " = " + student2.getMaxAssessment(ExamName.HISTORY));
        System.out.println(student2 + "\n");
        System.out.println("Max grade in " + ExamName.HISTORY.toString() + " = " + student3.getMaxAssessment(ExamName.HISTORY));
        System.out.println(student3 + "\n");
        System.out.println("Max grade in " + ExamName.HISTORY.toString() + " = " + student4.getMaxAssessment(ExamName.HISTORY));
        System.out.println(student4 + "\n");

        student1.deleteAssessment(ExamName.PHILOSOPHY,LocalDate.of(2018,10,23));
        System.out.println(student1);
        System.out.println(student1.getNumberOfExamsWithThisGrade(2));
        System.out.println(student2.getNumberOfExamsWithThisGrade(2));

        System.out.println(student1.getAverageAssessment(3));
    }
}
