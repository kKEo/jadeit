package org.maziarz.jadeit.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class RequirementRequirementPk implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Requirement subject;
	private Requirement object;

	public RequirementRequirementPk() {
	}
	
	@ManyToOne
	public Requirement getSubject() {
		return subject;
	}
	
	public void setSubject(Requirement subject) {
		this.subject = subject;
	}
	
	@ManyToOne
	public Requirement getObject() {
		return object;
	}
	
	public void setObject(Requirement object) {
		this.object = object;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((object == null) ? 0 : object.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		RequirementRequirementPk other = (RequirementRequirementPk) obj;
		if (object == null) {
			if (other.object != null)
				return false;
		} else if (!object.equals(other.object))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}	
	
}
