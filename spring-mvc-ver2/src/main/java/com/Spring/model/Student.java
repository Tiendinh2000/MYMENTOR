package com.Spring.model;

public class Student {
	private int id;
	private String studentName;
	private String address;
	private String phonenumber;
	private int grade;
	private String skill;
	private int fk_accountId;

	public Student() {
	}

	public Student(int id) {
		this.id = id;
	}

	public Student(int id, String studentName, String address,String phonenumber, int grade, String skill, int fk_accountId) {
		this.id = id;
		this.studentName = studentName;
		this.address = address;
		this.phonenumber=phonenumber;
		this.grade = grade;
		this.fk_accountId = fk_accountId;
		this.skill = skill;
		
	}

	public Student(String studentName, String address,String phonenumber, int grade, String skill,int fk_accountId) {

		this.studentName = studentName;
		this.address = address;
		this.grade = grade;
		this.phonenumber=phonenumber;
		this.skill = skill;
		this.fk_accountId = fk_accountId;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}



	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public int getFk_accountId() {
		return fk_accountId;
	}

	public void setFk_accountId(int fk_accountId) {
		this.fk_accountId = fk_accountId;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student (" + id + ", " + studentName + ", " + address + ", " + grade + ", " + ", " + skill +", fk:" + fk_accountId+ ")";
	}

}
