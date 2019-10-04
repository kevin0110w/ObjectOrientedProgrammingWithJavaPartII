
package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor  implements Sensor {
    private ArrayList<Sensor> averageSensor;
    private List<Integer> readings;
    
    public AverageSensor() {
        this.averageSensor = new ArrayList<Sensor>();
        this.readings = new ArrayList<Integer>();
    }
    /*
    Adds a new sensor to the average sensor
    */
    public void addSensor(Sensor additional) {
        this.averageSensor.add(additional);
    }
    /*
    Returns whether average sensor is on or off
    The average sensor is on when all its sensors are on. 
    
    */
    @Override
    public boolean isOn() {
        boolean check = true;
        for (Sensor s : this.averageSensor) {
            if (s.isOn() == false) {
                check = false;
                break;
            }
            check = true;
        }
        return check;
    }
    /*
    When the average sensor is switched on, all its sensors have to be switched on    if they were not on already
    */
    @Override
    public void on() {
        for (Sensor s : this.averageSensor) {
            if (s.isOn() == false) {
                s.on();
            }
        }
    }
    /*
    When the average sensor is closed, at least one of its sensors has to be switched off. It's also possible that all its sensors are switched off.
    */
    @Override
    public void off() {
       boolean check = false;
       for (Sensor s:this.averageSensor) {
           if (s.isOn() == false) { // keep going throught sensors, if one is off
               break; // can exit
           }
           check = true; //have gone through list and not one sensor is off
       }
       if (check == true) {
           this.averageSensor.get(0).off(); //turn the first sensor off
       }
    }
    /*
    The measure method of our AverageSensor returns the average of the readings of all its sensors (because the return value is int, the readings are rounded down as it is for integer division). If the measure method is called when the average sensor is off, or if the average sensor was not added any sensor, the method throws an IllegalStateException. 
    */
    @Override
    public int measure() {
        int reading = 0;
        for (Sensor s: this.averageSensor) {
            if (s.isOn()) {
            reading += s.measure();
            }
        }
        if (this.averageSensor.isEmpty() || this.isOn() == false) {
            throw new IllegalStateException("Average Sensor is off or does not              have any sensors");
        } else {
        int averageReading = reading / this.averageSensor.size();
        this.readings.add(averageReading);
        return averageReading;  
        }
    }
    
    /*
    returns a list of the reading results of all the measurements executed through      your AverageSensor
    */
    public List<Integer> readings() {
        return this.readings;
    }
}   

