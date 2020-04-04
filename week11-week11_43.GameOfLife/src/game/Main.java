package game;

public class Main {

    public static void main(String[] args) {
        PersonalBoard oa = new PersonalBoard(3, 3);
        oa.turnToLiving(0, 0);
        oa.turnToLiving(1, 0);
        oa.turnToLiving(1, 1);
        oa.turnToLiving(1, 2);
        oa.turnToLiving(0, 2);
        System.out.println(oa.getNumberOfLivingNeighbours(0, 1));

    }
}
