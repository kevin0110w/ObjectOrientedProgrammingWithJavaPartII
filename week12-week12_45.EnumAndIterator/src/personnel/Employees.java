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
 * @author kevin0110w
 */
public class Employees {
    private List<Person> list;
    
    public Employees() {
        this.list = new ArrayList<Person>();
    }
    public void add(Person person) {
        this.list.add(person);
    }
    
    public void add(List<Person> persons) {
        this.list.addAll(persons);
    }
    
    public void print() {
        Iterator it = this.list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
    
    public void print(Education education) {
     Iterator<Person> it = this.list.iterator();
     while (it.hasNext()) {
         Person p = it.next();
         if (p.getEducation().equals(education)) {
             System.out.println(p);
            }
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> it = this.list.iterator();
        while (it.hasNext()) {
            Person p = it.next();
            if (p.getEducation().equals(education)) {
                it.remove();
            }
        }
    }
}
