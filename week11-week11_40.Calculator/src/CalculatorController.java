
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author kevin0110w
 */
public class CalculatorController implements ActionListener {

    private JTextField input, output;
    private CalculatorModel calculator;
    private JButton Z, add, minus;

    public CalculatorController(CalculatorModel calculator, JTextField input, JTextField output, JButton Z, JButton add, JButton minus) {
        this.Z = Z;
        this.add = add;
        this.minus = minus;
        this.calculator = calculator;
        this.input = input;
        this.output = output;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            add();
        } else if (e.getSource() == minus) {
            subtract();
        } else if (e.getSource() == Z) {
            reset();
        }
        this.input.setText("");
    }

    private void add() {
        try {
            int addition = Integer.parseInt(this.input.getText());
            this.calculator.addTwoNumbers(addition);
            this.output.setText(Integer.toString(this.calculator.getValue()));
            enableZ();
        } catch (NumberFormatException e) {
            this.input.setText("0");
        }
    }

    private void subtract() {
        try {
            int sub = Integer.parseInt(this.input.getText());
            this.calculator.subTwoNumbers(sub);
            this.output.setText(Integer.toString(this.calculator.getValue()));
            enableZ();
        } catch (NumberFormatException e) {
            this.input.setText("0");
        }
    }

    private void reset() {
        this.calculator.resetValue();
        this.output.setText(Integer.toString(0));
        Z.setEnabled(false);
    }
    
    private void enableZ() {
        if (this.calculator.getValue() == 0) {
            this.Z.setEnabled(false);
        } else {
            this.Z.setEnabled((true));
        }
    }
}
