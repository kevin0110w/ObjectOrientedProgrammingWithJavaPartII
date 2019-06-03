import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class GameManager {
    private ArrayList<Jumper> jumpers;
    private Random jumperRandom, judgesRandom;
    private Scanner scanner;
    private int round;
    
    public GameManager(Scanner scanner) {
        this.jumpers = new ArrayList<Jumper>();
        this.judgesRandom = new Random();
        this.jumperRandom = new Random();
        this.scanner = scanner;
        this.round = 1;
    }
    
    public void scores() {
        System.out.println();
        System.out.println("Thanks!");
        System.out.println();
        System.out.println("Tournament results: ");
        System.out.println(String.format("%-12s", "Position") +  "Name");
        for (int i = 0; i < this.jumpers.size(); i++) {
            System.out.println(String.format("%-12d", i+1) + this.jumpers.get(i));
            System.out.println("            " + "jump lengths: " + this.jumpers.get(i).getDistancesString());
        }
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

    public void addJumper(Jumper jumper) {
        this.jumpers.add(jumper);
    }
    
    public int getRound() {
        return this.round;
    }
    
    public ArrayList<Jumper> getJumpers() {
        return this.jumpers;
    }

    void incRound() {
        this.round++;
    }
}
