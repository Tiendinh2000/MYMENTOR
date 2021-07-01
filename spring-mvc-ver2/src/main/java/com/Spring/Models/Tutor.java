package com.Spring.Models;

public class Tutor {

	private int id;
	private String name;
	private String credential;
	private String address;
	private int experienceYear;
    private String subject;

	public Tutor() {
	}

	public Tutor(int id) {
		this.id = id;
	}

	public Tutor(int id, String name, String address, String credential, int experienceYear) {
		this.id = id;
		this.credential = credential;
		this.name = name;
		this.address = address;
		this.experienceYear = experienceYear;
		this.subject=subject;
		
	}

	public Tutor(String name, String address, String credential, int experienceYear,String subject) {
		this.credential = credential;
		this.name = name;
		this.address = address;
		this.experienceYear = experienceYear;
		this.subject= subject;
		
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
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}



	@Override
	public String toString() {
		return "Tutor [id=" + id + ", name=" + name + ", credential=" + credential + ", address=" + address
				+ ", experienceYear=" + experienceYear + " , subject="+subject +"]";
	}

}
