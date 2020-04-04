/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.Scanner;
/**
 *
 * @author woohoo
 */
public class Human extends Movable {
    private Scanner scanner;
    public Human(int widthMax, int heightMax, Scanner s) {
        super(widthMax, heightMax, "@");
        this.scanner = s;
    }

    @Override
    public void generateStartingPosition() {
        this.setCurrentPosition(new Position(0, 0));
    }

    @Override
    public void generateTemporaryPosition() {
        int tempX = this.getCurrentPosition().getX();
        int tempY = this.getCurrentPosition().getY();
        String commands = this.scanner.nextLine();
        for (int i = 0; i < commands.length(); i++) {
            switch (commands.charAt(i)) {
                case 'w':
                    if (tempY > 0) {
                        tempY--;
                    }
                    break;
                case 's':
                    if (tempY < super.getHeightMax() - 1) {
                        tempY++;
                    }
                    break;
                case 'a':
                    if (tempX > 0) {
                        tempX--;
                    }
                    break;
                case 'd':
                    if (tempX < super.getWidthMax() - 1) {
                        tempX++;
                    }
                    break;
            }
            this.getTemporaryPositions().add(new Position(tempX, tempY));
        }
    }
}
