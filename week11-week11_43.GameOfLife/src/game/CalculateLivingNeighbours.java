package game;
/**
 *
 * @author woohoo
 */
class CalculateLivingNeighbours {
    private int counter, x, y;
    private PersonalBoard personalBoard;
    public CalculateLivingNeighbours(PersonalBoard personalBoard) {
        this.personalBoard = personalBoard;
    }
    void setCoordinates(int x, int y) {
        this.counter = 0;
        this.x = x;
        this.y = y;
    }
    int calculateNeighbours() {
        // find out whether coordinates are at edges of boards
        if ((y == 0 || y == personalBoard.getHeight()-1) && (x == 0 || x == personalBoard.getWidth()-1)) {
           calculationForCorner();
              return counter; 
        } 
        //otherwise check whether coordinates at sides of boards
        else if (((x == 0 && y > 0 && y < personalBoard.getHeight()-1) || 
                (x == personalBoard.getWidth()-1 && y > 0 && y < personalBoard.getHeight()-1) || 
                (y == 0 && x > 0 && x < personalBoard.getWidth()-1) ||
                (y == personalBoard.getHeight()-1 && x > 0 && x < personalBoard.getWidth()-1))) {
           calculationForSide();
              return counter;
        }
        // of if coordinates are anywhere else on the board
        else if ((x > 0 && x < personalBoard.getWidth()-1) && (y > 0 && y < personalBoard.getHeight()-1)) {
            calculationForCentre();
               return counter;
        } 
     return counter;
    }
    
    public void testOneUpLeft() {
        this.counter += this.personalBoard.getBoard()[x-1][y-1] ? 1 : 0;
    }
    
    public void testOneUp() {
        this.counter += this.personalBoard.getBoard()[x][y-1] ? 1 : 0;
    }
   
    public void testOneUpRight() {
        this.counter += this.personalBoard.getBoard()[x+1][y-1] ? 1 : 0;
    }
    
    public void testOneRight() {
        this.counter += this.personalBoard.getBoard()[x+1][y] ? 1 : 0;
    }
    
    public void testOneRightDown() {
        this.counter += this.personalBoard.getBoard()[x+1][y+1] ? 1 : 0;
    }
    
    public void testOneDown() {
        this.counter += this.personalBoard.getBoard()[x][y+1] ? 1 : 0;
    }
    
    public void testOneLeftDown() {
        this.counter += this.personalBoard.getBoard()[x-1][y+1] ? 1 : 0;
    }
    
    public void testOneLeft() {
        this.counter += this.personalBoard.getBoard()[x-1][y] ? 1 : 0;
    }

    private void calculationForCorner() {
        if (this.x == 0 && this.y == 0) {
            testOneRight();
            testOneRightDown();
            testOneDown();
        } else if (this.x == 0 && this.y == personalBoard.getHeight() - 1) {
            testOneUp();
            testOneUpRight();
            testOneRight();
        } else if (this.x == personalBoard.getWidth()-1 && this.y == 0) {
            testOneDown();
            testOneLeftDown();
            testOneLeft();
        } else if (this.x == personalBoard.getWidth() - 1 && this.y == personalBoard.getHeight() - 1) {
            testOneLeft();
            testOneUpLeft();
            testOneUp();
        }
    }

    private void calculationForCentre() {
        testOneUp();
        testOneUpRight();
        testOneRight();
        testOneRightDown();
        testOneDown();
        testOneLeftDown();
        testOneLeft();
        testOneUpLeft();    
    }

    private void calculationForSide() {
        if (x == 0 && y > 0 && y < personalBoard.getHeight()-1) {
            testOneUp();
            testOneUpRight();
            testOneRight();
            testOneRightDown();
            testOneDown();
            return;
        } else if (x == personalBoard.getWidth()-1 && y > 0 && y < personalBoard.getHeight()-1) {
            testOneUp();
            testOneUpLeft();
            testOneLeft();
            testOneLeftDown();
            testOneDown();
        } else if (y == 0 && x > 0 && x < personalBoard.getWidth()-1) {
            testOneRight();
            testOneRightDown();
            testOneDown();
            testOneLeftDown();
            testOneLeft();
        } else if (y == personalBoard.getHeight()-1 && x > 0 && x < personalBoard.getWidth()-1) {
            testOneLeft();
            testOneUpLeft();
            testOneUp();
            testOneUpRight();
            testOneRight();
        }
    }
}
