/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

/**
 *
 * @author kevin0110w
 */
public class PersonalBoard extends GameOfLifeBoard {
    
    public PersonalBoard(int width, int height) {
        super(width, height);
        
    }
    
    @Override
    public void turnToLiving(int x, int y) {
        if (checkBoundary(x,y)) {
              return;
        } else {
            super.getBoard()[x][y] = true;
        }
    }
    
    @Override
    public void turnToDead(int x, int y) {
          if (checkBoundary(x,y)) {
              return;
          }
            super.getBoard()[x][y] = false;
    }

    @Override
    public boolean isAlive(int x, int y) {
         if (checkBoundary(x,y)) {
            return false;
        } else {
             return super.getBoard()[x][y];
         }
    }

    @Override
    public void initiateRandomCells(double probabilityForEachCell) {
       Random random = new Random();
       for (int i = 0; i < super.getBoard().length; i++) {
           for (int j = 0; j < super.getBoard()[i].length; j++) {
            double probability = random.nextDouble();
            if (probability < probabilityForEachCell && probabilityForEachCell != 0) {
                this.turnToLiving(i, j);
            } else {
                this.turnToDead(i, j);
                }
            }
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        // Get Corners
        if ((x == 0 || x == super.getBoard().length-1) && (y == 0 || y == super.getBoard()[0].length-1)) {
            return checkNumberOfLivingNeighboursForCornerCell(x, y);
        } 
        // Get left or right borders
        else if (x == 0 || x == super.getBoard().length-1 && y > 0 && y < super.getBoard()[0].length-1) {
            return checkNumberOfLivingNeighboursForVerticalBorder(x, y);
        } 
        // get top or bottom borders
        else if (y == 0 || y == super.getBoard()[0].length-1 && x > 0 && x < super.getBoard().length-1) {
            return checkNumberOfLivingNeighboursForHorizontalBorder(x, y);
        } 
        // get the rest
        else {
           return checkNumberOfLivingNeighbourForCentralCell(x,y);
        }
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        switch(livingNeighbours) {
                case 0:
                case 1:
                    turnToDead(x,y);
                    break;
                case 2:
                    break;
                case 3:
                    if (!(super.getBoard()[x][y])) {
                    turnToLiving(x,y);
                    }
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    turnToDead(x,y);
                    break;
        }
    }
    
    public boolean checkBoundary(int x, int y) {
        return x >= super.getWidth() || y >= super.getHeight() || x < 0 || y < 0;
    }

    private int checkNumberOfLivingNeighboursForCornerCell(int x, int y) {
        int total = 0;
        if (x == 0 && y == 0) {
            total += getRightCell(x,y);
            total += getBotRightCell(x,y);
            total += getBotMiddleCell(x,y);
        } else if (x != 0 && y == 0) {
            total += getBotMiddleCell(x,y);
            total += getBotLeftCell(x,y);
            total += getLeftCell(x,y);
        } else if (x == 0 && y != 0) {
            total += getTopMiddleCell(x,y);
            total += getTopRightCell(x,y);
            total += getRightCell(x,y);
        } else {
            total += getLeftCell(x,y);
            total += getTopLeftCell(x,y);
            total += getTopMiddleCell(x,y);
        }
        return total;
    }

    private int checkNumberOfLivingNeighboursForHorizontalBorder(int x, int y) {
        int total = 0;
        if (y == 0) {
            total += getLeftCell(x,y);
            total += getBotLeftCell(x,y);
            total += getBotMiddleCell(x,y);
            total += getBotRightCell(x,y);
            total += getRightCell(x,y);
        } else {
            total += getLeftCell(x,y);
            total += getTopLeftCell(x,y);
            total += getTopMiddleCell(x,y);
            total += getTopRightCell(x,y);
            total += getRightCell(x,y);
        }
        return total;
    }

    private int checkNumberOfLivingNeighboursForVerticalBorder(int x, int y) {
        int total = 0;
       if (x == 0) {
            total += getTopMiddleCell(x,y);
            total += getTopRightCell(x,y);
            total += getRightCell(x,y);
            total += getBotRightCell(x,y);
            total += getBotMiddleCell(x,y);
        } else {
            total += getBotMiddleCell(x,y);
            total += getBotLeftCell(x,y);
            total += getLeftCell(x,y);
            total += getTopLeftCell(x,y);
            total += getTopMiddleCell(x,y);
        }
        return total;
    }
    
    private int checkNumberOfLivingNeighbourForCentralCell(int x, int y) {
        int total = 0;
        total += getTopLeftCell(x,y);
        total += getTopMiddleCell(x,y);
        total += getTopRightCell(x,y);
        total += getLeftCell(x,y);
        total += getRightCell(x,y);
        total += getBotLeftCell(x,y);
        total += getBotMiddleCell(x,y);
        total += getBotRightCell(x,y);
        return total;
    }
    
    private int getTopLeftCell(int x, int y) {
        return super.getBoard()[x-1][y-1] ? 1 : 0;
    }
    
    private int getTopMiddleCell(int x,int  y) {
        return super.getBoard()[x][y-1] ? 1 : 0;
    }
    
    private int getTopRightCell(int x, int y) {
        return super.getBoard()[x+1][y-1] ? 1 : 0;
    }
    
    private int getLeftCell(int x, int y) {
        return super.getBoard()[x-1][y] ? 1 : 0;
    }
        
    private int getRightCell(int x, int  y) {
        return super.getBoard()[x+1][y] ? 1 : 0;
    }
    
    private int getBotLeftCell(int x, int y) {
        return super.getBoard()[x-1][y+1] ? 1 : 0;
    }
    
    private int getBotMiddleCell(int x, int y) {
        return super.getBoard()[x][y+1] ? 1 : 0;
    }
    
    private int getBotRightCell(int x, int  y) {
        return super.getBoard()[x+1][y+1] ? 1 : 0;
    }
}
