package com.Spring.controller.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Spring.Models.UserAccount;
import com.Spring.Service.HomeService;
import com.Spring.Service.Impl.UserAccountService;

@Controller(value="userController")
public class HomeController {

	@Autowired
	UserAccountService service;
	
	@Autowired
	HomeService HomeService;
	
	
	
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
		if(service.register(acc)==true)
			return mav;
		else {
			mav.setViewName("404");
			return mav;}
		
	}
	
	@RequestMapping(value = "/user/trainer", method = RequestMethod.GET)
	public ModelAndView TutorListPage() {
		ModelAndView mav = new ModelAndView("/user/trainer");
		mav.addObject("Tutormenu",HomeService.TutorWithSubject());
		return mav;
	}
	

	
	@RequestMapping("/user/homepage")
	private String UserSuccess() {
		return "Homepage";
	}
	
}
