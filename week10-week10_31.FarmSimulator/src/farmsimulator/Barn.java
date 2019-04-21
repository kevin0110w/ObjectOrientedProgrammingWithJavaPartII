/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Collection;
import java.util.LinkedList;

public class Barn {

    private BulkTank tank;
    private MilkingRobot robot;

    public Barn(BulkTank tank) {
        this.tank = tank;
    }

    public BulkTank getBulkTank() {
        return this.tank;
    }

    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.robot = milkingRobot;
        this.robot.setBulkTank(this.tank);
    }

    public void takeCareOf(Cow cow) {
        if (this.robot == null) {
            throw new IllegalStateException("The milking robot hasn't been installed");
        } else {
            this.robot.milk(cow);
        }
    }

    public void takeCareOf(Collection<Cow> cows) {
        if (this.robot == null) {
            throw new IllegalStateException("The milking robot hasn't been installed");
        }
        for (Cow cow : cows) {
            this.robot.milk(cow);
        }
    }

    public String toString() {
        return this.tank.toString();
    }

    public static void main(String[] args) {
        Barn barn = new Barn(new BulkTank());
        System.out.println("Barn: " + barn);

        MilkingRobot robot = new MilkingRobot();
        barn.installMilkingRobot(robot);

        Cow ammu = new Cow();
        ammu.liveHour();
        ammu.liveHour();

        barn.takeCareOf(ammu);
        System.out.println("Barn: " + barn);

        LinkedList<Cow> cowList = new LinkedList<Cow>();
        cowList.add(ammu);
        cowList.add(new Cow());

        for (Cow cow : cowList) {
            cow.liveHour();
            cow.liveHour();
        }

        barn.takeCareOf(cowList);
        System.out.println("Barn: " + barn);
    }
}
