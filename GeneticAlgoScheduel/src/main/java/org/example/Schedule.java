package org.example;

import comm.*;
import comm.Class;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// a Genetic algo schedule such that it will continue to go through
// generations until an offspring yields essentially 0 numofConflicts
public class Schedule {
    private boolean isFitnessChanged = true;
    private double fitness;
    private int numOfConflicts;
    ArrayList<Class> classes;
    private Random random;
    private Data data;
    private int classNumber;
    public Data getData() { return data; }
    public Schedule(Data data){
        this.data = data;
        classes = new ArrayList<Class>(data.getNumberOfClasses());
        this.random = new Random();
    }

    public Schedule initialize() {
        data.getDepartments().forEach(department -> {
            department.getCourses().forEach(course -> {
                Class newClass = new Class(classNumber++, department, course);
                List<MeetingTime> meetingTimes = data.getMeetingTimes();
                if (!meetingTimes.isEmpty()) {
                    newClass.setMeetingTime(meetingTimes.get(random.nextInt(meetingTimes.size())));
                }
                List<Room> rooms = data.getRooms();
                if (!rooms.isEmpty()) {
                    newClass.setRoom(rooms.get(random.nextInt(rooms.size())));
                }
                List<Instructor> instructors = course.getInstructors();
                if (!instructors.isEmpty()) {
                    newClass.setInstructor(instructors.get(random.nextInt(instructors.size())));
                }
                classes.add(newClass);
            });
        });

        return this;
    }

    public double getFitness(){
        if (isFitnessChanged){
            fitness = calculateFitness();
            isFitnessChanged = false;
        }
        return fitness;
    }
    public double calculateFitness(){
        // count num of conflicts
        numOfConflicts = 0;

        classes.stream().forEach(x ->{
            if (x.getRoom().getSeatingCapacity() < x.getCourse().getMaxStudentEnrolled()) { numOfConflicts++;}

            classes.stream().forEach(y -> {
                if (x.getMeetingTime() == y.getMeetingTime() && x.getID() != y.getID())
                {
                     if (x.getRoom() == y.getRoom()) { numOfConflicts++;}
                     if (x.getInstructor() == y.getInstructor()) {numOfConflicts++;}
                }
            });
        });

        return 1 / (double)(numOfConflicts + 1);
    }

    public String toString(){
        String returnValue = new String();
        for (int x = 0; x < classes.size()-1; x++) { returnValue += classes.get(x) + " "; }
        returnValue += classes.get(classes.size() - 1);
        return returnValue;
    }
    public ArrayList<Class> getClasses(){
        return classes;
    }
}
