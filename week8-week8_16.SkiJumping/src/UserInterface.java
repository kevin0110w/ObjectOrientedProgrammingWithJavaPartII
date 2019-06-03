import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private GameManager logic;
    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.logic = new GameManager(scanner);
    }
    
    public void play() {
        System.out.println("Kumpula ski jumping week");
        System.out.println();
        this.getPlayers();
        System.out.println();
        System.out.println("The tournament begins!");
        System.out.println("");
        do {
        System.out.print("Write \"jump\" to jump; otherwise you quit: ");
        String command = this.scanner.nextLine().toUpperCase();
        if (command.equals("QUIT")) {
            break;
        }
        System.out.println();
        this.getJumperOrder();
        this.getResults();
        } while (true);
        this.logic.scores();
       
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
            this.logic.addJumper(new Jumper(jumpersName));
        } while (true); 
    }
    
    public void getJumperOrder() {
            System.out.println("Round " + this.logic.getRound());
            System.out.println();
            System.out.println("Jumping order: ");
            int numberOfJumpers = this.logic.getJumpers().size();
            for (int i = 0; i < numberOfJumpers; i++) {
                System.out.println("  " + (i+1) + ". " + this.logic.getJumpers().get(i));
            }
            System.out.println("");
    }
    
    public void getResults(){
        System.out.println("Results of round " + this.logic.getRound());
            for (int i = 0; i < this.logic.getJumpers().size(); i++) {
                System.out.println("  " + this.logic.getJumpers().get(i).getName());
                int jump = this.logic.getJumpersJump();
                System.out.println("    length: " + jump);
                this.logic.getJumpers().get(i).addDistance(jump);
                ArrayList<Integer> judgesVotes = new ArrayList<Integer>();
                judgesVotes = this.logic.getJudgesScores();
                System.out.print("    judge votes: " + judgesVotes);
                Collections.sort(judgesVotes);
                this.logic.getJumpers().get(i).setPoints(jump + judgesVotes.get(1) + judgesVotes.get(2) + judgesVotes.get(3));
                System.out.println();
            }   
            this.logic.incRound();
            System.out.println();
    }
}
