package com.infinity.service;

import java.util.List;

import com.infinity.entity.Contact;

public interface ContactService {

	public boolean saveContact(Contact contact);
	
	public List<Contact> getAllContact();
	
	public Contact getContactById(Integer cid);
	
	public boolean deleteContactById(Integer cid);
 
	
}
