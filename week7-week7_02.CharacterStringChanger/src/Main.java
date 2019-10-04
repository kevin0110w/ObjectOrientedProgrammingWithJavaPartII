
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Test your program here
//        String word = "carrot";
//        Change change1 = new Change('a', 'b');
//        word = change1.change(word);
//        
//        System.out.println(word);
//        
//        Change change2 = new Change('r', 'x');
//        word = change2.change(word);
//        
//        System.out.println(word);
    Changer changes = new Changer();
    
    changes.addChange( new Change('A', 'I') );
    changes.addChange( new Change('!', '?') );
    changes.addChange( new Change('e', 'a') );
    changes.addChange( new Change('i', 'u') );
    
    String word = "Architect!";
    
    word = changes.change(word);
    
//    changes.addChange( new Change('a', 'b') );
//    changes.addChange( new Change('k', 'x') );
//    changes.addChange( new Change('o', 'å') );

//    String word = "carrot";
    
    
    System.out.println(word);
    }
}
