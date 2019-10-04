import java.util.ArrayList;
import java.util.HashMap;

    
public class VehicleRegister {
    private HashMap<RegistrationPlate, String> owners;
        public VehicleRegister() {
            this.owners = new HashMap<RegistrationPlate, String>();
        }
    public boolean add(RegistrationPlate plate, String owner) {
      if (!owners.containsKey(plate)) {
          this.owners.put(plate, owner);
          return true;
      } else {
          return false;
      }
    }
    
    public String get(RegistrationPlate plate) {
        if (this.owners.containsKey(plate)) {
            return this.owners.get(plate);
        } else {
            return null;
        }
    }
    
    public boolean delete(RegistrationPlate plate) {
        if (this.owners.containsKey(plate)) {
            this.owners.remove(plate);
            return true;
        } else {
        return false;
    }
    }
    
    public void printRegistrationPlates() {
        for (RegistrationPlate plate : owners.keySet()) {
            System.out.println(plate);
        }
    }
    
    public void printOwners() {
        ArrayList<String> temp = new ArrayList<String>();
        String nameToAdd = "";
        
        for (RegistrationPlate plate: this.owners.keySet()){
            nameToAdd = this.owners.get(plate);
            
            if (!temp.contains(nameToAdd)) {
                temp.add(nameToAdd);
            }
        }
        
        for (String owners: temp) {
            System.out.println(owners);
        }
    }
}
