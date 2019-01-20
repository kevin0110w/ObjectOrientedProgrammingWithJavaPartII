import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Hand implements Comparable<Hand>  {
    private ArrayList<Card> hand;
    
    public Hand(){
        this.hand = new ArrayList<Card>();
    }
    public void add(Card card) {
        this.hand.add(card);
    }
    
    public void print() {
        for (Card x: this.hand) {
            System.out.println(x);
        }
    }
    
    public void sort() {
        
        Collections.sort(this.hand);
        
        }

    @Override
    public int compareTo(Hand o) {
        int sum = 0;
        for (Card x: this.hand) {
            sum += x.getValue();
        }
        int osum = 0;
        for (Card p : o.hand) {
            osum += p.getValue();
        }
        
        if (sum - osum < 0) {
            return -1;
        } else if (sum - osum > 0) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public void sortAgainstSuit() {
        Collections.sort(this.hand, new SortAgainstSuitAndValue());
    }
    
    
}

