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
 * @author woohoo
 */
public class MaxWeightBox extends Box {

    private List<Thing> things;
    private int maxWeight;

    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<>();
    }

    @Override
    public void add(Thing thing) {
        int weight = 0;
        for (Thing t : things) {
            weight += t.getWeight();
        }

        if (thing.getWeight() + weight <= maxWeight) {
            this.things.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return this.things.contains(thing);
    }

}
