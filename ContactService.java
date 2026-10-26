package contact;


import java.util.HashMap;
import java.util.Map;

public class ContactService {
	
	private final Map<String, Contact> contacts = new HashMap<>();
	
	public void addContact(Contact contact) {
		if (contact == null) {
			throw new IllegalArgumentException("Contact cannot be null");
		}
		
		if (contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Contact ID already exists");
		}
		
		contacts.put(contact.getContactId(),contact);
	}
	
	public void deleteContact(String contactId) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID not found");
		}
		
		contacts.remove(contactId);
	}
	
	public Contact getContact(String contactId) {
		Contact contact = contacts.get(contactId);
		
		if (contact == null) {
			throw new IllegalArgumentException("Contact ID not found");
		}
		
		return contact;
	}
	
	public void updateContact(String contactId, String firstName,
			String lastName, String phone, String address) {
		
		Contact contact = getContact(contactId);
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setPhone(phone);
		contact.setAddress(address);
	}
}
