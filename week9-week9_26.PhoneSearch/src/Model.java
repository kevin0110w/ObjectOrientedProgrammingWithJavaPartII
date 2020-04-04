
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
public class Model {

    private Map<String, PhoneBookEntry> entries;

    public Model() {
        this.entries = new HashMap<>();
    }

    Map<String, PhoneBookEntry> filteredSearch(String query) {
        Map<String, PhoneBookEntry> contacts = new HashMap<String, PhoneBookEntry>();
        if (query == null) {
            return null;
        }

        for (String s : this.entries.keySet()) {
            if (this.entries.get(s).getName().contains(query)) {
                contacts.put(this.entries.get(s).getName(), this.entries.get(s));
            } else if (this.entries.get(s).getAddresses().contains(query)) {
                contacts.put(this.entries.get(s).getName(), this.entries.get(s));
            } else if (checkContainsEntryThatContainsString(this.entries.get(s).getNumbers(), query)) {
                contacts.put(this.entries.get(s).getName(), this.entries.get(s));
            }
        }
        return contacts;
    }

    private boolean checkContainsEntryThatContainsString(Set<String> elements, String query) {
        Iterator<String> it = elements.iterator();
        while (it.hasNext()) {
            String s = it.next();
            return (s.contains(query));
        }
        return false;
    }

    void removePersonsInformation(String name) {
        if (this.entries.containsKey(name)) {
            this.entries.remove(name);
        } else {
            return;
        }
    }

    PhoneBookEntry search(String query) {
        PhoneBookEntry e = null;
        if (this.entries.containsKey(query)) {
            e = this.entries.get(query);
        }
        return e;
    }

    void addAddressForAPerson(String name, String address) {
        PhoneBookEntry e;
        if (this.entries.containsKey(name)) {
            e = this.entries.get(name);
        } else {
            e = new PhoneBookEntry(name);
            this.entries.put(name, e);
        }
        e.setAddresses(address);
    }

    String searchNameByPhoneNumber(String phoneNo) {
        if (phoneNo == null) {
            return null;
        }

        for (String s : this.entries.keySet()) {
            if (this.entries.get(s).getNumbers().contains(phoneNo)) {
                return this.entries.get(s).getName();
            }
        }
        return null;
    }

    Set<String> phoneNumberSearchByPerson(String name) {
        if (name == null) {
            return null;
        }

        if (this.entries.containsKey(name)) {
            return this.entries.get(name).getNumbers();
        }
        return null;
    }

    void addPhoneNumberForAPerson(String name, String phoneNo) {
        PhoneBookEntry e;
        if (this.entries.containsKey(name)) {
            e = this.entries.get(name);
        } else {
            e = new PhoneBookEntry(name);
            this.entries.put(name, e);
        }
        e.getNumbers().add(phoneNo);
    }
}
