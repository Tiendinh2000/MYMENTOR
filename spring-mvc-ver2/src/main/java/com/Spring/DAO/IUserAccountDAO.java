package com.Spring.DAO;

import java.util.List;

import com.Spring.Models.UserAccount;

public interface IUserAccountDAO extends GenericDAO<UserAccount> {

	List<UserAccount> findAll();
	boolean register(UserAccount u) ;
	boolean delete(int id);
	boolean update(UserAccount u);
}
