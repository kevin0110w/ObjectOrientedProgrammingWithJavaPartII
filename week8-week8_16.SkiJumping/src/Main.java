
public class Main {

    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be very useful.
        JumpingLogic model = new JumpingLogic();
        JumpingInterface view = new JumpingInterface();
        JumpingController controller = new JumpingController(model, view);
        controller.start();
    }
}
