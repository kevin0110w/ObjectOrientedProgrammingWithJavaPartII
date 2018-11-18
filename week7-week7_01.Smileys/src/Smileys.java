
public class Smileys {

    public static void main(String[] args) {
         printWithSmileys("Method");
         printWithSmileys("Beerbottle");
         printWithSmileys("Interface");
         printWithSmileys("Matti");
         printWithSmileys("Arto");
    }
    
    private static void printWithSmileys(String characterString) {
        int number = (characterString.length()*2);
        int numberTwo = (characterString.length()*2)+2;
        
        String newerString = "";
        String rightBlankString = "";
        String leftBlankString = "";
        
        String newString = "";
        if (characterString.length() <6) {
        for (int i = 0; i < numberTwo; i=i+2) {
            newString += ":)";
            }
        } else if (characterString.length()>=6){
            for (int i = 0; i < number; i=i+2) {
            newString += ":)";
            }   
        } 
        System.out.println(newString);
        
        int numberOfWhiteSpaces = (int)((newString.length() - characterString.length() - 4)/2);
        if (characterString.length() % 2 == 0) {
            for (int i = 0; i < numberOfWhiteSpaces; i++) {
                rightBlankString += " ";
            } 
        } else {
            for (int i = 0; i <= numberOfWhiteSpaces; i++) {
                rightBlankString += " ";
            }
        }
        
        if (characterString.length() % 2 == 1) {
            for (int i = 0; i < numberOfWhiteSpaces; i++) {
                leftBlankString += " ";
            } 
        }
        
        if (characterString.length() % 2 == 0) {
        System.out.println(":)" + rightBlankString + characterString + rightBlankString + ":)");
        } else {
        System.out.println(":)" + leftBlankString + characterString + rightBlankString + ":)");
        }
        
        if (characterString.length() <6) {
        for (int i = 0; i < numberTwo; i=i+2) {
            newerString += ":)";
            }
        }
        
        else if (characterString.length()>=6){
            for (int i = 0; i < number; i=i+2) {
            newerString += ":)";
            }   
        } 
        System.out.println(newString);
    }
}
