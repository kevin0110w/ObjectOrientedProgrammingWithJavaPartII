package drawing.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Component;

public class KeyboardListener implements KeyListener {
  private Avatar avatar;
  private Component component;

  public KeyboardListener(Avatar avatar, Component component) {
    this.avatar = avatar;
    this.component = component;
  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      this.avatar.move(-5, 0);
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      this.avatar.move(5, 0);
    } 
    this.component.repaint();
  }

  @Override
  public void keyTyped(KeyEvent ke) {

  }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Keystroke " + e.getKeyCode() +  " pressed.");
    }
}
