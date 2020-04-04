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
public class Dungeon {

    private final int length;
    private final int height;
    private final int numberOfVampires;
    private final int numberOfMoves;
    private final boolean canVampiresMove;
    private final char[][] theDungeon;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.numberOfVampires = vampires;
        this.numberOfMoves = moves;
        this.canVampiresMove = vampiresMove;
        this.theDungeon = new char[height][length];
        setUpDungeon();
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public int getNumberOfVampires() {
        return numberOfVampires;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    public boolean CanVampiresMove() {
        return canVampiresMove;
    }

    public char[][] getTheDungeon() {
        return theDungeon;
    }
    
    public void run() {
        Model m = new Model(this.numberOfMoves);
        View v = new View();
        Controller c = new Controller(m, v, this);
        c.createCharacters(this.numberOfVampires);
        c.start();
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.height; j++) {
                s += this.getTheDungeon()[i][j];
            }
            s += "\n";
        }
        return s;
    }

    private void setUpDungeon() {
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.height; j++) {
                this.getTheDungeon()[i][j] = '.';
            }
        }
    }

    public boolean spotOccupiedByVampire(Position position) {
        return this.theDungeon[position.getY()][position.getX()] == 'v';
    }

    public boolean spotOccupiedByHuman(Position position) {
        return this.theDungeon[position.getY()][position.getX()] == '@';
    }

    public void updateBoardWithNewPosition(Movable m) {
        this.theDungeon[m.getCurrentPosition().getY()][m.getCurrentPosition().getX()] = m.getName().charAt(0);
    }

    public void resetPosition(Movable m) {
        this.theDungeon[m.getCurrentPosition().getY()][m.getCurrentPosition().getX()] = '.';
    }
}
