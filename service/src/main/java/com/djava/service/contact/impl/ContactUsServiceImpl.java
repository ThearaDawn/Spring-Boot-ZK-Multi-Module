package com.djava.service.contact.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.djava.domain.contact.ContactUs;
import com.djava.persistence.contact.ContactUsRepository;
import com.djava.service.contact.ContactService;

//for VM inject 
@Service("contactService")
public class ContactUsServiceImpl implements ContactService{

	@Autowired
	ContactUsRepository contactUsrepository;
	
	public ContactUsRepository getContactUsrepository() {
		return contactUsrepository;
	}

	public void setContactUsrepository(ContactUsRepository contactUsrepository) {
		this.contactUsrepository = contactUsrepository;
	}

	@Override
	public Optional<ContactUs> findById(Long id) {
		// TODO Auto-generated method stub
		return contactUsrepository.findById(id);
	}

	@Override
	public Optional<ContactUs> findByName(String username) {
		// TODO Auto-generated method stub
		return contactUsrepository.findByName(username);
	}

	@Override
	public ContactUs save(ContactUs contactUs) {
		// TODO Auto-generated method stub
		return contactUsrepository.save(contactUs);
	}

	@Override
	public Iterable<ContactUs> find() {
		// TODO Auto-generated method stub
		return contactUsrepository.findAll();
	}

	@Override
	public void remove(ContactUs contactUs) {
		// TODO Auto-generated method stub
		contactUsrepository.delete(contactUs);
	}

}

