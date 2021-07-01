package com.Spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Spring.Models.UserAccount;

public class UserAccountMapper implements RowMapper {

	@Override
	public UserAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
		try {
			UserAccount u = new UserAccount();
			u.setId(rs.getInt("id_useraccount"));
			u.setUserName(rs.getString("username"));
			u.setPassword(rs.getString("password"));
			u.setRole(rs.getString("role"));
			u.setEnable(rs.getInt("enable"));
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
