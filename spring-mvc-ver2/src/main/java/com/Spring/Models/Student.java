package com.Spring.Models;

public class Student {
	private int id;
	private String name;
	private String address;
	private int grade;
	private String subject;
	private String skill;

	public Student() {
	}

	public Student(int id) {
		this.id = id;
	}

	public Student(int id, String name, String address, int grade, String subject, String skill) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.grade = grade;
		this.subject = subject;
		this.skill = skill;
	}
	public Student( String name, String address, int grade, String subject, String skill) {

		this.name = name;
		this.address = address;
		this.grade = grade;
		this.subject = subject;
		this.skill = skill;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student ("+id +", "+ name+", "+ address+ ", "+ grade+", "+ subject +", "+ skill +")";
	}


	
}
