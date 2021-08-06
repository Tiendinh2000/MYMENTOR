package com.Spring.Service;

import java.util.List;

import com.Spring.model.Student;

public interface IStudentService {


	List<Student> findAll();
	boolean insert(Student s);
	boolean delete(int id);
	boolean update(Student t);
	Student findById(int id);
}
