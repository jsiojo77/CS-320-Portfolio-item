import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact must not be null.");
        }

        String contactId = contact.getContactId();
        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID must be unique.");
        }

        contacts.put(contactId, contact);
    }

    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID was not found.");
        }

        contacts.remove(contactId);
    }

    public void updateFirstName(String contactId, String firstName) {
        findContact(contactId).setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        findContact(contactId).setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        findContact(contactId).setPhone(phone);
    }

    public void updateNumber(String contactId, String number) {
        updatePhone(contactId, number);
    }

    public void updatePhoneNumber(String contactId, String phoneNumber) {
        updatePhone(contactId, phoneNumber);
    }

    public void updateAddress(String contactId, String address) {
        findContact(contactId).setAddress(address);
    }

    public Contact getContact(String contactId) {
        return findContact(contactId);
    }

    public int getContactCount() {
        return contacts.size();
    }

    private Contact findContact(String contactId) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID was not found.");
        }

        return contact;
    }
}
