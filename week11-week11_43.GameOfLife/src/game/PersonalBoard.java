package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;
/**
 *
 * @author woohoo
 */
public class PersonalBoard extends GameOfLifeBoard{
    private int width, height;
    private Random random;
    private CalculateLivingNeighbours calculator;
    
    public PersonalBoard(int width, int height) {
        super(width, height);
        random = new Random();
        this.calculator = new CalculateLivingNeighbours(this);
    }
    @Override
    public void initiateRandomCells(double probabilityForEachCell) {
        for (int i = 0; i < super.getBoard().length; i++) {
            for (int j = 0; j < super.getBoard()[i].length; j++) {
                double probability = random.nextDouble();
                if (probability <= probabilityForEachCell && probability != 0) {
                    super.getBoard()[i][j] = true;
                } else {
                    super.getBoard()[i][j] = false;
                }
            }
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        if (x >= 0 && x < super.getWidth() && y >= 0 && y < super.getHeight()) {
           return super.getBoard()[x][y];
       } else {
            return false;
        }
    }

    @Override
    public void turnToLiving(int x, int y) {
       if (x >= 0 && x < super.getWidth() && y >= 0 && y < super.getHeight()) {
           super.getBoard()[x][y] = true;
       }
    }

    @Override
    public void turnToDead(int x, int y) {
        if (x >= 0 && x < super.getWidth() && y >= 0 && y < super.getHeight()) {
           super.getBoard()[x][y] = false;
       }
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        this.calculator.setCoordinates(x, y);
        return calculator.calculateNeighbours();    
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        livingNeighbours = getNumberOfLivingNeighbours(x,y);
        switch (livingNeighbours){
                case 0:
                case 1:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    turnToDead(x,y);
                    break;
                case 2:
                case 3:
                    turnToLiving(x,y);
                    break;
               }
        }
    }  

