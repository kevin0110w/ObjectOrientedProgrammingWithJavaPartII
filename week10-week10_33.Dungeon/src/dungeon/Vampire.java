
package dungeon;

import java.util.Random;

public class Vampire {
    private int x, y, length, height, temp_X, temp_Y;
    private Random rand;
    private final String name;
    public Vampire(int length, int height) {
        this.rand = new Random();
        setStartingPosition(length, height);
        this.name = "v";
    }
    
    public void move(boolean vampireMove) {
        if (vampireMove) {
        this.temp_X = this.rand.nextInt(length);
        this.temp_Y = this.rand.nextInt(height);
        }
    }
    
    public void newPosition() {
            this.x = temp_X;
            this.y = temp_Y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getTempX() {
        return this.temp_X;
    }
    
    public int getTempY() {
        return this.temp_Y;
    }

    
    public String getName() {
        return name;
    }
    
    
    public String toString(){
        return this.name + " " + this.x + " " + this.y;
    }

    private void setStartingPosition(int length, int height) {
        while (this.x==0) {
            this.x = rand.nextInt(length);
        }
        while (this.y==0) {
            this.y = rand.nextInt(height);
        }
    }
}
