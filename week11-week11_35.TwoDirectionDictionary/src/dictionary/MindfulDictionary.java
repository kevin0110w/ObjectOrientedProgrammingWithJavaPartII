/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author woohoo
 */
public class MindfulDictionary {

    private Map<String, String> finnishToEnglish;
    private Map<String, String> englishToFinnish;
    private File file;

    public MindfulDictionary() {
        finnishToEnglish = new HashMap<String, String>();
        englishToFinnish = new HashMap<String, String>();
    }

    public MindfulDictionary(String file) {
        finnishToEnglish = new HashMap<String, String>();
        englishToFinnish = new HashMap<String, String>();
        this.file = new File(file);
    }

    public boolean load() {
        Scanner reader;
        try {
            reader = new Scanner(this.file);
            while (reader.hasNext()) {
                String line = reader.nextLine();
                String[] parts = line.split(":");   // the line is split at :
                this.add(parts[0], parts[1]);
            }
        } catch (FileNotFoundException ex) {
            return false;
        }
        return true;
    }

    public boolean save() {
        FileWriter writer;
        try {
            writer = new FileWriter(this.file);
            for (String s : this.finnishToEnglish.keySet()) {
                String line = s + ":" + this.finnishToEnglish.get(s) + "\n";
                writer.write(line);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException ex) {
            return false;
        }
        return true;
    }

    public void add(String word, String translation) {
        if (!this.finnishToEnglish.containsKey(word)) {
            this.finnishToEnglish.put(word, translation);
        }

        if (!this.englishToFinnish.containsKey(translation)) {
            this.englishToFinnish.put(translation, word);
        }
    }

    public String translate(String word) {
        if (this.finnishToEnglish.containsKey(word)) {
            return this.finnishToEnglish.get(word);
        } else if (this.englishToFinnish.containsKey(word)) {
            return this.englishToFinnish.get(word);
        } else {
            return null;
        }
    }

    public void remove(String word) {
        if (this.finnishToEnglish.containsKey(word)) {
            this.englishToFinnish.remove(this.finnishToEnglish.get(word));
            this.finnishToEnglish.remove(word);
        } else if (this.englishToFinnish.containsKey(word)) {
            this.finnishToEnglish.remove(this.englishToFinnish.get(word));
            this.englishToFinnish.remove(word);
        }

    }
}
