package com.djava.persistence.contact;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.djava.domain.contact.ContactUs;

@Repository
public interface ContactUsRepository extends JpaRepository<ContactUs, Long> {

	Optional<ContactUs> findByName(String username);
}
