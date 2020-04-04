/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

/**
 *
 * @author woohoo
 */
public class ProductContainerRecorder extends ProductContainer {
    private ContainerHistory history;
    
    public ProductContainerRecorder(String productName, double capacity, double initialVolume) {
        super(productName, capacity);
        super.addToTheContainer(initialVolume);
        this.history = new ContainerHistory();
        this.history.add(initialVolume);
    }
    
    public void addToTheContainer(double amount) {
        super.addToTheContainer(amount);
        this.history.add(this.getVolume());
    }
    
    public double takeFromTheContainer(double amount) {
        double vol = super.takeFromTheContainer(amount);
        this.history.add(this.getVolume());
        return vol;
    }
    
    public String history() {
        return this.history.toString();
    }
    
    public ContainerHistory getHistory() {
        return this.history;
    }
    
    public void printAnalysis() {
        System.out.println("Product: " + this.getName());
        System.out.println("History: " + this.history());
        System.out.println("Greatest product amount: " + this.getHistory().maxValue());
        System.out.println("Smallest product amount: " + this.getHistory().minValue());
        System.out.println("Average: " + this.getHistory().average());
        System.out.println("Greatest change: " + this.getHistory().greatestFluctuation());
        System.out.println("Variance: " + this.getHistory().variance());
        
    }
    
    
}
