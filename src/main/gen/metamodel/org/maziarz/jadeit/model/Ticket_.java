package org.maziarz.jadeit.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.maziarz.jadeit.model.Ticket.Priority;
import org.maziarz.jadeit.model.Ticket.Status;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Ticket.class)
public abstract class Ticket_ {

	public static volatile SingularAttribute<Ticket, Long> id;
	public static volatile CollectionAttribute<Ticket, Requirement> requirement;
	public static volatile SingularAttribute<Ticket, String> title;
	public static volatile SingularAttribute<Ticket, Status> status;
	public static volatile SingularAttribute<Ticket, Priority> priority;
	public static volatile SingularAttribute<Ticket, String> description;

}

