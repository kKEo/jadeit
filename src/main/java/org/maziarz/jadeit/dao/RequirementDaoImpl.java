package org.maziarz.jadeit.dao;

import org.maziarz.jadeit.model.Requirement;

public class RequirementDaoImpl extends BaseDaoImpl<Requirement> implements RequirementDao {

	@Override
	protected Class<?> getBaseClass() {
		return Requirement.class;
	}

}
