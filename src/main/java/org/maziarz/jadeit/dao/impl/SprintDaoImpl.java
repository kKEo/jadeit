package org.maziarz.jadeit.dao.impl;

import org.maziarz.jadeit.dao.SprintDao;
import org.maziarz.jadeit.model.Sprint;
import org.springframework.stereotype.Repository;

@Repository
public class SprintDaoImpl extends BaseDaoImpl<Sprint> implements SprintDao {

	@Override
	protected Class<Sprint> getBaseClass() {
		return Sprint.class;
	}

}
