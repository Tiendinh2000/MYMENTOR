package com.Spring.DAO.impl;

import java.util.List;

import javax.sound.midi.Soundbank;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.Spring.DAO.IUserAccountDAO;
import com.Spring.mapper.UserAccountMapper;
import com.Spring.model.Tutor;
import com.Spring.model.UserAccount;
import com.Spring.Service.IUserAccountService;

@Repository
public class UserAccountDAO extends CRUDDAO<UserAccount> implements IUserAccountDAO {


	public static void main(String[] args) {
		UserAccountDAO u = new UserAccountDAO();
System.out.println(u.delete(4));
	}

	@Override
	public List<UserAccount> findAll() {
		StringBuilder sql = new StringBuilder("SELECT * FROM useraccount");

		return query(sql.toString(), new UserAccountMapper());
	}

	@Override
	public boolean register(UserAccount u) {
		UserAccount dercryptedAccount =u;
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(dercryptedAccount.toString());
		String hashedPassword = passwordEncoder.encode(u.getPassword());
		try {
			dercryptedAccount.setPassword(hashedPassword);
			dercryptedAccount.setRole("ROLE_USER");
			dercryptedAccount.setEnable(1);
			System.out.println(dercryptedAccount.toString());
		}catch (Exception e) {
			return false;
		}
		String sql = "INSERT INTO useraccount(id_user,username,password,role,enable) VALUES (?,?,?,?,?)";
	      return insert(sql,u);
	}
 
	public List<UserAccount> findIdByUserName(String username){
		StringBuilder sql = new StringBuilder("SELECT * FROM useraccount WHERE username=?");
      
     UserAccount u = new UserAccount();
       u.setUserName(username);
		return find(sql.toString(), new UserAccountMapper(), u);

	}

	
	public List<UserAccount> findPassword(String pw){
		StringBuilder sql = new StringBuilder("SELECT * FROM useraccount WHERE password=?");
      
     UserAccount u = new UserAccount();
       u.setPassword(pw);
       return find(sql.toString(), new UserAccountMapper(), u);

	}
	
	@Override
	public boolean delete(int id) {
		String query = "DELETE FROM useraccount WHERE id_user=?";
		UserAccount u = new UserAccount(id);
		return delete(query, u);
	}

	@Override
	public boolean update(UserAccount u) {
		return false;
	}

	
	
}
