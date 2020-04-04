
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author woohoo
 */
public class Calculator {

    private Reader reader;
    private int calculationsPerformed;

    public Calculator() {
        this.reader = new Reader();
        this.calculationsPerformed = 0;
    }

    public void start() {
        while (true) {
            System.out.print("command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }

            if (command.equals("sum")) {
                sum();
            } else if (command.equals("difference")) {
                difference();
            } else if (command.equals("product")) {
                product();
            }
        }

        statistics();
    }

    private void sum() {
        List<Integer> values = readValues();
        // print the value according to the example above
        System.out.println("sum of the values " + (values.get(0) + values.get(1)));
        calculationsPerformed++;
    }

    private void difference() {
        List<Integer> values = readValues();
        // print the value according to the example above
        System.out.println("difference of the values " + (values.get(0) - values.get(1)));
        calculationsPerformed++;
    }

    private void product() {
        List<Integer> values = readValues();
        // print the value according to the example above
        System.out.println("product of the values" + (values.get(0) * values.get(1)));
        calculationsPerformed++;
    }

    private void statistics() {
        System.out.println("Calculations done " + calculationsPerformed);
    }

    private List<Integer> readValues() {
        List<Integer> values = new ArrayList<Integer>();
        System.out.print("value1: ");
        int value1 = this.reader.readInteger();
        values.add(value1);
        System.out.print("value2: ");
        int value2 = this.reader.readInteger();
        values.add(value2);
        return values;
    }
}
