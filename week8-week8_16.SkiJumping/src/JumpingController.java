
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
public class JumpingController {

    private Scanner s;
    private JumpingLogic model;
    private JumpingInterface view;

    public JumpingController(JumpingLogic model, JumpingInterface view) {
        this.s = new Scanner(System.in);
        this.model = model;
        this.view = view;

    }

    public void start() {
        this.view.printWelcome();
        this.view.printJumperCommand();
        recordJumperDetails();
        this.view.printJumpingCommencementMessage();
        startJumpingGame();
        this.view.printThanks();
        this.model.sortJumpersByHighestScores();
        this.view.printResults(this.model.getJumpers());
    }

    private void recordJumperDetails() {
        while (true) {
            System.out.print("  Participant name: ");
            String name = this.s.nextLine();

            if (name.isEmpty()) {
                break;
            }

            this.model.addJumper(name);
        }
    }

    private void startJumpingGame() {
        while (true) {
        System.out.print("Write \"jump\" to jump; otherwise you quit: ");
        String command = this.s.nextLine();
        
        if (!command.equals("jump")) {
            System.out.println("");
            break;
            }
        
        System.out.println("");
        controlJumpingRound();
        }
    }

    private void controlJumpingRound() {
        this.view.printRound(this.model.getRound());
        this.model.sortJumpers();
        this.view.printJumperOrder(this.model.getJumpers());
        this.model.generatePlayerJumps();
        this.view.printResultsOfRound(this.model.getRound(), this.model.getJumpers(), this.model.getJudgesScores(), this.model.getRoundJump());
        this.model.incrementRound();
    }
}
