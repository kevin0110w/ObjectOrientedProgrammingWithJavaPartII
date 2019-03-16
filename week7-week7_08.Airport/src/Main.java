import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static private ArrayList<Airplane> x = new ArrayList<Airplane>();
    static private ArrayList<Flight> y = new ArrayList<Flight>();
    static private boolean isTrue = true;
   
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        start(s);        
    }
    
     static void start(Scanner reader) {
        String command = "";
        welcome();
        while (isTrue) {
        choice(reader);
        }
    }
    
     static void welcome() {
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println("");
    }
    
     static void choice(Scanner reader) {
        System.out.println("Choose operation: ");
        System.out.println(" [1] Add airplane");
        System.out.println(" [2] Add flight");
        System.out.println(" [x] Exit");
         System.out.print("> ");
        String s = reader.nextLine();
        handleEvent(s, reader);
    }
    
     static void handleEvent(String choice, Scanner reader) {
        if (choice.equals("1")) {
            addAirplane(reader);
        } else if (choice.equals("2")) {
            addFlight(reader);
        } else {
            System.out.println("\nFlight service");
            System.out.println("------------");
            handleFlights(reader);
        }
    }
    static void handleFlights(Scanner reader) {
        String command = null;
        do {
        System.out.println("\nChoose operation: ");
        System.out.println("[1] Print planes");
        System.out.println("[2] Print flights");
        System.out.println("[3] Print plane info");
        System.out.println("[x] Quit");
        command = reader.nextLine();
        handleEvent2(command, reader);
        }  while (!command.equals("x"));
    }
    
    static void handleEvent2(String command, Scanner reader) {
    if (command.equals("1")) {
            printPlanes();
        } else if (command.equals("2")) {
            printFlights();
        } else if (command.equals("3")) {
            printPlaneInfo(reader);
        } else if (command.equals(("x"))) {
            changeTrue();
        }
    }
    
    static void changeTrue(){
        isTrue = false;
    }
    
     static void addAirplane(Scanner reader) {
        System.out.print("Give plane ID: ");
        String s = reader.nextLine();
        System.out.print("Give plane capacity: ");
        int id = Integer.parseInt(reader.nextLine());
        x.add(new Airplane(s, id));
    }
     
     static void addFlight(Scanner reader) {
         System.out.print("Give plane ID: ");
         String id = reader.nextLine();
         System.out.print("Give departure airport code: ");
         String departureAirportCode = reader.nextLine();
         System.out.print("Give destinatation airport code: ");
         String destinationAirportCode = reader.nextLine();
        
         for (int i = 0; i < x.size(); i++) {
             if (x.get(i).getID().equals(id)) {
                 y.add(new Flight(x.get(i), departureAirportCode, destinationAirportCode));
             }
         }
     }
     
     static void printPlanes() {
         for (Airplane plane : x) {
             System.out.println(plane);
         }
     }
     
     static void printFlights() {
         for (Flight flight : y) {
             System.out.println(flight);
         }
     }
     
     static void printPlaneInfo(Scanner reader) {
         System.out.print("Give plane ID: ");
         String id = reader.nextLine();
         for (int i = 0; i<x.size(); i++) {
             if (x.get(i).getID().equals(id)) {
                 System.out.println(x.get(i));
             }
         }
     }
}
