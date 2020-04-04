
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author woohoo
 */
public class Airplanes {
    private Map<String,Airplane> airplanes;
    
    public Airplanes() {
        this.airplanes = new HashMap<String,Airplane>();
    }
    
    public void addAirplane(String id, Airplane plane) {
        if (plane == null) {
            return;
        }
        
        this.airplanes.put(id, plane);
    }
    
    public Airplane getPlane(String id) {
        if (this.airplanes.containsKey(id)) {
            return this.airplanes.get(id);
        } else {
            return null;
        }
    }
    
    @Override
    public String toString() {
        String airplanes = "";
        for (String f: this.airplanes.keySet()) {
            airplanes += this.airplanes.get(f).toString() + "\n";;
        }
        return airplanes;
    }
    
}
