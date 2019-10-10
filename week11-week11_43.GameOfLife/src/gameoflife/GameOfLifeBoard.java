/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

/**
 *
 * @author kevin0110w
 */
public abstract class GameOfLifeBoard {
    protected boolean[][] board;
    protected int length;
    protected int height;
    
    public GameOfLifeBoard(int length, int height) {
        this.board = new boolean[height][length];
        this.length = length;
        this.height = height;
    }
    
    /**
     * provides access to the game board, 
     * which is a bidimensional table containing boolean values
     * @return 
     */
    public boolean[][] getBoard() {
        return this.board;
    }
    
    /**
     * returns the board width
     * @return 
     */
    public int getWidth() {
        return this.length;
    }
    
    /**
     * returns the board height
     * @return 
     */
    public int getHeight() {
        return this.height;
    }
    
    /**
     *  simulatees a turn of the game
     */
    public void playTurn() {
        
    }
    
    /**
     * animates the cell whose coordinates are (x, y), 
     * that is to say it assigns the value true to it. 
     * If the coordinates are outside the board, nothing happens.
     * @param x
     * @param y 
     */
    public abstract void turnToLiving(int x, int y);
    
    /**
     * kills the cell whose coordinates are (x, y), 
     * that is to say it assigns the value false to it. 
     * If the coordinates are outside the board, nothing happens.
     * @param x
     * @param y 
     */
    public abstract void turnToDead(int x, int y);  

    /**
     * tells whether the cell at (x, y) is alive. 
     * If the coordinates are outside the board, the method returns false.
     * @param x
     * @param y
     * @return 
     */
    public abstract boolean isAlive(int x, int y);

    /**
     * initiates all the cells of the board: 
     * every cell is alive with a probability of probabilityForEachCell. 
     * The probability is a double value between [0, 1]. 
     * If a method is called with value 1, all the cells have to be alive.
     * Accordingly , if the probability is 0, all the cells have to be dead.
     * @param probabilityForEachCell 
     */
    public abstract void initiateRandomCells(double probabilityForEachCell);
    
    /**
     * tells the number of living neighbours for the cell at (x, y).
     * @param x
     * @param y
     * @return 
     */
    public abstract int getNumberOfLivingNeighbours(int x, int y);

    /**
     * manages the cell (x, y) according to the rules of the Game of Life.
     * @param x
     * @param y
     * @param livingNeighbours 
     */
    public abstract void manageCell(int x, int y, int livingNeighbours);
    
}
