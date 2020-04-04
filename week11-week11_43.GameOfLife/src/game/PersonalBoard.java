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
 * @author woohoo
 */
public class PersonalBoard extends GameOfLifeBoard {

    public PersonalBoard(int length, int height) {
        super(length, height);
    }

    @Override
    public void turnToLiving(int x, int y) {
        if (withinBoard(x, y)) {
            super.getBoard()[x][y] = true;
        }
    }

    @Override
    public void turnToDead(int x, int y) {
        if (withinBoard(x, y)) {
            super.getBoard()[x][y] = false;
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        if (withinBoard(x, y)) {
            return super.getBoard()[x][y];
        } else {
            return false;
        }
    }

    @Override
    public void initiateRandomCells(double probabilityForEachCell) {
        long numberOfCellsToInitiate = Math.round(probabilityForEachCell * (super.getWidth() * super.getHeight()));
        Random rand = new Random();
        for (int i = 0; i < numberOfCellsToInitiate; i++) {
            while (true) {
                int randX = rand.nextInt(super.getWidth());
                int randY = rand.nextInt(super.getHeight());
                if (withinBoard(randX, randY) && !super.getBoard()[randX][randY]) {
                    super.getBoard()[randX][randY] = true;
                    break;
                }
            }
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        if (!withinBoard(x, y)) {
            return -1;
        }
        int aliveNeighbours = 0;
        if (isCornerCoordinate(x, y)) {
            aliveNeighbours = getNeighbourCountForCorner(x, y);
        } else if (isEdgeCoordinate(x, y)) {
            aliveNeighbours = getNeighbourCountForEdge(x, y);
        } else if (isCentralCoordinate(x, y)) {
            aliveNeighbours = getNeighbourCountForCentral(x, y);
        }
        return aliveNeighbours;
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        switch (livingNeighbours) {
            case 0:
            case 1:
                super.getBoard()[x][y] = false;
                break;
            case 2:
                if (super.getBoard()[x][y] == false) {
                    super.getBoard()[x][y] = false;
                } else {
                    super.getBoard()[x][y] = true;
                }
                break;
            case 3:
                super.getBoard()[x][y] = true;
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                super.getBoard()[x][y] = false;
                break;
        }

    }

    private boolean withinBoard(int x, int y) {
        return x >= 0 && x < this.getWidth() && y >= 0 && y < this.getHeight();
    }

    private boolean isCornerCoordinate(int x, int y) {
        return (x == 0 || x == super.getWidth() - 1) && (y == 0 || y == super.getHeight() - 1);
    }

    private boolean isEdgeCoordinate(int x, int y) {
        return isLeftEdge(x, y) || isRightEdge(x, y) || isTopEdge(x, y) || isBottomEdge(x, y);
    }

    private boolean isCentralCoordinate(int x, int y) {
        return !(isCornerCoordinate(x, y) && isEdgeCoordinate(x, y));
    }

    private boolean isLeftEdge(int x, int y) {
        return x == 0 && (y > 0 || y < this.getHeight() - 1);
    }

    private boolean isRightEdge(int x, int y) {
        return x == super.getWidth() - 1 && (y > 0 || y < this.getHeight() - 1);
    }

    private boolean isTopEdge(int x, int y) {
        return (x > 0 || x < this.getHeight() - 1) && y == 0;
    }

    private boolean isBottomEdge(int x, int y) {
        return (x > 0 || x < this.getHeight() - 1) && y == this.getHeight() - 1;
    }

    private int getTopLeftCell(int x, int y) {
        return super.getBoard()[x - 1][y - 1] ? 1 : 0;
    }

    private int getTopMiddleCell(int x, int y) {
        return super.getBoard()[x][y - 1] ? 1 : 0;
    }

    private int getTopRightCell(int x, int y) {
        return super.getBoard()[x + 1][y - 1] ? 1 : 0;
    }

    private int getLeftCell(int x, int y) {
        return super.getBoard()[x - 1][y] ? 1 : 0;
    }

    private int getRightCell(int x, int y) {
        return super.getBoard()[x + 1][y] ? 1 : 0;
    }

    private int getBottomLeftCell(int x, int y) {
        return super.getBoard()[x - 1][y + 1] ? 1 : 0;
    }

    private int getBottomMiddleCell(int x, int y) {
        return super.getBoard()[x][y + 1] ? 1 : 0;
    }

    private int getBottomRightCell(int x, int y) {
        return super.getBoard()[x + 1][y + 1] ? 1 : 0;
    }

    private int getNeighbourCountForCorner(int x, int y) {
        int total = 0;
        if (x == 0 && y == 0) {
            total += getRightCell(x, y) + getBottomRightCell(x, y) + getBottomMiddleCell(x, y);
        } else if (x == super.getWidth() - 1 && y == 0) {
            total += getLeftCell(x, y) + getBottomLeftCell(x, y) + getBottomMiddleCell(x, y);
        } else if (x == super.getWidth() - 1 && y == super.getHeight() - 1) {
            total += getLeftCell(x, y) + getTopLeftCell(x, y) + getTopMiddleCell(x, y);
        } else if (x == 0 && y == super.getHeight() - 1) {
            total += getRightCell(x, y) + getTopRightCell(x, y) + getTopMiddleCell(x, y);
        }
        return total;
    }

    private int getNeighbourCountForEdge(int x, int y) {
        int total = 0;
        if (isLeftEdge(x, y)) {
            total += getTopMiddleCell(x, y) + getTopRightCell(x, y) + getRightCell(x, y) + getBottomRightCell(x, y) + getBottomMiddleCell(x, y);
        } else if (isRightEdge(x, y)) {
            total += getTopMiddleCell(x, y) + getTopLeftCell(x, y) + getLeftCell(x, y) + getBottomLeftCell(x, y) + getBottomMiddleCell(x, y);
        } else if (isTopEdge(x, y)) {
            total += getLeftCell(x, y) + getBottomLeftCell(x, y) + getBottomMiddleCell(x, y) + getBottomRightCell(x, y) + getRightCell(x, y);
        } else if (isBottomEdge(x, y)) {
            total += getLeftCell(x, y) + getTopLeftCell(x, y) + getTopMiddleCell(x, y) + getTopRightCell(x, y) + getRightCell(x, y);
        }

        return total;
    }

    private int getNeighbourCountForCentral(int x, int y) {
        return getBottomLeftCell(x, y) + getBottomMiddleCell(x, y) + getBottomRightCell(x, y) + getLeftCell(x, y) + getRightCell(x, y) + getTopLeftCell(x, y) + getTopMiddleCell(x, y) + getTopRightCell(x, y);
    }
}
