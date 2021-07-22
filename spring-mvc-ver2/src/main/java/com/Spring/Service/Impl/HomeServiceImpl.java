package com.Spring.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.DAO.ITutorDAO;
import com.Spring.DAO.impl.TutorListDAO;
import com.Spring.Models.Tutor;
import com.Spring.Models.UserAccount;
import com.Spring.Service.HomeService;

@Service
public class HomeServiceImpl implements HomeService{
	
	@Autowired
	private TutorListDAO dao;

	@Override
	public List<Tutor> findAll() {
   return dao.findAll();
	}

	@Override
	public void insert(Tutor t) {
		dao.insert(t);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public void update(Tutor newTutor) {
		// TODO Auto-generated method stub
		dao.update(newTutor);
	}

	@Override
	public Tutor findByID(int id) {
		List l = dao.findById(id);
		if(l.size()==1) 
			return (Tutor) l.get(0);
		else
		  return null;
	}

	
	


	
}