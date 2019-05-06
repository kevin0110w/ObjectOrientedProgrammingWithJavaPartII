/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import reference.domain.Person;

/**
 *
 * @author kevin0110w
 */
public class PersonComparator implements Comparator<Person>{
    private Map<Person, Integer> peopleIdentities;
    public PersonComparator(Map<Person, Integer> peopleIdentities) {
        this.peopleIdentities = peopleIdentities;
    }
    @Override
    public int compare(Person o1, Person o2) {
       return (-1) * o1.getName().compareTo(o2.getName());
    }

    public static void main(String[] args) {
         Person matti = new Person("Matti");
    Person pekka = new Person("Pekka");
    Person mikke = new Person("Mikke");
    Person thomas = new Person("Thomas");

    Map<Person, Integer> peopleIdentities = new HashMap<Person, Integer>();
    peopleIdentities.put(matti, 42);
    peopleIdentities.put(pekka, 134);
    peopleIdentities.put(mikke, 8);
    peopleIdentities.put(thomas, 82);

    List<Person> ppl = Arrays.asList(matti, pekka, mikke, thomas);
    System.out.println("People before sorting: " + ppl);

    Collections.sort(ppl, new PersonComparator(peopleIdentities));
    System.out.println("People after sorting: " + ppl);
    }
    
}
