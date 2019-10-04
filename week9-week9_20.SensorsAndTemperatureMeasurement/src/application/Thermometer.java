
package application;

import java.util.Random;

public class Thermometer implements Sensor {
    private Random random;
    private boolean isOn;
    
    public Thermometer(){
    this.random = new Random();
    this.isOn = false;
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
        if (this.isOn == true) {
            return this.random.nextInt(60) - 30;
        } else {
            throw new IllegalStateException("Must be on");
        }
    }
    
}
