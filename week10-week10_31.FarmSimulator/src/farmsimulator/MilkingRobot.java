/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

public class MilkingRobot {

    private BulkTank tank;

    public MilkingRobot() {

    }

    public BulkTank getBulkTank() {
        if (this.tank == null) {
            return null;
        } else {
            return this.tank;
        }
    }

    public void setBulkTank(BulkTank tank) {
        this.tank = tank;
    }

    public void milk(Milkable milkable) {
        if (this.tank == null) {
            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        }
        tank.addToTank(milkable.milk());
    }

    public static void main(String[] args) {
        MilkingRobot milkingRobot = new MilkingRobot();
        Cow cow = new Cow();
        System.out.println("");

        BulkTank tank = new BulkTank();
        milkingRobot.setBulkTank(tank);
        System.out.println("Bulk tank: " + tank);

        for (int i = 0; i < 2; i++) {
            System.out.println(cow);
            System.out.println("Living..");
            for (int j = 0; j < 5; j++) {
                cow.liveHour();
            }
            System.out.println(cow);

            System.out.println("Milking...");
            milkingRobot.milk(cow);
            System.out.println("Bulk tank: " + tank);
            System.out.println("");
        }
    }
}
