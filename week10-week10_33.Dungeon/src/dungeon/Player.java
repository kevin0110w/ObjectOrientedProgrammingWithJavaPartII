package dungeon;

/**
 *
 * @author kevin0110w
 */
public class Player {
    private int x, y, length, height;
    private final String name;
    public Player(int length, int height) {
        this.length = length - 1;
        this.height  = height - 1;
        this.x = 0;
        this.y = 0;
        this.name = "@";
    }
    public boolean move(char command) {
            switch (command) {
                case 'w':
                    if (this.y > 0) {
                        this.y--;
                        return true;
                    }
                case 's':
                    if (this.y < this.height) {
                        this.y++;
                        return true;
                    }
                case 'a':
                    if (this.x > 0) {
                        this.x++;
                        return true;
                    }
                case 'd':
                    if (this.x < this.length) {
                        this.x--;
                        return true;
                    }
            }
            return false;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public String getName() {
        return name;
    }
    public String toString() {
        return this.name + " " + this.x + " " + this.y;
    }
}
