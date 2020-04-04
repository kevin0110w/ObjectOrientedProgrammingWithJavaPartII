/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

/**
 *
 * @author woohoo
 */
public class Both implements Criterion {
    private Criterion o1;
    private Criterion o2;

    public Both(Criterion o1, Criterion o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public boolean complies(String line) {
        return o1.complies(line) && o2.complies(line);
    }
}
