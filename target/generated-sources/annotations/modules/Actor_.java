package modules;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Actor.class)
public abstract class Actor_ {

	public static volatile SingularAttribute<Actor, String> firstName;
	public static volatile SingularAttribute<Actor, String> lastName;
	public static volatile SingularAttribute<Actor, Character> gender;
	public static volatile SingularAttribute<Actor, Integer> id;

	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String GENDER = "gender";
	public static final String ID = "id";

}

