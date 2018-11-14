import lombok.Getter;
import lombok.Setter;

@Getter
class Group {
    private int course;
    private GroupFacultyName groupFacultyName;
    private String nameGroup;

    Group(int course, GroupFacultyName groupFacultyName) {
        setCourse(course);
        setGroupFacultyName(groupFacultyName);
    }

    private void setCourse(int course) {
        if (course >= 1 && course <= 2) {

            this.course = course;
        } else {
            System.out.println("Enter correct course from 1 to 2");
        }
    }

    private void setGroupFacultyName(GroupFacultyName groupFacultyName) {
        if (course >= 1 && course <= 2) {
            if (groupFacultyName.equals(GroupFacultyName.COMPUTER_ENGINEERING) && course == 1) {
                nameGroup = GroupName.CE_12.toString();
            } else if (groupFacultyName==GroupFacultyName.COMPUTER_ENGINEERING && course == 2) {
                nameGroup = GroupName.CE_13.toString();
            } else if (groupFacultyName==GroupFacultyName.HISTORICAL && course == 1) {
                nameGroup = GroupName.HIS_44.toString();
            } else if (groupFacultyName==GroupFacultyName.HISTORICAL && course == 2) {
                nameGroup = GroupName.HIS_45.toString();
            } else if (groupFacultyName==GroupFacultyName.MANAGEMENT && course == 1) {
                nameGroup = GroupName.M_9.toString();
            } else if (groupFacultyName==GroupFacultyName.MANAGEMENT && course == 2) {
                nameGroup = GroupName.M_10.toString();
            } else if (groupFacultyName==GroupFacultyName.PHILOSOPHY && course == 1) {
                nameGroup = GroupName.PH_12.toString();
            } else if (groupFacultyName==GroupFacultyName.PHILOSOPHY && course == 2) {
                nameGroup = GroupName.PH_13.toString();
            } else if (groupFacultyName==GroupFacultyName.COMPUTER_SCIENCE && course == 1) {
                nameGroup = GroupName.CS_23.toString();
            } else if (groupFacultyName==GroupFacultyName.COMPUTER_SCIENCE && course == 2) {
                nameGroup = GroupName.CS_24.toString();
            } else if (groupFacultyName==GroupFacultyName.MATHEMATICAL_ANALYSIS && course == 1) {
                nameGroup = GroupName.MA_45.toString();
            } else if (groupFacultyName==GroupFacultyName.MATHEMATICAL_ANALYSIS && course == 2) {
                nameGroup = GroupName.MA_46.toString();
            }
            this.groupFacultyName = groupFacultyName;
        }
    }

    @Override
    public String toString() {
        return  nameGroup + "{" +
                "course=" + course +
                ", groupFacultyName=" + groupFacultyName +
                '}';
    }
}

