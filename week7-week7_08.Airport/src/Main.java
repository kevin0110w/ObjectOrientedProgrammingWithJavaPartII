import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        start(s);        
    }
    
    static void start(Scanner reader) {
        String command = "";
        while (!(command.equals("Exit"))) {
            welcome();
            choice(reader);
        }
    }
    
    static void welcome() {
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println("");
    }
    
    static void choice(Scanner reader) {
        System.out.println("Choose operation");
        System.out.println(" [1] Add airplane");
        System.out.println(" [2] Add flight");
        System.out.println(" [x] Exit");
        String s = reader.nextLine();
        handleEvent(s, reader);
    }
    
    static void handleEvent(String choice, Scanner reader) {
        if (choice.equals("1")) {
            addAirplane(reader);
        } else if (choice.equals("2")) {
            addFlight(reader);
        } else {
            
        }
    }
    
    static void addAirplane(Scanner reader) {
        System.out.println("Give plane ID: ");
        String s = reader.nextLine();
        System.out.println("Give plane capacity: ");
        int x = Integer.parseInt(reader.nextLine());
        Airplane airplane = new Airplane(s, x);
        
        
    }
}
