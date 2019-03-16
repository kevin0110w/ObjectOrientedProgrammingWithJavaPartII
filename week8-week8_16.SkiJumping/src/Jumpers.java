
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Freckles
 */
public class Jumpers {
    private String name;
    private int points;
    private int distance;
    
    public Jumpers(String name) {
        this.name = name;
        this.points = 0;
        this.distance = 0;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getPoints() {
        return this.points;
    }
    
    public int getDistances() {
        return this.distance;
    }
    
    public String toString() {
        return this.name + " (" + this.points + ")";
    }
}
