package org.maziarz.jadeit.model;

import java.util.Date;

public class Sprint {
	
	private String id;
	private String name;
	private String description;
	private Date startDate;
	private Date dueDate;
	private Status status;
	
	enum Status {ACTIVE, CLOSED}
	
	
}
