
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author woohoo
 */
public class Jumper implements Comparable<Jumper>{
    private String name;
    private int points;
    private List<Integer> jumps;

    public Jumper(String name) {
        this.name = name;
        this.points = 0;
        this.jumps = new ArrayList<Integer>();
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(int points) {
        this.points += points;
    }
    
    public void addJump(int jump) {
        this.jumps.add(jump);
    }

    @Override
    public String toString() {
        return this.name + " (" + this.points + " points)";
    }    

    @Override
    public int compareTo(Jumper o) {
        if (this.points < o.getPoints()) {
            return -1;
        } else if (this.points > o.getPoints()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int hashCode() {
        if (this.name == null) {
            return 7;
        }
        
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jumper other = (Jumper) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    String getJumpsString() {
        String jumpString = "";
        for (int i = 0; i < this.jumps.size(); i++) {
            if (i == this.jumps.size()-1) {
                jumpString += Integer.toString(this.jumps.get(i)) + " m";
            } else {
                jumpString += Integer.toString(this.jumps.get(i)) + " m, ";
            }
        }
        
        return jumpString;
    }
    
}
