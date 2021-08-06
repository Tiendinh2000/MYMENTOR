package com.Spring.controller.User;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Spring.DAO.impl.StudentDAO;
import com.Spring.DTO.StudentWithSubject;
import com.Spring.DTO.TutorWithSubject;
import com.Spring.model.Student;
import com.Spring.model.Tutor;
import com.Spring.Service.Impl.TutorServiceImpl;
import com.Spring.Service.Impl.StudentService;
import com.Spring.Service.Impl.SubjectService;
import com.Spring.Service.Impl.UserAccountService;

@Controller
public class TutorController { 

	@Autowired
	SubjectService subjectService;

	@Autowired
	UserAccountService userAccountservice;

	@Autowired
	TutorServiceImpl tutorService;

	@Autowired
	StudentService studentService;

	/// TutorController

	@RequestMapping(value = "/user/registryTutorPage", method = RequestMethod.GET)
	public ModelAndView getRegistryTutorPage() {
		TutorWithSubject t = new TutorWithSubject();
		ModelAndView mav = new ModelAndView("/user/registryTutor");
		mav.addObject("registryTutor", t);
		return mav;

	}

	@RequestMapping(value = "/user/registryTutor", method = RequestMethod.POST)
	public ModelAndView getTutorInfor(@ModelAttribute TutorWithSubject t,
			@RequestParam(value = "image", required = false) MultipartFile photo, Principal principal) {

		System.out.println("subject:" + getUserName(principal) + " tutor;" + t.getTutor().toString());
		int userId = userAccountservice.findIdByUserName(getUserName(principal));
		Tutor tutor = t.getTutor();
	//	System.out.println("photo :" + saveImage(photo));
		tutor.setFk_Account(userId);
		tutor.setImage(saveImage(photo));
		tutorService.registryAsTutor(tutor, t.getSubject().getSubjectName());
		return new ModelAndView("redirect:/homepage");
	}

	@RequestMapping(value = "/user/trainer", method = RequestMethod.GET)
	public ModelAndView TutorListPage() {
		ModelAndView mav = new ModelAndView("/user/trainer");
		HashMap<Tutor, String> map = new HashMap<Tutor, String>();
		List<Tutor> l = tutorService.findAll();
		int num = 1;
		for (Tutor t : l) {
			map.put(t, getSubjectById(t.getId()));
			num++;
			if (num == 10)
				break;
		}
		mav.addObject("hashmap", map);

		return mav;
	}

	public String getSubjectById(int id) {
		return subjectService.findSubjectByTutorId(id);
	}

	// Student controller

	@RequestMapping(value = "/user/registryStudentPage", method = RequestMethod.GET)
	public ModelAndView getRegistryStudentPage() {
		StudentWithSubject s = new StudentWithSubject();
		ModelAndView mav = new ModelAndView("/user/registryStudent");
		mav.addObject("registryStudent", s);
		return mav;

	}

	@RequestMapping(value = "/user/registryStudent", method = RequestMethod.POST)
	public ModelAndView getStudentInfor(@ModelAttribute StudentWithSubject student, Principal principal) {

		System.out.println(
				"sutdent:" + getUserName(principal) + " subject " + student.getSubject().getSubjectName().toString());
		int userId = userAccountservice.findIdByUserName(getUserName(principal));
		student.getStudent().setFk_accountId(userId);
		studentService.registryStudent(student.getStudent(), student.getSubject());
		return new ModelAndView("redirect:/homepage");
	}

	private String getUserName(Principal principal) {
		return principal.getName();
	}

	private String saveImage(MultipartFile file) {
		if (file != null && !file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				String rootPath = System.getProperty("catalina.home");

				// Poin to to Image directory
				File dir = new File(rootPath + File.separator + "assets/user/img");

				// create file name by id created from time
				String name = String.valueOf(new Date().getTime() + ".jpg");
				String f = dir.getAbsolutePath()+ File.separator + name;
				Path path=Paths.get(f);	
				Files.write(path, bytes);

				return name;
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("FILE EMPTY");
		}

		return "";
	}
}
