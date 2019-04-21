/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

public class BulkTank {

    private double capacity;
    private double volume;

    public BulkTank() {
        this.capacity = 2000;
        this.volume = 0;
    }

    public BulkTank(double capacity) {
        this.capacity = capacity;
        this.volume = 0;
    }

    public double getCapacity() {
        return this.capacity;
    }

    public double getVolume() {
        return this.volume;
    }

    public double howMuchFreeSpace() {
        return this.capacity - this.volume;
    }

    public void addToTank(double amount) {
        this.volume += amount;
        if (this.volume >= this.capacity) {
            this.volume = this.capacity;
        }
    }

    public double getFromTank(double amount) {
        if (this.volume > amount) {
            this.volume -= amount;
            return amount;
        } else {
            double amounttoreturn = amount - this.volume;
            this.volume = 0;
            return amounttoreturn;
        }
    }

    public String toString() {
        return Math.ceil(this.volume) + "/" + Math.ceil(this.capacity);
    }

    public static void main(String[] args) {
        BulkTank tank = new BulkTank();
        tank.getFromTank(100);
        tank.addToTank(25);
        tank.getFromTank(5);
        System.out.println(tank);

        tank = new BulkTank(50);
        tank.addToTank(100);
        System.out.println(tank);
    }
}
