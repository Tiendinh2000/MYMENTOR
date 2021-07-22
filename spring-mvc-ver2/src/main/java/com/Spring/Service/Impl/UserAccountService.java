package com.Spring.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.DAO.IUserAccountDAO;
import com.Spring.DAO.impl.TutorListDAO;
import com.Spring.DAO.impl.UserAccountDAO;
import com.Spring.Models.UserAccount;
import com.Spring.Service.IUserAccountService;
@Service
public class UserAccountService implements IUserAccountService {

	@Autowired
	private UserAccountDAO dao;

	@Override
	public boolean register(UserAccount u) {
		
		return dao.register(u);
	}

	@Override
	public List<UserAccount> findAll() {
	
		return null;
	}

	
	public int findIdByUserName(String name) throws NullPointerException {
	List<UserAccount> list = dao.findIdByUserName(name);
	if(list.size()==1) {
		return list.get(0).getId();
	}
	else
		throw new NullPointerException("can not find id of :"+name);
	}


}
