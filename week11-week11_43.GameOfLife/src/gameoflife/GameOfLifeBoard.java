/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

/**
 *
 * @author woohoo
 */
public abstract class GameOfLifeBoard {
    
    private int length;
    private int height;
    private boolean[][] board;
    
    public GameOfLifeBoard(int length, int height){
        this.length = length;
        this.height = height;
        this.board = new boolean[length][height];
    }
    
    public boolean[][] getBoard(){
        return this.board;
    }
    
    public int getWidth(){
        return this.length;
    }
    
    
    public int getHeight(){
        return this.height;
    }
    
    public void playTurn(){
        
    }
    
    public abstract void turnToLiving(int x, int y);
    public abstract void turnToDead(int x, int y);
    public abstract boolean isAlive(int x, int y);
    public abstract void initiateRandomCells(double probabilityForEachCell);
    public abstract int getNumberOfLivingNeighbours(int x, int y);
    public abstract void manageCell(int x, int y, int livingNeighbours);
}
