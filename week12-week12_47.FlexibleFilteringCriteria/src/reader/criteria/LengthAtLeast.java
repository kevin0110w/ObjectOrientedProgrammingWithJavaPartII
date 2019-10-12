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
public class LengthAtLeast implements Criterion {
    private int lengthMinimum;
    
    public LengthAtLeast(int length) {
        this.lengthMinimum = length;
    }
    @Override
    public boolean complies(String line) {
      return (line.length() >= this.lengthMinimum);
    }
    
}
