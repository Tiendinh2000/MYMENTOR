package com.Spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Spring.Models.Student;

public class StudentMapper implements RowMapper {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		try {
			Student t = new Student();
			t.setId(rs.getInt("id_student"));
			t.setName(rs.getString("Student_name"));
			t.setAddress("Student_address");
			t.setGrade(rs.getInt("Student_grade"));
			t.setSubject(rs.getString("Student_subject"));
			t.setSkill(rs.getString("Student_skill"));
			return t;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
