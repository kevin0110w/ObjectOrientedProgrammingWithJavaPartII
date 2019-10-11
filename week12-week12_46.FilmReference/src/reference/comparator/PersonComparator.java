/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import reference.domain.Person;

/**
 *
 * @author woohoo
 */
public class PersonComparator implements Comparator<Person> {
    private Map<Person, Integer> peopleIdentities;
    
    public PersonComparator(Map<Person, Integer> peopleIdentities) {
        this.peopleIdentities = new HashMap<Person, Integer>(peopleIdentities);
        
    }
    
    @Override
    public int compare(Person t, Person t1) {
        if (this.peopleIdentities.get(t) > this.peopleIdentities.get(t1)) {
            return -1;
        } else if (this.peopleIdentities.get(t) < this.peopleIdentities.get(t1)) {
            return 1;
        } else {
            return 0;
        }
    }
}
