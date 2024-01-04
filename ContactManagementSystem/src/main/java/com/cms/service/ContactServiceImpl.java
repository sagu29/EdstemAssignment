package com.cms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entiry.Contact;
import com.cms.exception.CmsException;
import com.cms.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	
	private ContactRepository cr;
	
	
	@Autowired
	public ContactServiceImpl(ContactRepository cr) {
		super();
		this.cr = cr;
	}

	@Override
	public List<Contact> getAllContact() {
		List<Contact> contactList= cr.findAll();
		if(contactList.isEmpty()) {
			throw new CmsException("Not found any contact");
		}
		return contactList;
	}

	@Override
	public String deleteContact(Integer conactId) {
		// TODO Auto-generated method stub
		Optional<Contact> contact= cr.findById(conactId);
		if(contact.isEmpty()) {
			throw new CmsException("Not found any contact by this: "+ conactId);
		}
		cr.deleteById(conactId);
		return "Contact is deleted";
	}

	@Override
	public Contact createContact(Contact contact) {
		if(contact== null) {
			throw new CmsException("contact details cannot be null");
		}
		return cr.save(contact);
	}

}
