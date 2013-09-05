package org.maziarz.jadeit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

@Entity
@Table(name = "ReqReqRel")
public class RequirementRequirementRelation implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	private Ticket task;
	
	@Id
	@OneToOne
	private Requirement req;
	
	@Column
	private ERelationType relationType;
	
}
