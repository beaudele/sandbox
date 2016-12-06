package com.sandbox.springmvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDao {

	@PersistenceContext
	private EntityManager manager;

	protected EntityManager getEntityManager() {
		return manager;
	}

	public void persist(Object entity) {
		getEntityManager().persist(entity);
	}

	public void delete(Object entity) {
		getEntityManager().remove(entity);
	}

	public void update(Object entity) {
		getEntityManager().merge(entity);
	}
}