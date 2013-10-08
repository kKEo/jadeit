package org.maziarz.jadeit.dao;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.maziarz.jadeit.model.Project;

public class ProjectDaoTest extends BaseDaoTest {

	@Resource
	ProjectDao dao;

	@Test
	public void testProjectDao() {

		Project l = dao.load(1L);
		
		Assert.assertEquals("project1", l.getName());
		
		
		
		Project s = new Project();
		s.setName("Project 1");

		dao.save(s);
		
		em.flush();
		em.clear();
		
	}

}
