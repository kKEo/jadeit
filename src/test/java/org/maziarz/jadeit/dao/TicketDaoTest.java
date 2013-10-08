package org.maziarz.jadeit.dao;

import java.util.Date;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.maziarz.jadeit.model.Requirement;
import org.maziarz.jadeit.model.Ticket;
import org.maziarz.jadeit.model.Ticket.Priority;
import org.maziarz.jadeit.model.TicketRequirementRelation;

public class TicketDaoTest extends BaseDaoTest {

	@Resource
	TicketDao dao;

	@Resource
	RequirementDao rdao;

	@Test
	public void testTicketDao() {
		Ticket t = new Ticket("title1", "desc", Priority.HIGH);
		dao.save(t);
		long id = t.getId();

		Ticket t2 = dao.load(id);

		Assert.assertEquals("title1", t2.getName());

		Requirement r = new Requirement();
		r.setName("Req1");
		rdao.save(r);

		
		TicketRequirementRelation trr = new TicketRequirementRelation();
		trr.setTicket(t2);
		trr.setRequirement(r);
		trr.setCreatedDate(new Date());
		
		t2.getRequirements().add(trr);
		
		
		dao.save(t2);
		
		em.flush();
		em.clear();
		
		Ticket loadedTicket = dao.load(id);
		
		Assert.assertTrue(t2 != loadedTicket);
		Assert.assertEquals(t2, loadedTicket);

		TicketRequirementRelation req = loadedTicket.getRequirements().iterator().next();
		Assert.assertNull(req.getRequirement().getDescription());
		req.getRequirement().setDescription("Desc");
		
		rdao.save(req.getRequirement());
		
		em.flush();
		em.clear();
		
		Requirement loadedRequirement = rdao.load(id);
		Assert.assertEquals("Req1", loadedRequirement.getName());
		Assert.assertEquals("Desc", loadedRequirement.getDescription());
		
		
	}
}
