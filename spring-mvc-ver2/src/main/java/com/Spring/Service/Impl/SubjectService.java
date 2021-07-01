package com.Spring.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.DAO.impl.SubjectDAO;
import com.Spring.Models.Subject;
import com.Spring.Service.ISubjectService;

@Service
public class SubjectService implements ISubjectService{

	@Autowired
	SubjectDAO dao;

	@Override
	public List<Subject> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}


}
