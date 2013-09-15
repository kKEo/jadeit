package org.maziarz.jadeit.dao;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.maziarz.jadeit.model.Sprint;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
@ContextConfiguration(locations = {"classpath:/spring/applicationContextEntityManager.xml"})
public class SprintDaoTest extends AbstractJUnit4SpringContextTests{

	@Resource
	SprintDao dao;
	
	@Test
	public void testTicketDao()  {
		
		Sprint sprint = dao.load(1L);
		
		Assert.assertEquals("Sprint 1", sprint.getName());
		
		Sprint s = new Sprint();
		s.setId(4L);
		s.setName("Sprint 4");
		
		dao.save(s);
	}
	
}
