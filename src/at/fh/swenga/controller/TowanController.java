package at.fh.swenga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import at.fh.swenga.game.data.Boot;

@Controller
public class TowanController {

	@RequestMapping(value = {"/", "index"})
	public String showWelcome() {
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin() {
		return "home";
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
	
	@RequestMapping(value = "/game", method = RequestMethod.GET)
	public String showGame() {
		return "game";
	}
	
	@RequestMapping(value = "/towanGame")
	public String startGame() {
		Boot game = new Boot();
		game = null;
		return "towanGame";
	}
	
	@RequestMapping(value = "/settings")
	public String showSettings() {
		return "settings";
	}
	
	@RequestMapping(value = "/impressum")
	public String showAbout() {
		return "impressum";
	}
	
	@RequestMapping(value = "/forgottenpwd")
	public String showForgottenPwd() {
		return "forgottenpwd";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex) {
		System.out.println("but an error occured.");
		ex.printStackTrace();
		return "error";
	}
}
