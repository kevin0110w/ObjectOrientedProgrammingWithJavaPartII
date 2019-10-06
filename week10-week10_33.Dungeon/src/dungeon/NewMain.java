/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;
import java.util.*;

/**
 *
 * @author woohoo
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "hello");
        map.put(2, "world");
        for (String s : map.values()) {
            System.out.println(s);
            map.remove(map.containsValue(s));
        }
        
        for (String s : map.values()) {
            System.out.println(s);
            
        }
        
    }
    
}
