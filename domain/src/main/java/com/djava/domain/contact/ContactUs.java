package com.djava.domain.contact;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ContactUs")
public class ContactUs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;

	@Column(name = "username")
	@Getter
	@Setter
	private String username;

	@Column(name = "phonenumber", unique = true)
	@Getter
	@Setter
	private String phonenumber;

//	ContactUs() {
//
//	}

	public static ContactUs create(final String username, final String phonenumber) {
		ContactUs contactUs = new ContactUs();

		contactUs.setUsername(username);
		contactUs.setPhonenumber(phonenumber);

		return contactUs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
