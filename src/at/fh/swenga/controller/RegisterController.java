package at.fh.swenga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegister() {
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegister() {
		return "verifyInfo";
	}
	
	@RequestMapping(value = "/verify", method = RequestMethod.GET)
	public String showVerification() {
		return "verifyInfo";
	}
	
	@RequestMapping(value = "/activate", method = RequestMethod.GET)
	public String showActivate() {
		return "activate";
	}
}
