package at.fh.swenga.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import at.fh.swenga.dao.UserRepository;
import at.fh.swenga.game.data.Boot;
import at.fh.swenga.game.data.Player;
import at.fh.swenga.model.UserModel;
import at.fh.swenga.model.UserRoleModel;

import at.fh.swenga.model.UserModel;

@Controller
public class TowanController {
	
	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = {"/", "index"})
	public String showWelcome(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("currUsername",auth.getName ());
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
	public String showProfile(Model model) {
		// Get user from DB
		UserModel user = null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		List<UserModel> userList = userRepository.findByUsername(auth.getName());
		user = userList.get(0);
		
		// Update DB
		user.setTotal_enemies_slain(user.getTotal_enemies_slain() + Player.Enemies_slain);
		user.setTotal_waves_completed(user.getTotal_waves_completed() + Player.Waves_completed);
		user.setTotal_towers_built(user.getTotal_towers_built() + Player.Towers_built);
		user.setPlaytime(user.getPlaytime() + Player.Playtime);
		
		// Read from DB
		model.addAttribute("currUsername",auth.getName());
		model.addAttribute("playtime", user.getPlaytime());
		model.addAttribute("total_enemies_slain", user.getTotal_enemies_slain());
		model.addAttribute("towers_build",user.getTotal_towers_built());
		model.addAttribute("waves_completed",user.getTotal_waves_completed());
		userRepository.save(user);
		
		// Reset Player stats
		Player.Enemies_slain = 0;
		Player.Waves_completed = 0;
		Player.Towers_built = 0;
		Player.Playtime = 0;
		
		return "profile";
	}
	
	
	
	@RequestMapping(value = "/game", method = RequestMethod.GET)
	public String showGame() {
		return "game";
	}
	
	@RequestMapping(value = "/towanGame")
	public String startGame() {
		new Boot();
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
		ex.printStackTrace();
		return "error";
	}
}