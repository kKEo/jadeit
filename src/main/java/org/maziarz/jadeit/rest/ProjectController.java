package org.maziarz.jadeit.rest;

import java.text.DateFormat;
import java.text.ParseException;

import org.maziarz.jadeit.dao.ProjectDao;
import org.maziarz.jadeit.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("rest")
public class ProjectController {

	@Autowired
	ProjectDao dao;

	@RequestMapping("project/{id}")
	@ResponseBody
	public Project getProjectById(@PathVariable Long id) {
		final Project project = new Project();
		project.setName("AA_" + id);
		project.setDescription("Desc");
		return project;
	}
}
