
import java.util.ArrayList;

public class Airplane {
    private String id;
    private int capacity;
    private ArrayList<Airplane> airplaneList;
    
    
    public Airplane(String id, Integer capacity) {
        this.id = id;
        this.capacity = capacity;
        this.airplaneList = new ArrayList<Airplane>();
    }
    public void addAirplane(Airplane airplane) {
        this.airplaneList.add(airplane);
    }
}
