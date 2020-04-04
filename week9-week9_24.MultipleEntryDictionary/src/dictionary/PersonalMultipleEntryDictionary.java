/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author woohoo
 */
public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {
    private Map<String, Set<String>> translations;

    public PersonalMultipleEntryDictionary() {
        this.translations = new HashMap<String, Set<String>>();
    }
    
    @Override
    public void add(String word, String entry) {
        Set<String> translation;
        if (!(this.translations.containsKey(word))) {
            translation = new HashSet<>();
            translation.add(entry);
            
        } else {
                       translation = this.translations.get(word);
                       translation.add(entry); 
        }
        this.translations.put(word, translation);
    }

    @Override
    public Set<String> translate(String word) {
        if (!(this.translations.containsKey(word))) {
            return null;
        }
        return this.translations.get(word);
    }

    @Override
    public void remove(String word) {
        if (!(this.translations.containsKey(word))) {
            return;
        }
        this.translations.remove(word);
    }
}
