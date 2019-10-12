/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

/**
 *
 * @author 
 */
public class Piece {
    protected int x;
    protected int y;
    
    public Piece(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    /**
     * returns the x coordinate of the piece, which was assigned in the constructor.
     * @return 
     */
    public int getX() {
        return this.x;
    }
     
    /**
     * returns the y coordinate of the piece, which was assigned in the constructor.
     * @return 
     */
    public int getY() {
        return this.y;
    }
    
    /**
     * returns true if the object has the same coordinates 
     * as the Piece instance received as paramater.
     * @param piece
     * @return 
     */
    public boolean runsInto(Piece piece) {
        return this.x == piece.getX() && this.y == piece.getY();
    }
    
    /**
     * returns the piece position following the pattern (x,y). 
     * For instance. (5,2) if the value of x is 5 and the value of y is 2.
     * @return 
     */
    public String toString() { 
        return "(" + this.x + "," + this.y + ")";
    }
}

