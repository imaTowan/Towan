package at.fh.swenga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import at.fh.swenga.model.UserModel;

@Controller
public class TowanController {

	@RequestMapping(value = {"/", "index"})
	public String showWelcome() {
		return "index";
	}
	
	@RequestMapping(value = "/register")
	public String showRegister() {
		return "register";
	}
	
	@RequestMapping(value = "/verify")
	public String showVerification() {
		return "verifyInfo";
	}
	
	@RequestMapping(value = "/activate")
	public String showActivate() {
		return "activate";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String handleLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/home")
	public String showHome() {
		return "home";
	}
	
	@RequestMapping(value = "/profile")
	public String showProfile() {
		return "profile";
	}
	
	@RequestMapping(value = "/forum")
	public String showForum() {
		return "forum";
	}
	
	@RequestMapping(value = "/game")
	public String showGame() {
		return "game";
	}
	
	@RequestMapping(value = "/settings")
	public String showSettings() {
		return "settings";
	}
	
	@RequestMapping(value = "/impressum")
	public String showAbout() {
		return "impressum";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex) {
		return "error";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(WebRequest request, Model model) {
		UserModel userModel = new UserModel();
	    model.addAttribute("user", userModel);
	    return "register";
	}
}
