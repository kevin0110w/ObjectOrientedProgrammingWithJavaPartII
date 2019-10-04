
import java.util.Scanner;


public class Main {
    public static boolean isAWeekDay(String string) {
        boolean isAWeekDay = false;
        if (string.matches("mon|tue|wed|thu|fri|sat|sun")) {
            isAWeekDay = true;
        } else {
            isAWeekDay = false;
        }
        return isAWeekDay;
    }
    
    public static boolean allVowels(String string) {
        boolean allVowels = false;
        if (string.matches("[aeiouäö]*")) {
           allVowels = true;
        } else {
            allVowels = false;
        }
        return allVowels;
    }
    
    public static boolean clockTime(String string) {
        boolean clockTime = false;
        if (string.matches("([01][0-9]|2[0-3])(:[0-5][0-9]){2}")) {
            clockTime = true;
        } else {
            clockTime = false;
        }
        return clockTime;
    }
    public static void main(String[] args) {
        System.out.print("Give a string: ");
        Scanner s = new Scanner(System.in);
        String x = s.nextLine();
        if (clockTime(x)) {
            System.out.println("The form is fine.");
        } else {
            System.out.println("The form is wrong.");
        }
    }
}
