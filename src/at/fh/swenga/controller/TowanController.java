package at.fh.swenga.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import at.fh.swenga.game.data.Boot;

@Controller
public class TowanController {

	@RequestMapping(value = {"/", "index"})
	public String showWelcome(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("currUsername",auth.getName());
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
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String doLogout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();  
	    session.invalidate();  
		
		return "index";
	}
	
	@RequestMapping(value = "/home")
	public String showHome() {
		return "home";
	}
	
	@RequestMapping(value = "/profile")
	public String showProfile() {
		return "profile";
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
