package org.maziarz.jadeit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Sprint {
	
	@Id
	private Long id;
	
	private String name;
	private String description;
	
	@Temporal(value = TemporalType.DATE)
	private Date startDate;
	
	@Temporal(value = TemporalType.DATE)
	private Date dueDate;
	
	@Enumerated
	private Status status;
	
	enum Status {ACTIVE, CLOSED}

	public String getName() {
		return name;
	}

	public void setId(long l) {
		this.id = l;
	}

	public void setName(String string) {
		this.name = string;
		
	}
	
	
}
