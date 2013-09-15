package org.maziarz.jadeit.dao;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.maziarz.jadeit.model.Requirement;
import org.maziarz.jadeit.model.Ticket;
import org.maziarz.jadeit.model.Ticket.Priority;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(locations = {"classpath:/spring/applicationContextEntityManager.xml"})
public class TicketDaoTest extends AbstractTransactionalJUnit4SpringContextTests{

	@Resource
	TicketDao dao;
	
	@Resource
	RequirementDao rdao;
	
	@Test
	public void testTicketDao()  {
		Ticket t = new Ticket("title1", "desc", Priority.HIGH);
		dao.save(t);
		long id = t.getId();
		
		Ticket t2 = dao.load(id);
		
		Assert.assertEquals("title1", t2.getTitle());
		
		Requirement r = new Requirement();
		r.setName("Req1");
		
		rdao.save(r);
		
		r.setDescrition("Desc");
		
		rdao.save(r);
		
		System.out.println(r.getId());
		
	}
	
}
