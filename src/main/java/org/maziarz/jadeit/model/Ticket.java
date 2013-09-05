package org.maziarz.jadeit.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class Ticket {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	private String title;

	@Column(name = "description", length = 3000)
	private String description;

	@Enumerated(EnumType.ORDINAL)
	private Priority priority;

	@Enumerated(EnumType.STRING)
	private Status status;

	@ManyToMany(mappedBy="ticket")
//	@JoinTable(name = "TICREQ", //
//			joinColumns = { @JoinColumn(name = "TICKET_ID", referencedColumnName = "ID") },//
//			inverseJoinColumns = { @JoinColumn(name = "REQUIREMENT_ID", referencedColumnName = "ID") }//
//	)
	private Collection<Requirement> requirement;

	// private Collection<TicketRequirementRelation> requirements = new ArrayList<TicketRequirementRelation>(4);

	public enum Priority {
		CRITICAL, HIGH, NORMAL, LOW
	}

	public enum Status {
		READY, INPROGRESS, NEW, SUSPENDED, CLOSED
	}

	private static Logger logger;

	static {
		logger = LoggerFactory.getLogger(TicketTests.class);
	}

	public Ticket(String title, String description, Priority priority) {
		this.title = title;
		this.description = description;
		this.priority = priority;
		this.status = Status.NEW;

		logger.info("Hello world");
	}

	public Ticket() {
		// for hibernate
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Priority getPriority() {
		return priority;
	}

	public Status getStatus() {
		return status;
	}
}
