
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RingingCentre {
    private HashMap<Bird, ArrayList<String>> observations;
    
    public RingingCentre(){
        this.observations = new HashMap<Bird, ArrayList<String>>();
    }
    
    public void observe(Bird bird, String place){
        if(!this.observations.containsKey(bird)){
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(place);
            this.observations.put(bird, temp);
        }
        else{
           this.observations.get(bird).add(place);
        }
}
    
  public void observations(Bird bird){
        System.out.print(bird);       
        System.out.print(" observations: ");
        if(this.observations.containsKey(bird)){
            System.out.println(""+ this.observations.get(bird).size());
            for(String place : this.observations.get(bird)) {
                System.out.println(place);
            }
        }
        else{
            System.out.println(""+ 0);
        }
}
    
    public static void main(String[] args) {
    RingingCentre kumpulaCentre = new RingingCentre();

    kumpulaCentre.observe( new Bird("Rose Starling", "Sturnus roseus", 2012), "Arabia" );
    kumpulaCentre.observe( new Bird("Rose-Coloured Starling", "Sturnus roseus", 2012), "Vallila" );
    kumpulaCentre.observe( new Bird("European Herring Gull", "Larus argentatus", 2008), "Kumpulanmäki" );
    kumpulaCentre.observe( new Bird("Rose Starling", "Sturnus roseus", 2008), "Mannerheimintie" );

    kumpulaCentre.observations( new Bird("Rose-Coloured Starling", "Sturnus roseus", 2012 ) );
    System.out.println("--");
    kumpulaCentre.observations( new Bird("European Herring Gull", "Larus argentatus", 2008 ) );
    System.out.println("--");
    kumpulaCentre.observations( new Bird("European Herring Gull", "Larus argentatus", 1980 ) );
    }
}
