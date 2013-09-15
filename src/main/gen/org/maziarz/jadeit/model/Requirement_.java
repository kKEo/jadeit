package org.maziarz.jadeit.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Requirement.class)
public abstract class Requirement_ {

	public static volatile SingularAttribute<Requirement, String> descrition;
	public static volatile SingularAttribute<Requirement, Long> id;
	public static volatile ListAttribute<Requirement, Ticket> ticket;
	public static volatile SingularAttribute<Requirement, String> name;

}

