package org.maziarz.jadeit.dao;

import org.hibernate.criterion.Restrictions;
import org.maziarz.jadeit.model.Ticket;
import org.springframework.transaction.annotation.Transactional;

public class TicketDaoImpl extends BaseDaoImpl<Ticket> implements TicketDao{

	@Transactional(readOnly = true)
	@Override
	public Ticket loadByTitle(String title) {
		return (Ticket) sessionFactory.getCurrentSession().createCriteria(Ticket.class).add(Restrictions.eq("title", title)).uniqueResult();
	}

	@Override
	protected Class<?> getBaseClass() {
		return Ticket.class;
	}
	
}
