package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void testContactCreation() {
		Contact contact = new Contact("12345", "Rick", "Martinez",
				"7570001111", "Fallon, Nevada");
		
		assertEquals("12345", contact.getContactId());
		assertEquals("Rick", contact.getFirstName());
		assertEquals("Martinez", contact.getLastName());
		assertEquals("7570001111", contact.getPhone());
		assertEquals("Fallon, Nevada", contact.getAddress());
	}
	
	@Test
	void testInvalidContactId() {
		assertThrows(IllegalArgumentException.class, () ->
		    new Contact(null, "Rick", "Martinez", "7570001111", "Fallon, Nevada"));
		
		
		assertThrows(IllegalArgumentException.class, () ->
	        new Contact("12345678901","Rick", "Martinez", "7570001111", "Fallon, Nevada"));	
	}
	
	@Test
	void testInvalidFirstName() {
		assertThrows(IllegalArgumentException.class, () ->
		    new Contact("12345", null, "Martinez", "7570001111","Fallon, Nevada"));
		
		
		assertThrows(IllegalArgumentException.class, () ->
	        new Contact("12345", "Christopher", "Martinez", "7570001111", "Fallon, Nevada"));	
	}
	
	@Test
	void testInvalidLastName() {
		assertThrows(IllegalArgumentException.class, () ->
		    new Contact("12345", "Rick", null, "7570001111","Fallon, Nevada"));
		
		
		assertThrows(IllegalArgumentException.class, () ->
	        new Contact("12345", "Rick", "Martinezzzz", "7570001111", "Fallon, Nevada"));
	}
	
	@Test
	void testInvalidPhone() {
		assertThrows(IllegalArgumentException.class, () ->
		    new Contact("12345", "Rick", "Martinez", null, "Fallon, Nevada"));
		
		
		assertThrows(IllegalArgumentException.class, () ->
	        new Contact("12345", "Rick", "Martinez", "757000111", "Fallon, Nevada"));
		
		assertThrows(IllegalArgumentException.class, () ->
        new Contact("12345", "Rick", "Martinez", "757000111A", "Fallon, Nevada"));
	}
	
	@Test
	void testInvalidAddress() {
		assertThrows(IllegalArgumentException.class, () ->
		    new Contact("12345", "Rick", "Martinez", "7570001111", null));
		
		
		assertThrows(IllegalArgumentException.class, () ->
	        new Contact("12345", "Rick", "Martinez", "7570001111", "1111122222333334444455555666667"));
	}
	

}
