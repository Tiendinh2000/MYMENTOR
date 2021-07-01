package com.Spring.DAO.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.Spring.DAO.IStudentDAO;
import com.Spring.Models.Student;
import com.Spring.mapper.StudentMapper;

@Repository
public class StudentDAO extends AbstractDAO<Student> implements IStudentDAO {

	@Override
	public List<Student> findAll() {
		StringBuilder sb = new StringBuilder("SELECT * FROM student_info");

		return query(sb.toString(), new StudentMapper());
	}

	@Override
	public boolean insert(Student s) {

		String sql = "INSERT INTO student_info(id_student,Student_name,Student_address,Student_grade, Student_subject, Student_skill) VALUES (?,?,?,?,?,?)";
		return insert(sql, s);
	}

	@Override
	public boolean delete(int id) {
		String sql = "DELETE FROM student_info WHERE id_student= ?";
		Student s = new Student(id);

		return delete(sql, s);
	}

	public static void main(String[] args) {
		StudentDAO s = new StudentDAO();
		Student n = new Student();
		n.setSkill("B");
		n.setId(1);
		n.setAddress("new");
		n.setGrade(6);
		n.setName("new");
		n.setSubject("new");
		System.out.println(s.update(n));
	}

	@Override
	public boolean update(Student t) {
		String sql = "UPDATE student_info SET Student_name=?,Student_address=?,Student_grade=?, Student_subject=?, Student_skill=? WHERE id_student=?";

		return update(sql, t);
	}

}
