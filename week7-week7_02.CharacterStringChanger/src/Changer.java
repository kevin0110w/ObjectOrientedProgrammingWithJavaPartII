
import java.util.ArrayList;
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
public class Changer {
    List<Change> changes;
    
    public Changer() {
        this.changes = new ArrayList<Change>();
    }
    
    public void addChange(Change change) {
        this.changes.add(change);
    }
    
    public String change(String characterString) {
        String duplicate = characterString;
        for (Change aChange : this.changes) {
            duplicate = aChange.change(duplicate);
        }
        return duplicate;
    }
}
