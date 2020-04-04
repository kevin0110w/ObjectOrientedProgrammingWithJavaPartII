
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
    private Model model;
    
    public GraphicCalculator(Model m) {
        this.model = m;
    }
    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(300, 150));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3,1);
        container.setLayout(layout);
        setContainer(container);
    }

    public JFrame getFrame() {
        return frame;
    }

    private void setContainer(Container container) {
        JTextField top = new JTextField();
        top.setEnabled(false);
        JTextField middle = new JTextField();
        middle.setText("0");
        top.setText("0");
        JPanel panel = new JPanel(new GridLayout(1,3));
        container.add(top);
        container.add(middle);
        container.add(panel);
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton z = new JButton("z");
        z.setEnabled(false);
        plus.setActionCommand("PLUS");
        minus.setActionCommand("MINUS");
        z.setActionCommand("Z");
        panel.add(plus);
        panel.add(minus);
        panel.add(z);
        CalculatorListener l = new CalculatorListener(this.model, top, middle, plus, minus, z);
        plus.addActionListener(l);
        minus.addActionListener(l);
        z.addActionListener(l);
    }
}
