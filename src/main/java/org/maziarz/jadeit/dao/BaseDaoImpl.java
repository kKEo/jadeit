package org.maziarz.jadeit.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * Abstract implementation of basic operation available for each DOA object
 * 
 * @author kkeo
 *
 * @param <T>
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	@Resource
	SessionFactory sessionFactory;
	
	@Transactional
	public void save(T t) {
		sessionFactory.getCurrentSession().save(t);
	}
	
	@Transactional
	public void delete(T t) {
		sessionFactory.getCurrentSession().delete(t);
	}
	
	@Transactional
	public void update(T t) {
		sessionFactory.getCurrentSession().merge(t);
	}

	abstract protected  Class<?> getBaseClass(); 
	
	@Transactional(readOnly = true)
	@Override
	public int count() {
		return (Integer) sessionFactory.getCurrentSession() //
				.createCriteria(getBaseClass()) //
				.setProjection(Projections.rowCount()) //
				.uniqueResult();
	}
	
	@SuppressWarnings("unchecked") /* as list() method */
	@Transactional(readOnly = true)
	@Override
	public List<T> list(int offset, int limit) {
		return (List<T>) sessionFactory.getCurrentSession() //
				.createCriteria(getBaseClass())  // fetch criteria object
				.setFirstResult(offset) // set offset
				.setMaxResults(limit) // apply limit
				.list();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public T load(Long id) {
		return (T) sessionFactory.getCurrentSession()
				.createCriteria(getBaseClass()) // fetch criteria object
				.add(Restrictions.eq("id", id)) // 
				.uniqueResult();
	}


}
