package at.fh.swenga.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import at.fh.swenga.dao.UserRepository;
import at.fh.swenga.dao.UserRoleRepository;
import at.fh.swenga.model.UserModel;
import at.fh.swenga.model.UserRoleModel;

@Controller
public class RegisterController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegister(Model model) {
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute UserModel newUserModel, BindingResult bindingResult,
			Model model) {
		
		
		//Password encryption
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		newUserModel.setPassword(passwordEncoder.encode(newUserModel.getPassword()));
		userRepository.save(newUserModel);
		
		//Create user-role for the user
		UserRoleModel role = new UserRoleModel();
		role.setRole("ROLE_USER");
		role.setUser(newUserModel);
		userRoleRepository.save(role);
			
		return "verifyInfo";
	}
	
	@GetMapping(path="/addAdmin") // Map ONLY GET Requests
	public @ResponseBody String addAdmin () {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		//Create admin
		UserModel admin = new UserModel("admin","adminadminadmin","towanAdmin@towan.us");
		admin.setActivated(true);
		userRepository.save(admin);
		
		//Create role for admin
		UserRoleModel role = new UserRoleModel();
		role.setRole("ROLE_ADMIN");
		role.setUser(admin);
		userRoleRepository.save(role);
		
		return "Saved";
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
