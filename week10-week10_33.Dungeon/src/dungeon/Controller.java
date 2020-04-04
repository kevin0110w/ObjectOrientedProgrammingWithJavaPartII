/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author woohoo
 */
public class Controller {

    private Model m;
    private View v;
    private Dungeon d;
    private Scanner scanner;
    

    public Controller(Model m, View v, Dungeon d) {
        this.m = m;
        this.v = v;
        this.d = d;
        this.scanner = new Scanner(System.in);
    }

    public void createCharacters(int numberOfVampires) {
        for (int i = 0; i <= numberOfVampires; i++) {
            if (i == 0) {
                Human theHuman = new Human(d.getLength(), d.getHeight(), this.scanner);
                theHuman.generateStartingPosition();
                this.m.setTheHuman(theHuman);
            } else {
                while (true) {
                    Vampire v = new Vampire(d.getLength(), d.getHeight());
                    v.generateStartingPosition();
                    while (v.getCurrentPosition().getX() == 0 && v.getCurrentPosition().getY() == 0) {
                        v.generateStartingPosition();
                    }
                    if (!this.m.getVampiresOnly().contains(v)) {
                        this.m.getVampiresOnly().add(v);
                        break;
                    }
                }
            }
        }
        updateDungeon(this.getAllCharacters());
    }

    public void start() {
        boolean winner = false;
        while (this.m.getNumberOfMoves() > 0) {
            this.v.printBlinkings(this.m.getNumberOfMoves());
            this.m.decrementMove();
            this.v.printCharacters(this.getAllCharacters());
            this.printDungeon();
            processRound();
            if (this.m.getVampiresOnly().isEmpty()) {
                winner = true;
                break;
            }
        }
        if (!winner) {
            this.v.printYouLose();
        } else {
            this.v.printYouWin();
        }
    }

    private void processRound() {
        this.m.getTheHuman().generateTemporaryPosition();
        List<Position> getHumanPositions = this.m.getTheHuman().getTemporaryPositions();
        for (int i = 0; i < getHumanPositions.size(); i++) {
            if  (checkPositionValid(getHumanPositions.get(i))) {
                this.d.resetPosition(this.m.getTheHuman());
                this.m.getTheHuman().setCurrentPosition(getHumanPositions.get(i));
                checkIfBumpsIntoVampire(getHumanPositions.get(i));
                if (this.d.CanVampiresMove()) {
                    moveVampires(getHumanPositions.get(i));
                }
            } 
        }
        this.m.getTheHuman().getTemporaryPositions().clear();
        this.updateDungeon(this.getAllCharacters());
    }

    private boolean checkPositionValid(Position tempPosition) {
        return (tempPosition.getX() >= 0 && tempPosition.getX() < this.d.getLength()) && (tempPosition.getY() >= 0 && tempPosition.getY() < this.d.getHeight());
    }

    private void checkIfBumpsIntoVampire(Position get) {
        List<Vampire> vampiresOnly = this.m.getVampiresOnly();
        for (int i = 0; i < vampiresOnly.size(); i++) {
            if (vampiresOnly.get(i).getCurrentPosition().equals(get)) {
                vampiresOnly.remove(vampiresOnly.get(i));
                i--;
            }
        }
        this.m.setVampiresOnly(vampiresOnly);
    }

    private void moveVampires(Position get) {
        List<Vampire> vampiresOnly = this.m.getVampiresOnly();
        for (int i = 0; i < vampiresOnly.size(); i++) {
            vampiresOnly.get(i).generateTemporaryPosition();
            if (vampiresOnly.get(i).getTemporaryPositions().get(0).equals(get)) {
                vampiresOnly.remove(vampiresOnly.get(i));
                i--;
            } else {
                if (checkPositionValidForVampire(vampiresOnly.get(i).getTemporaryPositions().get(0))) {
                    this.d.resetPosition(vampiresOnly.get(i));
                    vampiresOnly.get(i).setCurrentPosition(vampiresOnly.get(i).getTemporaryPositions().get(0));
                }
            }
        }
        this.m.setVampiresOnly(vampiresOnly);
    }

    public void printDungeon() {
        this.v.printDungeon(this.d);
    }

    private void updateDungeon(List<Movable> allCharacters) {
        for (Movable m : allCharacters) {
            this.d.updateBoardWithNewPosition(m);
        }
    }

    private void resetBoard(List<Movable> vampiresOnly) {
        for (Movable m : vampiresOnly) {
            this.d.resetPosition(m);
        }
    }

    private boolean checkPositionValidForVampire(Position get) {
        return this.checkPositionValid(get) && !this.d.spotOccupiedByVampire(get);
    }

    private List<Movable> getAllCharacters() {
        List<Movable> allCharacters = new ArrayList<>();
        allCharacters.add(this.m.getTheHuman());
        allCharacters.addAll(this.m.getVampiresOnly());
        return allCharacters;
    }
}
