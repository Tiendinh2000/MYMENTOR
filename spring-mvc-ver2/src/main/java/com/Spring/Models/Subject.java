package com.Spring.Models;

public class Subject {
private int id;
private String name;


public Subject() {
}
public Subject(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}

public Subject(String name) {
	this.name = name;
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

@Override
	public String toString() {
	
	return "id "+id + ": "+ name;
	}

}