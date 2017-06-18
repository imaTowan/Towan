package at.fh.swenga.controller;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import at.fh.swenga.dao.EntryRepository;
import at.fh.swenga.dao.ForumRepository;
import at.fh.swenga.dao.SubforumRepository;
import at.fh.swenga.model.EntryModel;
import at.fh.swenga.model.ForumModel;
import at.fh.swenga.model.SubforumModel;

@Controller
public class ForumController {

	
	@Autowired
	ForumRepository forumRepository;
	
	@Autowired
	SubforumRepository subforumRepository;
	
	@Autowired
	EntryRepository entryRepository;
	
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
		return "forum/subforum";
	}
	
	@RequestMapping(value = "/forum/entry")
	public String showEntries(Model model) {
		List<EntryModel> forums = entryRepository.findAll();
		model.addAttribute("forums", forums);
		return "forum/subforum";
	}
	
}
