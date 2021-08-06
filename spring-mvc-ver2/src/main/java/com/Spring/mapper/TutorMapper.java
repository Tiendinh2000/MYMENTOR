package com.Spring.mapper;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Spring.model.Tutor;

public class TutorMapper implements RowMapper {

	@Override
	public Tutor mapRow(ResultSet rs, int rowNum) throws SQLException {
		try {
			Tutor t = new Tutor();
			t.setId(rs.getInt("id_tutor"));
			t.setGender(rs.getString("Tutor_gender"));
			t.setPhonenumber(rs.getString("Tutor_phonenumber"));
			t.setTutorName(rs.getString("Tutor_name"));
			t.setAddress(rs.getString("Tutor_address"));
			t.setCredential(rs.getString("Tutor_credential"));
			t.setExperienceYear(rs.getInt("Tutor_experienceYear"));
			t.setImage(rs.getString("Tutor_image"));
			t.setDescription(rs.getString("Tutor_description"));
			t.setFk_Account(rs.getInt("fk_Account"));
			return t;
		} catch (SQLException e) {
			return null;
		}
	}

}
