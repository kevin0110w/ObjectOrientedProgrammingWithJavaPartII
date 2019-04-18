
import java.util.ArrayList;

public class ListOfPlanesAndFlights {

    private ArrayList<Airplane> planes;
    private ArrayList<Flight> flights;

    public ListOfPlanesAndFlights() {
        this.planes = new ArrayList<Airplane>();
        this.flights = new ArrayList<Flight>();
    }

    public void addPlane(Airplane plane) {
        this.planes.add(plane);
    }

    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }

    public void printPlanes() {
        for (Airplane plane : this.planes) {
            System.out.println(plane);
        }
    }

    public void printFlights() {
        for (Flight flight : this.flights) {
            System.out.println(flight);
        }
    }

    public ArrayList<Airplane> getPlanes() {
        return this.planes;
    }

    public ArrayList<Flight> getFlights() {
        return this.flights;
    }
}