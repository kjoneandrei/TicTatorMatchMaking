package com.jofa.elo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

import com.jofa.elo.dao.EloDao;
import com.jofa.elo.exception.EloNotSavedException;
import com.jofa.elo.model.Elo;

@Repository("eloDao")
public class EloDaoImpl implements EloDao<Elo, String> {

	private Session currentSession;
    private Transaction currentTransaction;
    
    public EloDaoImpl() {
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
	public void persist(Elo entity) throws EloNotSavedException {
		currentSession.persist(entity);
	}
	
	@Override
	public void saveOrUpdate(Elo entity){
		currentSession.saveOrUpdate(entity);
	}


	@Override
	public void update(Elo entity) {
		currentSession.update(entity);
		
	}

	@Override
	public Elo findByUserName(String username) {
		return (Elo)currentSession.get(Elo.class, username);
	}

	@Override
	public void delete(Elo entity) {
		currentSession.delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Elo> findAll() {
		return currentSession.createCriteria(Elo.class).list();
	}

	@Override
	public void deleteAll() {
		// TODO IMPLEMENT
		
	}

	@Override
	public void save(Elo entity) {
		currentSession.save(entity);		
	}
	
}
