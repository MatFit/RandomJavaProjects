import comm.*;
import comm.Class;
import org.example.Data;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestCreation {
    @Test
    public void testCreationClass(){
        // Create instances of required classes
        Room room = new Room("Room 101", 30); // Assuming Room class has a constructor with parameters (String, int)
        Instructor instructor = new Instructor(1, "Computer Science"); // Assuming Instructor class has a constructor with parameters (String, String)
        MeetingTime meetingTime = new MeetingTime("J123", "12:00 PM"); // Assuming MeetingTime class has a constructor with parameter (String)
        Course course = new Course("CS101", 3,10,null); // Assuming Course class has a constructor with parameters (String, String)
        Department department = new Department("CS",null); // Assuming Department class has a constructor with parameter (String)

        // Create an instance of Class with the created objects
        Class myClass = new Class(1, department, course);

        // Print the details of the Class object to verify
        System.out.println(myClass.toString());
    }
    @Test
    public void testCreationData(){
        Data data = new Data();
        assertNotNull(data);

        System.out.println(data.getCourses().size());
    }
}
