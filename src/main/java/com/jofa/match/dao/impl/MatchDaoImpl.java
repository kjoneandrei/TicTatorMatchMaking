package com.jofa.match.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;
import com.jofa.match.dao.MatchDao;

import com.jofa.match.exception.MatchNotSavedException;

@Repository("matchDao")
public class MatchDaoImpl implements MatchDao<Match, String> {

	private Session currentSession;
    private Transaction currentTransaction;
    
    public MatchDaoImpl() {
    }

    public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	private static SessionFactory getSessionFactory() {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
		    configure().build();
		SessionFactory sessionFactory = new Configuration().buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}
	
	@Override
	public void persist(Match entity) throws MatchNotSavedException {
		currentSession.persist(entity);
	}
	
	@Override
	public void saveOrUpdate(Match entity){
		currentSession.saveOrUpdate(entity);
	}


	@Override
	public void update(Match entity) {
		currentSession.update(entity);
		
	}

	@Override
	public Match findById(Integer id) {
		return (Match)currentSession.get(Match.class, id);
	}

	@Override
	public void delete(Match entity) {
		currentSession.delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Match> findAll() {
		return currentSession.createCriteria(Match.class).list();
	}

	@Override
	public void deleteAll() {
		// TODO IMPLEMENT
		
	}

	@Override
	public void save(Match entity) {
		currentSession.save(entity);		
	}


}
