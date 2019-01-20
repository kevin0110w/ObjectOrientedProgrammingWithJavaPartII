
import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> dictionary;
//    private ArrayList<String> contents;
    
    public Dictionary() {
        this.dictionary = new HashMap<String, String>();
//        this.contents = new ArrayList<String>();
    }
    /*
     returning the translation of its parameter. 
    If the word is unknown, it returns null.
    */
    public String translate(String word) {
        if (this.dictionary.containsKey(word)) {
            return this.dictionary.get(word);
        } else {
            return null;
        }
    }
    /*
    adding a new translation to the dictionary
    */
    public void add(String word, String translation) {
        if (!(dictionary.containsKey(word))) {
            this.dictionary.put(word, translation);
        }
    }
    
    /*
     returns the amount of words in the dictionary
    */
    public int amountOfWords() {
        return this.dictionary.size();
    }
    
    public ArrayList<String> translationList() {
        ArrayList<String> translations = new ArrayList<String>();
        int i = 0;
        for (String key: this.dictionary.keySet()) {
           translations.add(key);
       }
       
       for (String values : this.dictionary.values()) {
           translations.set(i, translations.get(i) + " = " + values);
           i++;
       }
       return translations;
    }
}
