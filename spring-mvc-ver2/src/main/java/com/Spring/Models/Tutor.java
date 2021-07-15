package com.Spring.Models;

public class Tutor {

	private int id;
	private String name;
	private String gender;
	private String phonenumber;
	private String credential;
	private String address;
	private int experienceYear;
private String subjects;
private String description;
	public Tutor() {
	}

	public Tutor(int id) {
		this.id = id;
	}

	public Tutor(int id, String name, String gender, String phonenumber, String address, String credential, int experienceYear,String subjects,String description) {
		this.id = id;
		this.credential = credential;
		this.gender=gender;
		this.phonenumber=phonenumber;
		this.name = name;
		this.address = address;
		this.experienceYear = experienceYear;
		this.subjects=subjects;
		this.description=description;
	}

	public Tutor(String name,String gender, String phonenumber, String address, String credential, int experienceYear,String subjects,String description) {
		this.credential = credential;
		this.gender=gender;
		this.phonenumber=phonenumber;
		this.name = name;
		this.address = address;
		this.experienceYear = experienceYear;
		this.subjects=subjects;
this.description= description;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getExperienceYear() {
		return experienceYear;
	}

	public void setExperienceYear(int experienceYear) {
		this.experienceYear = experienceYear;
	}

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}
	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	
	
	
	
	public String getSubjects() {
		return subjects;
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Tutor [id=" + id + ", name= " + name + ", gender="+gender+", phonenumber= "+phonenumber+", credential="  + credential + ", address=" + address
				+ ", experienceYear=" + experienceYear + ",des= " + description+ ", subject =" +subjects+"]";
	}

}
