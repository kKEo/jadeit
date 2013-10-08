package org.maziarz.jadeit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "TicReqRel")
@AssociationOverrides({
  @AssociationOverride(name="pk.ticket,", joinColumns = @JoinColumn(name = "ticketId")),	
  @AssociationOverride(name="pk.category,", joinColumns = @JoinColumn(name = "categoryId"))
})
public class TicketRequirementRelation implements Serializable {

	private static final long serialVersionUID = 1L;

	TicketRequirementPK pk = new TicketRequirementPK();

	@EmbeddedId
	public TicketRequirementPK getPk() {
		return pk;
	}

	public void setPk(TicketRequirementPK pk) {
		this.pk = pk;
	}

	@Transient
	public Ticket getTicket() {
		return getPk().getTicket();
	}

	public void setTicket(Ticket t) {
		getPk().setTicket(t);
	}
	
	@Transient
	public Requirement getRequirement(){
		return getPk().getRequirement();
	}
	
	public void setRequirement(Requirement r){
		getPk().setRequirement(r);
	}
	
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean equals(Object o) {

		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		TicketRequirementRelation that = (TicketRequirementRelation) o;

		if (getPk() != null && !getPk().equals(that.getPk())) {
			return false;
		} else if (getPk() != null) {
			return false;
		}
		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
}
