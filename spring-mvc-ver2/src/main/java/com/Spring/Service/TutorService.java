package com.Spring.Service;

import java.util.List;

import com.Spring.model.*;


public interface TutorService {
	List<Tutor> findAll();
  void insert(Tutor t);
  void delete(int id);
  void update(Tutor newTutor );
  Tutor findByID(int id);
  boolean registrySubject(int tutorId, int subjectId);
}
