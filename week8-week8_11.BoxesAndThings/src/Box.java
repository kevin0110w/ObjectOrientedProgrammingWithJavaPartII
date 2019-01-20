
import java.util.ArrayList;


public class Box implements ToBeStored {
    private double maxWeight;
//    private double weight;
    private ArrayList<ToBeStored> box;
    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
//        this.weight = 0;
        this.box = new ArrayList<ToBeStored>();
    }
    
    public void add(ToBeStored thing) {
        if (this.maxWeight - weight() >= thing.weight()) {
            this.box.add(thing);
//            this.weight += thing.weight();
        }
    }
    
    public String toString() {
        return "Box: " + this.box.size() + " things, total weight " + weight() + " kg";
    }

    @Override
    public double weight() {
        double weight = 0;
        for (ToBeStored x : this.box) {
            weight += x.weight();
        }
        return weight;
    }
}
