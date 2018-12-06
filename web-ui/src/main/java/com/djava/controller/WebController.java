package com.djava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	/*@GetMapping(value = { "", "/", "/home" })*/
	@GetMapping("/home")
	public String homePage() {
		return "hoem";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

}
