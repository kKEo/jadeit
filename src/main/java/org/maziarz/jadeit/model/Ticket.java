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

	private Priority priority;

	private Status status;
	
	private Collection<Requirement> requirements;

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

	@Enumerated(EnumType.ORDINAL)
	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	@Enumerated(EnumType.STRING)
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setRequirements(Collection<Requirement> r) {
		this.requirements = r;
	}
	
	@ManyToMany
	public Collection<Requirement> getRequirements() {
		return requirements;
	}
	
	
}
