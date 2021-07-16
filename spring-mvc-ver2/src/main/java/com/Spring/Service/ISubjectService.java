package com.Spring.Service;

import java.util.List;

import com.Spring.Models.Subject;
import com.Spring.Models.Tutor;

public interface ISubjectService {
	
	List<Subject> findAll();
	List<Tutor> FindTutorBySubject(String name) ;
}
