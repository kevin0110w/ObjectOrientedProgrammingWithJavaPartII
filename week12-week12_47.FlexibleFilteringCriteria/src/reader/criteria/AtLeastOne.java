/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author woohoo
 */
public class AtLeastOne implements Criterion {

    List<Criterion> object;

    public AtLeastOne(Criterion... object) {
        this.object = new ArrayList<>();
        this.addObjects(object);
    }

    public void addObjects(Criterion... object) {
        for (Criterion c : object) {
            this.object.add(c);
        }
    }

    @Override
    public boolean complies(String line) {
        for (Criterion c : this.object) {
            if (c.complies(line)) {
                return c.complies(line);
            }
        }
        return false;
    }

}
