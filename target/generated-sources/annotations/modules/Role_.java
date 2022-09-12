package modules;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Role.class)
public abstract class Role_ {

	public static volatile SingularAttribute<Role, Actor> actor;
	public static volatile SingularAttribute<Role, String> role;

	public static final String ACTOR = "actor";
	public static final String ROLE = "role";

}

