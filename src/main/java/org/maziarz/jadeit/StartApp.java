package org.maziarz.jadeit;

import org.maziarz.jadeit.dao.SprintDao;
import org.maziarz.jadeit.model.Sprint;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring/applicationContextEntityManager.xml");
		SprintDao sd = (SprintDao)context.getBean("sprintDao");
		
		Sprint s = new Sprint();
		s.setId(2L);
		s.setName("Sprint 2");
		sd.save(s);
	}
}
