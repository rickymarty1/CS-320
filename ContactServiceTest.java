package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	
	private ContactService service;
	private Contact contact;
	
	@BeforeEach
	void setUp() {
		service = new ContactService();
		contact = new Contact("12345", "Rick", "Martinez", "7570001111", "Fallon, Nevada");
	}

	@Test
	void testAddContact() {
		service.addContact(contact);
		
		assertEquals(contact, service.getContact("12345"));	
	}
	
	@Test
	void testDuplicateContactId() {
		service.addContact(contact);
		
		Contact duplicate = new Contact("12345", "Ricky", "Martin", "7570002222", "Reno, Nevada");
		
		assertThrows(IllegalArgumentException.class,()->
		    service.addContact(duplicate));
	}
	
	@Test
	void testDeleteContact() {
		service.addContact(contact);
		service.deleteContact("12345");
		
		assertThrows(IllegalArgumentException.class,()->
	    service.getContact("12345"));
	}
	
	@Test
	void testUpdateContact() {
		service.addContact(contact);
		service.updateContact("12345", "Ricky", "Martin", "7570002222", "Reno, Nevada");
		
		Contact updated = service.getContact("12345");
		
		assertEquals("Ricky", updated.getFirstName());
		assertEquals("Martin", updated.getLastName());
		assertEquals("7570002222", updated.getPhone());
		assertEquals("Reno, Nevada", updated.getAddress());
	}

}
