
import java.util.HashMap;
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
public class VehicleRegister {

    private Map<RegistrationPlate, String> owners;

    public VehicleRegister() {
        this.owners = new HashMap<RegistrationPlate, String>();
    }

    public boolean add(RegistrationPlate plate, String owner) {
        if (this.owners.containsKey(plate)) {
            return false;
        }
        this.owners.put(plate, owner);
        return true;
    }

    public String get(RegistrationPlate plate) {
        if (!this.owners.containsKey(plate)) {
            return null;
        }
        return this.owners.get(plate);
    }

    public boolean delete(RegistrationPlate plate) {
        if (this.owners.containsKey(plate)) {
            this.owners.remove(plate);
            return true;
        }
        return false;
    }
    
    public void printRegistrationPlates() {
        for (RegistrationPlate rp : this.owners.keySet()) {
            System.out.println(rp);
        }
    }
    
    public void printOwners() {
        Map<String,Integer> placeHolder = new HashMap<String,Integer>();
        for (RegistrationPlate rp : this.owners.keySet()) {
            if (!(placeHolder.containsKey(this.owners.get(rp)))) {
                System.out.println(this.owners.get(rp));
                placeHolder.put(this.owners.get(rp), 1);
            } 
        }
    }

}
