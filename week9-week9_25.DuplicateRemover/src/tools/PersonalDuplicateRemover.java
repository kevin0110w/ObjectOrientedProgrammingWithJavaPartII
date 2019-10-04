/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Freckles
 */
public class PersonalDuplicateRemover implements DuplicateRemover {
    private Map<String, Integer> entries;
    private int numberOfDuplicates;
//    private Set<String> uniqueCharacterStrings;
    
    public PersonalDuplicateRemover () {
        this.entries = new HashMap<String, Integer>();
//        this.uniqueCharacterStrings = new HashSet<String>();
    }
            
    //stores a characterString if it's not a duplicate.
    @Override
    public void add(String characterString) {
        int temp = 0;
        if (!this.entries.containsKey(characterString)) {
            this.entries.put(characterString, 0);
        } else {
            temp = this.entries.get(characterString) + 1;
            this.entries.put(characterString, temp);
        }     
    }

    //returns the number of detected duplicates.
    @Override
    public int getNumberOfDetectedDuplicates() {
        int temp = 0;
        for (int x: this.entries.values()) {
            temp += x;
        }
        return temp;
    }
    //returns an object which implements the interface Set<String>
    @Override
    public Set<String> getUniqueCharacterStrings() {
        Set<String> uniqueSet = new HashSet<String>();
        for (String x: this.entries.keySet()) {
            uniqueSet.add(x);
        }
        return uniqueSet;
    }
    
    //removes stored characterStrings and resets the amount of detected duplicates.
    @Override
    public void empty() {
        Set <String> keys = this.entries.keySet();
        this.entries.clear();
      for (String s: keys) {
          if (this.entries.containsKey(s))
         this.entries.remove(s);
    }
    }
}
