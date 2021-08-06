package com.Spring.model;

public class Tutor {

	private int id;
	private String tutorName;
	private String gender;
	private String phonenumber;
	private String credential;
	private String address;
	private int experienceYear;
	private String image;
    private String description;
    private int fk_Account;
	public Tutor() {
	}

	public Tutor(int id) {
		this.id = id;
	}

	public Tutor(int id, String tutorName, String gender, String phonenumber, String address, String credential, int experienceYear,String image,String description,int Account) {
		this.id = id;
		this.credential = credential;
		this.gender=gender;
		this.phonenumber=phonenumber;
		this.tutorName = tutorName;
		this.address = address;
		this.experienceYear = experienceYear;
		this.image = image;
		this.description=description;
		this.fk_Account=Account;
	}

	public Tutor(String tutorName,String gender, String phonenumber, String address, String credential, int experienceYear,String image,String description,int Account) {
		this.credential = credential;
		this.gender=gender;
		this.phonenumber=phonenumber;
		this.tutorName = tutorName;
		this.address = address;
		this.experienceYear = experienceYear;
		this.image = image;
        this.description= description;
    	this.fk_Account=Account;
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

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFk_Account() {
		return fk_Account;
	}

	public void setFk_Account(int fk_Account) {
		this.fk_Account = fk_Account;
	}
	
	

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Tutor [id=" + id + ", name= " + tutorName + ", gender="+gender+", phonenumber= "+phonenumber+", credential="  + credential + ", address=" + address
				+ ", experienceYear=" + experienceYear +",image="+image + ",des= " + description+ ", fk ="+fk_Account+ "]";
	}


}
