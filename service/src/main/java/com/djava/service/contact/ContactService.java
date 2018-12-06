package com.djava.service.contact;

import java.util.Optional;

import com.djava.domain.contact.ContactUs;

public interface ContactService {

	Optional<ContactUs> findById(Long id);

	Optional<ContactUs> findByName(String username);

	ContactUs save(ContactUs contactUs);

	Iterable<ContactUs> find();

	void remove(ContactUs contactUs);

}
