/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Collection;

/**
 *
 * @author woohoo
 */
public class Barn {
    private BulkTank tank;
    private MilkingRobot robot;

    public Barn(BulkTank tank) {
        this.tank = tank;
        this.robot = null;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.robot = milkingRobot;
        this.robot.setBulkTank(this.tank);
    }
    
    public void takeCareOf(Cow cow) {
        if (this.robot == null) {
            throw new IllegalStateException();
        }
        
        this.robot.milk(cow);
    }
    
    public void takeCareOf(Collection<Cow> cows) {
         if (this.robot == null) {
            throw new IllegalStateException();
        }
         
         for (Cow c : cows) {
             this.robot.milk(c);
         }
         
    }
    public BulkTank getBulkTank() {
        if (this.tank == null) {
            throw new IllegalStateException();
        }
        return this.tank;
    }
    public String toString() {
        return  Math.ceil(this.tank.getVolume()) + "/" + this.tank.getCapacity();
    }
}
