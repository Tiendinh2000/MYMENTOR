package com.Spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Spring.model.Subject;

public class SubjectMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		try {
			Subject s = new Subject();
			s.setId(rs.getInt("id_subject"));
			s.setSubjectName(rs.getString("subject_name"));
			return s;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}



}
