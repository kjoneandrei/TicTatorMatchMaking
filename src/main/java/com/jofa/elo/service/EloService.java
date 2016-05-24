package com.jofa.elo.service;

import java.util.List;

import com.jofa.elo.dao.impl.EloDaoImpl;
import com.jofa.elo.model.Elo;

public class EloService {

	private static EloDaoImpl eloDaoImpl;

	public EloService() {
		eloDaoImpl = new EloDaoImpl();
	}

	public void persist(Elo entity) {
		eloDaoImpl.openCurrentSessionwithTransaction();
		eloDaoImpl.persist(entity);
		eloDaoImpl.closeCurrentSessionwithTransaction();
	}
	
	public void save(Elo entity) {
		eloDaoImpl.openCurrentSessionwithTransaction();
		eloDaoImpl.save(entity);
		eloDaoImpl.closeCurrentSessionwithTransaction();
	}

	public void update(Elo entity) {
		eloDaoImpl.openCurrentSessionwithTransaction();
		eloDaoImpl.update(entity);
		eloDaoImpl.closeCurrentSessionwithTransaction();
	}

	public Elo findById(String username) {
		eloDaoImpl.openCurrentSession();
		Elo book = eloDaoImpl.findByUserName(username);
		eloDaoImpl.closeCurrentSession();
		return book;
	}

	public void delete(String username) {
		eloDaoImpl.openCurrentSessionwithTransaction();
		Elo book = eloDaoImpl.findByUserName(username);
		eloDaoImpl.delete(book);
		eloDaoImpl.closeCurrentSessionwithTransaction();
	}

	public List<Elo> findAll() {
		eloDaoImpl.openCurrentSession();
		List<Elo> books = eloDaoImpl.findAll();
		eloDaoImpl.closeCurrentSession();
		return books;
	}

	public void deleteAll() {
		eloDaoImpl.openCurrentSessionwithTransaction();
		eloDaoImpl.deleteAll();
		eloDaoImpl.closeCurrentSessionwithTransaction();
	}

	public EloDaoImpl eloDao() {
		return eloDaoImpl;
	}

	public void SaveOrUpdate(Elo user) {
		// TODO Auto-generated method stub

		eloDaoImpl.openCurrentSessionwithTransaction();
		eloDaoImpl.saveOrUpdate(user);
		eloDaoImpl.closeCurrentSessionwithTransaction();
	}	
}