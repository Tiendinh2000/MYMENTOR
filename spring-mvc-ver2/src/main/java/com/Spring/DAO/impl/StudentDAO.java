package com.Spring.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.Spring.DAO.IStudentDAO;
import com.Spring.mapper.StudentMapper;
import com.Spring.mapper.TutorMapper;
import com.Spring.model.Student;

@Repository
public class StudentDAO extends CRUDDAO<Student> implements IStudentDAO {

	@Override
	public List<Student> findAll() {
		StringBuilder sb = new StringBuilder("SELECT * FROM student_info");

		return query(sb.toString(), new StudentMapper());
	}

	@Override
	public boolean insert(Student s) {

		String sql = "INSERT INTO student_info(id_student,Student_name,Student_address,Student_phonenumber,Student_grade, Student_skill,Fk_AccountId) VALUES (?,?,?,?,?,?,?)";
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
	System.out.println(s.findStudentByAccountId(19));  
	}

	@Override
	public boolean update(Student t) {
		String sql = "UPDATE student_info SET Student_name=?,Student_address=?,Student_phonenumber=?,Student_grade=?, Student_skill=?,Fk_AccountId=? WHERE id_student=?";

		return update(sql, t);
	}

	
	public List<Student> findById(int id){
		String sql ="SELECT * FROM student_info WHERE id_student=?";
		Student student = new Student(id);
		return findById(sql, new StudentMapper(), student);
	}
	
	public List<Student> findStudentByAccountId(int id){
		String sql ="SELECT * FROM student_info WHERE Fk_AccountId=?";
		List list = new ArrayList<>();
		try {
			Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				list.add(new StudentMapper().mapRow(resultSet, 0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
	
	public boolean registryStudent(Student student, int...id) {
		String sql = "INSERT INTO student_info(Student_name,Student_address,Student_phonenumber,Student_grade, Student_skill,Fk_AccountId) VALUES (?,?,?,?,?,?);";
		String sql1= "INSERT INTO student_has_subject(student_id_student,subject_id_subject) VALUES (?,?) ";
		
		int inserted_id;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1,student.getStudentName());
			preparedStatement.setString(2,student.getAddress());
			preparedStatement.setString(3,student.getPhonenumber());
			preparedStatement.setInt(4,student.getGrade());
			preparedStatement.setString(5,student.getSkill());
			preparedStatement.setInt(6,student.getFk_accountId());
			preparedStatement.executeUpdate();
			
	        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                inserted_id=(int)generatedKeys.getLong(1);
	              //  System.out.println("inserted_id:"+inserted_id);
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	            
	            //this stament for insert subjects of tutor
	            for(int i : id) {
	         PreparedStatement preparedStatement2 =connection.prepareStatement(sql1);
	         preparedStatement2.setInt(1, inserted_id);
	         preparedStatement2.setInt(2, i);
	         preparedStatement2.executeUpdate();
	         System.out.println(i);
	         }
	         
	        }
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	
		
	}
}
