
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author woohoo
 */
public class Box {
    private double maxWeight;
    private List<ToBeStored> contents;
    
    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        this.contents = new ArrayList<ToBeStored>();
    }
    
    public void add(ToBeStored toBeStored) {
        if (toBeStored.weight() + this.weight() <= maxWeight) {
            contents.add(toBeStored);
        }
    }
    
    public double weight() {
        double currentWeight = 0;
        for (ToBeStored thing : contents) {
            currentWeight += thing.weight();
        }
        return currentWeight;
    }

    @Override
    public String toString() {
        return "Box: " + this.contents.size() + " things, total weight " + this.weight() + " kg";
    }
    
    
}
