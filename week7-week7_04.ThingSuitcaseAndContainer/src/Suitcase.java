
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
public class Suitcase {
    private List<Thing> things;
    private int limit;

    public Suitcase(int limit) {
        this.limit = limit;
        this.things = new ArrayList<Thing>();
    }

    public void addThing(Thing thing) {
        if (this.totalWeight() + thing.getWeight() > this.limit) {
            
        } else {
            this.things.add(thing);
        }
    }
    
    public String getSize() {
        int size = this.things.size();
        if (size == 0) {
            return "empty";
        } else if (size == 1) {
            return this.things.size() + " thing";
        } else {
            return this.things.size() + " things";
        }
    }
    
    public void printThings() {
        for (Thing t : this.things) {
            System.out.println(t);
        }
    }
    
    public int totalWeight() {
        int currentWeight = 0;
        for (Thing t : this.things) {
            currentWeight += t.getWeight();
        }
        return currentWeight;
    }
    
    public Thing heaviestThing() {
        if (this.things.size() == 0) {
            return null;
        } 
        
        Thing heaviest = this.things.get(0);
        for (Thing t : this.things) {
            if (t.getWeight() > heaviest.getWeight()) {
                heaviest = t;
            }
        }
        return heaviest;
        
    }
    
    @Override
    public String toString() {
        return this.getSize() + " (" + this.totalWeight() + " kg)";
    }

    Iterable<Thing> getThings() {
        return this.things;
    }
    
    
    
    
}
