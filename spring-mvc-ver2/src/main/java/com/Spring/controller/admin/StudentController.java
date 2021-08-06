package com.Spring.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Spring.model.Student;
import com.Spring.model.Tutor;
import com.Spring.Service.Impl.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/admin/StudentList", method = RequestMethod.GET)
	public ModelAndView TutorListPage() {
		ModelAndView mav = new ModelAndView("/admin/studentList");
		mav.addObject("studentmenu", studentService.findAll());
		return mav;
	}



	@RequestMapping(value = "/admin/editStudent", method = RequestMethod.POST)
	public ModelAndView updateStudentInfor(@ModelAttribute Student s) {
		studentService.update(s);
		return new ModelAndView("redirect:/admin/StudentList");

	}
	@RequestMapping(value = "/admin/editStudentPage", method = RequestMethod.GET)
	public ModelAndView update(@RequestParam("id") int id) {
		ModelAndView mav = new ModelAndView("/admin/editStudent");
		Student student = studentService.findById(id);
		mav.addObject("editedStudent", student);
		return mav;
	}
}
