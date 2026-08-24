import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ContactTest {

    @Test
    void testContactCreatedWithValidValues() {
        Contact contact = new Contact("1234567890", "Seven", "Siojo", "1234567890", "123 Main Street");

        assertEquals("1234567890", contact.getContactId());
        assertEquals("Seven", contact.getFirstName());
        assertEquals("Siojo", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    void testContactIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(null, "Seven", "Siojo", "1234567890", "123 Main Street"));
    }

    @Test
    void testContactIdCannotBeLongerThanTenCharacters() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345678901", "Seven", "Siojo", "1234567890", "123 Main Street"));
    }

    @Test
    void testContactIdIsNotUpdatable() {
        assertThrows(NoSuchMethodException.class, () -> Contact.class.getDeclaredMethod("setContactId", String.class));
    }

    @Test
    void testFirstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", null, "Siojo", "1234567890", "123 Main Street"));
    }

    @Test
    void testFirstNameCannotBeLongerThanTenCharacters() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Firstname11", "Siojo", "1234567890", "123 Main Street"));
    }

    @Test
    void testLastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Seven", null, "1234567890", "123 Main Street"));
    }

    @Test
    void testLastNameCannotBeLongerThanTenCharacters() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Seven", "Lastname111", "1234567890", "123 Main Street"));
    }

    @Test
    void testPhoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Seven", "Siojo", null, "123 Main Street"));
    }

    @Test
    void testPhoneMustBeExactlyTenDigits() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Seven", "Siojo", "123456789", "123 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Seven", "Siojo", "12345678901", "123 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Seven", "Siojo", "12345abcde", "123 Main Street"));
    }

    @Test
    void testAddressCannotBeNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Seven", "Siojo", "1234567890", null));
    }

    @Test
    void testAddressCannotBeLongerThanThirtyCharacters() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "Seven", "Siojo", "1234567890", "1234567890123456789012345678901"));
    }

    @Test
    void testFieldsCanBeUpdatedWithValidValues() {
        Contact contact = new Contact("1", "Seven", "Siojo", "1234567890", "123 Main Street");

        contact.setFirstName("John");
        contact.setLastName("Smith");
        contact.setPhone("0987654321");
        contact.setAddress("456 Oak Avenue");

        assertEquals("1", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Oak Avenue", contact.getAddress());
    }
}
