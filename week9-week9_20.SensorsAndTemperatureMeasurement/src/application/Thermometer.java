/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author woohoo
 */
public class Thermometer implements Sensor {
    private boolean isOn;
    private Random rand;

    public Thermometer() {
        this.isOn = false;
        this.rand = new Random();
    }
    
    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void on() {
        this.isOn = true;
    }

    @Override
    public void off() {
        this.isOn = false;
    }

    @Override
    public int measure() {
        if (this.isOn == false) {
            throw new IllegalStateException();
        }
        int randomNo = this.rand.nextInt(61) - 30;
        return randomNo;
    }
    
}
