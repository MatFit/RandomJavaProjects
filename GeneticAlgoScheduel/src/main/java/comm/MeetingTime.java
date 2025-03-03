package comm;

public class MeetingTime {
    public String ID;
    public String time;
    public MeetingTime(String ID, String time){
        this.ID = ID;
        this.time = time;
    }

    public String getID() {
        return ID;
    }
    public String getTime() {
        return time;
    }
}
