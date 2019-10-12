/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.List;
import java.util.ArrayList;
import wormgame.Direction;

/**
 *
 * @author 
 */
public class Worm {
    private List<Piece> pieces;
    private Direction direction;
    private int originalX;
    private int originalY;
    private boolean canGrow;
    
    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.pieces = new ArrayList<Piece>();
        this.pieces.add(new Piece(originalX, originalY));
        this.direction = originalDirection;
        this.originalX = originalX;
        this.originalY = originalY;
        this.canGrow = true;
    }
    
    /**
     * return's Worm's direction.
     * @return 
     */
        public Direction getDirection() {
            return this.direction;
        }
        
    /**
     * sets a new direction for the worm. 
     * The worm starts to move in the new direction when the method move is called again.
     * @param dir 
     */
    public void setDirection(Direction dir) {
        this.direction = dir;
    }
    
    /**
     * returns the Worm's length. 
     * The Worm's length has to be equal to the length of the list 
     * returned by the method getPieces().
     * @return 
     */
    public int getLength() {
        return this.getPieces().size();
    }
    
    /**
     * returns a list of Piece objects which the worm is composed of. 
     * The pieces in the list are in order, with the worm head at the end of the list.
     * @return 
     */
    public List<Piece> getPieces() {
        return this.pieces;
    }
    
    /**
     * moves the worm one piece forward.
     * a new piece is added and the first piece is deleted
     */
    public void move() {
        Piece head = this.pieces.get(this.pieces.size()-1);
        Piece newHead = null;
        int headX = head.getX();
        int headY = head.getY();
        String direction = this.direction.toString();
        if (direction.equals("UP")) {
            newHead = new Piece(headX, headY-1);
        } else if (direction.equals("RIGHT")) {
            newHead = new Piece(headX+1, headY);
        } else if (direction.equals("DOWN")) {
            newHead = new Piece(headX, headY+1);
        } else if (direction.equals("LEFT")) {
            newHead = new Piece(headX-1, headY);
        }
        this.pieces.add(newHead);
        
        if (!canGrow) {
            this.pieces.remove(0);
        }
        
        if (this.getLength() >= 3) {
            this.canGrow = false;
        }
        
    }
    
    /**
     *     grows the worm by one piece. The worm grows together with the following move method call;
     after the first move method call the worm does not grow any more.
     */
    public void grow() {
        this.canGrow = true;
    }
    
    /**
     * checks whether the worm runs into the parameter piece. 
     * If so -- that is, if a piece of the worm runs into the parameter piece -- 
     * the method returns the value true; otherwise it returns false.
     * @param piece
     * @return 
     */
    public boolean runsInto(Piece piece) {
        for (Piece p : this.pieces) {
            if (p.runsInto(piece)) {
                return true;
            }
        }
        return false;
    }
    /**
     * check whether the worm runs into itself. 
     * If so -- that is, if one of the worm's pieces runs into another piece -- 
     * the method returns the value true. Otherwise it returns false.
     * @return 
     */
    public boolean runsIntoItself() { 
        Piece head = this.pieces.get(this.pieces.size()-1);
        for (int i = 0; i < this.pieces.size()-1; i++) {
            Piece x = this.pieces.get(i);
            if (head.runsInto(x)) {
                return true;
            }
        }
        return false;
    }
}
