
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author woohoo
 */
public class AirportPanel {

    private Scanner reader;
    private Airplanes airplanes;
    private Flights flights;

    public AirportPanel() {
        this.reader = new Scanner(System.in);
        this.airplanes = new Airplanes();
        this.flights = new Flights();
    }

    public void start() {
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println("");
        chooseAirportOperation();
    }

    private void chooseAirportOperation() {
        while (true) {
            System.out.println("Choose operation:");
            System.out.println("[1] Add airplane");
            System.out.println("[2] Add flight");
            System.out.println("[x] Exit");
            System.out.print("> ");
            String command = this.reader.nextLine();
            if (command.equals("1")) {
                addAirplane();
            } else if (command.equals("2")) {
                addFlight();
            } else if (command.equals("x")) {
                System.out.println("");
                break;
            }
        }
        flightService();
    }

    private void addAirplane() {
        System.out.print("Give plane ID: ");
        String id = this.reader.nextLine();
        System.out.print("Give plane capacity: ");
        int capacity = Integer.valueOf(this.reader.nextLine());
        Airplane plane = new Airplane(id, capacity);
        this.airplanes.addAirplane(id, plane);
    }

    private void addFlight() {
        System.out.print("Give plane ID: ");
        String id = this.reader.nextLine();
        System.out.print("Give departure airport code: ");
        String departureAirportCode = this.reader.nextLine();
        System.out.print("Give destination airport code: ");
        String destinationAirportCode = this.reader.nextLine();
        Flight f = new Flight(this.airplanes.getPlane(id), departureAirportCode, destinationAirportCode);
        this.flights.addFlight(f);
    }

    private void flightService() {
        System.out.println("Flight service");
        System.out.println("------------");
        System.out.println("");
        chooseFlightOperation();
    }

    private void chooseFlightOperation() {
        while (true) {
            System.out.println("Choose operation:");
            System.out.println("[1] Print planes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print plane info");
            System.out.println("[x] Quit");
            System.out.print("> ");
            String command = this.reader.nextLine();
            if (command.equals("1")) {
                printPlanes();
            } else if (command.equals("2")) {
                printFlights();
                System.out.println("");
            } else if (command.equals("3")) {
                printPlaneInfo();
                System.out.println("x");
            } else if (command.equals("x")) {
                System.out.println("");
                break;
            }
        }
    }

    private void printPlanes() {
        System.out.println(this.airplanes);
    }

    private void printFlights() {
        System.out.println(this.flights);
    }

    private void printPlaneInfo() {
        System.out.print("Give plane ID: ");
        String id = this.reader.nextLine();
        System.out.println(this.airplanes.getPlane(id));
    }
}
