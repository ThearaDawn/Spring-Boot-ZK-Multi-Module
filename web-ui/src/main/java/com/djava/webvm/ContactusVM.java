package com.djava.webvm;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

import com.djava.domain.contact.ContactUs;
import com.djava.service.contact.ContactService;
import com.djava.utils.ViewModel;

import lombok.Getter;
import lombok.Setter;
 

public class ContactusVM extends ViewModel{
	
	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ContactusVM.class);
	
	@Getter @Setter
	private ContactUs contactus;
	
	@Getter @Setter
	private ListModelList<ContactUs> contactUsList;
	
	@WireVariable
	private ContactService contactService;
	
	@Init
	@Override
	public void init() {
		contactus = ContactUs.create("", "");
		List<ContactUs> list = new ArrayList<> ();
		if(contactService !=null && contactService.find() !=null) {
			contactService.find().iterator().forEachRemaining(list::add);
			contactUsList = new ListModelList<>(list);
		}
		
	}
	
	@Command
	@NotifyChange({"contactus", "contactUsList"})
	public void save() {
		if(contactus.getId()==null) {
			contactus = contactService.save(contactus);
			contactUsList.add(contactus);
		}
		else contactService.save(contactus);
	}
	
	@Command
	@NotifyChange({"contactus", "contactUsList"})
	public void remove() {
		contactService.remove(contactus);
		contactUsList.remove(contactus);
		clean();
	}
	
	@Command
	@NotifyChange("contactus")
	public void clean() {
		contactus = ContactUs.create("", "");
	}
	
	public Validator getFormValidator() {
	    return new AbstractValidator() {
	        public void validate(ValidationContext ctx) {
	        	if(StringUtils.isEmpty(contactus.getUsername())) {
	        		addInvalidMessage(ctx, "username", "Username is required");
	        	}
	        }
	    };
	}

}
