/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

/**
 *
 * @author 
 */
public class Both implements Criterion {
    private Criterion c;
    private Criterion c1;
    
    public Both(Criterion c, Criterion c1) {
        this.c = c;
        this.c1 = c1;
    }
    
    @Override
    public boolean complies(String line) {
        return c.complies(line) && c1.complies(line);
    }
    
}
