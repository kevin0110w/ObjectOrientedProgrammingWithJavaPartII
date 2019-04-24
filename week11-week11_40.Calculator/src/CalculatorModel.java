
/**
 *
 * @author kevin0110w
 */
public class CalculatorModel {

    private int value;

    public CalculatorModel() {
        this.value = 0;
    }

    public void addTwoNumbers(int number) {
        this.value += number;
    }

    public void subTwoNumbers(int number) {
        this.value -= number;
    }

    public int getValue() {
        return this.value;
    }

    public void resetValue() {
        this.value = 0;
    }
}
