/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author woohoo
 */
public abstract class Movable {

    private int widthMax;
    private int heightMax;
    private Position currentPosition;
    private List<Position> temporaryPositions;
    private String name;

    public Movable(int widthMax, int heightMax, String name) {
        this.heightMax = heightMax;
        this.widthMax = widthMax;
        this.name = name;
        this.temporaryPositions = new ArrayList<>();
    }

    public int getWidthMax() {
        return widthMax;
    }

    public void setWidthMax(int widthMax) {
        this.widthMax = widthMax;
    }

    public int getHeightMax() {
        return heightMax;
    }

    public void setHeightMax(int heightMax) {
        this.heightMax = heightMax;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getCurrentPosition() {
        return this.currentPosition;
    }

    public void setCurrentPosition(Position newPosition) {
        this.currentPosition = newPosition;
    }
    
    
    public List<Position> getTemporaryPositions() {
        return temporaryPositions;
    }

    public void setTemporaryPosition(List<Position> temporaryPositions) {
        this.temporaryPositions = temporaryPositions;
    }

    abstract void generateStartingPosition();

    public boolean checkValidMove(int x, int y) {
        return validXPosition(x) && validYPosition(y);
    }

    private boolean validXPosition(int x) {
        return x >= 0 && x < this.widthMax;
    }

    private boolean validYPosition(int y) {
        return y >= 0 && y < this.heightMax;
    }

    @Override
    public String toString() {
        return this.name + " " + this.currentPosition;
    }
    
    public abstract void generateTemporaryPosition();
}
