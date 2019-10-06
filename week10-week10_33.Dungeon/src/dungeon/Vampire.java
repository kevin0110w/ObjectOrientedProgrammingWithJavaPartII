package dungeon;

import java.util.Random;

/**
 *
 * @author woohoo
 */
public class Vampire implements Character{
    public final char name;
    public int x, y, heightBoundary, lengthBoundary, tempX, tempY;
    public Random randomX, randomY;
    public boolean vampiresMove;
    
    public Vampire(int heightBoundary, int lengthBoundary, boolean vampiresMove) {
        this.name = 'v';
        this.heightBoundary = heightBoundary;
        this.lengthBoundary = lengthBoundary;
        this.randomY = new Random();
        this.randomX = new Random();
        this.vampiresMove = vampiresMove;
        this.startingPositions();
    }

    public int getTempX() {
        return tempX;
    }

    public int getTempY() {
        return tempY;
    }
    
    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    public void generateNewCoordinates() {
        if (this.vampiresMove) {
            tempX = this.randomX.nextInt(this.lengthBoundary);
            tempY = this.randomY.nextInt(this.heightBoundary);
        }
    }
    
    public void move(boolean canMove) {
        if (canMove) {
        this.x = this.tempX;
        this.y = this.tempY;
        }
    }
    

    @Override
    public char getName() {
        return this.name;
        
    }
    
    @Override
    public String toString() {
         return this.name + " " + this.x + " " + this.y;
    }

    private void startingPositions() {
        while (true) {
            this.x = this.randomX.nextInt(this.lengthBoundary);
            this.tempX = this.x;
            this.y = this.randomY.nextInt(this.heightBoundary);
            this.tempY = this.y;
            if (!(this.x == 0 && this.y == 0)) {
                return;
            }
        }
        
    }
}
