package comm;

public class Class {
    private Integer ID;
    private MeetingTime meetingTime;
    private Instructor instructor;
    private Course course;
    private Department department;
    private Room room;

    public Class(Integer ID, Department department, Course course) {
        this.ID = ID;
        this.course = course;
        this.department = department;
    }

    public Integer getID() { return ID; }
    public MeetingTime getMeetingTime() { return meetingTime; }
    public void setMeetingTime(MeetingTime meetingTime) { this.meetingTime = meetingTime; }
    public Instructor getInstructor() { return instructor; }
    public void setInstructor(Instructor instructor) { this.instructor = instructor; }
    public Course getCourse() { return course; }
    public Department getDepartment() { return department; }
    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }


    @Override
    public String toString() {
        return "ID: " + ID + " | " +
                "Meeting Time: " + (meetingTime != null ? meetingTime.toString() : "N/A") + " | " +
                "Instructor: " + (instructor != null ? instructor.toString() : "N/A") + " | " +
                "Course: " + (course != null ? course.toString() : "N/A") + " | " +
                "Department: " + (department != null ? department.toString() : "N/A") + " | " +
                "Room: " + (room != null ? room.toString() : "N/A");
    }
}
