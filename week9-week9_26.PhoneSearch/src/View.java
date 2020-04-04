
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author woohoo
 */
public class View {

    public void printWelcomeScreen() {
        System.out.println("phone search");
        System.out.println("available operations");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit");
    }

    void printNumberSearchForPerson(Set<String> phoneNumberSearchByPerson) {
        if (phoneNumberSearchByPerson.isEmpty()) {
            System.out.println("  not found");
            return;
        }
        
        Iterator<String> it = phoneNumberSearchByPerson.iterator();
        while (it.hasNext()) {
            String no = " " + it.next();
            System.out.println(no);
        }
    }

    void printNameSearchForNumber(String searchNameByPhoneNumber) {
        System.out.println(" " + searchNameByPhoneNumber);
    }

    void printSearch(PhoneBookEntry search) {
        System.out.println(search.returnContactInfo());
    }

    void printFilteredSearch(List<PhoneBookEntry> filteredSearch) {
        for (PhoneBookEntry s : filteredSearch) {
            System.out.println(s);
        }
    }

    void printName() {
        System.out.print("whose number: ");
    }

    void printNumber() {
        System.out.print("number: ");
    }

    void printWhoseAddress() {
        System.out.print("whose address: ");
    }

    void printStreet() {
        System.out.print("street: ");
    }

    void printCity() {
        System.out.print("city: ");
    }

    void printWhoseInfo() {
        System.out.print("whose information: ");
    }

    void printKeyWord() {
        System.out.print("keyword (if empty, all listed): ");
    }

    void printCommand() {
        System.out.print("command: ");
    }

    void printNotFound() {
        System.out.println("  not found");
    }
}
