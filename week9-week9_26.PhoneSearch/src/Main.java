
public class Main {

    public static void main(String[] args) {
        // Start your program here
        // ATTENTION: In your program, you can create only one instance of class Scanner!
        Model m = new Model();
        View v = new View();
        Controller c = new Controller(m, v);
        c.start();
    }
}
