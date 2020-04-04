package wordinspection;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        // test your code here

        File file = new File("src/shortList.txt");
        // all words are in file src/wordList.txt
        WordInspection w = new WordInspection(file);
        for (String x : w.wordsContainingZ()) {
            System.out.println(x);
        }
//        System.out.println(w.wordCount());
//        System.out.println(w.wordsContainingZ().size());
        
//        for (String s : w.wordsContainingZ()) {
//            System.out.println(s);
//        }
//        
//        for (String s : w.wordsEndingInL()) {
//            System.out.println(s);
//        }

//        for (String s : w.wordsWhichContainAllVowels()) {
//            System.out.println(s);
//        }
    }
}
