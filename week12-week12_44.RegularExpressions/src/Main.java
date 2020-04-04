
public class Main {

    public static void main(String[] args) {
        // write test code here
//        System.out.println(isAWeekDay("tie"));
//        System.out.println(allVowels("aoueaiueioueieiei"));
        System.out.println(clockTime("17:23:05"));
    }
    
    public static boolean isAWeekDay(String string) {
        return string.matches("mon|tue|wed|thu|fri|sat|sun");
    }
    
    public static boolean allVowels(String string) {
        return string.matches("[aeiouäö]*");
    }
    
    public static boolean clockTime(String string) {
        return string.matches("([0-1][0-9]|[2][0-3])(:[0-5][0-9]){2}");
    }
}
