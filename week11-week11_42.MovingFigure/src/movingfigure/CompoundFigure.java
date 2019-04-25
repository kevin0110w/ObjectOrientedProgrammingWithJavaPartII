/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author kevin0110w
 */
public class CompoundFigure extends Figure{
    private List<Figure> figures;
    
    public CompoundFigure() {
        super(0,0);
        this.figures = new ArrayList<Figure>();
    }
    
    public void add(Figure f) {
        this.figures.add(f);
    }
    
    @Override
    public void draw(Graphics graphics) {
        for (Figure figure : this.figures) {
            figure.draw(graphics);
        }
    }
    
    @Override
    public void move(int x, int y) {
        for (Figure figure : this.figures) {
            figure.move(x,y);
        }
    }
}
