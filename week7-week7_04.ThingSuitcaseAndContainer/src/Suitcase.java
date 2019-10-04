
import java.util.ArrayList;

public class Suitcase {
    private ArrayList<Thing> suitcase;
    private int maxWeight;
//    private int count;
//    private int weight;
    
    public Suitcase(int maxWeight) {
        this.suitcase = new ArrayList<Thing>();
        this.maxWeight = maxWeight;
//        this.count = 0;
//        this.weight = 0;
    }
    
    public void addThing(Thing thing) {
        if ((this.totalWeight() + thing.getWeight()) <= this.maxWeight) {
            this.suitcase.add(thing);
//            this.weight += thing.getWeight();
//            this.count++;
        }
    }
    
    public String toString() {
        String output = "";
//        if (this.count == 0) {
           if (this.suitcase.size() == 0) {
            output += "empty (" + this.totalWeight() + " kg)";
//        } else if (this.count == 1) {
        } else if (this.suitcase.size() == 1) {
            output += "1 thing (" + this.totalWeight() + " kg)";
        } else {
            output += this.suitcase.size() + " things (" + this.totalWeight() + " kg)";
        }
        return output;
    }

    
    public void printThings() {
        for (Thing thing : this.suitcase) {
            System.out.println(thing);
        }
    }
    
    public int totalWeight() {
        int weight = 0;
        for (Thing things : this.suitcase) {
            weight += things.getWeight();
        }
        return weight;
    }   
    
    public Thing heaviestThing() {
        if (this.suitcase.size() == 0) {
            return null;
        }
        
        Thing thing = this.suitcase.get(0);
        int heaviest = this.suitcase.get(0).getWeight();
        for (Thing a : this.suitcase) {
            if (a.getWeight() >= heaviest) {
                heaviest = a.getWeight();
                thing = a;
            } 
        }
        return thing;
    }
}
