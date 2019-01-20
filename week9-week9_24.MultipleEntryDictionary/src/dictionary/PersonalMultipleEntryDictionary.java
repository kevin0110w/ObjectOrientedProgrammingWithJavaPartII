package dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Freckles
 */
public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {
    private Map<String, Set<String>> entries;
    
    public PersonalMultipleEntryDictionary () {
        this.entries = new HashMap<String, Set<String>>();
    }
            
    @Override
    public void add(String word, String entry) {
        if (!this.entries.containsKey(word)) {
            this.entries.put(word, new HashSet<String>());
        }
        
        Set<String> translations = this.entries.get(word);
        translations.add(entry);
    }

    @Override
    public Set<String> translate(String word) {
        if(!this.entries.containsKey(word)) {
            return null;
        } else {
            return this.entries.get(word);
        }
    }

    @Override
    public void remove(String word) {
        if(this.entries.containsKey(word)) {
            this.entries.remove(word);
        }
    }
}
