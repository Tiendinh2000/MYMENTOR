package com.Spring.Service;

import java.util.List;

import com.Spring.Models.UserAccount;

public interface IUserAccountService {

	boolean register(UserAccount u);
	List<UserAccount> findAll();
}
