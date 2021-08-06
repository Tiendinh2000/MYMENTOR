package com.Spring.DAO;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.Spring.model.Tutor;



public interface GenericDAO<T> {
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
	boolean update (String sql, Object parameters);
	boolean insert (String sql, Object parameters);
	int count(String sql, Object... parameters);
	boolean delete(String sql,Object parameters);
  
}
