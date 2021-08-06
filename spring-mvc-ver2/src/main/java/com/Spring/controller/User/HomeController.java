package com.Spring.controller.User;

import java.lang.ProcessBuilder.Redirect;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.Spring.DTO.TutorWithSubject;
import com.Spring.model.Student;
import com.Spring.model.Subject;
import com.Spring.model.Tutor;
import com.Spring.model.UserAccount;

import com.Spring.Service.TutorService;
import com.Spring.Service.Impl.TutorServiceImpl;
import com.Spring.Service.Impl.StudentService;
import com.Spring.Service.Impl.SubjectService;
import com.Spring.Service.Impl.UserAccountService;

@Controller(value = "userController")
public class HomeController {

	@Autowired
	UserAccountService userAccountservice;

	@Autowired
	TutorServiceImpl tutorService;

	@Autowired
	SubjectService subjectService;

	@Autowired
StudentService studentService;
	
	@RequestMapping(value = "/user/homepage", method = RequestMethod.GET)
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("Homepage");
		return mav;

	}

	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public ModelAndView getLogin() {
		ModelAndView mav = new ModelAndView("/user/userLogin");
		return mav;
	}

	@RequestMapping(value = "/user/getRegister", method = RequestMethod.GET)
	public ModelAndView RegisterPage() {
		UserAccount acc = new UserAccount();
		ModelAndView mav = new ModelAndView("/user/register");
		mav.addObject("newAccount", acc);
		return mav;
	}

	@RequestMapping(value = "/user/Register", method = RequestMethod.POST)
	public String Register(@Validated @ModelAttribute("newAccount") UserAccount acc, BindingResult bindingResult) {

		if (bindingResult.hasErrors())
			return "/user/register";

		else {
			userAccountservice.register(acc);
			return "Homepage";
		}

	}

	@RequestMapping(value = "/check/username", method = RequestMethod.GET)
	private String checkUserName(String username) {
		// if(userAccountservice.findIdByUserName(username)!=nu)
		return "no";
	}

	@RequestMapping("/user/homepage")
	private String UserSuccess() {
		return "Homepage";
	}

	@RequestMapping("/user/contact")
	private String getContact() {
		return "/user/contact";
	}

	////

	@RequestMapping(value = "/user/userTutors", method = RequestMethod.GET)
	public ModelAndView YourTutor(Principal principal) {
		ModelAndView mav = new ModelAndView("/user/userTutorProfile");
		int id = userAccountservice.findIdByUserName(getUserName(principal));
		System.out.println("fined:" + id);
		List<Tutor> list = tutorService.findTutorByAccountId(id);
		mav.addObject("tutorList", list);
		return mav;
	}

	@RequestMapping(value = "/user/userDeleteTutor/{id}", method = RequestMethod.GET)
	public String deleteTutor(@PathVariable(value = "id") int id) {
		try {
			tutorService.delete(id);
			return "redirect:/user/userTutors";
		} catch (Exception e) {
			return "redirect:/404";
		}
 
	}

	private String getUserName(Principal principal) {
		return principal.getName();
	}

	@RequestMapping("/404")
	private String get404() {
		return "/404";
	}
	
	///
	@RequestMapping(value = "/user/userStudents", method = RequestMethod.GET)
	public ModelAndView YourStudent(Principal principal) {
		ModelAndView mav = new ModelAndView("/user/userStudentProfile");
		int id = userAccountservice.findIdByUserName(getUserName(principal));
		System.out.println("fined:" + id);
		List<Student> list = studentService.findStudentByAccountId(id);
		mav.addObject("studentList", list);
		return mav;
	}

	@RequestMapping(value = "/user/userDeleteStudent/{id}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable(value = "id") int id) {
		try {
			studentService.delete(id);
			return "redirect:/user/userStudents";
		} catch (Exception e) {
			return "redirect:/404";
		}
 
	}
	
	
}
