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
public class Not implements Criterion {
    private Criterion o1;

    public Not(Criterion o1) {
        this.o1 = o1;
    }

    @Override
    public boolean complies(String line) {
        return (!this.o1.complies(line));
    }
    
    
}
