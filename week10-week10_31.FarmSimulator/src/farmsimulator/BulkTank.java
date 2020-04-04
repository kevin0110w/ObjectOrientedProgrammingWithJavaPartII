/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author woohoo
 */
public class BulkTank {

    private double capacity;
    private double volume;

    public BulkTank() {
        this.volume = 0.0;
        this.capacity = 2000.0;
    }

    public BulkTank(double capacity) {
        this.capacity = capacity;
        this.volume = 0.0;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getVolume() {
        return this.volume;
    }

    public double howMuchFreeSpace() {
        return this.capacity - this.volume;
    }

    public void addToTank(double amount) {
        if (amount <= this.capacity - this.volume) {
            this.volume += amount;
        } else {
            this.volume = this.capacity;
        }
    }

    public double getFromTank(double amount) {
        double returnAmount = 0.0;
        if (this.volume <= amount) {
            returnAmount = this.volume;
            this.volume = 0.0;
        } else {
            this.volume -= amount;
            returnAmount = amount;
        }
        return returnAmount;
    }

    @Override
    public String toString() {
        return Math.ceil(this.volume) + "/" + Math.ceil(this.capacity);
    }
}
