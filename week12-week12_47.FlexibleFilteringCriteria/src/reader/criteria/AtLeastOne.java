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
 * @author 
 */
public class AtLeastOne implements Criterion {
    private Criterion[] criteria;
    
    public AtLeastOne(Criterion... criteria) {
        this.criteria = criteria;
    }
    
    @Override
    public boolean complies(String line) {
        for (int i = 0; i < this.criteria.length; i++) {
            if (this.criteria[i].complies(line)) {
                return this.criteria[i].complies(line);
            }
        }
        return false;
    }
    
}
