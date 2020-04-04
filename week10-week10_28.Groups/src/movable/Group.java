/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author woohoo
 */
public class Group implements Movable {

    private List<Movable> objects;

    public Group() {
        this.objects = new ArrayList<Movable>();
    }

    public void addToGroup(Movable movable) {
        this.objects.add(movable);
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.objects.size(); i++) {
            if (i == this.objects.size() - 1) {
                s += this.objects.get(i).toString();
            } else {
                s += this.objects.get(i).toString() + "\n";
            }
        }
        return s;
    }

    @Override
    public void move(int dx, int dy) {
        this.objects.stream()
                .forEach(m -> m.move(dx, dy));
    }
}
