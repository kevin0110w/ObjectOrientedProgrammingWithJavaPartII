/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.List;

/**
 *
 * @author woohoo
 */
public class View {
    public void printBlinkings(int x){
        System.out.println(x);
        System.out.println("");
    }
    
    public void printCharacters(List<Movable> things){
        for (Movable m : things) {
            System.out.println(m);
        }
        System.out.println("");
    }
    
    public void printDungeon(Dungeon d) {
        System.out.println(d);
    }
    
    public void printYouWin(){
        System.out.println("YOU WIN");
    }
    
    public void printYouLose(){
        System.out.println("YOU LOSE");
    }
}
