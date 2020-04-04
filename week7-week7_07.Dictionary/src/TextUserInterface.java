
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author woohoo
 */
public class TextUserInterface {

    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start() {
        printSelection();
        handleInput();
    }

    public void add() {
        System.out.print("In Finnish: ");
        String word = this.reader.nextLine();
        System.out.print("Translation: ");
        String translation = this.reader.nextLine();
        this.dictionary.add(word, translation);
    }

    public void translate() {
        System.out.print("Give a word: ");
        String word = this.reader.nextLine();
        String translation = this.dictionary.translate(word);
        System.out.print("Translation: " + translation);
    }

    private void printSelection() {
        System.out.println("Statements:");
        System.out.println("  add - adds a word pair to the dictionary");
        System.out.println("  translate - asks a word and prints its translation");
        System.out.println("  quit - quit the text user interface");
        System.out.println("");
    }

    private void handleInput() {
        String statement = "";
        while (!(statement.equals("quit"))) {
            System.out.print("Statement: ");
            statement = this.reader.nextLine();
            switch (statement.toLowerCase()) {
                case "quit":
                    System.out.println("Cheers!");
                    break;
                case "add":
                    this.add();
                    System.out.println("");
                    break;
                case "translate":
                    this.translate();
                    System.out.println("");
                    break;
                default:
                    System.out.println("Unknown statement");
                    System.out.println("");
                    break;
            }
        }
    }
}
