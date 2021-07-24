package com.Spring.Service;

import java.util.List;

import com.Spring.Models.*;


public interface HomeService {
	List<Tutor> findAll();
  void insert(Tutor t);
  void delete(int id);
  void update(Tutor newTutor );
  Tutor findByID(int id);
  boolean registrySubject(int tutorId, int subjectId);
}
