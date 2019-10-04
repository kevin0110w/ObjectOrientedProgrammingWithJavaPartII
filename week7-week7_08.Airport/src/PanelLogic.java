
import java.util.Scanner;

public class PanelLogic {

    private Scanner reader;
    private boolean isTrue;
    private ListOfPlanesAndFlights list;

    public PanelLogic() {
        this.reader = new Scanner(System.in);
        this.isTrue = true;
        this.list = new ListOfPlanesAndFlights();
    }

    public void start() {
        String command = "";
        welcome();
        while (this.isTrue) {
            choice();
        }
    }

    public void welcome() {
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println();
    }

    public void choice() {
        System.out.println("Choose operation: ");
        System.out.println("[1] Add airplane");
        System.out.println("[2] Add flight");
        System.out.println("[x] Exit");
        System.out.print("> ");
        String s = reader.nextLine();
        handleEvent(s);
    }

    public void handleEvent(String choice) {
        if (choice.equals("1")) {
            addAirplane();
        } else if (choice.equals("2")) {
            addFlight();
        } else if (choice.equals("x")) {
            System.out.println("\nFlight service");
            System.out.println("------------");
            handleFlights();
        }
    }

    public void addAirplane() {
        System.out.print("Give plane ID: ");
        String id = reader.nextLine();
        System.out.print("Give plane capacity: ");
        int capacity = Integer.parseInt(reader.nextLine());
        this.list.addPlane(new Airplane(id, capacity));
    }

    public void addFlight() {
        System.out.print("Give plane ID: ");
        String id = reader.nextLine();
        Airplane plane = list.getPlane(id);
        System.out.print("Give departure airport code: ");
        String departureAirportCode = reader.nextLine();
        System.out.print("Give destination airport code: ");
        String destinationAirportCode = reader.nextLine();
        this.list.addFlight(new Flight(plane, departureAirportCode, destinationAirportCode));
    }

    public void handleFlights() {
        String command = null;
        do {
            System.out.println("\nChoose operation: ");
            System.out.println("[1] Print planes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print plane info");
            System.out.println("[x] Quit");
            System.out.print("> ");
            command = reader.nextLine();
            handleEvent2(command);
        } while (!command.equals("x"));
    }

    public void handleEvent2(String command) {
        if (command.equals("1")) {
            printPlanes();
        } else if (command.equals("2")) {
            printFlights();
        } else if (command.equals("3")) {
            printPlaneInfo();
        } else if (command.equals(("x"))) {
            changeTrue();
        }
    }

    public void changeTrue() {
        this.isTrue = false;
    }

    public void printPlanes() {
        this.list.printPlanes();
    }

    public void printFlights() {
        this.list.printFlights();
    }

    public void printPlaneInfo() {
        System.out.print("Give plane ID: ");
        String id = this.reader.nextLine();
        for (Airplane plane : this.list.getPlanes()) {
            if ((plane.getID().equals(id))) {
                System.out.println(plane);
            }
        }
    }
}
