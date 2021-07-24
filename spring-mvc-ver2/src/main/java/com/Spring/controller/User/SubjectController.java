package com.Spring.controller.User;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Spring.Models.Subject;
import com.Spring.Service.Impl.SubjectService;

@Controller
public class SubjectController {

	@Autowired
	SubjectService subjectService;
	

	@RequestMapping(value = "/user/math_tutors", method = RequestMethod.GET)
	public ModelAndView Math_TutorList() {
		ModelAndView mav = new ModelAndView("/user/math-trainer");
		mav.addObject("tutorList",subjectService.FindTutorBySubject("Math"));
		mav.addObject("SubjectName", "Math");
		return mav;
	}
	
	@RequestMapping(value = "/user/literature_tutors", method = RequestMethod.GET)
	public ModelAndView literature_TutorList() {
		ModelAndView mav = new ModelAndView("/user/math-trainer");
		mav.addObject("tutorList",subjectService.FindTutorBySubject("Literature"));
		mav.addObject("SubjectName", "Literature");
		return mav;
	}
	
	@RequestMapping(value = "/user/english_tutors", method = RequestMethod.GET)
	public ModelAndView English_TutorList() {
		ModelAndView mav = new ModelAndView("/user/math-trainer");
		mav.addObject("tutorList",subjectService.FindTutorBySubject("English"));
		mav.addObject("SubjectName", "English");
		return mav;
	}
	


}
