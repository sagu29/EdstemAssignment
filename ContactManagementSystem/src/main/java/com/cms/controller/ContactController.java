package com.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cms.entiry.Contact;
import com.cms.service.ContactService;

import jakarta.validation.Valid;

@RestController
public class ContactController {
	
	private ContactService cs;
	
	@Autowired
	public ContactController(ContactService cs) {
		super();
		this.cs = cs;
	}
	
	@GetMapping("/contacts")
	public ResponseEntity<List<Contact>> getAllContact(){
	return new ResponseEntity<List<Contact>>(cs.getAllContact(), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/contacts/{contactId}")
	public ResponseEntity<String> deleteContact(@PathVariable Integer contactId){
		return new ResponseEntity<String>(cs.deleteContact(contactId), HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/contacts")
	public ResponseEntity<Contact> createContact(@Valid @RequestBody Contact contact){
		Contact cont = cs.createContact(contact);
		return new ResponseEntity<Contact>(cont, HttpStatus.CREATED);
	}
}
