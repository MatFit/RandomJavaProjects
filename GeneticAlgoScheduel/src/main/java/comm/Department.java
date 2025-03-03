package comm;

import java.util.ArrayList;

public class Department {
    public String name;
    public ArrayList<Course> courses;
    public Department(String name, ArrayList<Course> courses){
        this.name = name;
        this.courses = courses;
    }
    public String getName(){
        return name;
    }
    public ArrayList<Course> getCourses() {
        return courses;
    }
    @Override
    public String toString() {
        return name;
    }
}
