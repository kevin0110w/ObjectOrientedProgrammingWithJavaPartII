/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker.applicationlogic;

/**
 *
 * @author kevin0110w
 */
public class PersonalCalculator implements Calculator {
    private int value;
    
    public PersonalCalculator() {
        this.value = 0;
    }
    @Override
    public int giveValue() {
       return this.value;
    }

    @Override
    public void increase() {
        this.value++;
    }
    
    public static void main(String[] args) {
          Calculator calc = new PersonalCalculator();
        System.out.println("Value: " + calc.giveValue());
        calc.increase();
        System.out.println("Value: " + calc.giveValue());
        calc.increase();
        System.out.println("Value: " + calc.giveValue());
    }
    
}
