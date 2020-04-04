/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author woohoo
 */
public class Box implements Thing {

    private int maximumCapacity;
    private List<Thing> things;

    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.things = new ArrayList<Thing>();
    }

    public boolean addThing(Thing thing) {
        if (this.getVolume() + thing.getVolume() <= this.maximumCapacity) {
            this.things.add(thing);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getVolume() {
        int vol = 0;
        for (Thing t : this.things) {
            vol += t.getVolume();
        }
        return vol;
    }
    
    public String toString() {
        return "  things in the box: "+this.getVolume()+" dm^3";
    }
}
