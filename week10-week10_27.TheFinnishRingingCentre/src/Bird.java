
public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }
    
       @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (getClass() != other.getClass()) {
            return false;
        }
        Bird compared = (Bird) other;
        
        if (this.latinName.equals(compared.latinName) && this.ringingYear == compared.ringingYear) {
            return true;
        } else {
            return false;
        }
    }

    
   public int hashCode(){
        if(this.latinName == null){
            return 7;
        }
        
        return this.ringingYear + this.latinName.hashCode();
}
    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }
    
    public static void main(String[] args) {
    Bird bird1 = new Bird("Rose Starling", "Sturnus roseus", 2012);
    Bird bird2 = new Bird("Rose-Coloured Starling", "Sturnus roseus", 2012);
    Bird bird3 = new Bird("Hooded Crow", "Corvus corone cornix", 2012);
    Bird bird4 = new Bird("Rose-Coloured Pastor", "Sturnus roseus", 2000);

    System.out.println( bird1.equals(bird2));   // same Latin name and same observation year: they are the same bird
    System.out.println( bird1.equals(bird3));   // different Latin name: they are not the same bird
    System.out.println( bird1.equals(bird4));   // different observation year: not the same bird
    System.out.println( bird1.hashCode()==bird2.hashCode() );
    }
}


