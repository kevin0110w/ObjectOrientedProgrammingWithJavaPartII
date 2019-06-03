package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author woohoo
 */
public class Dungeon {
    private int length, height, vampires, moves;
    private boolean vampiresMoves;
    private String[][] dungeonLayout;
    private List<Vampire> theVampires;
    private Player player;
    private Scanner scanner;
    
    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.scanner = new Scanner(System.in);
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMoves = vampiresMoves;
        this.theVampires = new ArrayList<Vampire>();
        this.dungeonLayout = new String[length][height];
        setDungeonLayout();
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getVampires() {
        return vampires;
    }
    public void setVampires(int vampires) {
        this.vampires = vampires;
    }
    public int getMoves() {
        return moves;
    }
    public void setMoves(int moves) {
        this.moves = moves;
    }
    public boolean isVampireMoves() {
        return vampiresMoves;
    }
    public void setVampireMoves(boolean vampireMoves) {
        this.vampiresMoves = vampireMoves;
    }
    public void setDungeonLayout() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.length; j++) {
                this.dungeonLayout[i][j] = ".";
            }
        }
    }
    
    public void printDungeonLayout() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.length; j++) {
                System.out.print(this.dungeonLayout[i][j]);
            }
            System.out.println();
        }
    }
    
    public void updateDungeonLayoutFromPlayer() {
        setDungeonLayout();
        int vertical = this.player.getY();
        int horizontal = this.player.getX();
        this.dungeonLayout[vertical][horizontal] = this.player.getName();
    }
    
    public void updateDungeonLayoutFromVamp(int pos) {
        int vertical = this.theVampires.get(pos).getY();
        int horizontal = this.theVampires.get(pos).getX();
        this.dungeonLayout[vertical][horizontal] = this.theVampires.get(pos).getName();
    }
    
    public void setVampires() {
        for (int i = 0; i < this.vampires; i++) {
            this.theVampires.add(new Vampire(this.length, this.height));
        }
    }
    
    public void run() {
        this.player = new Player(this.length, this.height);
        setVampires();
        String command = "";
        while (this.moves > 0) {
            System.out.println(this.moves);
            System.out.println();
            System.out.println(this.player);
            updateDungeonLayoutFromPlayer();
            for (int i = 0; i < this.theVampires.size(); i++) {
                System.out.println(this.theVampires.get(i));
                updateDungeonLayoutFromVamp(i);
            }
            System.out.println();
            printDungeonLayout();
            System.out.println();
            command = this.scanner.nextLine();
            for (int i = 0; i < command.length(); i++) {
                if (this.player.move(command.charAt(i))) {
                 vampiresMove();   
                }
            }
            if (result()) {
                System.out.println("YOU WIN");
                System.exit(0);
            }
            this.moves--;
        }
        System.out.println("YOU LOSE");
    }
    public void vampiresMove() {
        int vertical = this.player.getY();
        int horizontal = this.player.getX();
        for (int i = 0; i < theVampires.size(); i++) {
            theVampires.get(i).move(this.vampiresMoves);
            if (this.dungeonLayout[theVampires.get(i).getTempY()][theVampires.get(i).getTempX()].equals(".")) {
                theVampires.get(i).newPosition();
            } else if (theVampires.get(i).getTempY() == vertical && theVampires.get(i).getTempX() == horizontal) {
            this.theVampires.remove(i);
            i--;
        }    
        }
    }

    private boolean result() {
        return this.theVampires.isEmpty();
    }
}
