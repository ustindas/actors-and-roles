package modules;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Director.class)
public abstract class Director_ {

	public static volatile SingularAttribute<Director, String> firstName;
	public static volatile SingularAttribute<Director, String> lastName;
	public static volatile SingularAttribute<Director, Integer> id;

	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String ID = "id";

}

