package at.fh.swenga.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysql.jdbc.log.Log;

import at.fh.swenga.dao.UserRepository;
import at.fh.swenga.model.UserModel;

@Controller
public class RegisterController {
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegister(Model model) {
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute UserModel newUserModel, BindingResult bindingResult,
			Model model) {
		
		//UserModel user = userRepository.findByUserId(newUserModel.getUser_id());
		System.out.println("###########################################WRITETODB######################");
		System.out.println("User: " + newUserModel.getUsername());
		System.out.println("UserMail: " + newUserModel.getEmail_address());
		System.out.println("UserID: " + newUserModel.getUser_id());

		
		
		userRepository.save(newUserModel);
			
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
