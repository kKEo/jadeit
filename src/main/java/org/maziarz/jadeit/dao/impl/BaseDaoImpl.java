package org.maziarz.jadeit.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.maziarz.jadeit.dao.BaseDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * Abstract implementation of basic operation available for each DOA object
 *
 * @param <T>
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	protected EntityManager em;
	
	public EntityManager getEntityManager() {
		return em;
	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	@PersistenceUnit
	protected EntityManagerFactory emf;
	
	@Transactional
	public void save(T t) {
		em.persist(t);
	}
	
	@Transactional
	public void delete(T t) {
		em.remove(t);
	}
	
	@Transactional
	public void update(T t) {
		em.merge(t);
	}

	abstract protected  Class<T> getBaseClass(); 
	
	@Transactional(readOnly = true)
	@Override
	public long count() {
		CriteriaBuilder builder = emf.getCriteriaBuilder();
		CriteriaQuery<Long> criteria =  builder.createQuery(Long.class);
		criteria.select(builder.count(criteria.from(getBaseClass())));
		return em.createQuery(criteria).getSingleResult();
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<T> list(int offset, int limit) {
		CriteriaBuilder builder = emf.getCriteriaBuilder();
		CriteriaQuery<T> criteria =  builder.createQuery(getBaseClass());
		
		List<T> resultList = em.createQuery(criteria).setFirstResult(offset).setMaxResults(limit).getResultList();
		return resultList;
	}

	@Transactional(readOnly = true)
	@Override
	public T load(Long id) {
		return (T) em.find(getBaseClass(), id);
	}


}
