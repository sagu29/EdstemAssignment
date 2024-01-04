package com.cms.service;

import java.util.List;

import com.cms.entiry.Contact;

public interface ContactService {
	
	public List<Contact> getAllContact();
	
	public String deleteContact(Integer conactId);
	
	public Contact createContact(Contact contact);
	

}
