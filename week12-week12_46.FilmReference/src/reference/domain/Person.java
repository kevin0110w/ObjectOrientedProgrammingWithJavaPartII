/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.domain;

/**
 *
 * @author kevin0110w
 */
public class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String toString() {
        return this.name;
    }
    
    
    public boolean equals(Person other) {
        return this.name.equals(other.getName());
    }
        public int hashCode() {
        return this.name.hashCode();
    }
}
