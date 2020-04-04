
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author woohoo
 */
public class CalculatorListener implements ActionListener {
    private JTextField top, middle;
    private JButton plus, minus, z;
    private Model model;

    public CalculatorListener(Model model, JTextField top, JTextField middle, JButton plus, JButton minus, JButton z) {
        this.model = model;
        this.top = top;
        this.middle = middle;
        this.plus = plus;
        this.minus = minus;
        this.z = z;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("PLUS")) {
            plus();
        } else if (e.getActionCommand().equals("MINUS")) {
            minus();
        } else if (e.getActionCommand().equals("Z")) {
            z();
        }
        
    }

    private void plus() {
        if (!invalidInput()) {
            this.middle.setText("");
            return;
        }
        int inputNumber = Integer.valueOf(this.middle.getText());
        this.model.setOutput(this.model.getOutput() + inputNumber);
        this.top.setText(Integer.toString(this.model.getOutput()));
        System.out.println(Integer.toString(this.model.getOutput()));
        this.middle.setText("");
        if (this.model.getOutput() == 0) {
            this.z.setEnabled(false);
        }  else {
            this.z.setEnabled(true);
        }
    }

    private void minus() {
        if (!invalidInput()) {
            this.middle.setText("");
            return;
        }
        int inputNumber = Integer.valueOf(this.middle.getText());
        this.model.setOutput(this.model.getOutput() - inputNumber);
        this.top.setText(Integer.toString(this.model.getOutput()));
        this.middle.setText("");
        if (this.model.getOutput() == 0) {
            this.z.setEnabled(false);
        } else {
            this.z.setEnabled(true);
        }
    }

    private void z() {
        
        this.model.clear();
        this.top.setText(Integer.toString(this.model.getOutput()));
        this.middle.setText("");
        this.z.setEnabled(false);
    }

    private boolean invalidInput() {
        String text = this.middle.getText();
        try {
            Double.parseDouble(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
