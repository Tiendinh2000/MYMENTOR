package com.Spring.controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Spring.Service.Impl.SubjectService;

@Controller
public class SubjectController {

	@Autowired
	SubjectService service;
	
//	@RequestMapping(value="/user/homepage",method=RequestMethod.GET)
//	public ModelAndView page() {
//		ModelAndView mav = new ModelAndView("Homepage");
//		return mav;
//	
//	}
	
}
