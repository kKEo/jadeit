package org.maziarz.jadeit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TicReqRel")
@IdClass(TicketRequirementRelationPK.class)
public class TicketRequirementRelation implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	private Ticket ticket;
	
	@Id
	@ManyToOne
	private Requirement requirement;
	
	@Column
	private ERelationType relationType;
	
}
