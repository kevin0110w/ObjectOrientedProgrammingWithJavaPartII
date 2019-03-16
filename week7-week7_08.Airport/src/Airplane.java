
import java.util.ArrayList;

public class Airplane {
    
    private String id;
    private Integer capacity;
    private ArrayList<Airplane> planes = new ArrayList<Airplane>();
   
    public Airplane(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }
    
//    public void addAirplane1(Airplane plane) {
//       add(plane);
//    }
    
    public String getID() {
        return this.id;
    }
    
    public int getCapacity() {
        return this.capacity;
    }
    
    public String toString() {
        return this.id + " (" + this.capacity + ")";
    }
}
