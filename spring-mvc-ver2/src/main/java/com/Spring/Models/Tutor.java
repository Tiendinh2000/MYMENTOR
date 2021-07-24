package com.Spring.Models;

public class Tutor {

	private int id;
	private String tutorName;
	private String gender;
	private String phonenumber;
	private String credential;
	private String address;
	private int experienceYear;
    private String description;
    private int Account_id;
	public Tutor() {
	}

	public Tutor(int id) {
		this.id = id;
	}

	public Tutor(int id, String tutorName, String gender, String phonenumber, String address, String credential, int experienceYear,String description,int AccountId) {
		this.id = id;
		this.credential = credential;
		this.gender=gender;
		this.phonenumber=phonenumber;
		this.tutorName = tutorName;
		this.address = address;
		this.experienceYear = experienceYear;

		this.description=description;
		this.Account_id=AccountId;
	}

	public Tutor(String tutorName,String gender, String phonenumber, String address, String credential, int experienceYear,String description,int AccountId) {
		this.credential = credential;
		this.gender=gender;
		this.phonenumber=phonenumber;
		this.tutorName = tutorName;
		this.address = address;
		this.experienceYear = experienceYear;
        this.description= description;
    	this.Account_id=AccountId;
	}


	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
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


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
	public int getAccount_id() {
		return Account_id;
	}

	public void setAccount_id(int account_id) {
		Account_id = account_id;
	}

	@Override
	public String toString() {
		return "Tutor [id=" + id + ", name= " + tutorName + ", gender="+gender+", phonenumber= "+phonenumber+", credential="  + credential + ", address=" + address
				+ ", experienceYear=" + experienceYear + ",des= " + description+ "]";
	}

}
