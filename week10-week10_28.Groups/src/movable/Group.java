
package movable;

import java.util.ArrayList;
import java.util.List;

public class Group implements Movable {
    private List<Movable> group;
    
    public Group() {
        this.group = new ArrayList<Movable>();
    }
    public String toString() {
        String desc = "";
       for (Movable movable : this.group) {
           desc = desc + movable.toString();
           desc = desc + "\n";
       }
       return desc;
    }
    
    public void addToGroup(Movable movable) {
        this.group.add(movable);
    }
    
    @Override
    public void move(int dx, int dy) {
       for (Movable movable : this.group) {
           movable.move(dx, dy);
       }
    }
}
