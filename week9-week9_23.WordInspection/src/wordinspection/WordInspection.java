/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Freckles
 */
public class WordInspection {
    private Scanner reader;
    private ArrayList<String> lines;
    private List<String> zList, lList, palindromeList, wordsWhichContainAllVowelsList;
    
    public WordInspection(File file) throws Exception {
        this.reader = new Scanner(file, "UTF-8");
        this.lines = new ArrayList<String>();
        this.zList = new ArrayList<String>();
        this.lList = new ArrayList<String>();
        this.palindromeList = new ArrayList<String>();
        this.wordsWhichContainAllVowelsList = new ArrayList<String>();
        read();
        }
    
    public ArrayList<String> getLines() {
        return this.lines;
    }
    public void read() {
        while (this.reader.hasNextLine()) {
            String line = this.reader.nextLine();
            this.lines.add(line);
            if (line.indexOf('z') >= 0) {
                zList.add(line);
            }
            if (line.endsWith("l")) {
                lList.add(line);
            }
            if (isPalindrome(line)) {
                this.palindromeList.add(line);
            }

            if (containsAllVowels(line)) {
                this.wordsWhichContainAllVowelsList.add(line);
            }
        }
    }
    
    public int wordCount() {
        System.out.println(this.lines.size());
        return this.lines.size();
        
    }
    
    public List<String> wordsContainingZ() {
        return this.zList;
    }
    
    public List<String> wordsEndingInL() {
        return this.lList;
    }
    
    public List<String> palindromes() {
        return this.palindromeList;
    }
    
    public List<String>wordsWhichContainAllVowels() {
        return this.wordsWhichContainAllVowelsList;
    }
    
    public boolean isPalindrome(String string) {
        String reversed = "";
        for (int i = string.length()-1; i >= 0; i--) {
            reversed = reversed + string.charAt(i);
        }
        if (string.equals(reversed)) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean containsAllVowels(String string) {
        boolean check = false;
        String vowels = "aeiouyäö";
        for (int i = 0; i < vowels.length(); i++) {
            for (int j = 0; j < string.length(); j++) {
                if (vowels.charAt(i) == string.charAt(j)) {
                    check = true;
                    j = string.length();
                } else { 
                    check = false;
                }
            }
            if (!check) {
                break;
            }
        }

        return check;
    }
}
