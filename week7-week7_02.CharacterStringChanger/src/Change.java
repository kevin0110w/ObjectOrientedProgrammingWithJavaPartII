/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Freckles
 */
public class Change {
    protected char fromCharacter;
    protected char toCharacter;
    
    public Change(char fromCharacter, char toCharacter) {
        this.fromCharacter = fromCharacter;
        this.toCharacter = toCharacter;
    }
    
    public String change(String characterString) {
        String output = "";
        for (int i = 0; i < characterString.length(); i++) {
            if (this.fromCharacter == characterString.charAt(i)) {
                output = output + toCharacter;
            } else {
                output = output + characterString.charAt(i);
            }
        }
        return output;
    }
}
