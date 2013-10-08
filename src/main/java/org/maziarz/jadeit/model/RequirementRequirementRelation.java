package org.maziarz.jadeit.model;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ReqReqRel")
@AssociationOverrides({
	  @AssociationOverride(name="pk.subject,", joinColumns = @JoinColumn(name = "subject_id")),	
	  @AssociationOverride(name="pk.object,", joinColumns = @JoinColumn(name = "object_id"))
	})
public class RequirementRequirementRelation implements Serializable{

	private static final long serialVersionUID = 1L;

	private RequirementRequirementPk pk = new RequirementRequirementPk();
	
	@EmbeddedId
	public RequirementRequirementPk getPk() {
		return pk;
	}
	
	public void setPk(RequirementRequirementPk pk) {
		this.pk = pk;
	}

	@Transient
	public Requirement getObject() {
		return getPk().getObject();
	}
	
	public void setObject(Requirement object) {
		getPk().setObject(object);
	}
	
	@Transient
	public Requirement getSubject() {
		return getPk().getSubject();
	}
	
	public void setSubject(Requirement subject) {
		getPk().setSubject(subject);
	}
	
	public enum RelationType {
		DEPENDS, BLOCKS, 
	}
	
	private RelationType relationType;
	
	@Enumerated(EnumType.STRING)
	public RelationType getRelationType() {
		return relationType;
	}
	
	public void setRelationType(RelationType relationType) {
		this.relationType = relationType;
	}
	
	public boolean equals(Object o) {

		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		RequirementRequirementRelation that = (RequirementRequirementRelation) o;

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
