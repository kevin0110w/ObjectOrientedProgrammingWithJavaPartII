
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PhoneBook {

    private List<Contact> contacts;
    private boolean helperfound;

    public PhoneBook() {
        this.contacts = new ArrayList<Contact>();
        this.helperfound = false;
    }
    
    /**
     * Command 1 - add number, if name already exists add number to
     * map containing key name If not, add new and name
     *
     * @param name - name of contact
     * @param number - number of contact
     */
    public void addNumber(String name, String number) {
        boolean added = false;
        if (this.contacts.isEmpty()) {
            Contact new_contact = new Contact(name);
            new_contact.addNumber(number);
            this.contacts.add(new_contact);
            added = true;
        } else {
            for (Contact existing_contact : this.contacts) {
                if (existing_contact.getName().equals(name)) {
                    existing_contact.addNumber(number);
                    added = true;
                }
            }
        }
        if (!added) {
            Contact new_contact = new Contact(name);
            new_contact.addNumber(number);
            this.contacts.add(new_contact);
        }
    }

    /**
     * Command 2 Search for numbers by a name. If contact exists,
     * return a list of their numbers otherwise return not found
     *
     * @param name of a contact
     * @return
     */
    public Set<String> searchByName(String name) {
        boolean found = false;
        Set<String> numbers = new HashSet<String>();
        for (Contact existing_contact : this.contacts) {
            if (existing_contact.getName().equals(name)) {
                found = true;
                numbers = existing_contact.getNumbers();
            }
        }
        if (!(found)) {
            String notFound = "not found";
            numbers.add(notFound);
        }
        return numbers;
    }

    public String searchByNumber(String number) {
        boolean found = false;
        String name = "";
        for (Contact existing_contact : this.contacts) {
            if (existing_contact.getNumbers().contains(number)) {
                found = true;
                name = existing_contact.getName();
            }
        }

        if (!found) {
            name = "not found";
        }
        return name;
    }

    public void addAddress(String name, Address address) {
        boolean contactadded = false;
        if (this.contacts.isEmpty()) {
            Contact new_contact = new Contact(name);
            new_contact.addAddress(address);
            this.contacts.add(new_contact);
            contactadded = true;
        } else {
            for (Contact contact : this.contacts) {
                if (contact.getName().equals(name)) {
                    contact.addAddress(address);
                    contactadded = true;
                }
            }
        }
        
        if (!contactadded) {
            Contact new_contact = new Contact(name);
            new_contact.addAddress(address);
            this.contacts.add(new_contact);
        }
    }

    public void searchDetails(String name) {
        boolean found = false;
        for (Contact existing_contact : this.contacts) {
            if (existing_contact.getName().equals(name)) {
                String address = existing_contact.getAddressDescription();
                String phone = existing_contact.getPhoneDescription();
                System.out.println(address);
                System.out.println(phone);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println(" not found");
        }
    }

    public void deleteInfo(String name) {
        Contact a_contact = null;
        if (this.contacts.isEmpty()) {
            return;
        }
        for (Contact contact : this.contacts) {
            if (contact.getName().equals(name)) {
                a_contact = contact;
            }
        }
        this.contacts.remove(a_contact);
    }

    public void filter(String keyword) {
        
        if (this.contacts.isEmpty()) {
            return;
        }
        this.sortList();
        if (keyword.equals("")) {
            for (Contact a_contact: this.contacts) {
                System.out.println();
                System.out.println(a_contact);
            }
            return;
        }
        
        for (int i = 0; i < this.contacts.size(); i++) {
            if (this.contacts.get(i).getName().contains(keyword)) {
                this.helperfound = true;
                System.out.println();
                System.out.println(this.contacts.get(i));
            } else if (this.contacts.get(i).getAddressString().contains(keyword)) {
                this.helperfound = true;
                System.out.println();
                System.out.println(this.contacts.get(i));
            } else if (i == this.contacts.size()-1 && this.helperfound == false) {
                System.out.println(" keyword not found");
                this.helperfound = false;
            }
        }
    }
    
    public void sortList() {
        Comparator<Contact> cmp = new Comparator<Contact>() {
            @Override
            public int compare(Contact o1, Contact o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
            Collections.sort(this.contacts, cmp);
        }
}
