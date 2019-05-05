import java.util.ArrayList;

public class Jumper {
    private String name;
    private int points;
    private ArrayList<Integer> distances;
    
     Jumper(String name) {
        this.name = name;
        this.points = 0;
        this.distances = new ArrayList<Integer>();
    }

   
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getPoints() {
        return this.points;
    }
    
    public void setPoints(int points) {
        this.points += points;
    }
    
    public void addDistance(int distance) {
        this.distances.add(distance);
    }
    
    public ArrayList<Integer> getDistances() {
        return this.distances;
    }
    
    public String toString() {
        return this.name + " (" + this.points + " points)";
    }
    
    public String getDistancesString() {
        String line = "";
        for (int i = 0; i < this.distances.size(); i++) {
            if (i == this.distances.size()-1) {
                line = line + this.distances.get(i) + " m";
            } else {
                line = line +  this.distances.get(i) + " m, ";
            }
        }
        return line;
    }
}