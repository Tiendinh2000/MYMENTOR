package com.Spring.DAO.impl;

import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Repository;

import com.Spring.DAO.ITutorDAO;
import com.Spring.mapper.TutorMapper;
import com.Spring.model.Subject;
import com.Spring.model.Tutor;
import com.Spring.model.UserAccount;

@Repository
public class TutorListDAO extends CRUDDAO<Tutor> implements ITutorDAO {

	
	public static void main(String[] args) {
		TutorListDAO t = new TutorListDAO();
		System.out.println(t.delete(136));
	}
	@Override
	public List<Tutor> findAll() {
		StringBuilder sb = new StringBuilder("SELECT * FROM tutor");
		return query(sb.toString(), new TutorMapper());

	}

	@Override
	public void insert(Tutor t) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO tutor(id_tutor,Tutor_name,Tutor_gender,Tutor_phonenumber,Tutor_address, Tutor_credential,Tutor_experienceyear,Tutor_image,Tutor_description,fk_Account) VALUES (?,?,?,?,?,?,?,?,?,?)";
		insert(sql, t);
	}

	@Override
	public boolean delete(int id) {
		String query = "DELETE FROM tutor WHERE id_tutor =?";
		Tutor t = new Tutor(id);
		return delete(query, t);

	}

	@Override
	public boolean  update(Tutor t) {
		String sql = "UPDATE tutor SET Tutor_name=?,Tutor_gender=?,Tutor_phonenumber=?,Tutor_address=?,Tutor_credential=?,Tutor_experienceYear=?,Tutor_image=?,Tutor_description=?,fk_Account=? WHERE id_tutor=?";
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

	public List<Tutor> findByAccountId(int id) {
		StringBuilder sql = new StringBuilder("SELECT * FROM tutor WHERE fk_Account=?");
		List list = new ArrayList<>();
		try {
			Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				list.add(new TutorMapper().mapRow(resultSet, 0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}


	public List<Tutor> findById(int id) {
		String sql = "SELECT * FROM tutor WHERE id_tutor=?";
		Tutor t = new Tutor(id);
		System.out.println("find:" + t.toString());
		return findById(sql.toString(), new TutorMapper(), t);
	}

	public List<Subject> SubjectsOfTutor(int id) {

		String sql = "SELECT *  FROM subject "
				+ "INNER JOIN tutor_subject ON tutor_subject.subject_id_subject=subject.id_subject "
				+ "INNER JOIN fasttutor.tutor ON tutor.id_Tutor= tutor_subject.tutor_id_Tutor "
				+ "WHERE tutor.id_tutor=?";
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

	public boolean registrySubject(int tutor_id, int subject_id) {
		String sql = "INSERT INTO tutor_subject(tutor_id_Tutor,subject_id_subject) VALUES (?,?) ";
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, tutor_id);
			preparedStatement.setInt(2, subject_id);
			preparedStatement.executeQuery();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		// (Tutor_name,Tutor_gender,Tutor_phonenumber,Tutor_address,Tutuor_credential,Tutor_experienceyear,Tutor_description,fk_AccountId)

	}

	public boolean registryAsTutor(Tutor t, int... id) {

		String sql = "INSERT INTO tutor(Tutor_name,Tutor_gender,Tutor_phonenumber,Tutor_address, Tutor_credential,Tutor_experienceyear,Tutor_image,Tutor_description,fk_Account) VALUES (?,?,?,?,?,?,?,?,?);";
		String sql1 = "INSERT INTO tutor_subject(tutor_id_Tutor,subject_id_subject) VALUES (?,?) ";

		int inserted_id;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, t.getTutorName());
			preparedStatement.setString(2, t.getGender());
			preparedStatement.setString(3, t.getPhonenumber());
			preparedStatement.setString(4, t.getAddress());
			preparedStatement.setString(5, t.getCredential());
			preparedStatement.setInt(6, t.getExperienceYear());
			preparedStatement.setString(7, t.getImage());
			preparedStatement.setString(8, t.getDescription());
			preparedStatement.setInt(9, t.getFk_Account());

			preparedStatement.executeUpdate();

			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					inserted_id = (int) generatedKeys.getLong(1);
				} else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}

				// this stament for insert subjects of tutor
				for (int i : id) {
					PreparedStatement preparedStatement2 = connection.prepareStatement(sql1);
					preparedStatement2.setInt(1, inserted_id);
					preparedStatement2.setInt(2, i);
					preparedStatement2.executeUpdate();
					System.out.println(i);
				}

			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}