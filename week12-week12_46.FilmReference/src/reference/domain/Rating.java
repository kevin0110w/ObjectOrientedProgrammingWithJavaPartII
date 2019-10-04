package reference.domain;

/**
 *
 * @author kevin0110w
 */
public enum Rating {
    BAD(-5),
    MEDIOCRE(-3),
    NOT_WATCHED(0),
    NEUTRAL(1),
    FINE(3),
    GOOD(5);
    
    private int value;
    
    private Rating(int value) { 
        this.value = value;
    }
    
    public int getValue() {
    return this.value;
    }
    
    public static void main(String[] args ) {
          Rating given = Rating.GOOD;
    System.out.println("Rating " + given + ", value " + given.getValue());
    given = Rating.NEUTRAL;
    System.out.println("Rating " + given + ", value " + given.getValue());
    }
}

