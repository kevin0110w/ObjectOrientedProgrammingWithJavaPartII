/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

/**
 *
 * @author woohoo
 */
public class OneThingBox extends Box {

    private Thing[] thing;

    public OneThingBox() {
        this.thing = new Thing[1];
    }

    @Override
    public void add(Thing thing) {
        if (this.thing[0] == null) {
            this.thing[0] = thing;
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        if (this.thing[0] == null) {
            return false;
        }
        return this.thing[0].equals(thing);
    }
}
