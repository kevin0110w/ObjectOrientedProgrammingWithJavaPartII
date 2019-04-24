package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author kevin0110w
 */
public class MindfulDictionary {

    private String file;
    private Map<String, String> translationToEnglish, translationToFinnish;

    public MindfulDictionary() {
        this.translationToEnglish = new HashMap<String, String>();
        this.translationToFinnish = new HashMap<String, String>();
    }

    public MindfulDictionary(String file) {
        this.translationToEnglish = new HashMap<String, String>();
        this.translationToFinnish = new HashMap<String, String>();
        this.file = file;
    }

    public boolean load() {
        File f = new File(this.file);
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(f);
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");
                add(parts[0], parts[1]);
            }
        } catch (FileNotFoundException g) {
            return false;
        }
        return true;
    }

    public boolean save() {
        File file = new File(this.file);
        String line = "";
        FileWriter out = null;
        {
            try {
                out = new FileWriter(file);
                for (String finnishWord : this.translationToFinnish.keySet()) {
                    line = finnishWord + ":" + this.translationToFinnish.get(finnishWord) + "\n";
                    out.write(line);
                }
            } catch (IOException e) {
                return false;
            } finally {
                try {
                    out.close();
                } catch (IOException e) {
                    return false;
                }
            }
            return true;
        }
    }

    public void add(String word, String translation) {
        if (this.translationToEnglish.containsKey(translation) || this.translationToFinnish.containsKey(word)) {
            return;
        } else {
            this.translationToEnglish.put(translation, word);
            this.translationToFinnish.put(word, translation);
        }
    }

    public String translate(String word) {
        String line = "";
        if (this.translationToEnglish.containsKey(word)) {
            line = this.translationToEnglish.get(word);
        } else if (this.translationToFinnish.containsKey(word)) {
            line = this.translationToFinnish.get(word);
        } else {
            line = null;
        }
        return line;
    }

    public void remove(String word) {
        if (this.translationToEnglish.containsKey(word)) {
            this.translationToFinnish.remove(this.translationToEnglish.get(word));
            this.translationToEnglish.remove(word);
        } else if (this.translationToFinnish.containsKey(word)) {
            this.translationToEnglish.remove(this.translationToFinnish.get(word));
            this.translationToFinnish.remove(word);
        }
    }

    public static void main(String[] args) {
//        MindfulDictionary dict = new MindfulDictionary();
//        dict.add("apina", "monkey");
//        dict.add("banaani", "banana");
//        dict.add("apina", "apfe");
//
//        System.out.println(dict.translate("apina"));
//        System.out.println(dict.translate("monkey"));
//        System.out.println(dict.translate("programming"));
//        System.out.println(dict.translate("banana"));

//        MindfulDictionary dict = new MindfulDictionary();
//        dict.add("apina", "monkey");
//        dict.add("banaani", "banana");
//        dict.add("ohjelmointi", "programming");
//        dict.remove("apina");
//        dict.remove("banana");
//
//        System.out.println(dict.translate("apina"));
//        System.out.println(dict.translate("monkey"));
//        System.out.println(dict.translate("banana"));
//        System.out.println(dict.translate("banaani"));
//        System.out.println(dict.translate("ohjelmointi"));
//        MindfulDictionary dict = new MindfulDictionary("src/words.txt");
//        dict.load();
//
//        System.out.println(dict.translate("apina"));
//        System.out.println(dict.translate("ohjelmointi"));
//        System.out.println(dict.translate("alla oleva"));
//        MindfulDictionary dict = new MindfulDictionary("src/words.txt");
//        dict.load();
//
//// using the dictionary
//        dict.save();
//MindfulDictionary s = new MindfulDictionary("test/tmp/tmp78346.txt");
//s.add("tietokone", "computer");
//s.save();
        MindfulDictionary s = new MindfulDictionary("test/words.txt");
        s.load();
        s.translate("olut");
        s.save();
    }
}
