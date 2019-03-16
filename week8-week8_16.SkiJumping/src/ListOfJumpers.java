
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Freckles
 */
public class ListOfJumpers {
    private ArrayList<Jumpers> list;
    private ArrayList<Integer> judgesVotes;
    
    public ListOfJumpers() {
        this.list = new ArrayList<Jumpers>();
        this.judgesVotes = new ArrayList<Integer>();
    }
    private void setJudgesVotes() {
        int n = 0;
        Random r = new Random();
        
        while (n < 5) {
            int x = r.nextInt(10) + 10;
            this.judgesVotes.add(x);
            n++;
        }
    }
    
    private ArrayList<Integer> getJudgesVotes() {
        return this.judgesVotes;
    }
    
    private ArrayList<Jumpers> getJumpers() {
        return this.list;
    }
    
    
    public String toString() {
        String s = null;
        for (Jumpers jumper : this.list) {
        s = jumper.getName() + " (" + jumper.getPoints() + ")";
        s = s + "\n";
        }
        return s;
    }
}
