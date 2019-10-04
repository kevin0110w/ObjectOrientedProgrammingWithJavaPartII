import java.util.*;

public class TextUserInterface {
    private Scanner s;
    private Dictionary dictionary;
    
    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.s = reader;
        this.dictionary = dictionary;
    }
    
    public void start() {
        String translation = "", finnish = "", translateword =  "";
        System.out.println("Statement: ");
        System.out.println("\t add - adds a word to the dictionary");
        System.out.println("\t translate - asks a word and print its translation");
        System.out.println("\t quit - quit the text user interface");
        
        System.out.println("Statement: ");
        String command = s.nextLine();
        while (!(command.equals("quit"))) {
            if (command.equals("add")) {
            System.out.println("In Finnish: ");
            finnish = s.nextLine();
            System.out.println("Translation: ");
            translation = s.nextLine();
            add(finnish, translation);
        } else if (command.equals("translate")) {
            System.out.println("Give a word: ");
            finnish = s.nextLine();
            System.out.println("Translation: ");
            translateword = translate(finnish);
            System.out.println(translateword);
        } else {
            System.out.println("Unknown Statement");
            System.out.println("");
            
        }
            System.out.println("Statement: ");
            command = s.nextLine();
            }
        System.out.println("Cheers!");
        }
    
    /*
    add asks for a word pair from the user and adds them to the dictionary.
    
    */
    public void add(String word, String translation) {
        this.dictionary.add(word, translation);
    }
    
    /*
    asks a word from the user and it returns the translation.
    */
    public String translate(String word) {
        return this.dictionary.translate(word);
     
    }

}
