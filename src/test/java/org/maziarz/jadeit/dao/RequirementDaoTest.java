package org.maziarz.jadeit.dao;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.maziarz.jadeit.model.Requirement;
import org.maziarz.jadeit.model.RequirementRequirementRelation.RelationType;

public class RequirementDaoTest extends BaseDaoTest {

	@Resource
	RequirementDao rdao;

	@Test
	public void testRequirementDao() {
		
		Requirement r1 = new Requirement();
		r1.setName("req1");
		r1.setDescription("reqDesc1");
		rdao.save(r1);
		em.flush();
		em.clear();
		
		r1 = rdao.load(1L);

		Requirement r2 = new Requirement();
		r2.setName("req1");
		r2.setDescription("reqDesc1");
		
		/* r2 blocks r1  */
		r2.addRelation(RelationType.BLOCKS, r1);
		
		rdao.save(r2);

		Assert.assertEquals(new Long(1), r1.getId());
		Assert.assertEquals(new Long(2), r2.getId());
		
		em.flush();
		em.clear();
		
		Requirement loadedRequirement = rdao.load(1L);
		
		/* There is one relation where loaded requirement is a subject */
		Assert.assertEquals(1, loadedRequirement.getRelated().size());
		
		/* There is no relations where loaded requirement is an object */
		Assert.assertEquals(0, loadedRequirement.getRelatedBy().size());
		
	}
}
