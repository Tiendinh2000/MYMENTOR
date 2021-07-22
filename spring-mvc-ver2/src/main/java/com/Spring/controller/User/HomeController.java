package com.Spring.controller.User;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Spring.Models.Tutor;
import com.Spring.Models.UserAccount;
import com.Spring.Service.HomeService;
import com.Spring.Service.Impl.SubjectService;
import com.Spring.Service.Impl.UserAccountService;

@Controller(value="userController")
public class HomeController {

	@Autowired
	UserAccountService userAccountservice;
	
	@Autowired
	HomeService tutorService;
	
	@Autowired
	SubjectService subjectService;
	
	@RequestMapping(value="/user/homepage",method=RequestMethod.GET)
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("Homepage");
		return mav;
	
	}
	
	@RequestMapping(value="/user/login",method=RequestMethod.GET)
	public ModelAndView getLoging() {
		ModelAndView mav = new ModelAndView("/user/userLogin");
		return mav;
	}
	
	
	@RequestMapping(value="/user/getRegister",method=RequestMethod.GET)
	public ModelAndView RegisterPage( ) {
		UserAccount acc = new UserAccount();
		ModelAndView mav = new ModelAndView("/user/register");
		mav.addObject("newAccount",acc);
		return mav;
	
	}
	
	@RequestMapping(value="/user/Register",method=RequestMethod.POST)
	public ModelAndView Register(@ModelAttribute UserAccount acc) {
		ModelAndView mav = new ModelAndView("daDangKi");
		if(userAccountservice.register(acc)==true)
			return mav;
		else {
			mav.setViewName("404");
			return mav;}
		
	}
	
	@RequestMapping(value = "/user/trainer", method = RequestMethod.GET)
	public ModelAndView TutorListPage() {
		ModelAndView mav = new ModelAndView("/user/trainer");
		HashMap<Tutor, String> map = new HashMap<Tutor, String>();
		List<Tutor> l = tutorService.findAll();
		for(Tutor t :l) {
			map.put(t, getSubjectById(t.getId()));
		}
		
		mav.addObject("hashmap",map);
		
		return mav;
	}
	

	public String getSubjectById(int id) {
	return  subjectService.findSubjectByTutorId(id);
	}

	
	@RequestMapping("/user/homepage")
	private String UserSuccess() {
		return "Homepage";
	}
	
	/// TutorController
	
	@RequestMapping(value = "/user/registryTutorPage", method = RequestMethod.GET)
	public ModelAndView getRegistryTutorPage() {
		Tutor newTutor = new Tutor();
		ModelAndView mav = new ModelAndView("/user/createForm");
		mav.addObject("newTutor",newTutor);
		return mav;
		
	}
	
	@RequestMapping(value = "/user/registryTutor", method = RequestMethod.POST)
	public ModelAndView input(@ModelAttribute Tutor t, Principal principal) {
		try {
		String userName = principal.getName();
	    int userId = userAccountservice.findIdByUserName(userName);
	    t.setAccount_id(userId);
				tutorService.insert(t);}
		catch (Exception e) {
		   return new ModelAndView("404");
		}
		return new ModelAndView("redirect:/homepage") ;
		}
	
	
	
}
