package wordinspection;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        // test your code here

        File file = new File("src/shortList.txt");
        // all words are in file src/wordList.txt
        WordInspection s = new WordInspection(file);
        System.out.println(s.wordCount());// expected:<24> but was:<20>  
        int i = 0;
        for (String d : s.getLines()) {
            System.out.println(d);
            i++;
    }
        System.out.println(i);
}
}
