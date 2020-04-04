/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author woohoo
 */
public class ContainerHistory {

    private List<Double> history;

    public ContainerHistory() {
        this.history = new ArrayList<>();
    }

    public void add(double situation) {
        this.history.add(situation);
    }

    public void reset() {
        this.history.clear();
    }

    public double maxValue() {
        if (this.history.size() == 0) {
            return 0.0;
        }

        double max = this.history.get(0);
        for (Double d : this.history) {
            if (d > max) {
                max = d;
            }
        }
        return max;
    }

    public double minValue() {
        if (this.history.size() == 0) {
            return 0.0;
        }
        double min = this.history.get(0);
        for (Double d : this.history) {
            if (d < min) {
                min = d;
            }
        }
        return min;
    }

    public double average() {
        if (this.history.size() == 0) {
            return 0.0;
        }

        double sum = 0.0;
        for (Double d : this.history) {
            sum += d;
        }
        double average = sum / this.history.size();
        return average;
    }

    public double greatestFluctuation() {
        if (this.history.size() < 2) {
            return 0.0;
        }
        double greatestFluctuation = 0.0;
        for (int i = 0; i < this.history.size() - 1; i++) {
            double temp = this.history.get(i + 1) - this.history.get(i);
            if (temp < 0) {
                temp *= -1;
            }

            if (temp > greatestFluctuation) {
                greatestFluctuation = temp;
            }
        }
        return greatestFluctuation;
    }

    public double variance() {
        if (this.history.size() < 2) {
            return 0.0;
        }

        double average = this.average();
        double variance = 0.0;
        for (Double d : this.history) {
            variance = variance + ((d - average) * (d - average));
        }
        variance = (variance / (this.history.size() - 1));
        return variance;
    }

    public String toString() {
        return this.history.toString();
    }
}
