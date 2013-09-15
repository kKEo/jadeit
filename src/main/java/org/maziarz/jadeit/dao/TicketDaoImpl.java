package org.maziarz.jadeit.dao;

import org.maziarz.jadeit.model.Ticket;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value="ticketDao")
public class TicketDaoImpl extends BaseDaoImpl<Ticket> implements TicketDao{

	@Transactional(readOnly = true)
	@Override
	public Ticket loadByTitle(String title) {
		
		throw new RuntimeException("Not implemented");
		
		//return (Ticket) sessionFactory.getCurrentSession().createCriteria(Ticket.class).add(Restrictions.eq("title", title)).uniqueResult();
	}

	@Override
	protected Class<Ticket> getBaseClass() {
		return Ticket.class;
	}
	
}
