package com.Spring.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.Spring.DAO.GenericDAO;
import com.Spring.DAO.ISubjectDAO;
import com.Spring.Models.Subject;
import com.Spring.Models.Tutor;
import com.Spring.mapper.SubjectMapper;
import com.Spring.mapper.TutorMapper;

@Repository
public class SubjectDAO extends AbstractDAO<Subject> implements ISubjectDAO {

	@Override
	public List<Subject> findAll() {
		String sql = "SELECT * FROM subjects";
		return query(sql, new SubjectMapper());
	}

	public static void main(String[] args) {
		SubjectDAO d = new SubjectDAO();

		System.out.println(d.findSubjectsOfTeacher(4).toString());
	}

	public boolean registrySubject(int IdTutor, int IdSubject) {
		String sql ="INSERT INTO tutor_subject VALUES (?,?)";
		Connection connection;
		PreparedStatement preparedStatement;
		try {
			connection = getConnection();
			 preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, IdTutor);
			preparedStatement.setInt(2, IdSubject);
			
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
		
	}
	
	public List<Subject> findSubjectsOfTeacher(int id) {
		String sql = "SELECT *  FROM subject "
				+ "INNER JOIN tutor_subject ON tutor_subject.subject_id_subject=subject.id_subject "
				+ "INNER JOIN fasttutor.tutor ON tutor.id_Tutor= tutor_subject.tutor_id_Tutor " + "WHERE id_Tutor=? ";
		List<Subject> list = new ArrayList<Subject>();
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int i = rs.getInt("id_subject");
				String name = rs.getString("subject_name");
				list.add(new Subject(i,name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Tutor> findTutorsBySubject(String nameOfSubject){
		
		
		String sql =  "SELECT * FROM tutor "
				+ "JOIN tutor_subject ON tutor.id_Tutor=tutor_subject.tutor_id_Tutor "
				+ "JOIN subject ON subject.id_subject = tutor_subject.subject_id_subject "
				+ "WHERE subject_name=?"; 
		
		List<Tutor> list = new ArrayList<Tutor>();
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,nameOfSubject );
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
Tutor t = new TutorMapper().mapRow(rs, 0);
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
