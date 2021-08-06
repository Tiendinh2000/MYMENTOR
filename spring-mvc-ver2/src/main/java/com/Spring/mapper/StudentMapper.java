package com.Spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Spring.model.Student;

public class StudentMapper implements RowMapper {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		try {
			Student t = new Student();
			t.setId(rs.getInt("id_student"));
			t.setStudentName(rs.getString("Student_name"));
			t.setAddress(rs.getString("Student_address"));
			t.setPhonenumber(rs.getString("Student_phonenumber"));
			t.setGrade(rs.getInt("Student_grade"));
			t.setSkill(rs.getString("Student_skill"));
			t.setFk_accountId(rs.getInt("Fk_AccountId"));
			return t;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
