/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Freckles
 */
public class MaxWeightBox extends Box {
    private int maxWeight;
    private List<Thing> container;
    
    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.container = new ArrayList<Thing>();
    }
    
    @Override
    public void add(Thing thing) {
       int weight = 0;
       for (Thing a_thing : this.container) {
           weight += a_thing.getWeight();
       }
       if (weight + thing.getWeight() <= this.maxWeight) {
           this.container.add(thing);
       }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return this.container.contains(thing);
    }
    public static void main(String[] args) {
         MaxWeightBox coffeeBox = new MaxWeightBox(10);
        coffeeBox.add(new Thing("Saludo", 5));
        coffeeBox.add(new Thing("Pirkka", 5));
        coffeeBox.add(new Thing("Kopi Luwak", 5));

        System.out.println(coffeeBox.isInTheBox(new Thing("Saludo")));
        System.out.println(coffeeBox.isInTheBox(new Thing("Pirkka")));
        System.out.println(coffeeBox.isInTheBox(new Thing("Kopi Luwak")));
    }
}
