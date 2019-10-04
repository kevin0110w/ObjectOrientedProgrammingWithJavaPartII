
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraphicCalculator implements Runnable {

    private JFrame frame;
    public JButton plus, minus, Z;
    private CalculatorModel calculator;

    public GraphicCalculator() {
        this.calculator = new CalculatorModel();
    }

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3,1);
        container.setLayout(layout);
        JTextField output = new JTextField();
        output.setText("0");
        output.setEnabled(false);
        JTextField input = new JTextField();
        container.add(output);
        container.add(input);
        JPanel panel = new JPanel(new GridLayout(1, 3));
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton Z = new JButton("Z");
            Z.setEnabled(false);
        CalculatorController logic = new CalculatorController(this.calculator, input, output, Z, plus, minus);
        panel.add(plus);
        panel.add(minus);
        panel.add(Z);
        plus.addActionListener(logic);
        minus.addActionListener(logic);
        Z.addActionListener(logic);
        container.add(panel);
    }

    public JFrame getFrame() {
        return frame;
    }
}
