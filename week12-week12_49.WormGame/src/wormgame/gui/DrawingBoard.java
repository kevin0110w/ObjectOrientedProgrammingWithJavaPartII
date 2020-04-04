/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.domain.Piece;
import wormgame.game.WormGame;

/**
 *
 * @author woohoo
 */
public class DrawingBoard extends JPanel implements Updatable {

    private int pieceLength;
    private WormGame g;

    public DrawingBoard(WormGame g, int pieceLength) {
        this.g = g;
        this.pieceLength = pieceLength;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        for (Piece p : this.g.getWorm().getPieces()) {
            g.fill3DRect(p.getX()*this.pieceLength, p.getY()*this.pieceLength, this.pieceLength, this.pieceLength, true);
        }
        g.setColor(Color.RED);
        g.fillOval(this.g.getApple().getX()*this.pieceLength, this.g.getApple().getY()*this.pieceLength, this.pieceLength, this.pieceLength);
    }

    @Override
    public void update() {
        this.repaint();
    }
}
