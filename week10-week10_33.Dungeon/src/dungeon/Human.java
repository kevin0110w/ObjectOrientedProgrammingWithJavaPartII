/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author woohoo
 */
public class Human implements Character {
    public final char name;
    public int x;
    public int y;
    public int tempX;
    public int tempY;
    public int heightBoundary;
    public int lengthBoundary;
    
    public Human(int heightBoundary, int lengthBoundary) {
        this.name = '@';
        this.x = 0;
        this.y = 0;
        this.tempX = this.x;
        this.tempY = this.y;
        this.heightBoundary = heightBoundary;
        this.lengthBoundary = lengthBoundary;
    }
    
    public int getTempX() {
        return tempX;
    }

    public void setTempX(int tempX) {
        this.tempX = tempX;
    }

    public int getTempY() {
        return tempY;
    }

    public void setTempY(int tempY) {
        this.tempY = tempY;
    }
    
    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }
    
    public void setX(int newX){
        this.x = newX;
    }
    
    public void setY(int newY){
        this.y = newY;
    }

    public void generateNewCoordinates(char command) {
        switch(command) {
                // to go up
                case 'w':
                    if (this.tempY > 0) {
                        this.tempY = this.y-1;
                    }
                    break;
                // to go down
                case 's':
                    if (this.tempY < this.heightBoundary-1) {                        
                        this.tempY = this.y+1;
                    }
                    break;
                // to go left
                case 'a':
                    if (this.tempX > 0) {
                        this.tempX = this.x-1;
                    }
                    break;
                // to go right
                case 'd':
                    if (this.tempX < this.lengthBoundary-1) {
                         this.tempX = this.x+1;
                    }
                    break;    
        }
          
    }

    @Override
    public char getName() {
        return this.name;
    }
    
    @Override
    public String toString() {
        return this.name + " " + this.getX() + " " + this.getY();
    }
}
