package com.Spring.DAO;

import java.util.List;

import com.Spring.model.Subject;

public interface ISubjectDAO extends GenericDAO<Subject> {

	
	List<Subject> findAll();
	
}
