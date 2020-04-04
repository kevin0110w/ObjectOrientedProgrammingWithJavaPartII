
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
public class Container {
    private int limit;
    private List<Suitcase> suitcases;

    public Container(int limit) {
        this.limit = limit;
        this.suitcases = new ArrayList<Suitcase>();
    }

    public void addSuitcase(Suitcase suitcase) {
        if (this.getTotalWeight() + suitcase.totalWeight() > this.limit) {
            
        } else {
            this.suitcases.add(suitcase);
        }
    }
    
    public void printThings() {
        for (Suitcase s : this.suitcases) {
            s.printThings();
        }
    }
    
    public int getTotalWeight() {
        int weight = 0;
        for (int i = 0; i < this.suitcases.size(); i++) {
            for (Thing t : this.suitcases.get(i).getThings()) {
                weight += t.getWeight();
            }
        }
        return weight;
    }
    
    @Override
    public String toString() {
        return this.suitcases.size() + " suitcases (" + this.getTotalWeight() + " kg)";
    }
    
    
}
