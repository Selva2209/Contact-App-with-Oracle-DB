package com.infinity.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infinity.entity.Contact;
import com.infinity.repositories.repository;

@Service
public class ContactSeriveImpl implements ContactService {

	@Autowired
	private repository repo;

	@Override
	public boolean saveContact(Contact contact) {
		contact.setActiveSwitch('Y');
		Contact save = repo.save(contact);
		if (save != null && save.getContactId() != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Contact> getAllContact() {
		List<Contact> findAll = repo.findAll();
		return findAll;
	}

	@Override
	public Contact getContactById(Integer cid) {
		Optional<Contact> findById = repo.findById(cid);
		if (findById.isPresent()) {
			Contact contact = findById.get();
			return contact;
		}
		return null;
	}

	@Override
	public boolean deleteContactById(Integer cid) {
		boolean status = repo.existsById(cid);
		if (status) {
			repo.deleteById(cid);
			return true;
		}
		return false;
	}

}
