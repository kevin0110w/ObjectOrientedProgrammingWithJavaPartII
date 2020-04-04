package tools;

public class Main {

    public static void main(String[] args) {
        // Test your class here
DuplicateRemover s = new PersonalDuplicateRemover();
s.add("apina");
s.add("apina");
s.add("gorilla");
s.add("gorilla");
s.add("apina");
        System.out.println(s.getNumberOfDetectedDuplicates());
    }
}
