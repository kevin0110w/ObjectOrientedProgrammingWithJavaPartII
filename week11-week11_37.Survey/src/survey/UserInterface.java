package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Survey");
        frame.setPreferredSize(new Dimension(500, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        JLabel areYou = new JLabel("Are you?");
        JCheckBox yes = new JCheckBox("Yes!");
        JCheckBox no = new JCheckBox("No!");
        JLabel why = new JLabel("Why?");
        ButtonGroup buttons = new ButtonGroup();
        JRadioButton noReason = new JRadioButton("No reason.");
        JRadioButton because = new JRadioButton("Because it is fun!");
        buttons.add(noReason);
        buttons.add(because);
        JButton done = new JButton("Done!");
        container.add(areYou);
        container.add(yes);
        container.add(no);
        container.add(why);
        container.add(noReason);
        container.add(because);
        container.add(done);
    }

    public JFrame getFrame() {
        return frame;
    }
}
