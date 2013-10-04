package org.maziarz.jadeit.dao.impl;

import org.maziarz.jadeit.dao.RequirementDao;
import org.maziarz.jadeit.model.Requirement;
import org.springframework.stereotype.Repository;

@Repository
public class RequirementDaoImpl extends BaseDaoImpl<Requirement> implements RequirementDao {

	@Override
	protected Class<Requirement> getBaseClass() {
		return Requirement.class;
	}

}
