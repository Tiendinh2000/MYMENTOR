package com.Spring.Service;

import java.util.List;

import com.Spring.model.Subject;
import com.Spring.model.Tutor;

public interface ISubjectService {
	
	List<Subject> findAll();
	List<Tutor> FindTutorBySubject(String name) ;
}
