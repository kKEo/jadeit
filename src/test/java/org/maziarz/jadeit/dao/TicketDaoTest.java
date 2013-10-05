package org.maziarz.jadeit.dao;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.maziarz.jadeit.model.Requirement;
import org.maziarz.jadeit.model.Ticket;
import org.maziarz.jadeit.model.Ticket.Priority;

public class TicketDaoTest extends BaseDaoTest {

	@Resource
<<<<<<< Updated upstream
	TicketDao dao;

	@Resource
	RequirementDao rdao;
=======
	TicketDao ticketDao;

	@Resource
	RequirementDao resourceDao;
>>>>>>> Stashed changes

	@Test
	public void testTicketDao() {
		Ticket t = new Ticket("title1", "desc", Priority.HIGH);
		ticketDao.save(t);
		long id = t.getId();

<<<<<<< Updated upstream

		Ticket t2 = dao.load(id);
=======
		Ticket t2 = ticketDao.load(id);
>>>>>>> Stashed changes

		Assert.assertEquals("title1", t2.getName());

		Requirement r = new Requirement();
		r.setName("Req1");

<<<<<<< Updated upstream
		rdao.save(r);

		r.setDescrition("Desc");

		rdao.save(r);
		resourceDao.save(r);

		r.setDescrition("Desc");

=======
		resourceDao.save(r);

		r.setDescrition("Desc");

>>>>>>> Stashed changes
		resourceDao.save(r);

		System.out.println(r.getId());

	}
}
