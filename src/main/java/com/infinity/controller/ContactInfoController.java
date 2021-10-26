package com.infinity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.infinity.entity.Contact;
import com.infinity.service.ContactService;

@Controller
public class ContactInfoController {

	@Autowired
	private ContactService contactservice;
	
	@GetMapping("/contact")
	public String loadContactForm(Model model) {
		Contact contactobj=new Contact();
		model.addAttribute("contact", contactobj);
		return "contactInfo";
	}
	
	@PostMapping("/savecontact")
	public String saveContactForm(Contact contact, Model model) {
		boolean isSaved = contactservice.saveContact(contact);
		if (isSaved) {
			model.addAttribute("succes", "Contact Saved Succesfully");
		} else {
			model.addAttribute("error", "Failed to Save Contact");
		}
		return "contactInfo";
	}
}
