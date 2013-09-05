package org.maziarz.jadeit.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Requirement {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@Column(length = 3000)
	private String descrition;
	
//	private List<RequirementRequirementRelation> requiredBy;
	@ManyToMany(targetEntity=Ticket.class)
	private List<Ticket> ticket; 
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}

	public Long getId() {
		return id;
	}
	
}
