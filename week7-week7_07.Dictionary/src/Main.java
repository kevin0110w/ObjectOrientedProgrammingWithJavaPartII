
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Dictionary dictionary = new Dictionary();
//    dictionary.add("apina", "monkey");
//    dictionary.add("banaani", "banana");
//    dictionary.add("cembalo", "harpsichord");
//
//    System.out.println(dictionary.translate("apina"));
//    System.out.println(dictionary.translate("porkkana"));

//    Dictionary dictionary = new Dictionary();
//    dictionary.add("apina", "monkey");
//    dictionary.add("banaani", "banana");
//    System.out.println(dictionary.amountOfWords());
//
//    dictionary.add("cembalo", "harpsichord");
//    System.out.println(dictionary.amountOfWords());
//  Dictionary dictionary = new Dictionary();
//    dictionary.add("apina", "monkey");
//    dictionary.add("banaani", "banana");
//    dictionary.add("cembalo", "harpsichord");
//
//    ArrayList<String> translations = dictionary.translationList();
//    for(String translation: translations) {
//        System.out.println(translation);
//    }  
    Scanner reader = new Scanner(System.in);
    Dictionary dict = new Dictionary();
//
    TextUserInterface ui = new TextUserInterface(reader, dict);
    ui.start();
                
    }
}
