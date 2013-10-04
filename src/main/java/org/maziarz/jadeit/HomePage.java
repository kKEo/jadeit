package org.maziarz.jadeit;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.maziarz.jadeit.dao.TicketDao;
import org.maziarz.jadeit.model.Ticket;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	@SpringBean
	TicketDao ticketDao;

	public HomePage(final PageParameters parameters) {
		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

		Ticket ticket = new Ticket("test", "test desc", Ticket.Priority.NORMAL);
		ticketDao.save(ticket);

		String title = "Undefined";
		title = ticketDao.loadByTitle("test").getName();

		add(new Label("ticket", title));

	}
}
