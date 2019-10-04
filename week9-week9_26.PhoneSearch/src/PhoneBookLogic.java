import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookLogic {
    private Scanner reader;
    private PhoneBook book;
    private boolean isTrue;
    
    public PhoneBookLogic() {
        this.reader = new Scanner(System.in);
        this.book = new PhoneBook();
        this.isTrue = true;
    }
    
    public void start() {
        System.out.println("phone search");
        System.out.println("available operations:");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit" + "\n");
        while (this.isTrue) {
        choice();
        }
    }
    
    public void choice(){
        System.out.print("command: ");
        String choice = this.reader.nextLine();
        if (choice.equals("1")) {
            addNumber();
        } else if (choice.equals("2")) {
            searchByName();
        } else if (choice.equals("3")) {
            searchByNumber();
        } else if (choice.equals("4")) {
            addAddress();
        } else if (choice.equals("5")) {
            searchByDetails();
        } else if (choice.equals("6")) {
            deleteInfo();
        } else if (choice.equals("7")) {
            filteredListing();
        } else if (choice.equals("x")) {
            this.isTrue = false;
        }
        System.out.println();
    }

    private void addNumber() {
        System.out.print("whose number: ");
        String name = this.reader.nextLine();
        System.out.print("number: ");
        String number = this.reader.nextLine();
        this.book.addNumber(name, number);
    }

    private void searchByName() {
        Set<String> numbers = new HashSet<String>();
        System.out.print("whose number: ");
        String name = this.reader.nextLine();
        numbers = this.book.searchByName(name);
        for (String number : numbers) {
            System.out.println(" " + number);
        }
    }

    private void searchByNumber() {
        System.out.print("number: ");
        String number = this.reader.nextLine();
        String name = "";
        name = this.book.searchByNumber(number);
        System.out.println(" " + name);
    }

    private void addAddress() {
        System.out.print("whose address: ");
        String name = this.reader.nextLine();
        System.out.print("street: ");
        String address = this.reader.nextLine();
        System.out.print("city: ");
        String city = this.reader.nextLine();
        this.book.addAddress(name, new Address(address, city));
    }

    private void searchByDetails() {
        System.out.print("whose information: ");
        String name = this.reader.nextLine();
        this.book.searchDetails(name);
    }
    
    private void deleteInfo() {
        System.out.print("whose information: ");
        String name = this.reader.nextLine();
        this.book.deleteInfo(name);
    }

    private void filteredListing() {
        System.out.print("keyword (if empty, all listed): ");
        String keyword = this.reader.nextLine();
        this.book.filter(keyword);
    }
}
