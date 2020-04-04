/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Random;

/**
 *
 * @author woohoo
 */
public class Cow implements Milkable, Alive {

    private String name;
    private double capacity;
    private double amount;
    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    public Cow() {
        this.name = NAMES[new Random().nextInt(NAMES.length)];
        this.capacity = 15 + new Random().nextInt(26);
    }

    public Cow(String name) {
        this.name = name;
        this.capacity = 15 + new Random().nextInt(26);
    }

    public String getName() {
        return name;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getAmount() {
        return this.amount;
    }

    @Override
    public String toString() {
        return this.name + " " + Math.ceil(this.amount) + "/" + this.capacity;
    }

    @Override
    public double milk() {
        double vol = this.amount;
        this.amount = 0.0;
        return vol;
    }

    @Override
    public void liveHour() {
        double hourlyProduce = ( 1.0 * (new Random().nextInt(13)) + 7) / 10;
        if (this.amount + hourlyProduce <= this.capacity) {
            this.amount += hourlyProduce;
        } else {
            this.amount = this.capacity;
        }
    }

}
