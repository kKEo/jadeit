package org.maziarz.jadeit.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
@ContextConfiguration(locations = { "classpath:/spring/applicationContextEntityManager.xml" })
public class BaseDaoTest extends AbstractJUnit4SpringContextTests {

	
	@PersistenceContext
	protected EntityManager em;
	
}
