/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;
import java.util.Random;

public class Cow implements Milkable, Alive { 
    private String name;
    private Random random = new Random();
    private double amount;
    private double capacity;
    
    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
    public Cow() {
        this.name = NAMES[random.nextInt(30)];
        this.capacity = random.nextInt(26) + 15;
    }
    
    public Cow(String name) {
        this.name = name;
        this.capacity = random.nextInt(26) + 15;
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getCapacity() {
        return this.capacity;
    }
    public double getAmount() {
        return this.amount;
    }
    
   public String toString() {
     return this.name + " "  + Math.ceil(this.amount) + "/" + this.capacity;
   }

    @Override
    public double milk() {
        double milk = this.amount;
        this.amount = 0;
        return milk;
    }

    @Override
    public void liveHour() {
       double milk = (random.nextDouble() * (2-0.7) + 0.7);
       this.amount += milk;
       if (this.amount >= this.capacity) {
           this.amount = this.capacity;
       }
    }
    
    public static void main(String[] args) {
        Cow cow = new Cow();
        System.out.println(cow);

        Alive livingCow = cow;
        livingCow.liveHour();
        livingCow.liveHour();
        livingCow.liveHour();
        livingCow.liveHour();

        System.out.println(cow);

        Milkable milkingCow = cow;
        milkingCow.milk();

        System.out.println(cow);
        System.out.println("");

        cow = new Cow("Ammu");
        System.out.println(cow);
        cow.liveHour();
        cow.liveHour();
        System.out.println(cow);
        cow.milk();
        System.out.println(cow);
    }
}
