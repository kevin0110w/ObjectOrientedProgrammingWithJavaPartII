/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author woohoo
 */
public class PersonalDuplicateRemover implements DuplicateRemover {
    private Map<String, Integer> characterStrings;
    private Set<String> uniqueStrings;
    
    public PersonalDuplicateRemover() {
        this.characterStrings = new HashMap<String, Integer>();
        this.uniqueStrings = new HashSet<String>();
    }
    
    @Override
    public void add(String characterString) {
        this.uniqueStrings.add(characterString);
        int numberOfThisString = 0;
        if (this.characterStrings.containsKey(characterString)) {
            numberOfThisString = this.characterStrings.get(characterString); 
            numberOfThisString++;
        }
        this.characterStrings.put(characterString, numberOfThisString);
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        int totalDuplicates = 0;
        for (String word : characterStrings.keySet()) {
            System.out.println(word);
            if (this.characterStrings.get(word) > 0) {
                totalDuplicates += this.characterStrings.get(word);
            }
        }
        return totalDuplicates;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return this.uniqueStrings;
    }

    @Override
    public void empty() {
        this.uniqueStrings.clear();
        this.characterStrings.clear();
    }
}
