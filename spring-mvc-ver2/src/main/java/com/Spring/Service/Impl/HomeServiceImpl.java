package com.Spring.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.DAO.ITutorDAO;
import com.Spring.DAO.impl.TutorListDAO;
import com.Spring.Models.Tutor;
import com.Spring.Models.UserAccount;
import com.Spring.Service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private TutorListDAO dao;

	@Override
	public List<Tutor> findAll() {
		return dao.findAll();
	}

	@Override
	public void insert(Tutor t) {
		dao.insert(t);

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public void update(Tutor newTutor) {
		// TODO Auto-generated method stub
		dao.update(newTutor);
	}

	@Override
	public Tutor findByID(int id) {
		List l = dao.findById(id);
		if (l.size() == 1)
			return (Tutor) l.get(0);
		else
			return null;
	}

	@Override
	public boolean registrySubject(int tutorId, int subjectId) {
		return dao.registrySubject(tutorId, subjectId);
	}

	public boolean registryAsTutor(Tutor t, String SubjectsName) {
		List ids = new ArrayList<Integer>();

		for (char c : SubjectsName.toCharArray()) {
			if (c == 'M')
				ids.add(1);
			if (c == 'E')
				ids.add(2);
			if (c == 'L')
				ids.add(3);
		}
		int[] array = new int[ids.size()];
		int index = 0;
		for (Object i : ids) {
			array[index] = (int) i;
			index++;
		}

		
		dao.registryAsTutor(t, array);
		return true;
	}

}