package org.maziarz.jadeit.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.maziarz.jadeit.model.Sprint.Status;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Sprint.class)
public abstract class Sprint_ {

	public static volatile SingularAttribute<Sprint, Long> id;
	public static volatile SingularAttribute<Sprint, Date> startDate;
	public static volatile SingularAttribute<Sprint, Status> status;
	public static volatile SingularAttribute<Sprint, String> description;
	public static volatile SingularAttribute<Sprint, String> name;
	public static volatile SingularAttribute<Sprint, Date> dueDate;

}

