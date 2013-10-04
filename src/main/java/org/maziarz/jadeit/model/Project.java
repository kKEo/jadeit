package org.maziarz.jadeit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Project extends BaseObject {

	@Temporal(value = TemporalType.DATE)
	private Date startDate;

	@Temporal(value = TemporalType.DATE)
	private Date endDate;

	@Temporal(value = TemporalType.DATE)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(value = TemporalType.DATE)
	public Date EndDate() {
		return endDate;
	}

	public void setExitDate(Date exitDate) {
		this.endDate = exitDate;
	}

}
