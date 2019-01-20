/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author Freckles
 */
public class ConstantSensor implements Sensor {
    private int measure;
    private final boolean isOn;
    
    public ConstantSensor(int measure) {
        this.measure = measure;
        this.isOn = true;
    }

    @Override
    public boolean isOn() {
       return this.isOn;
    }

    @Override
    public void on() {
        
    }

    @Override
    public void off() {
        
    }

    @Override
    public int measure() {
        return this.measure;
        }
    }
 