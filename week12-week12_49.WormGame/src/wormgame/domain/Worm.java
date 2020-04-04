/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.ArrayList;
import java.util.List;
import wormgame.Direction;

/**
 *
 * @author woohoo
 */
public class Worm {

    private Direction direction;
    private int originalX;
    private int originalY;
    private List<Piece> pieces;
    private boolean canGrow;

    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.originalX = originalX;
        this.originalY = originalY;
        this.direction = originalDirection;
        this.pieces = new ArrayList<>();
        this.pieces.add(new Piece(this.originalX, this.originalY));
        this.canGrow = true;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction dir) {
        this.direction = dir;
    }

    public int getLength() {
        return this.getPieces().size();
    }

    public List<Piece> getPieces() {
        return this.pieces;
    }

    public void move() {
        Piece endPiece = this.pieces.get(this.pieces.size() - 1);
        switch (this.direction) {
            case LEFT:
                this.pieces.add(new Piece(endPiece.getX() - 1, endPiece.getY()));
                break;
            case RIGHT:
                this.pieces.add(new Piece(endPiece.getX() + 1, endPiece.getY()));
                break;
            case UP:
                this.pieces.add(new Piece(endPiece.getX(), endPiece.getY() - 1));
                break;
            case DOWN:
                this.pieces.add(new Piece(endPiece.getX(), endPiece.getY() + 1));
                break;
        }

        if (!canGrow) {
            this.pieces.remove(0);
        }

        if (this.pieces.size() > 2) {
            this.canGrow = false;
        }
    }

    public void grow() {
        this.canGrow = true;
    }

    public boolean runsInto(Piece piece) {
        for (Piece p : this.pieces) {
            if (p.runsInto(piece)) {
                return true;
            }
        }
        return false;
    }

    public boolean runsIntoItself() {
        Piece head = this.pieces.get(this.pieces.size() - 1);
        for (int i = 0; i < this.pieces.size() - 1; i++) {
            Piece x = this.pieces.get(i);
            if (head.runsInto(x)) {
                return true;
            }
        }
        return false;
    }
}
