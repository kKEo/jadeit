package org.maziarz.jadeit.model;

import org.junit.Assert;
import org.junit.Test;
import org.maziarz.jadeit.model.Ticket;
import org.maziarz.jadeit.model.Ticket.Priority;
import org.maziarz.jadeit.model.Ticket.Status;

public class TicketTests {

	@Test
	public void simpleTicket() {
		Ticket t = new Ticket("Test title", "Test description", Priority.NORMAL);

		Assert.assertEquals("Test title", t.getName());
		Assert.assertEquals("Test description", t.getDescription());
		Assert.assertEquals(Priority.NORMAL, t.getPriority());
		Assert.assertEquals(Status.NEW, t.getStatus());
	}

}
