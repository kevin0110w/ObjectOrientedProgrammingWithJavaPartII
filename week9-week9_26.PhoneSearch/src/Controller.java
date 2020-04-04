
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
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
public class Controller {

    private Model m;
    private View v;
    private Scanner reader;

    public Controller(Model m, View v) {
        this.m = m;
        this.v = v;
        this.reader = new Scanner(System.in);
    }

    public void start() {
        this.v.printWelcomeScreen();
        while (true) {
            System.out.println("");
            if (!this.handleCommand()) {
                break;
            };
        }
    }

    public void addPhoneNumberForAPerson(String name, String phoneNo) {
        this.m.addPhoneNumberForAPerson(name, phoneNo);
    }

    public void phoneNumberSearchByPerson(String name) {
        Set<String> phoneNumberSearchByPerson = this.m.phoneNumberSearchByPerson(name);
        if (phoneNumberSearchByPerson == null) {
            this.v.printNotFound();
        } else {
            this.v.printNumberSearchForPerson(phoneNumberSearchByPerson);
        }
    }

    public void searchNameByPhoneNumber(String phoneNo) {
        String searchNameByPhoneNumber = this.m.searchNameByPhoneNumber(phoneNo);
        if (searchNameByPhoneNumber == null) {
            this.v.printNotFound();
        } else {
            this.v.printNameSearchForNumber(searchNameByPhoneNumber);
        }
    }

    public void addAddressForAPerson(String name, String address) {
        this.m.addAddressForAPerson(name, address);
    }

    public void search(String query) {
        PhoneBookEntry search = this.m.search(query);
        if (search == null) {
            this.v.printNotFound();
            return;
        }
        this.v.printSearch(search);
    }

    public void removePersonsInformation(String name) {
        this.m.removePersonsInformation(name);
    }

    public void filteredSearch(String query) {
        Map<String, PhoneBookEntry> filteredSearch = this.m.filteredSearch(query);
        List<PhoneBookEntry> results = new ArrayList<>(filteredSearch.values());
        Collections.sort(results);
        if (filteredSearch.isEmpty()) {
            this.v.printNotFound();
        } else {
            this.v.printFilteredSearch(results);
        }
    }

    private boolean handleCommand() {
        this.v.printCommand();
        String word = this.reader.nextLine();
        String name = "";
        String number = "";
        String street = "";
        String address = "";
        String city = "";
        String keyWord = "";
        switch (word) {
            case "1":
                this.v.printName();
                name = this.reader.nextLine();
                this.v.printNumber();
                number = this.reader.nextLine();
                this.m.addPhoneNumberForAPerson(name, number);
                return true;
            case "2":
                this.v.printName();
                name = this.reader.nextLine();
                this.phoneNumberSearchByPerson(name);
                return true;
            case "3":
                this.v.printNumber();
                number = this.reader.nextLine();
                this.searchNameByPhoneNumber(number);
                return true;
            case "4":
                this.v.printWhoseAddress();
                name = this.reader.nextLine();
                this.v.printStreet();
                street = this.reader.nextLine();
                this.v.printCity();
                city = this.reader.nextLine();
                address = street + " " + city;
                this.addAddressForAPerson(name, address);
                return true;
            case "5":
                this.v.printName();
                name = this.reader.nextLine();
                this.search(name);
                return true;
            case "6":
                this.v.printWhoseInfo();
                name = this.reader.nextLine();
                this.removePersonsInformation(name);
                return true;
            case "7":
                this.v.printKeyWord();
                keyWord = this.reader.nextLine();
                System.out.println("");
                this.filteredSearch(keyWord);
                return true;
            case "x":
                return false;
        }
        return false;
    }
}
