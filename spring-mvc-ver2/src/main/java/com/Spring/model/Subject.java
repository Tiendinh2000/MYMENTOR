package com.Spring.model;

public class Subject {
private int id;
private String subjectName;


public Subject() {
}
public Subject(int id, String subjectName) {
	super();
	this.id = id;
	this.subjectName = subjectName;
}

public Subject(String subjectName) {
	this.subjectName = subjectName;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}


public String getSubjectName() {
	return subjectName;
}
public void setSubjectName(String subjectName) {
	this.subjectName = subjectName;
}
@Override
	public String toString() {
	
	return "id "+id + ": "+ subjectName;
	}

}
