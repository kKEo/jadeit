package org.maziarz.jadeit.dao;

import org.maziarz.jadeit.model.Sprint;
import org.springframework.stereotype.Repository;

@Repository(value="sprintDao")
public class SprintDaoImpl extends BaseDaoImpl<Sprint> implements SprintDao{

	@Override
	protected Class<Sprint> getBaseClass() {
		return Sprint.class;
	}

}
