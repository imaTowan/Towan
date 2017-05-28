package at.fh.swenga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import at.fh.swenga.model.UserModel;

@Controller
public class RegisterController {

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegister(WebRequest request, Model model) {
		UserModel userModel = new UserModel();
	    model.addAttribute("user", userModel);
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
