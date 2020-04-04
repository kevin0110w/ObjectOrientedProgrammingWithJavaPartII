
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author woohoo
 */
public class PromissoryNote {

    private Map<String, Double> people;

    public PromissoryNote() {
        this.people = new HashMap<String, Double>();
    }

    public void setLoan(String toWhom, double value) {

        this.people.put(toWhom, value);
    }

    public double howMuchIsTheDebt(String whose) {
        if (!this.people.containsKey(whose)) {
            return 0.0;
        }
        return this.people.get(whose);
    }
}
