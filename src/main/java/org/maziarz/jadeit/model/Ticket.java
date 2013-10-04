package org.maziarz.jadeit.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class Ticket extends BaseObject {

	@Enumerated(EnumType.ORDINAL)
	private Priority priority;

	@Enumerated(EnumType.STRING)
	private Status status;

	@ManyToMany(mappedBy = "ticket")
	private Collection<Requirement> requirement;

	// private Collection<TicketRequirementRelation> requirements = new ArrayList<TicketRequirementRelation>(4);

	public enum Priority {
		CRITICAL, HIGH, NORMAL, LOW
	}

	public enum Status {
		READY, INPROGRESS, NEW, SUSPENDED, CLOSED
	}

	private static Logger logger = LoggerFactory.getLogger(Ticket.class);

	public Ticket(String name, String description, Priority priority) {
		this.setName(name);
		this.setDescription(description);
		this.priority = priority;
		this.status = Status.NEW;
	}

	@SuppressWarnings("unused" /* for hbn's sake */)
	private Ticket() {

	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
