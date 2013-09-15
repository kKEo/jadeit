package org.maziarz.jadeit.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TicketRequirementRelation.class)
public abstract class TicketRequirementRelation_ {

	public static volatile SingularAttribute<TicketRequirementRelation, Requirement> requirement;
	public static volatile SingularAttribute<TicketRequirementRelation, ERelationType> relationType;
	public static volatile SingularAttribute<TicketRequirementRelation, Ticket> ticket;

}

