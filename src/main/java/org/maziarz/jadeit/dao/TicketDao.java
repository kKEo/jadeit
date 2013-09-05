package org.maziarz.jadeit.dao;

import org.maziarz.jadeit.model.Ticket;

public interface TicketDao extends BaseDao<Ticket>{
	Ticket loadByTitle(String title);
}
