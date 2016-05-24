package com.jofa.match.service;

import java.util.List;

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;
import com.jofa.match.dao.impl.MatchDaoImpl;

public class MatchService {

	private static MatchDaoImpl matchDaoImpl;

	
	public MatchService() {
		matchDaoImpl = new MatchDaoImpl();
	}

	public void persist(Match entity) {
		matchDaoImpl.openCurrentSessionwithTransaction();
		matchDaoImpl.persist(entity);
		matchDaoImpl.closeCurrentSessionwithTransaction();
	}
	
	public void save(Match entity) {
		matchDaoImpl.openCurrentSessionwithTransaction();
		matchDaoImpl.save(entity);
		matchDaoImpl.closeCurrentSessionwithTransaction();
	}

	public void update(Match entity) {
		matchDaoImpl.openCurrentSessionwithTransaction();
		matchDaoImpl.update(entity);
		matchDaoImpl.closeCurrentSessionwithTransaction();
	}

	public Match findById(Integer id) {
		matchDaoImpl.openCurrentSession();
		Match book = matchDaoImpl.findById(id);
		matchDaoImpl.closeCurrentSession();
		return book;
	}

	public void delete(int id) {
		matchDaoImpl.openCurrentSessionwithTransaction();
		Match book = matchDaoImpl.findById(id);
		matchDaoImpl.delete(book);
		matchDaoImpl.closeCurrentSessionwithTransaction();
	}

	public List<Match> findAll() {
		matchDaoImpl.openCurrentSession();
		List<Match> books = matchDaoImpl.findAll();
		matchDaoImpl.closeCurrentSession();
		return books;
	}

	public void deleteAll() {
		matchDaoImpl.openCurrentSessionwithTransaction();
		matchDaoImpl.deleteAll();
		matchDaoImpl.closeCurrentSessionwithTransaction();
	}

	public MatchDaoImpl matchDao() {
		return matchDaoImpl;
	}

	public void SaveOrUpdate(Match match) {
		// TODO Auto-generated method stub

		matchDaoImpl.openCurrentSessionwithTransaction();
		matchDaoImpl.saveOrUpdate(match);
		matchDaoImpl.closeCurrentSessionwithTransaction();
	}
}