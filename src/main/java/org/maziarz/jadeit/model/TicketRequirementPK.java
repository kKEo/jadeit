package org.maziarz.jadeit.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class TicketRequirementPK implements Serializable{

	private static final long serialVersionUID = 1L;

	private Ticket ticket;
	private Requirement requirement;
	
	public TicketRequirementPK() {
	}

	@ManyToOne
	public Ticket getTicket() {
		return ticket;
	}
	
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	@ManyToOne
	public Requirement getRequirement() {
		return requirement;
	}
	
	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((requirement == null) ? 0 : requirement.hashCode());
		result = prime * result + ((ticket == null) ? 0 : ticket.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketRequirementPK other = (TicketRequirementPK) obj;
		
		if (requirement == null) {
			if (other.requirement != null)
				return false;
		} else if (!requirement.equals(other.requirement))
			return false;
		if (ticket == null) {
			if (other.ticket != null)
				return false;
		} else if (!ticket.equals(other.ticket))
			return false;
		return true;
	}
	
}
