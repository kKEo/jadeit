package org.maziarz.jadeit.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Requirement extends BaseObject {

//	private List<RequirementRequirementRelation> requiredBy;
	
	@ManyToMany
	private List<Ticket> ticket; 
	
		
}
