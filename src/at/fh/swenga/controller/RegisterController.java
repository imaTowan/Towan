package at.fh.swenga.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private SimpleMailMessage customMailMessage;
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegister(Model model) {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute UserModel newUserModel, BindingResult bindingResult, Model model) {

		if (newUserModel.getPassword().length() < 14)
			return "register2";
		else {
			// Password encryption
			
			newUserModel.setPassword(passwordEncoder.encode(newUserModel.getPassword()));
			userRepository.save(newUserModel);

			// Create user-role for the user
			UserRoleModel role = new UserRoleModel();
			role.setRole("ROLE_USER");
			role.setUser(newUserModel);
			userRoleRepository.save(role);
			
			//Send verification mail
			SimpleMailMessage msg = new SimpleMailMessage(this.customMailMessage);
			msg.setTo(newUserModel.getEmail_address());
			msg.setText(String.format(msg.getText(), newUserModel.getUsername(), "http://localhost:8080/Towan/verification?id="+newUserModel.getUserId()));
			this.mailSender.send(msg);

			return "verifyInfo";
		}
	}

	@RequestMapping(path = "/addAdmin", method = RequestMethod.GET) // Map ONLY GET Requests
	public @ResponseBody String addAdmin() {
		// @ResponseBody means the returned String is the response, not a view
		// name
		// @RequestParam means it is a parameter from the GET or POST request

		// Create admin
		UserModel admin = new UserModel("admin", passwordEncoder.encode("adminadminadmin"), "towanAdmin@towan.us");
		admin.setActivated(true);
		userRepository.save(admin);

		// Create role for admin
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
	
	@RequestMapping("/verification")
	public String doVerification(@RequestParam String id) {
		
		userRepository.setUserActivated(Long.parseLong(id));
		
		return "login";
	}

	@RequestMapping(value = "/activate", method = RequestMethod.GET)
	public String showActivate() {
		return "activate";
	}
}
