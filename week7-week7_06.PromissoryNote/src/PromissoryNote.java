
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Freckles
 */
public class PromissoryNote {
    private HashMap<String, Double> debts;
    /*
    creates a new promissory note
    */
    public PromissoryNote() {
        this.debts = new HashMap<String, Double>();
    }
    /*
    stores the information about loans to specific people.
    */
    public void setLoan(String toWhome, double value) {
        if (this.debts.containsKey(toWhome)) {
            this.debts.replace(toWhome, value);
    } else {
            this.debts.put(toWhome, value);
        }
    }
    /*
     returns the entity of the debt held by the parameter person
    */
    public double howMuchIsTheDebt(String whose) {
        if (this.debts.containsKey(whose)) {
            return this.debts.get(whose);
    }
        return 0;
    }
}