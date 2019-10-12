package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Worm;
import wormgame.domain.Piece;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {
    private Worm worm;
    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Apple apple;
    private Random rand;
            
    public WormGame(int width, int height) {
        super(1000, null);
        this.rand = new Random();
        this.width = width;
        this.height = height;
        this.worm = new Worm(this.width / 2, this.height / 2, Direction.DOWN);
        this.continues = true;       
        
        createApple();
        addActionListener(this);
        setInitialDelay(2000);

    }
    
    public int randomX() {
        int randx = rand.nextInt(this.width);
        return randx;
    }
    
    public int randomY() {
        int randy = rand.nextInt(this.height);
        return randy;
    }
    /**
     * returns the WormGame worm.
     * @return 
     */
    public Worm getWorm() {
        return this.worm;
    }
    
    /**
     * sets on the game the method parameter worm. 
     * If the method getWorm is called after the worm has been set up, 
     * it has to return a reference to the same worm.
     * @param worm 
     */
    public void setWorm(Worm worm) {
        this.worm = worm;
   }
    
    /**
     *  returns the apple of the WormGame.
     */
    public Apple getApple() {
        return this.apple;
    }
    
    /**
     * sets the method parameter apple on the worm game. 
     * If the method getApple is called after the apple has been set up, it has to return a reference to the same apple.
     * @param apple 
     */
    public void setApple(Apple apple) {
        this.apple = apple;
    }


    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (continues) {
            this.worm.move();
            if (bumpsIntoTopBorder() || bumpsIntoLeftBorder() || bumpsIntoRightBorder() || bumpsIntoBottomBorder()) {
                this.continues = false;
                System.out.println(this.continues);
                return;
            }
            if (this.worm.runsInto(this.apple)) {
                this.worm.grow();
                createApple();
            } else if (this.worm.runsIntoItself()) {
                this.continues = false;
            }
            this.updatable.update();
            this.setDelay(1000 / this.worm.getLength());
        }

    }

    private void createApple() {
         while (true) {
            this.apple = new Apple(randomX(), randomY());
            if (!this.worm.runsInto(apple)) {
                break;
            }
        }
    }

    private boolean bumpsIntoTopBorder() {
        for (int i = 0; i < width; i++) {
            Piece p = new Piece(i, 0);
            if (this.worm.runsInto(p)) {
                return true;
            }
        }
        return false;
    }

    private boolean bumpsIntoLeftBorder() {
        for (int i = 0; i < height; i++) {
            Piece p = new Piece(0, i);
            if (this.worm.runsInto(p)) {
                return true;
            }
        }
        return false;
    }

    private boolean bumpsIntoRightBorder() {
        for (int i = 0; i < height; i++) {
            Piece p = new Piece(width, i);
            if (this.worm.runsInto(p)) {
                return true;
            }
        }
        return false;
    }

    private boolean bumpsIntoBottomBorder() {
        for (int i = 0; i < width; i++) {
            Piece p = new Piece(i, height);
            if (this.worm.runsInto(p)) {
                return true;
            }
        }
        return false;
    }

}
