
import java.util.HashSet;
import java.util.Iterator;
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
public class PhoneBookEntry implements Comparable<PhoneBookEntry> {

    private String name;
    private String address;
    private Set<String> numbers;

    public PhoneBookEntry(String name) {
        this.name = name;
        this.address = "";
        this.numbers = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public String getAddresses() {
        if (this.address.isEmpty() || this.address.equals("null")) {
            return "address unknown";
        } else {
            return this.address;
        }
    }

    public Set<String> getNumbers() {
        return numbers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddresses(String addresses) {
        this.address = addresses;
    }

    public void setNumbers(Set<String> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        String phoneNumberString = returnPhoneNumberString();
        return " " + name + "\n" + "  address: " + this.getAddresses() + "\n" + phoneNumberString;

    }

    public String returnContactInfo() {
        String phoneNumberString = returnPhoneNumberString();
        return "  address: " + this.getAddresses() + "\n" + phoneNumberString;
    }

    public String returnPhoneNumberString() {
        String s = "  phone numbers:\n";

        String[] phoneArray = new String[this.numbers.size()];
        this.numbers.toArray(phoneArray);

        for (int i = 0; i < phoneArray.length; i++) {
            if (i == (phoneArray.length - 1)) {
                s += "   " + phoneArray[i];
            } else {
                s += "   " + phoneArray[i] + "\n";
            }
        }

        if (this.numbers.isEmpty()) {
            s = "  phone number not found";
        }
        return s;
    }

    @Override
    public int compareTo(PhoneBookEntry o) {
        if (this.name.charAt(0) < o.getName().charAt(0)) {
            return -1;
        } else if (this.name.charAt(0) > o.getName().charAt(0)) {
            return 1;
        } else {
            return 0;
        }
    }
}
