/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

import java.util.ArrayList;
import java.util.List;


public class OneThingBox extends Box {
    private List<Thing> oneThingBox;
    
    public OneThingBox() {
        this.oneThingBox = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing) {
        if (this.oneThingBox.isEmpty()) {
            this.oneThingBox.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        if (this.oneThingBox.contains(thing)) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
         OneThingBox box = new OneThingBox();
        box.add(new Thing("Saludo", 5));
        box.add(new Thing("Pirkka", 5));

        System.out.println(box.isInTheBox(new Thing("Saludo")));
        System.out.println(box.isInTheBox(new Thing("Pirkka")));
    }
}
