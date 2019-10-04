/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.logic;

import java.util.ArrayList;
import java.util.List;
import moving.domain.Box;
import moving.domain.Thing;

/**
 *
 * @author Freckles
 */
public class Packer {
    private int boxesVolume;
    private List<Box> boxes;
    
    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
        this.boxes = new ArrayList<Box>();
    }
    
    public List<Box> packThings(List<Thing> thing) {
       
       Box box = new Box(this.boxesVolume);
       if (thing.isEmpty() == false) {
           this.boxes.add(box);
       
       for (Thing z: thing) {
           if (box.addThing(z) == true) {
               box.addThing(z);
           } else {
               Box newBox = new Box(box);
               newBox.addThing(z);
               this.boxes.add(newBox);
           }
       }
     }
       return this.boxes;
    }
}
