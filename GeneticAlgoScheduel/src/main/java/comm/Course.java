package comm;

import java.util.ArrayList;

public class Course {
    private String name;
    private Integer ID;
    private Integer maxStudentEnrolled;
    private ArrayList<Instructor> instructors;

    public Course(String name, Integer ID, Integer maxStudentEnrolled, ArrayList<Instructor> instructors){
        this.ID = ID;
        this.name = name;
        this.maxStudentEnrolled = maxStudentEnrolled;
        this.instructors = instructors;
    }

    public String getName() {
        return name;
    }
    public Integer getID(){
        return ID;
    }
    public Integer getMaxStudentEnrolled() {
        return maxStudentEnrolled;
    }
    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }
    public String toString(){
        return name;
    }
}
