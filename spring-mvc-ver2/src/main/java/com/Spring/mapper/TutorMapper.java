package com.Spring.mapper;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Spring.Models.Tutor;

public class TutorMapper implements RowMapper {


	@Override
	public Tutor mapRow(ResultSet rs, int rowNum) throws SQLException {
		try {
			Tutor t = new Tutor();
			t.setId(rs.getInt("id_Tutor"));
			t.setName(rs.getString("Tutor_name"));
			t.setAddress(rs.getString("Tutor_address"));
			t.setCredential(rs.getString("Tutor_credential"));
			t.setExperienceYear(rs.getInt("Tutor_experienceYear"));
	
			return t;
		}catch(SQLException e) {
			return null;
		}
	}


	}

