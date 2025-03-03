package comm;

public class Instructor {
    public Integer ID;
    public String name;
    public Instructor(Integer ID, String name){
        this.ID = ID;
        this.name = name;
    }

    public Integer getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public String toString(){
        return name;
    }
}
