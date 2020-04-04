
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author woohoo
 */
public class JumpingLogic {

    private List<Jumper> jumpers;
    private Random rand;
    private int round;
    private Map<Jumper, List<Integer>> judgesScore;
    private Map<Jumper, Integer> roundJump;

    public JumpingLogic() {
        this.jumpers = new ArrayList<Jumper>();
        this.rand = new Random();
        this.round = 1;
        this.judgesScore = new HashMap<Jumper, List<Integer>>();
        this.roundJump = new HashMap<Jumper, Integer>();
    }

    public void incrementRound() {
        this.round++;
    }

    public void addJumper(String name) {
        this.jumpers.add(new Jumper(name));
    }

    public void generateJumpScore(Jumper jumper) {
        int score = rand.nextInt(60) + 60;
        jumper.addJump(score);
        jumper.setPoints(score);
        this.roundJump.put(jumper, score);
    }

    public void generateJudgesScores(Jumper jumper) {
        List<Integer> judgeScores = new ArrayList<Integer>();
        int i = 0;
        while (i < 5) {
            int score = rand.nextInt(10) + 10;
            judgeScores.add(score);
            i++;
        }
        this.judgesScore.put(jumper, judgeScores);
        Collections.sort(judgeScores);
        jumper.setPoints(judgeScores.get(1));
        jumper.setPoints(judgeScores.get(2));
        jumper.setPoints(judgeScores.get(3));
    }

    public void generatePlayerJumps() {
        for (Jumper j : this.jumpers) {
            this.generateJumpScore(j);
            this.generateJudgesScores(j);
        }
    }
    
    public void sortJumpers() {
        Collections.sort(this.jumpers);
    }

    public String getRound() {
        return Integer.toString(this.round);
    }
    
    public List<Jumper> getJumpers() {
        return this.jumpers;
    }
    
    public Map<Jumper, List<Integer>> getJudgesScores() {
        return this.judgesScore;
    }
    
    public Map<Jumper, Integer> getRoundJump() {
        return this.roundJump;
    }

    void sortJumpersByHighestScores() {
       Collections.sort(jumpers, new SortJumpersByHighScore());
    }
}
