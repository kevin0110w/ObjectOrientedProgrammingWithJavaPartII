/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.domain;

/**
 * @author kevin0110w
 * Create the enumerated type Rating in reference.domain. 
 * The enum class Rating has a public method public int getValue(), 
 * which returns the value of the rating.
 */
public enum Rating {
    BAD (-5),
    MEDIOCRE (-3),
    NOT_WATCHED (0),
    NEUTRAL (1),
    FINE (3),
    GOOD (5);
    
    private int rating;
    
    private Rating(int rating) {
        this.rating = rating;
    }
    
    public int getValue() {
        return this.rating;
    
    }
}
