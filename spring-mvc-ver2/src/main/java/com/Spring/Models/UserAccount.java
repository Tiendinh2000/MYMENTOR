package com.Spring.Models;

public class UserAccount {

	private int id;
	private String userName;
	private String password;
	private String role;
	private int enable;

	public UserAccount(int id, String userName, String password, String role, int enable) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.enable = enable;
	}
	
	public UserAccount(String userName, String password) {
		this.userName = userName;
		this.password = password;

	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}



	public UserAccount() {
	};

	public UserAccount(int id) {
		this.id = id;
	};

	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserAccount [id=" + id + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ ", enable=" + enable + "]";
	}



}
