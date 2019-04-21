/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

/**
 *
 * @author Freckles
 */
public class Student extends Person {
    private int credits;
    
    public Student(String name, String address) {
        super(name, address);
        this.credits = 0;
    }
    
    public void study() {
        this.credits++;
    }
    
    public int credits() {
        return this.credits;
    }
    
//     public static void main(String[] args) {
//        Student olli = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki");
//        System.out.println(olli);
//        System.out.println("credits " + olli.credits());
//        olli.study();
//        System.out.println("credits "+ olli.credits());
//    }
     
     @Override
     public String toString() {
         return super.toString() + "\n  credits " + this.credits();
     }
      public static void main(String[] args) {
        Student olli = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki");
        System.out.println( olli );
        olli.study();
        System.out.println( olli );
    }
}
