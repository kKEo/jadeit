package org.maziarz.jadeit.rest;

import org.maziarz.jadeit.dao.ProjectDao;
import org.maziarz.jadeit.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class DefaultController {

	@Autowired
	ProjectDao dao;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Project getProjectById(@PathVariable Long id) {
		final Project project = new Project();
		project.setName("BB_" + id);
		project.setDescription("Desc");
		return project;
	}
}
