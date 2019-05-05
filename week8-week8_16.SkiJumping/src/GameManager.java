import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class GameManager {
    private ArrayList<Jumper> jumpers;
    private Random jumperRandom, judgesRandom;
    private Scanner scanner;
    private int round;
    
    public GameManager() {
        this.jumpers = new ArrayList<Jumper>();
        this.judgesRandom = new Random();
        this.jumperRandom = new Random();
        this.scanner = new Scanner(System.in);
        this.round = 1;
    }
    
    public ArrayList<Integer> getJudgesScores() {
        ArrayList<Integer> judgesScores = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            int score = this.judgesRandom.nextInt(11) + 10;
            judgesScores.add(score);
        }
        return judgesScores;
    }
    
    public int getJumpersJump() {
        int jump = this.jumperRandom.nextInt(61) + 60;
        return jump;
    }
    
    public void getPlayers() {
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        String jumpersName = "";
        
        do {
            System.out.print("  Participant name: ");
            jumpersName = this.scanner.nextLine();
            if (jumpersName.equals("")) {
                break;
            }
            this.jumpers.add(new Jumper(jumpersName));
        } while (!jumpersName.equals("")); 
    }
    
    public void play() {
        System.out.println("Kumpula ski jumping week");
        System.out.println();
        getPlayers();
        System.out.println();
        System.out.println("The tournament begins!");
        System.out.println("");
        System.out.print("Write \"jump\" to jump; otherwise you quit: ");
        String command = this.scanner.nextLine();
        System.out.println("");
        rounds(command);
        scores();
    }
    
    public void rounds(String command) {
       while (command.equals("jump")) {
            System.out.println("Round " + this.round);
            System.out.println("");
            System.out.println("Jumping order: ");
            for (int i = 0; i < this.jumpers.size(); i++) {
                System.out.println("  " + (i+1) + ". " + this.jumpers.get(i));
            }
            System.out.println("");
            System.out.println("Results of round " + this.round);
            for (int i = 0; i < this.jumpers.size(); i++) {
                System.out.println("  " + this.jumpers.get(i).getName());
                int jump = getJumpersJump();
                System.out.println("    length: " + jump);
                this.jumpers.get(i).addDistance(jump);
                ArrayList<Integer> judgesVotes = new ArrayList<Integer>();
                judgesVotes = getJudgesScores();
                System.out.print("    judge votes: " + judgesVotes);
                Collections.sort(judgesVotes);
                this.jumpers.get(i).setPoints(jump + judgesVotes.get(1) + judgesVotes.get(2) + judgesVotes.get(3));
                System.out.println();
            }   
            this.round++;
            System.out.println();
            System.out.print("Write 'jump' to jump; otherwise you quit: ");
            command = this.scanner.nextLine();
//            System.out.print();
        }
    }
    
    public void scores() {
        System.out.println();
        System.out.println("Thanks!");
        System.out.println();
        System.out.println("Tournament results: ");
        System.out.println("Position   Name");
        for (int i = 0; i < this.jumpers.size(); i++) {
            System.out.println((i+1) + "           " + this.jumpers.get(i) + "\n             jump lengths: " + this.jumpers.get(i).getDistancesString());
        }
    }
}
