package alex;

import lombok.Getter;//Импортируем библиотеку ламбок (делает для всех геттеры если я не указываю их вручную)
import lombok.Setter;//Импортируем библиотеку ламбок (делает для всех сеттеры если я не указываю их вручную)

import java.time.LocalDate;
import java.time.Month;

@Getter
@Setter
public class Exam {
    private static final int MIN_SEMESTER = 1;//задаем границы
    private static final int MAX_SEMESTER = 4;//задаем границы
    private static final int MIN_ASSESSMENT = 0;//задаем границы оценки
    private static final int MAX_ASSESSMENT = 100;//задаем границы оценки
    private static final LocalDate MIN_DATE = LocalDate.of(2017, Month.SEPTEMBER, 1);//это минимальная дата которую можно ввести
    private static final LocalDate MAX_DATE = LocalDate.of(2019, Month.JULY, 1);//масимальная...
    private ExamName examName;//Это вызов enum с названиями экзаменов
    private Integer assessment;//переменная...
    private LocalDate localDate;//сама дата...
    private int semester;

    boolean setLocalDate(LocalDate localDate) {
        LocalDate oneSemesterEnd = LocalDate.of(2017, 12, 31);//тут короче я добавил границы семестров
        LocalDate twoSemesterStart = LocalDate.of(2018, 1, 1);//чтобы когда я пишу дату оно сразу понимало какой семестр
        LocalDate twoSemesterEnd = LocalDate.of(2018, 6, 30);
        LocalDate threeSemesterStart = LocalDate.of(2018, 9, 1);
        LocalDate threeSemesterEnd = LocalDate.of(2018, 12, 31);
        LocalDate fourSemesterStart = LocalDate.of(2019, 1, 1);
        LocalDate fourSemesterEnd = LocalDate.of(2019, 6, 30);
        LocalDate summerStart = LocalDate.of(2018, 7, 1);//это даты каникул
        LocalDate summerEnd = LocalDate.of(2018, 8, 31);//и это
        if (localDate.isAfter(MIN_DATE) && localDate.isBefore(MAX_DATE) && !(localDate.isAfter(summerStart) &&
                localDate.isBefore(summerEnd))) {//ставим условие что введенная дата не каникулы и не не раньше или позже указанных дат
            if (localDate.isAfter(MIN_DATE) && localDate.isBefore(oneSemesterEnd)) {//по условиям говорим какой семестр...
                this.semester = 1;
            } else if (localDate.isAfter(twoSemesterStart) && localDate.isBefore(twoSemesterEnd)) {//по условиям говорим какой семестр...
                this.semester = 2;
            } else if (localDate.isAfter(threeSemesterStart) && localDate.isBefore(threeSemesterEnd)) {//по условиям говорим какой семестр...
                this.semester = 3;
            } else if (localDate.isAfter(fourSemesterStart) && localDate.isBefore(fourSemesterEnd)) {//по условиям говорим какой семестр...
                this.semester = 4;
            }
            this.localDate = localDate;//присваиваем значение
            return true;
        } else if (localDate.isAfter(summerStart) && localDate.isBefore(summerEnd)) {//если дата во время каникул
            System.out.println("Summer holidays from 1 JUlY to 31 AUGUST");
            return false;
        } else {
            System.out.println("Enter correct data from (" + MIN_DATE + ") to (" + MAX_DATE + ")");
            return false;
        }
    }

    void setAssessment(Integer assessment) {//условие для оценки...
        if (assessment >= MIN_ASSESSMENT && assessment <= MAX_ASSESSMENT) {
            this.assessment = assessment;
        } else {
            System.out.println("Enter correct assessment from" + MIN_ASSESSMENT + " to " + MAX_ASSESSMENT);
        }
    }

    Exam(ExamName examName, Integer assessment, LocalDate localDate) {
        setAssessment(assessment);
        setExamName(examName);
        setLocalDate(localDate);
    }

    @Override
    public String toString() {
        return "\n alex.Exam{" +
                "examName=" + examName +
                ", assessment=" + assessment +
                ", localDate=" + localDate +
                ", semester=" + semester +
                '}' ;
    }
}
