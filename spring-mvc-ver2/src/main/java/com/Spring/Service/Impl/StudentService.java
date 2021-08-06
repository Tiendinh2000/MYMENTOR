package com.Spring.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.DAO.impl.StudentDAO;
import com.Spring.model.Student;
import com.Spring.model.Subject;
import com.Spring.Service.IStudentService;

@Service
public class StudentService implements IStudentService {

	@Autowired
	StudentDAO dao;

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public boolean insert(Student s) {
		// TODO Auto-generated method stub
		return dao.insert(s);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public boolean update(Student t) {
		// TODO Auto-generated method stub
		return dao.update(t);
	}

	public List<Student> findStudentByAccountId(int id){
		return dao.findStudentByAccountId(id);
	}
	
	public boolean registryStudent(Student student, Subject subject) {

		for (int i : toSubjectId(subject)) {
			System.out.println("tosubject idL" + i);
		}

		return dao.registryStudent(student, toSubjectId(subject));
	}

	public int[] toSubjectId(Subject subject) {
		List ids = new ArrayList<Integer>();
		for (char c : subject.getSubjectName().toCharArray()) {
			if (c == 'M')
				ids.add(1);
			if (c == 'E')
				ids.add(2);
			if (c == 'L')
				ids.add(3);
		}
		int[] array = new int[ids.size()];
		int index = 0;
		for (Object i : ids) {
			array[index] = (int) i;
			index++;
		}
		return array;
	}

	@Override
	public Student findById(int id) {

		List list = dao.findById(id);
		return (Student) list.get(0);
	}
}
