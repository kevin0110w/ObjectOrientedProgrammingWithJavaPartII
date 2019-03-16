
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        ArrayList<Jumpers> jumper = new ArrayList<Jumpers>();
        welcome();
        enterParticipants(jumper, x);
        
    }
    
    public static void welcome() {
        System.out.println("Kumpula ski jumping week");
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase");
    }
    
    public static void enterParticipants(ArrayList<Jumpers> y, Scanner reader) {
        String command = null;
        do {
            System.out.print("Participant name: ");
            command = reader.nextLine();
            Jumpers x = new Jumpers(command);
            y.add(x);
            
        } while (!command.isEmpty());
        System.out.println(y);
    }
}
