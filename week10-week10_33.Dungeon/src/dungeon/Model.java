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
public class Model {

    private Human theHuman;
    private List<Vampire> vampiresOnly;
    private int numberOfMoves;

    public Model(int numberOfMoves) {
        this.numberOfMoves = numberOfMoves;
        this.vampiresOnly = new ArrayList<>();
    }

    public void setTheHuman(Human h) {
        this.theHuman = h;
    }

    public Human getTheHuman() {
        return this.theHuman;
    }

    public void setVampiresOnly(List<Vampire> allVampires) {
        this.vampiresOnly = allVampires;
    }

    public List<Vampire> getVampiresOnly() {
        return vampiresOnly;
    }

    public int getNumberOfMoves() {
        return this.numberOfMoves;
    }

    public void decrementMove() {
        this.numberOfMoves--;
    }
}
