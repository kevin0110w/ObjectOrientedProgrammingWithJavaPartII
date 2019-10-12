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
    private WormGame game;
    private int pieceLength;
    
    public DrawingBoard(WormGame game, int pieceLength) {
        this.game = game;
        this.pieceLength = pieceLength;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        for (Piece piece : this.game.getWorm().getPieces()) {
            g.fill3DRect(piece.getX()*this.pieceLength, piece.getY()*this.pieceLength, this.pieceLength, this.pieceLength, true);
        }
        g.setColor(Color.RED);
        
        g.fillOval(game.getApple().getX()*this.pieceLength, game.getApple().getY()*this.pieceLength, this.pieceLength, this.pieceLength);
    }

    @Override
    public void update() {
        this.repaint();
    }
}
