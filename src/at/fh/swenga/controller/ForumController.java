package at.fh.swenga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import at.fh.swenga.dao.ForumRepository;
import at.fh.swenga.model.ForumModel;
import at.fh.swenga.model.SubforumModel;
import at.fh.swenga.dao.SubforumRepository;

@Controller
public class ForumController {

	
	@Autowired
	ForumRepository forumRepository;
	
	@Autowired
	SubforumRepository subforumRepository;
	
	@RequestMapping(value = "/forum")
	public String showForum(Model model) {
		List<ForumModel> forums = forumRepository.findAll();
		model.addAttribute("forums", forums);
		return "forum";
	}
	
	@RequestMapping(value = "/forum/subforum")
	public String showSubforum(Model model) {
		List<SubforumModel> forums = subforumRepository.findAll();
		model.addAttribute("forums", forums);
		return "forum";
	}
}
