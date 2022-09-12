package modules;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Movie.class)
public abstract class Movie_ {

	public static volatile SingularAttribute<Movie, Integer> year;
	public static volatile SetAttribute<Movie, Genre> genres;
	public static volatile SetAttribute<Movie, Director> directors;
	public static volatile SetAttribute<Movie, Role> roles;
	public static volatile SingularAttribute<Movie, String> name;
	public static volatile SingularAttribute<Movie, Float> rank;
	public static volatile SingularAttribute<Movie, Integer> id;

	public static final String YEAR = "year";
	public static final String GENRES = "genres";
	public static final String DIRECTORS = "directors";
	public static final String ROLES = "roles";
	public static final String NAME = "name";
	public static final String RANK = "rank";
	public static final String ID = "id";

}

