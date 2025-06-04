import java.util.ArrayList;
import java.util.List;

public class Phonebook {
    private final List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public boolean deleteContact(String name) {
        return contacts.removeIf(c -> c.getName().equalsIgnoreCase(name));
    }

    public boolean updateContact(String name, String newPhone) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                c.setPhone(newPhone);
                return true;
            }
        }
        return false;
    }

    public Contact searchByName(String name) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
