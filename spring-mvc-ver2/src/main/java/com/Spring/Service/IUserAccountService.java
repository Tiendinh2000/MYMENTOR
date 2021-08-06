package com.Spring.Service;

import java.util.List;

import com.Spring.model.UserAccount;

public interface IUserAccountService {

	boolean register(UserAccount u);
	List<UserAccount> findAll();
}
