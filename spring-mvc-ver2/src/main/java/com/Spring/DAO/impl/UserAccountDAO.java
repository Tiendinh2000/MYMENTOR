package com.Spring.DAO.impl;

import java.util.List;

import javax.sound.midi.Soundbank;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.Spring.DAO.IUserAccountDAO;
import com.Spring.Models.Tutor;
import com.Spring.Models.UserAccount;
import com.Spring.Service.IUserAccountService;
import com.Spring.mapper.UserAccountMapper;

@Repository
public class UserAccountDAO extends AbstractDAO<UserAccount> implements IUserAccountDAO {


	public static void main(String[] args) {
		UserAccountDAO u = new UserAccountDAO();
		UserAccount a = new UserAccount();
		a.setPassword("tien2");
		a.setUserName("123456");
		a.setRole("ROLE_USER");
		a.setEnable(1);
		System.out.println(u.register(a));
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
		String hashedPassword = passwordEncoder.encode(u.getPassword());

		try {
			dercryptedAccount.setPassword(hashedPassword);
			dercryptedAccount.setRole(hashedPassword);
			dercryptedAccount.setEnable(1);
		}catch (Exception e) {
			return false;
		}
		String sql = "INSERT INTO useraccount(id_user,username,password,role,enable) VALUES (?,?,?,?,?)";
	      return insert(sql,u);
	}
 
	public List<UserAccount> findUserName(String username){
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
