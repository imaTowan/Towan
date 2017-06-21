package at.fh.swenga.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.dao.EntryRepository;
import at.fh.swenga.dao.ForumRepository;
import at.fh.swenga.dao.SubforumRepository;
import at.fh.swenga.dao.UserRepository;
import at.fh.swenga.model.EntryModel;
import at.fh.swenga.model.ForumModel;
import at.fh.swenga.model.SubforumModel;
import at.fh.swenga.model.UserModel;

@Controller
public class ForumController {

	
	@Autowired
	ForumRepository forumRepository;
	
	@Autowired
	SubforumRepository subforumRepository;
	
	@Autowired
	EntryRepository entryRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/forum")
	public String showForum(Model model) {
		List<ForumModel> forums = forumRepository.findAll();
		model.addAttribute("forums", forums);
		return "forum";
	}
	

	@RequestMapping(value = "/forum/subforum")
	public String showSubforum(Model model, @RequestParam int id) {
		List<SubforumModel> forums = subforumRepository.findByForumForumId(id);
		model.addAttribute("forums", forums);
		
		return "forum/subforum";
	}
	
	@RequestMapping(value = "/entry")
	public String showEntries(Model model, @RequestParam int id) {
		List<EntryModel> forums = entryRepository.findBySubforumSubforumId(id);
		model.addAttribute("forums", forums);
		return "forum/entry";
	}

	@RequestMapping("/deleteForum")
	public String deleteTopic(Model model, @RequestParam int id) {
		forumRepository.deleteByForumId(id);
		return "forward:forum";
	}
	

	@RequestMapping(value = "/addEntry", method = RequestMethod.GET)
	public String showAddEntryForm(Model model, @RequestParam int id){
		return "forum/editEntry";
	}
	
	@RequestMapping(value = "/addEntry", method = RequestMethod.POST)
	public String addEntry(@Valid @ModelAttribute EntryModel newEntryModel, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			String errorMessage = "";
			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				errorMessage += fieldError.getField() + " is invalid<br>";
			}
			model.addAttribute("errorMessage", errorMessage);
			return "forward:/entry";
		}
		
		//if (newEntryModel != null) {
			//model.addAttribute("errorMessage", "Entry already exists!<br>");
		//} else {
		newEntryModel.setDate(new Timestamp(System.currentTimeMillis()));
		UserModel user = null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		List<UserModel> userList = userRepository.findByUsername(auth.getName());
		user = userList.get(0);
		newEntryModel.setUser(user);
		newEntryModel.setSubforum(null);
		entryRepository.save(newEntryModel);
		
		return "forum/entry";
	}
	
	@RequestMapping(value = "/addTopic", method = RequestMethod.GET)
	public String showAddTopicForm(Model model) {
		return "forum/editTopic";
	}

	@RequestMapping(value = "/addTopic", method = RequestMethod.POST)
	public String addTopic(@Valid @ModelAttribute ForumModel newForumModel, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			String errorMessage = "";
			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				errorMessage += fieldError.getField() + " is invalid<br>";
			}
			model.addAttribute("errorMessage", errorMessage);
			return "/forum";
		}

		if (newForumModel != null) {
			model.addAttribute("errorMessage", "Forum already exists!<br>");
			return "/forum";
		
		} else {
			
		forumRepository.save(newForumModel);
		return "/forum";
		}
	}
		
		@RequestMapping(value = "/addSubforum", method = RequestMethod.GET)
		public String showAddSubforumForm(Model model) {
			return "forum/editSubforum";
		}
		
		@RequestMapping(value = "/addSubforum", method = RequestMethod.POST)
		public String addSubforum(@Valid @ModelAttribute SubforumModel newSubforumModel, BindingResult bindingResult,
				Model model) {
			if (bindingResult.hasErrors()) {
				String errorMessage = "";
				for (FieldError fieldError : bindingResult.getFieldErrors()) {
					errorMessage += fieldError.getField() + " is invalid<br>";
				}
				model.addAttribute("errorMessage", errorMessage);
				return "forum/subforum";
			}

			if (newSubforumModel != null) {
				model.addAttribute("errorMessage", "Forum already exists!<br>");
				return "forum/subforum";
			
			} else {
				
			subforumRepository.save(newSubforumModel);
			return "forum/subforum";
				}	
			}
		@RequestMapping("/deleteSubforum")
		public String deleteSubforum(Model model, @RequestParam int id) {
			subforumRepository.deleteBysubforumId(id);
			return "forward:forum";
		}
		
	
}
