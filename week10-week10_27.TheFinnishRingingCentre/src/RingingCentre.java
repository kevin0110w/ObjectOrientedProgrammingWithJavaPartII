
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
public class RingingCentre {

    private Map<Bird, List<String>> observationPlaces;

    public RingingCentre() {
        this.observationPlaces = new HashMap<Bird, List<String>>();
    }

    public void observe(Bird bird, String place) {
        List<String> places = new ArrayList<String>();
        if (!this.observationPlaces.containsKey(bird)) {
            places.add(place);
        } else {
            places.addAll(this.observationPlaces.get(bird));
            places.add(place);
        }
        this.observationPlaces.put(bird, places);
    }

    public void observations(Bird bird) {
        if (this.observationPlaces.containsKey(bird)) {
            System.out.println(bird + " observations: " + this.observationPlaces.get(bird).size());
            this.observationPlaces.get(bird).stream()
                    .forEach(place -> System.out.println(place));
        } else {
            System.out.println(bird + " observations: 0");
        }
    }
}
