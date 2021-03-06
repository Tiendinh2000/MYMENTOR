package com.Spring.controller.admin;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;     
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Spring.model.Tutor;
import com.Spring.Service.TutorService;
import com.Spring.Service.Impl.TutorServiceImpl;
import com.Spring.Service.Impl.UserAccountService;

//@Controller(value="adminController")

@Controller
public class HomeController {

	@Autowired
    TutorService homeService;	

	@Autowired
	UserAccountService userAccountService;
	
	@RequestMapping(value = "/admin/TutorList", method = RequestMethod.GET)
	public ModelAndView TutorListPage() {
		ModelAndView mav = new ModelAndView("/admin/tutorList");
		mav.addObject("Tutormenu",homeService.findAll());
		return mav;
	}

	@RequestMapping(value = "/admin/insertPage", method = RequestMethod.GET)
	public ModelAndView inputPage() {
		Tutor newTutor = new Tutor();
		ModelAndView mav = new ModelAndView("/admin/insert");
		mav.addObject("newTutor",newTutor);
		return mav;
		
	}
	
	@RequestMapping(value = "/admin/insert", method = RequestMethod.POST)
	public ModelAndView input(@ModelAttribute Tutor t,Principal principal) {
		String userName = principal.getName();
		t.setFk_Account(userAccountService.findIdByUserName(userName));
				homeService.insert(t);
		return new ModelAndView("redirect:/admin/TutorList") ;
		}
	
	
	@RequestMapping(value = "/admin/deleteTutor/{id}", method = RequestMethod.GET)
	public String deleteTutor(@PathVariable(value="id") int id) {
		homeService.delete(id);
		return "redirect:/admin/TutorList";
	}
	
	
	@RequestMapping(value = "/admin/editTutorPage", method = RequestMethod.GET)
	public ModelAndView updatePage(@RequestParam("id") int id) {
		//editId=id; 
		ModelAndView mav =  new ModelAndView("/admin/editTutor");
	    Tutor t = homeService.findByID(id);
		mav.addObject("editedTutor",t);
		return mav;
	}
		
	@RequestMapping(value = "/admin/editTutor", method = RequestMethod.POST)
	public ModelAndView updateTutorInfor(@ModelAttribute Tutor t) {
		homeService.update(t);
		return new ModelAndView("redirect:/admin/TutorList");
		
	}
	
	@RequestMapping("/admin/success")
	private String AdminSuccess() {
		return "redirect:/admin/TutorList";}
	
}
