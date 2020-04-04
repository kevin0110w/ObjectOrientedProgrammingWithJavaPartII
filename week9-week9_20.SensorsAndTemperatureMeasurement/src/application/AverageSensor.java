/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author woohoo
 */
public class AverageSensor implements Sensor {

    private List<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<Sensor>();
        this.readings = new ArrayList<Integer>();
    }

    public void addSensor(Sensor additional) {
        this.sensors.add(additional);
    }

    public List<Integer> readings() {
        return this.readings;
    }

    @Override
    public boolean isOn() {
        for (Sensor s : this.sensors) {
            if (s.isOn() == false) {
                return false;
            }
        }
        return true;

    }

    @Override
    public void on() {
        for (Sensor s : this.sensors) {
            s.on();
        }
    }

    @Override
    public void off() {
        for (Sensor sensor : this.sensors) {
            if (sensor.isOn() == false) {
                return;
            }
        }
        this.sensors.get(0).off();
    }

    @Override
    public int measure() {
        if (this.sensors.size() == 0) {
            throw new IllegalStateException();
        }

        if (this.isOn() == false) {
            throw new IllegalStateException();
        }

        int sum = 0;
        for (Sensor s : this.sensors) {
            sum += s.measure();
        }

        int average = sum / this.sensors.size();
        this.readings.add(average);
        return average;
    }

}
