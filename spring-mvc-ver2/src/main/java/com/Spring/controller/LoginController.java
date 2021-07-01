package com.Spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping("/login")
	private String login() {
		
		return "userLogin";
	}

	
	@RequestMapping(value="/homepage",method=RequestMethod.GET)
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("Homepage");
		return mav;
}

}
