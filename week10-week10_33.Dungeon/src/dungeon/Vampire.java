/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author woohoo
 */
public class Vampire extends Movable {
    private Random randomGenerator;
    private int tempY;
    private int tempX;
    
    public Vampire(int widthMax, int heightMax) {
        super(widthMax, heightMax, "v");
        this.randomGenerator = new Random();
    }

    @Override
    public void generateStartingPosition() {
        int x = getRandomXPosition();
        int y = getRandomYPosition();
        this.setCurrentPosition(new Position(x, y));
    }
    
    private int getRandomXPosition() {
        return this.randomGenerator.nextInt(super.getWidthMax());
    }

    private int getRandomYPosition() {
        return this.randomGenerator.nextInt(super.getHeightMax());
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vampire other = (Vampire) obj;
        if (!Objects.equals(this.getName(), other.getName())) {
            return false;
        }
        if (!Objects.equals(this.getCurrentPosition(), other.getCurrentPosition())) {
            return false;
        }
        return true;
    }

    @Override
    public void generateTemporaryPosition() {
        int x = getRandomXPosition();
        int y = getRandomYPosition();
        Position newTemporaryPosition = new Position(x, y);
        this.getTemporaryPositions().add(newTemporaryPosition);
    }
}
