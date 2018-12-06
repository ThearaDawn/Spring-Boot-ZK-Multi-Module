package com.djava.webvm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Init;

import com.djava.utils.ViewModel;

import lombok.Getter;
import lombok.Setter;


public class MainVM extends ViewModel {

	private static Logger logger = LoggerFactory.getLogger(MainVM.class);
	
	@Getter @Setter
	private String systemName;
	
	@Getter @Setter
	private String miniLogo;
	
	@Getter @Setter
	private boolean authenticated;
	
	@Init
	public void init() {
		logger.info("MainVM initialed!!!");
	}
}
