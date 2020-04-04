
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author woohoo
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author woohoo
 */
public class JumpingInterface {

    public JumpingInterface() {

    }

    void printWelcome() {
        System.out.println("Kumpula ski jumping week");
        System.out.println("");
    }

    void printJumperCommand() {
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
    }

    void printJumpingCommencementMessage() {
        System.out.println("");
        System.out.println("The tournament begins!");
        System.out.println("");
    }

    void printRound(String round) {
        System.out.println("Round " + round);
        System.out.println("");
    }

    void printJumperOrder(List<Jumper> jumpers) {
        System.out.println("Jumping order:");
        int i = 1;
        for (Jumper j : jumpers) {
            System.out.println("  " + i + ". " + j.toString());
            i++;
        }
        System.out.println("");
    }

    void printResultsOfRound(String round, List<Jumper> jumpers, Map<Jumper, List<Integer>> judgesScores, Map<Jumper, Integer> roundJump) {
        System.out.println("Results of round " + round);
        for (Jumper jumper : jumpers) {
            System.out.println("  " + jumper.getName());
            System.out.println("    length: " + roundJump.get(jumper));
            System.out.println("    judge votes: " + judgesScores.get(jumper));
            
        }
        System.out.println("");
    }

    void printThanks() {
        System.out.println("Thanks!");
        System.out.println("");
    }

    void printResults(List<Jumper> jumpers) {
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        int i = 1;
        for (Jumper j : jumpers) {
            System.out.println(i + "           " + j);
            System.out.println("            jump lengths: " + j.getJumpsString());
            i++;
        }
        
    }

}
