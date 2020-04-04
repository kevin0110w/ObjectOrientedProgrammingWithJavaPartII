package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private Random rand;
    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;

    public WormGame(int width, int height) {
        super(1000, null);
        this.rand = new Random();
        this.width = width;
        this.height = height;
        this.continues = true;
        this.worm = new Worm(width / 2, height / 2, Direction.DOWN);
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
    
    public Worm getWorm() {
        return this.worm;
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public Apple getApple() {
        return this.apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
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
