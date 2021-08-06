package com.Spring.DTO;

import com.Spring.model.Student;
import com.Spring.model.Subject;

public class StudentWithSubject {
private Student student;
private Subject subject;





public StudentWithSubject() {
	super();
}
public StudentWithSubject(Student student, Subject subject) {
	super();
	this.student = student;
	this.subject = subject;
}
public Student getStudent() {
	return student;
}
public void setStudent(Student student) {
	this.student = student;
}
public Subject getSubject() {
	return subject;
}
public void setSubject(Subject subject) {
	this.subject = subject;
}

@Override
public String toString() {
	return "StudentWithSubject [student=" + student + ", subject=" + subject + "]";
}




}
