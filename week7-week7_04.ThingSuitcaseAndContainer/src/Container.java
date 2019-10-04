
import java.util.ArrayList;

public class Container {
    private ArrayList<Suitcase> container;
    private int maxWeight;
    private int weight;
    
    public Container(int maxWeight) {
        this.maxWeight = maxWeight;
        this.container = new ArrayList<Suitcase>();
        this.weight = 0;
    }
    
    public void addSuitcase(Suitcase suitcase) {
        if ((suitcase.totalWeight() + this.weight) <= this.maxWeight) {
             this.container.add(suitcase);
             this.weight += suitcase.totalWeight();
        }
    }
    
    public String toString() {
        return this.container.size() + " suitcases (" + this.weight + "kg)";
    }
    
    public void printThings() {
        for (Suitcase suitcase : this.container) {
            suitcase.printThings();
        }
    }
}
