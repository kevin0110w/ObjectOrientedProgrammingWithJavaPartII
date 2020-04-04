
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author woohoo
 */
public class Hand implements Comparable<Hand> {
    private List<Card> hand;

    public Hand() {
        this.hand = new ArrayList<Card>();
    }
    
    
    public void add(Card card) {
        this.hand.add(card);
    }
    
    public void print() {
        for (int i = 0; i < this.hand.size(); i++) {
            System.out.println(this.hand.get(i));
        }
    }
    
    public void sort() {
        Collections.sort(this.hand);
    }

    @Override
    public int compareTo(Hand o) {
        int value = 0;
        for (Card x : this.hand) {
            value += x.getValue();
        }
        
        int otherValue = 0;
        for (Card y : o.hand) {
            otherValue += y.getValue();
        }
        
        return value - otherValue;
    }
    
    public void sortAgainstSuit() {
        Collections.sort(this.hand, new SortAgainstSuitAndValue());
    }
}
