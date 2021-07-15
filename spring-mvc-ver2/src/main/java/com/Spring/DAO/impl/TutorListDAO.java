package com.Spring.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.Spring.DAO.ITutorDAO;
import com.Spring.Models.Subject;
import com.Spring.Models.Tutor;
import com.Spring.Models.UserAccount;
import com.Spring.mapper.TutorMapper;
import com.sun.org.apache.bcel.internal.generic.RETURN;

@Repository
public class TutorListDAO extends AbstractDAO<Tutor> implements ITutorDAO {

	@Override
	public List<Tutor> findAll() {
		StringBuilder sb = new StringBuilder("SELECT * FROM tutor");
		return query(sb.toString(), new TutorMapper());

	}

	public static void main(String[] args) {
		
		TutorListDAO l = new TutorListDAO();
		
		System.out.println(l.TutorWithSubjectList());
		
//		List<Tutor> l1 = l.findAll();
//	   for(Tutor t :l1) {
//		  String subjectName = l.getSubjectName(l.SubjectsOfTutor(t.getId()));
//		 t.setSubject(subjectName);
//	   }
//	   
//	   System.out.println(l1.toString());
	
		
		
		
	}

	

	
	@Override
	public void insert(Tutor t) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO tutor(id_Tutor,Tutor_name,Tutor_gender,Tutor_phonenumber,Tutor_address, Tutor_credential,Tutor_experienceyear,Tutor_description) VALUES (?,?,?,?,?,?,?,?)";
		insert(sql, t);
	}

	@Override
	public boolean delete(int id) {
		String query = "DELETE FROM tutor WHERE id_Tutor =?";
		Tutor t = new Tutor(id);
		return delete(query, t);

	}

	@Override
	public boolean update(Tutor t) {
		String sql = "UPDATE tutor SET Tutor_name=?,Tutor_gender=?,Tutor_phonenumber=?,Tutor_address=?,Tutor_credential=?,Tutor_experienceYear=?,Tutor=description WHERE id_Tutor=?";
		System.out.println(t.toString() + " DAO");
		try {
			update(sql, t);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<Tutor> findByExperience(int exp) {
		StringBuilder sql = new StringBuilder("SELECT * FROM tutor WHERE Tutor_experienceyear=?");
		Tutor t = new Tutor();
		t.setExperienceYear(exp);

		return find(sql.toString(), new TutorMapper(), t);

	}

	public List<Tutor> findById(int id) {
		StringBuilder sql = new StringBuilder("SELECT * FROM tutor WHERE id_Tutor=?");
		Tutor t = new Tutor();
		t.setId(id);

		return findById(sql.toString(), new TutorMapper(), t);
	}

	public List<Subject> SubjectsOfTutor(int id) {

		String sql = "SELECT *  FROM subject "
				+ "INNER JOIN tutor_subject ON tutor_subject.subject_id_subject=subject.id_subject "
				+ "INNER JOIN fasttutor.tutor ON tutor.id_Tutor= tutor_subject.tutor_id_Tutor "
				+"WHERE tutor.id_tutor=?";
		List<Subject> list = new ArrayList<Subject>();
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String name = rs.getString("subject_name");
			   list.add(new Subject(name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}
	
	public String getSubjectName(List<Subject> subjects) {
		String result="";
		for(Subject s: subjects) {
			result+=s.getName()+", ";
		}
		
		return result;
	}
	
	public List<Tutor> TutorWithSubjectList(){
		
	TutorListDAO dao = new TutorListDAO();
	
      List<Tutor> list = dao.findAll();
		   for(Tutor t :list) {
				  String subjectName = dao.getSubjectName(dao.SubjectsOfTutor(t.getId()));
				 t.setSubjects(subjectName);
			   }
		   return list;
	}
}