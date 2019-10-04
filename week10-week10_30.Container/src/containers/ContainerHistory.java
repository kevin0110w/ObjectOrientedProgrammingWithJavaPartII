/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import java.util.ArrayList;

public class ContainerHistory {

    private ArrayList<Double> history;

    public ContainerHistory() {
        this.history = new ArrayList<Double>();
    }

    public void add(double situation) {
        this.history.add(situation);
    }

    public void reset() {
        this.history.clear();
    }

    public double maxValue() {
        double temp = 0;
        for (double number : this.history) {
            if (number >= temp) {
                temp = number;
            }
        }
        return temp;
    }

    public double minValue() {
        double temp = 0;
        temp = this.history.get(0);
        for (double number : this.history) {
            if (number <= temp) {
                temp = number;
            }
        }
        return temp;
    }

    public double average() {
        double temp = 0;
        for (double number : this.history) {
            temp += number;
        }
        temp /= this.history.size();
        return temp;
    }

    public double greatestFluctuation() {
        if (this.history.size() < 2) {
            return 0;
        }
        double temp = 0;
        double temp2 = 0;
        for (int i = 0; i < this.history.size() - 1; i++) {
            temp = this.history.get(i) - this.history.get(i + 1);
            if (temp < 0) {
                temp *= -1;
            }
            if (temp > temp2) {
                temp2 = temp;
            }
        }
        return temp2;
    }

    public double variance() {
        if (this.history.size() < 2) {
            return 0;
        }
        double sum = 0;
        double average = this.average();
        for (int i = 0; i < this.history.size(); i++) {
            double x = ((this.history.get(i) - average) * (this.history.get(i) - average));
            sum += x;
        }
        sum = sum / (this.history.size() - 1);
        return sum;
    }

    public String toString() {
        return this.history.toString();
    }
}
