package org.maziarz.jadeit.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TicketRequirementRelationPK implements Serializable{

	private static final long serialVersionUID = 1L;

	private long ticket;
	
	private long requirement;
	
	public TicketRequirementRelationPK(long ticketId, long reqId) {
		this.ticket = ticketId;
		this.requirement = reqId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (requirement ^ (requirement >>> 32));
		result = prime * result + (int) (ticket ^ (ticket >>> 32));
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
		TicketRequirementRelationPK other = (TicketRequirementRelationPK) obj;
		if (requirement != other.requirement)
			return false;
		if (ticket != other.ticket)
			return false;
		return true;
	}
	
}
