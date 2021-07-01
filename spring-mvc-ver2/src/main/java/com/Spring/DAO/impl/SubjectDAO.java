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

@Repository
public class SubjectDAO extends AbstractDAO<Subject> implements ISubjectDAO {

	@Override
	public List<Subject> findAll() {
		String sql = "SELECT * FROM subjects";
		return query(sql, new SubjectMapper());
	}

	public static void main(String[] args) {
		SubjectDAO d = new SubjectDAO();

		System.out.println(d.SubjectsOfTeacher(2));
	}

	public List<Subject> SubjectsOfTeacher(int id) {
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

	public List<Tutor> allInFor(){
		
		
		
		
		return null;
		
	}

}
