package com.Spring.controller.admin;

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

import com.Spring.Models.Tutor;
import com.Spring.Service.HomeService;
import com.Spring.Service.Impl.HomeServiceImpl;

@Controller(value="adminController")
public class HomeController {

	@Autowired
    HomeService homeService;	

	
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
	public ModelAndView input(@ModelAttribute Tutor t) {
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
		
		return "daDangKi";}
	
}
