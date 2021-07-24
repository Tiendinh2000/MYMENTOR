package com.Spring.Models;

public class TutorWithSubject {
private Tutor tutor;
private Subject subject;
public TutorWithSubject(Tutor tutor, Subject subject) {
	super();
	this.tutor = tutor;
	this.subject = subject;
}


public TutorWithSubject() {
	super();
}


public Tutor getTutor() {
	return tutor;
}
public void setTutor(Tutor tutor) {
	this.tutor = tutor;
}
public Subject getSubject() {
	return subject;
}
public void setSubject(Subject subject) {
	this.subject = subject;
}


@Override
public String toString() {
	return "TutorWithSubject [tutor=" + tutor + "\n"+", subject=" + subject + "]";
}


}
