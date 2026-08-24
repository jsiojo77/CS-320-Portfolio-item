import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    void setUp() {
        contactService = new ContactService();
    }

    @Test
    void testAddContactWithUniqueId() {
        Contact contact = new Contact("1", "Seven", "Siojo", "1234567890", "123 Main Street");

        contactService.addContact(contact);

        assertEquals(1, contactService.getContactCount());
        assertEquals(contact, contactService.getContact("1"));
    }

    @Test
    void testCannotAddContactWithDuplicateId() {
        Contact contactOne = new Contact("1", "Seven", "Siojo", "1234567890", "123 Main Street");
        Contact contactTwo = new Contact("1", "John", "Smith", "0987654321", "456 Oak Avenue");

        contactService.addContact(contactOne);

        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contactTwo));
        assertEquals(1, contactService.getContactCount());
    }

    @Test
    void testCannotAddNullContact() {
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(null));
    }

    @Test
    void testDeleteContactByContactId() {
        Contact contact = new Contact("1", "Seven", "Siojo", "1234567890", "123 Main Street");
        contactService.addContact(contact);

        contactService.deleteContact("1");

        assertEquals(0, contactService.getContactCount());
        assertThrows(IllegalArgumentException.class, () -> contactService.getContact("1"));
    }

    @Test
    void testCannotDeleteContactThatDoesNotExist() {
        assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("missing"));
    }

    @Test
    void testUpdateFirstNameByContactId() {
        addDefaultContact();

        contactService.updateFirstName("1", "John");

        assertEquals("John", contactService.getContact("1").getFirstName());
    }

    @Test
    void testUpdateLastNameByContactId() {
        addDefaultContact();

        contactService.updateLastName("1", "Smith");

        assertEquals("Smith", contactService.getContact("1").getLastName());
    }

    @Test
    void testUpdatePhoneByContactId() {
        addDefaultContact();

        contactService.updatePhone("1", "0987654321");

        assertEquals("0987654321", contactService.getContact("1").getPhone());
    }

    @Test
    void testUpdateNumberByContactId() {
        addDefaultContact();

        contactService.updateNumber("1", "0987654321");

        assertEquals("0987654321", contactService.getContact("1").getPhone());
    }

    @Test
    void testUpdatePhoneNumberByContactId() {
        addDefaultContact();

        contactService.updatePhoneNumber("1", "0987654321");

        assertEquals("0987654321", contactService.getContact("1").getPhone());
    }

    @Test
    void testUpdateAddressByContactId() {
        addDefaultContact();

        contactService.updateAddress("1", "456 Oak Avenue");

        assertEquals("456 Oak Avenue", contactService.getContact("1").getAddress());
    }

    @Test
    void testCannotUpdateContactThatDoesNotExist() {
        assertThrows(IllegalArgumentException.class, () -> contactService.updateFirstName("missing", "John"));
        assertThrows(IllegalArgumentException.class, () -> contactService.updateLastName("missing", "Smith"));
        assertThrows(IllegalArgumentException.class, () -> contactService.updatePhone("missing", "0987654321"));
        assertThrows(IllegalArgumentException.class, () -> contactService.updateNumber("missing", "0987654321"));
        assertThrows(IllegalArgumentException.class, () -> contactService.updatePhoneNumber("missing", "0987654321"));
        assertThrows(IllegalArgumentException.class, () -> contactService.updateAddress("missing", "456 Oak Avenue"));
    }

    @Test
    void testCannotUpdateFieldsWithInvalidValues() {
        addDefaultContact();

        assertThrows(IllegalArgumentException.class, () -> contactService.updateFirstName("1", null));
        assertThrows(IllegalArgumentException.class, () -> contactService.updateFirstName("1", "Firstname11"));
        assertThrows(IllegalArgumentException.class, () -> contactService.updateLastName("1", null));
        assertThrows(IllegalArgumentException.class, () -> contactService.updateLastName("1", "Lastname111"));
        assertThrows(IllegalArgumentException.class, () -> contactService.updatePhone("1", null));
        assertThrows(IllegalArgumentException.class, () -> contactService.updatePhone("1", "123456789"));
        assertThrows(IllegalArgumentException.class, () -> contactService.updatePhone("1", "12345abcde"));
        assertThrows(IllegalArgumentException.class, () -> contactService.updateNumber("1", null));
        assertThrows(IllegalArgumentException.class, () -> contactService.updateNumber("1", "123456789"));
        assertThrows(IllegalArgumentException.class, () -> contactService.updateNumber("1", "12345abcde"));
        assertThrows(IllegalArgumentException.class, () -> contactService.updatePhoneNumber("1", null));
        assertThrows(IllegalArgumentException.class, () -> contactService.updatePhoneNumber("1", "123456789"));
        assertThrows(IllegalArgumentException.class, () -> contactService.updatePhoneNumber("1", "12345abcde"));
        assertThrows(IllegalArgumentException.class, () -> contactService.updateAddress("1", null));
        assertThrows(IllegalArgumentException.class,
                () -> contactService.updateAddress("1", "1234567890123456789012345678901"));
    }

    private void addDefaultContact() {
        contactService.addContact(new Contact("1", "Seven", "Siojo", "1234567890", "123 Main Street"));
    }
}
