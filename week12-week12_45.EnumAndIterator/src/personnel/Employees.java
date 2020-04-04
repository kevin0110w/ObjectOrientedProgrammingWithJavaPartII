/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author woohoo
 */
public class Employees {

    private List<Person> employees;

    public Employees() {
        this.employees = new ArrayList<>();
    }

    public void add(Person person) {
        if (person == null) {
            return;
        }

        this.employees.add(person);
    }

    public void add(List<Person> persons) {
        if (persons.isEmpty()) {
            return;
        }

        this.employees.addAll(persons);
    }

    public void print() {
        Iterator<Person> personIterator = this.employees.iterator();
        while (personIterator.hasNext()) {
            System.out.println(personIterator.next());
        }
    }
    
    public void print(Education education) {
        Iterator<Person> personIterator = this.employees.iterator();
        while (personIterator.hasNext()) {
            Person p = personIterator.next();
            if (p.getEducation() == education) {
                System.out.println(p);
            }
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> personIterator = this.employees.iterator();
        while (personIterator.hasNext()) {
            Person p = personIterator.next();
            if (p.getEducation() == education) {
                personIterator.remove();
            }
        }
    }
}
