/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author woohoo
 */
public class Model {

    private int input;
    private int output;

    public Model() {
        this.input = 0;
        this.output = 0;
    }

    public int getInput() {
        return input;
    }

    public int getOutput() {
        return output;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public void setOutput(int output) {
        this.output = output;
    }

    public void clear() {
        this.output = 0;
    }
}
