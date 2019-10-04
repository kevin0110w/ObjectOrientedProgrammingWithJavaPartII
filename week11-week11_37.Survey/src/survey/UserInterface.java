package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Survey");
        frame.setPreferredSize(new Dimension(200, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }


    public JFrame getFrame() {
        return frame;
    }

    private void createComponents(Container contentPane) {
        BoxLayout layout = new BoxLayout(contentPane, BoxLayout.Y_AXIS);
        contentPane.setLayout(layout);
        
        JLabel text = new JLabel("Are you?");
        JCheckBox yes = new JCheckBox("Yes!");
        JCheckBox no = new JCheckBox("No!");
        JLabel text2 = new JLabel("Why?");
        ButtonGroup b = new ButtonGroup();
        JRadioButton no_reason = new JRadioButton("No reason.");
        JRadioButton because = new JRadioButton("Because it is fun!");
        b.add(no_reason);
        b.add(because);
        contentPane.add(text);
        contentPane.add(yes);
        contentPane.add(no);
        contentPane.add(text2);
        contentPane.add(no_reason);
        contentPane.add(because);
        JButton done = new JButton("Done!");
        contentPane.add(done);
    }
}
