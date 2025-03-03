package org.example;

import java.sql.Array;
import java.util.ArrayList;

import comm.*;
import comm.Class;
import java.util.ArrayList;
import java.util.Arrays;

public class Data {
    private ArrayList<Room> rooms;
    private ArrayList<Department> departments;
    private ArrayList<Instructor> instructors;
    private ArrayList<Course> courses;
    private ArrayList<MeetingTime> meetingTimes;
    private ArrayList<Class> classes;
    private Integer numberOfClasses = 0;

    public Data(){ initialize(); }

    public Data initialize (){
        // Room Factory?
        // Will refactor this part later
        Room room1 = new Room("E100", 20);
        Room room2 = new Room("E101", 20);
        Room room3 = new Room("E102", 20);
        Room room4 = new Room("E103", 20);
        rooms = new ArrayList<>(Arrays.asList(room1, room2, room3));

        MeetingTime meetingTime1 = new MeetingTime("J1", "MWF 11:00PM - 12:00 PM");
        MeetingTime meetingTime2 = new MeetingTime("J2", "TTH 11:00PM - 12:00 PM");
        MeetingTime meetingTime3 = new MeetingTime("J3", "MWF 9:00AM - 10:00 AM");
        MeetingTime meetingTime4 = new MeetingTime("J4", "SaSu 9:00AM - 10:00 AM");
        meetingTimes = new ArrayList<>(Arrays.asList(meetingTime1, meetingTime2, meetingTime3, meetingTime4));

        Instructor instructor1 = new Instructor(111, "Jack");
        Instructor instructor2 = new Instructor(112, "Hack");
        Instructor instructor3 = new Instructor(113, "Zack");
        Instructor instructor4 = new Instructor(114, "Hack");
        instructors = new ArrayList<>(Arrays.asList(instructor1, instructor2, instructor3, instructor4));

        Course course1 = new Course("CS101", 331, 20, new ArrayList<>(Arrays.asList(instructor1)));
        Course course3 = new Course("CS103", 333, 20, new ArrayList<>(Arrays.asList(instructor3)));
        Course course2 = new Course("CS102", 332, 20, new ArrayList<>(Arrays.asList(instructor2, instructor2)));
        Course course4 = new Course("MATH104", 334, 20, new ArrayList<>(Arrays.asList(instructor4, instructor3)));
        Course course5 = new Course("MATH105", 335, 20, new ArrayList<>(Arrays.asList(instructor1, instructor4)));
        Course course6 = new Course("MATH106", 336, 20, new ArrayList<>(Arrays.asList(instructor2, instructor3)));
        Course course7 = new Course("PHY104", 334, 20, new ArrayList<>(Arrays.asList(instructor4, instructor3)));
        Course course8 = new Course("PHY105", 335, 20, new ArrayList<>(Arrays.asList(instructor1, instructor4)));
        Course course9 = new Course("PHY106", 336, 20, new ArrayList<>(Arrays.asList(instructor2, instructor4)));
        courses = new ArrayList<>(Arrays.asList(course1,course2,course3, course4, course5, course6, course7, course8, course9));

        Department computerScienceDepartment = new Department("CS", new ArrayList<>(Arrays.asList(course1,course2, course3)));
        Department mathDepartment = new Department("MATH", new ArrayList<>(Arrays.asList(course4,course5, course6)));
        Department physicsDepartment = new Department("ALL", new ArrayList<>(Arrays.asList(course7, course8, course9)));
        departments = new ArrayList<>(Arrays.asList(computerScienceDepartment, mathDepartment, physicsDepartment));
        departments.forEach(x -> numberOfClasses += x.getCourses().size());

        return this;
    }


    public ArrayList<Room> getRooms() { return rooms; }
    public ArrayList<Department> getDepartments() { return departments; }
    public ArrayList<Instructor> getInstructors() { return instructors; }
    public ArrayList<Course> getCourses() { return courses; }
    public ArrayList<MeetingTime> getMeetingTimes() { return meetingTimes; }
    public Integer getNumberOfClasses() { return numberOfClasses; }


}