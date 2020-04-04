/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author woohoo
 */
public class WordInspection {

    private File file;
    private Scanner reader;
    private int wordCount;
    private List<String> wordsContainingZ;
    private List<String> wordsEndingInL;
    private List<String> palindromes;
    private List<String> allVowels;
    private List<String> allWords;

    public WordInspection(File file) throws Exception {
        this.file = file;
        this.wordCount = 0;
        this.reader = new Scanner(this.file, "UTF-8");
        this.wordsContainingZ = new ArrayList<>();
        this.wordsEndingInL = new ArrayList<>();
        this.palindromes = new ArrayList<>();
        this.allVowels = new ArrayList<>();
        this.allWords = new ArrayList<>();
        this.readFile();
    }

    public int wordCount() {
        return this.allWords.size();
    }

    public List<String> wordsContainingZ() {
        return this.wordsContainingZ;
    }

    public List<String> wordsEndingInL() {
        return this.wordsEndingInL;
    }

    public List<String> palindromes() {
        return this.palindromes;
    }

    public List<String> wordsWhichContainAllVowels() {
        return this.allVowels;
    }

    private void readFile() {
        while (this.reader.hasNext()) {
            String line = this.reader.nextLine();
            allWords.add(line);
        }
        checkWords();
    }

    private void checkWord(String word) {
        checkWordContainsZ(word);
        checkWordEndingInL(word);
        checkWordIsPallindrome(word);
        checkWordContainsAllVowels(word);
    }

    private void checkWordContainsZ(String word) {
        if (!checkWordLengthGreaterThanZero(word)) {
            return;
        }
        if (word.indexOf("z") >= 0 || word.indexOf("Z") >= 0) {
            this.wordsContainingZ.add(word);
        }
    }

    private void checkWordEndingInL(String word) {
        if (!checkWordLengthGreaterThanZero(word)) {
            return;
        }

        String lastLetter = word.substring(word.length() - 1);

        if (lastLetter.equals("l") || lastLetter.equals("L")) {
            this.wordsEndingInL.add(word);
        }
    }

    private void checkWordIsPallindrome(String word) {
        if (!checkWordLengthGreaterThanZero(word)) {
            return;
        }

        for (int i = 0; i < word.length() / 2; i++) {
            if (!(word.charAt(i) == word.charAt(word.length() - (i + 1)))) {
                return;
            }
        }
        this.palindromes.add(word);
    }

    private void checkWordContainsAllVowels(String word) {
        if (!checkWordLengthGreaterThanZero(word)) {
            return;
        }
        Map<Character, Character> vowels = setUpVowelsDict();

        for (Character character : vowels.keySet()) {
            if (word.indexOf(character) < 0) {
                return;
            }
        }
        this.allVowels.add(word);
    }

    private boolean checkWordLengthGreaterThanZero(String word) {
        return word.length() > 0;
    }

    private Map<Character, Character> setUpVowelsDict() {
        String vowelsString = "aeiouyäö";
        Map<Character, Character> vowelsDict = new HashMap<Character, Character>();
        for (int i = 0; i < vowelsString.length(); i++) {
            vowelsDict.put(vowelsString.charAt(i), vowelsString.charAt(i));
        }
        return vowelsDict;
    }

    private void checkWords() {
        for (String w : this.allWords) {
            checkWord(w);
        }
    }
}
