package farmsimulator;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            double hourlyProduce = ( 1.0 * (new Random().nextInt(13)) + 7) / 10;
            System.out.println(hourlyProduce);
        }
    }
}
