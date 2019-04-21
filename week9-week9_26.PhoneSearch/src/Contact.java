import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Contact {
    private String name;
    private Set<String> numbers;
    private Set<Address> addresses;
    
    public Contact(String name) {
        this.name = name;
        this.numbers = new HashSet<String>();
        this.addresses = new HashSet<Address>();
    }
    
    public String getName() {
        return this.name;
    }
    
    public Set<String> getNumbers() {
        return this.numbers;
    }
    
    public Set<Address> getAddresses() {
        return this.addresses;
    }
    
    public String getAddressString() {
        Iterator iterator = this.addresses.iterator();
        String addresses = "";
        while (iterator.hasNext()) {
            addresses += iterator.next();
            addresses += " ";
        }
        return addresses;
    }
    
    public void addNumber(String number) {
        this.numbers.add(number);
    }
    
    public void addAddress(Address address) {
        this.addresses.add(address);
    }
    
    public String getAddressDescription() {
        String address = "";
        Iterator iterator = this.addresses.iterator();
        if (this.addresses.isEmpty()) {
            address = " address unknown";
        } else {
            address = " address: ";
            while (iterator.hasNext()) {
                address = address + iterator.next();
            }
        }
        return address;
    }
    
    public String getPhoneDescription() {
        String phone = "";
        Iterator iterator = this.numbers.iterator();
        if (this.numbers.isEmpty()) {
            phone = " phone number not found";
        } else {
            phone = " phone numbers: ";
            while (iterator.hasNext()) {
                phone = phone + "\n   " + iterator.next();
            }
        }
        return phone;
    }
    
    public String toString() {
        String word = "";
        word = word + this.name;
        word = word + "\n " + this.getAddressDescription();
        word = word + "\n " + this.getPhoneDescription();
        return word;
    }
}
