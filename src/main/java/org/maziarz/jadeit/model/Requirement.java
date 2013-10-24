package org.maziarz.jadeit.model;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.maziarz.jadeit.model.RequirementRequirementRelation.RelationType;

@Entity
public class Requirement extends BaseObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TicketRequirementRelation> tickets = new HashSet<TicketRequirementRelation>(); 
	
	@OneToMany(mappedBy = "pk.requirement")
	public Collection<TicketRequirementRelation> getTickets() {
		return tickets;
	}
	
	public void setTickets(Collection<TicketRequirementRelation> tickets) {
		this.tickets = tickets;
	}
		
	private Collection<RequirementRequirementRelation> subjectObjectRelations = new HashSet<RequirementRequirementRelation>();
	
	@OneToMany(mappedBy = "pk.object", cascade = CascadeType.ALL)
	Collection<RequirementRequirementRelation> getSubjectObjectRelations() {
		return subjectObjectRelations;
	}
	
	void setSubjectObjectRelations(Collection<RequirementRequirementRelation> subjects) {
		this.subjectObjectRelations = subjects;
	}

	private Collection<RequirementRequirementRelation> objectSubjectRelations = new HashSet<RequirementRequirementRelation>();

	@OneToMany(mappedBy = "pk.subject")
	Collection<RequirementRequirementRelation> getObjectSubjectRelations() {
		return objectSubjectRelations;
	}
	
	void setObjectSubjectRelations(Collection<RequirementRequirementRelation> objects) {
		this.objectSubjectRelations = objects;
	}

	public void addRelation(RelationType blocks, Requirement r1) {
		RequirementRequirementRelation rrr = new RequirementRequirementRelation();
		rrr.setSubject(this);
		rrr.setRelationType(blocks);
		rrr.setObject(r1);
		
		this.getSubjectObjectRelations().add(rrr);
	}

	@Transient
	public Collection<RequirementRequirementRelation> getRelated() {
		return getSubjectObjectRelations();
	}

	@Transient
	public Collection<RequirementRequirementRelation> getRelatedBy() {
		return getObjectSubjectRelations();
	}
}
