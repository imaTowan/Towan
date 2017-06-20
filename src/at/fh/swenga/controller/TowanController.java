package at.fh.swenga.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String showProfile(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("currUsername",auth.getName());
		return "profile";
	}
	
	
	@RequestMapping(value = "/game", method = RequestMethod.GET)
	public String showGame() {
		return "game";
	}
	
	@RequestMapping(value = "/gameWin")
	public String handleDownloadWindows(HttpServletResponse response) throws ServletException, IOException {
		OutputStream out = response.getOutputStream();
		FileInputStream in = new FileInputStream("Towan/src/lib/natives_win/lwjgl64.dll");
		byte[] buffer = new byte[4096];
		int length;
		while ((length = in.read(buffer)) > 0){
		    out.write(buffer, 0, length);
		}
		in.close();
		out.flush();
		return "gameWin";
	}
	
	@RequestMapping(value = "/gameLinux")
	public String handleDownloadLinux(HttpServletResponse response) throws ServletException, IOException {
		OutputStream out = response.getOutputStream();
		FileInputStream in = new FileInputStream("Towan/src/lib/natives_linux/liblwjgl64.so");
		byte[] buffer = new byte[4096];
		int length;
		while ((length = in.read(buffer)) > 0){
		    out.write(buffer, 0, length);
		}
		in.close();
		out.flush();
		return "gameWin";
	}
	
	@RequestMapping(value = "/gameMac")
	public String handleDownloadMac(HttpServletResponse response) throws ServletException, IOException {
		OutputStream out = response.getOutputStream();
		FileInputStream in = new FileInputStream("Towan/src/lib/natives_mac/liblwjgl64.dylib");
		byte[] buffer = new byte[4096];
		int length;
		while ((length = in.read(buffer)) > 0){
		    out.write(buffer, 0, length);
		}
		in.close();
		out.flush();
		return "gameWin";
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
