/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Freckles
 */
import java.util.Scanner;

public class Calculator {
    private Reader reader;
    private int count;
    private int[] values;
    public Calculator() {
        this.reader = new Reader();
        this.count = 0;
        this.values = new int[2];
    }
    public void start() {
        while (true) {
            System.out.println("command: ");
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
//        System.out.println("value1: ");
//        int value1 = reader.readInteger();
//        System.out.println("value2: ");
//        int value2 = reader.readInteger();
        numbers();
//        System.out.println("sum of the values: " + (value1 + value2));
        System.out.println("sum of the values: " + (this.values[0] + this.values[1]));
        this.count++;
    }
    
    private void difference() {
//        System.out.println("value1: ");
//        int value1 = reader.readInteger();
//        System.out.println("value2: ");
//        int value2 = reader.readInteger();
    numbers();
//        System.out.println("difference of the values: " + (value1 - value2));
System.out.println("sum of the values: " + (this.values[0] - this.values[1]));
        this.count++;
    }
    
    private void product() {
//        System.out.println("value1: ");
//        int value1 = reader.readInteger();
//        System.out.println("value2: ");
//        int value2 = reader.readInteger();
//        System.out.println("product of the values: " + (value1 * value2));
numbers();
System.out.println("sum of the values: " + (this.values[0] * this.values[1]));
        this.count++;
    }
    
    private void statistics() {
        System.out.println("Calculations done: " + this.count);
    }
    
    private int[] numbers() {
        System.out.println("value1: ");
        int value1 = reader.readInteger();
        this.values[0] = value1;
        System.out.println("value2: ");
        int value2 = reader.readInteger();
        this.values[1] = value2;
        return this.values;
    }
}
