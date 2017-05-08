package at.fh.swenga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TowanController {

	@RequestMapping(value = "/index")
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
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String handleLogin() {
		return "login";
	}
	
	@RequestMapping(value = {"/","home"})
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
}
