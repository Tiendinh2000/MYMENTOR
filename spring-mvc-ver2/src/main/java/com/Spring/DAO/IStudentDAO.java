package com.Spring.DAO;

import java.util.List;

import com.Spring.model.Student;

public interface IStudentDAO extends GenericDAO<Student> {

	List<Student> findAll();
	boolean insert(Student s);
	boolean delete(int id);
	boolean update(Student t);
}
