/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author woohoo
 */
public class Farm implements Alive {

    private String owner;
    private Barn barn;
    private List<Cow> cows;

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        this.cows = new ArrayList<>();
    }

    public void manageCows() {
        this.barn.takeCareOf(cows);
    }

    public String getFarmOwnerString() {
        return this.owner + "\n";
    }

    public String getBarnInfoString() {
        return "Barn bulk tank: " + this.barn + "\n";
    }

    public String getCowInfoString() {
        String w = "";
        if (this.cows.size() == 0) {
            w += "No cows.";
        } else {
            w += "Animals:";
            for (int i = 0; i < this.cows.size(); i++) {
                if (i == this.cows.size() - 1) {
                    w += "        " + this.cows.get(i);
                } else {
                    w += "        " + this.cows.get(i) + " ";
                }
            }
        }
        return w;
    }

    public void installMilkingRobot(MilkingRobot r) {
        this.barn.installMilkingRobot(r);
    }
    
    @Override
    public String toString() {
        String s = "";
        s += getFarmOwnerString();
        s += getBarnInfoString();
        s += getCowInfoString();
        return s;
    }

    public void addCow(Cow c ){
        this.cows.add(c);
    }
    public String getOwner() {
        return owner;
    }

    public Barn getBarn() {
        return barn;
    }

    public List<Cow> getCows() {
        return cows;
    }

    @Override
    public void liveHour() {
        for (Cow c : cows) {
            c.liveHour();
        }

    }

}
