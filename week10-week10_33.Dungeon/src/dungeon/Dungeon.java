/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.Scanner;

/**
 *
 * @author woohoo
 */
public class Dungeon {
    private final int length;
    private final int height;
    private final int vampires;
    private final boolean vampiresMove;
    private int moves;
    private char[][] dungeon;
    
    
    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        this.dungeon = new char[this.height][this.length];
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public int getVampires() {
        return vampires;
    }

    public boolean isVampiresMove() {
        return vampiresMove;
    }

    public int getMoves() {
        return moves;
    }
    
    public void run() {
        this.setUpDungeon();
        GameManager gm = new GameManager(this);
        gm.run();
    }
    
    public void setUpDungeon() {
        for (int i = 0; i < this.dungeon.length; i++) {
            for (int j = 0; j < this.dungeon[i].length; j++) {
                this.dungeon[i][j] = '.';
            }
        }
    }

    public char[][] getDungeon() {
        return dungeon;
    }

    public void setDungeon(char[][] dungeon) {
        this.dungeon = dungeon;
    }
    
    public String toString() {
        String dungeon = "";
        for (int i = 0; i < this.dungeon.length; i++) {
            for (int j = 0; j < this.dungeon[i].length; j++) {
                dungeon += this.dungeon[i][j];
            }
            dungeon += "\n";
        }
        dungeon += "\n";
        return dungeon;
    }

    public void setPosition(int vertical, int horizontal, char name) {
        this.dungeon[vertical][horizontal] = name;
    }
    
    public char getPosition(int vertical, int horizontal) {
        return this.dungeon[vertical][horizontal];
    }

    void setMoves(int i) {
        this.moves = i;
    }

    void resetPosition(int y, int x) {
        setPosition(y, x, '.');
    }
}
