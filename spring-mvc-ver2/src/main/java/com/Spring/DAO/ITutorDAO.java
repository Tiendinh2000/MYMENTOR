package com.Spring.DAO;

import java.util.List;

import com.Spring.Models.Tutor;

public interface ITutorDAO  extends GenericDAO<Tutor> {

	List<Tutor> findAll();
	void insert(Tutor t);
	boolean delete(int id);
	boolean update(Tutor t);
	
}
