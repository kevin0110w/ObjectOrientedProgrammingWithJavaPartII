package moving.domain;

import java.util.List;
import java.util.ArrayList;

public class Box implements Thing{
    private int maximumCapacity;
    private List<Thing> things;
    
    public Box(int maximumCapacity){
        this.maximumCapacity = maximumCapacity;
        this.things = new ArrayList<Thing>();
    }
    
    public Box(Box aBox){
        this.things = new ArrayList<Thing>();
        this.maximumCapacity = aBox.maximumCapacity;
    }
    
    public boolean addThing(Thing thing){
        if((thing.getVolume() + this.getVolume()) <= this.maximumCapacity){
            this.things.add(thing);
            return true;
        }
        return false;
    }
    
    @Override
    public int getVolume(){
        int vol = 0;
        for(Thing x : this.things){
            vol += x.getVolume();
        }
        return vol;
    }
    
}
