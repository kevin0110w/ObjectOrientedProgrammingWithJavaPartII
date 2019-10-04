/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Freckles
 */
public class Farm implements Alive {
    private String owner;
    private Barn barn;
    private Collection<Cow> cows; 
    
    public Farm(String name, Barn barn) {
        this.owner = name;
        this.barn = barn;
        this.cows = new LinkedList<Cow>();
    }
    
    @Override
    public void liveHour() {
        for (Cow cow:this.cows) {
            cow.liveHour();
        }
    }
    
    public void manageCows() {
        for (Cow cow : cows) {
            this.barn.takeCareOf(cow);
        }
    }
    
    public String toString() {
        String s = "";
        s = s + "Farm owner: " + this.getOwner() + "\n";
        s = "Barn bulk tank: " + this.barn.toString();
        s = s + "\n";
        
        if (this.cows.size() > 0) {
            s = s + "Animals: " + "\n";
            for (Cow cow : this.cows) {
                s = s + "\t" + cow.toString() + "\n";
            }
        } else {
            s = s + "No cows.";
        }
        return s;
    }
    
    public String getOwner() {
        return this.owner;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.barn.installMilkingRobot(milkingRobot);
    }
    
    public void addCow(Cow cow) {
        this.cows.add(cow);
    }
    
    public static void main(String[] args) {
        Farm farm = new Farm("Esko", new Barn(new BulkTank()));

        farm.addCow(new Cow());
        farm.addCow(new Cow());
        farm.addCow(new Cow());

        farm.liveHour();
        farm.liveHour();
        System.out.println(farm);
    }
}
