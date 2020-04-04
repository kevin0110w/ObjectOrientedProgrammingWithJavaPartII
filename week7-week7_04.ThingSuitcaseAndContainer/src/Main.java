
public class Main {

    public static void main(String[] args) {
        // use this main class to test your program!
//        Thing book = new Thing("Happiness in Three Steps", 2);
//        Thing mobile = new Thing("Nokia 3210", 1);
//
//        System.out.println("Book name: " + book.getName());
//        System.out.println("Book weight: " + book.getWeight());
//
//        System.out.println("Book: " + book);
//        System.out.println("Mobile: " + mobile);
//        Thing book = new Thing("Happiness in three steps", 2);
//        Thing mobile = new Thing("Nokia 3210", 1);
//        Thing brick = new Thing("Brick", 4);
//
//        Suitcase suitcase = new Suitcase(5);
//        System.out.println(suitcase);
//
//        suitcase.addThing(book);
//        System.out.println(suitcase);
//
//        suitcase.addThing(mobile);
//        System.out.println(suitcase);
//
//        suitcase.addThing(brick);
//        System.out.println(suitcase);
//        Thing book = new Thing("Happiness in Three Steps", 2);
//        Thing mobile = new Thing("Nokia 3210", 1);
//        Thing brick = new Thing("Brick", 4);
//
//        Suitcase suitcase = new Suitcase(10);
//        suitcase.addThing(book);
//        suitcase.addThing(mobile);
//        suitcase.addThing(brick);
//
//        System.out.println("Your suitcase contains the following things:");
//        suitcase.printThings();
//        System.out.println("Total weight: " + suitcase.totalWeight() + " kg");
//    Thing book = new Thing("Happiness in Three Steps", 2);
//        Thing mobile = new Thing("Nokia 3210", 1);
//        Thing brick = new Thing("Brick", 4);
//
//        Suitcase suitcase = new Suitcase(10);
//        suitcase.addThing(book);
//        suitcase.addThing(mobile);
//        suitcase.addThing(brick);
//
//        Thing heaviest = suitcase.heaviestThing();
//        System.out.println("The heaviest thing: " + heaviest);
//        Thing book = new Thing("Happiness in Three Steps", 2);
//        Thing mobile = new Thing("Nokia 3210", 1);
//        Thing brick = new Thing("Brick", 4);
//
//        Suitcase tomsCase = new Suitcase(10);
//        tomsCase.addThing(book);
//        tomsCase.addThing(mobile);
//
//        Suitcase georgesCase = new Suitcase(10);
//        georgesCase.addThing(brick);
//
//        Container container = new Container(1000);
//        container.addSuitcase(tomsCase);
//        container.addSuitcase(georgesCase);
//
//        System.out.println(container);
//Thing book = new Thing("Happiness in Three Steps", 2);
//        Thing mobile = new Thing("Nokia 3210", 1);
//        Thing brick = new Thing("Brick", 4);
//
//        Suitcase tomsCase = new Suitcase(10);
//        tomsCase.addThing(book);
//        tomsCase.addThing(mobile);
//
//        Suitcase georgesCase = new Suitcase(10);
//        georgesCase.addThing(brick);
//
//        Container container = new Container(1000);
//        container.addSuitcase(tomsCase);
//        container.addSuitcase(georgesCase);
//
//        System.out.println("There are the following things in the container suitcases:");
//        container.printThings();
        Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
    }

    public static void addSuitcasesFullOfBricks(Container container) {
        int counter = 1;
        while (counter <= 100) {
            Thing brick = new Thing("brick", counter);
            Suitcase s = new Suitcase(100);
            s.addThing(brick);
            container.addSuitcase(s);
            counter++;
        }
    }

}
