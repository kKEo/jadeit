package org.maziarz.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.internal.FormatStyle;
import org.maziarz.jadeit.model.Requirement;
import org.maziarz.jadeit.model.Ticket;

public class GenrateDDLs {

	public static void main(String[] args) {
		new GenrateDDLs().printDdl(Ticket.class, Requirement.class);
	}

	public  void printDdl(Class<?> ... classes) {
		Configuration configuration = new Configuration();
		configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

		for (Class<?> c : classes ) {
			configuration.addAnnotatedClass(c);
		}
//		configuration.addAnnotatedClass(TicketRequirementRelation.class);

		final Dialect dialect = Dialect.getDialect(configuration.getProperties());

		String[] stmts = configuration.generateSchemaCreationScript(dialect);

		for (String s : stmts) {
			if (s.startsWith("create")) {
				System.out.println(FormatStyle.DDL.getFormatter().format(s) + ";");
			}
		}
	}
}
