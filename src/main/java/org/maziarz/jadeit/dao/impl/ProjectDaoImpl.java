package org.maziarz.jadeit.dao.impl;

import org.maziarz.jadeit.dao.ProjectDao;
import org.maziarz.jadeit.model.Project;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDaoImpl extends BaseDaoImpl<Project> implements ProjectDao {

	@Override
	protected Class<Project> getBaseClass() {
		return Project.class;
	}

}
