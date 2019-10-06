/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author woohoo
 */
public class GameManager {
    private Dungeon theDungeon;
//    private List<Vampire> vampires;
    private Map<Vampire, Integer> vampires;
    private Scanner reader;  
    private Human h;
    
    public GameManager(Dungeon aDungeon) {
        this.theDungeon = aDungeon;
//        this.vampires = new ArrayList<Vampire>();
        this.vampires = new HashMap<Vampire, Integer>();
        this.reader = new Scanner(System.in);
        this.h = new Human(theDungeon.getHeight(), theDungeon.getLength());
    }
    
    public void run() {
        this.theDungeon.setPosition(this.h.getY(), this.h.getX(), this.h.getName());
        createPlayers();    
        while (this.theDungeon.getMoves() > 0) {
            System.out.println(this);
            if (this.vampires.size() == 0) {
                break;
            }
            move();
            this.theDungeon.setMoves(this.theDungeon.getMoves()-1);
        }
        if (this.theDungeon.getMoves() == 0) {
            loser();
        } else {
            winner();
        }
        
    }
    
    public void createPlayers() {
        int x = 0;
        while (x < theDungeon.getVampires()) {
            Vampire v = new Vampire(theDungeon.getHeight(), theDungeon.getLength(), theDungeon.isVampiresMove());
            this.vampires.put(v, x);
            this.theDungeon.setPosition(v.getY(), v.getX(), v.getName());
            x++;
        }
    }

    private void move() {
        String command = this.reader.nextLine();
        for (int i = 0; i < command.length(); i++) {
            h.generateNewCoordinates(command.charAt(i));
            resetBoard(h);
            moveHuman();
            updateMove(h);
            checkHumanAgainstVampire();
            updateVampireMove();
        }
    }
    
    
    @Override
    public String toString() {
        String dungeon = "";
        
        // blinkings
        dungeon += this.theDungeon.getMoves() + "\n";
        dungeon += "\n";
        dungeon += this.h.toString() + "\n";
        // player positions 
       for (Vampire v : this.vampires.keySet()) {
          dungeon += v.toString() + "\n";
       }
        dungeon += "\n";
        // dungeon
        dungeon += this.theDungeon.toString();
        
        return dungeon;
        
    }

    private void winner() {
        System.out.println("YOU WIN");
    }
    
    private void loser() {
        System.out.println("YOU LOSE");
    }

    private void updateMove(Character character) {
        this.theDungeon.setPosition(character.getY(), character.getX(), character.getName());
    }

    private void checkHumanAgainstVampire() {
        Iterator<Vampire> vampireIterator = this.vampires.keySet().iterator();
        
        while (vampireIterator.hasNext()) {
            Vampire vampire = vampireIterator.next();
            if (vampire.getX() == h.getX() && vampire.getY() == h.getY()) {
                vampireIterator.remove();
            }
        }
    }

    private void updateVampireMove() {
        Iterator<Vampire> vampireIterator = this.vampires.keySet().iterator();
        
        while (vampireIterator.hasNext()) {
            Vampire v = vampireIterator.next();
            
            if (checkDeadVampire(v)) {
                vampireIterator.remove();
                break;
            }
            v.generateNewCoordinates();
            boolean validMove = checkValidVampireMove(v);
            boolean deadVampire = checkDeadVampireMove(v);
            if (deadVampire) {
                
                vampireIterator.remove();
                break;
            } else {
            resetBoard(v);
            v.move(validMove);
            updateMove(v);
            }
        }
    }

    private boolean checkValidVampireMove(Vampire v) {
        return (!(this.theDungeon.getPosition(v.getTempY(), v.getTempX()) == 'v'));
    }

    private boolean checkDeadVampire(Vampire v) {
        return (this.theDungeon.getPosition(v.getY(), v.getX()) == '@');
    }
    
    private boolean checkDeadVampireMove(Vampire v) {
        return (this.theDungeon.getPosition(v.getTempY(), v.getTempX()) == '@');
    }

    private void resetBoard(Character x) {
        this.theDungeon.resetPosition(x.getY(), x.getX());
    }

    private void moveHuman() {
       h.setX(h.getTempX());
       h.setY(h.getTempY());
    }
}
