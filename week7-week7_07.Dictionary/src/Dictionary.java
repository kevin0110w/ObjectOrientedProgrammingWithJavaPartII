
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author woohoo
 */
public class Dictionary {
    private Map<String,String> words;
    
    public Dictionary() {
        this.words = new HashMap<String,String>();
    }
    
    public String translate(String word) {
        if (!this.words.containsKey(word)) {
            return null;
        }
        
        return this.words.get(word);
    }
    
    public void add(String word, String translation) {
        this.words.put(word, translation);
    }
    
    public int amountOfWords() {
        return this.words.size();
    }

    public ArrayList<String> translationList() {
        ArrayList<String> wordList = new ArrayList<String>();
        for (String key : this.words.keySet()) {
            wordList.add(key + " = " + this.words.get(key));
        }
        return wordList;
    }
}
