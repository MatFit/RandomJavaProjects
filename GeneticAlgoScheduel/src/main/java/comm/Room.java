package comm;

public class Room {
    private String number;
    private Integer seatingCapacity;
    public Room (String number, Integer seatingCapacity){
        this.number = number;
        this.seatingCapacity = seatingCapacity;
    }
    public String getNumber(){
        return number;
    }
    public Integer getSeatingCapacity(){
        return seatingCapacity;
    }
    public String toString(){
        return number;
    }
}
