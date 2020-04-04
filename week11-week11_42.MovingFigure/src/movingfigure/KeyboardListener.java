/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author woohoo
 */
public class KeyboardListener implements KeyListener {

    private Component comp;
    private Figure fig;

    public KeyboardListener(Component comp, Figure fig) {
        this.comp = comp;
        this.fig = fig;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.fig.move(-1, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.fig.move(1, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.fig.move(0, 1);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.fig.move(0, -1);
        }

        this.comp.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }

}
