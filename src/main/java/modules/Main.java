package modules;

import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class Main {

    private static Session session = HibernateUtil.getSessionFactory().openSession();

    private static CriteriaBuilder cb = session.getCriteriaBuilder();

    // Все актеры по имени Jullia
    public static void query1(){

        CriteriaQuery<Actor> query = cb.createQuery(Actor.class);
        Root<Actor> actorRoot = query.from(Actor.class);
        query.select(actorRoot);

        query.where(cb.equal(actorRoot.get("firstName"), "Julia"));
        TypedQuery<Actor> tq = session.createQuery(query);
        List<Actor> actors = tq.getResultList();

        System.out.println("Выведите всех актеров с именем Julia");
        for (Actor actor : actors) {
            System.out.println(actor);
        }
        System.out.println();
    }

    // Все фильмы с Pitt

    public static void query2(){
        CriteriaQuery<Movie> query = cb.createQuery(Movie.class);
        Root<Movie> movieRoot = query.from(Movie.class);
        Join<Movie, Role> roles = movieRoot.join("roles");
        Join<Role, Actor> actor = roles.join("actor");

        query.where(cb.equal(roles.get("actor").get("lastName"), "Pitt"));
        query.select(movieRoot);
        TypedQuery<Movie> tq = session.createQuery(query);
        List<Movie> movies = tq.getResultList();

        System.out.println("Выведите все фильмы, в которых снимался актер по фамилии Pitt");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
        System.out.println();
    }

    // Фильмы с Tom или Tommy
    public static void query3(){
       // CriteriaQuery<Movie> query = cb.createQuery(Movie.class);
        CriteriaQuery<Director> query = cb.createQuery(Director.class);
        Root<Movie> movieRoot = query.from(Movie.class);
        Join<Movie, Role> roles = movieRoot.join("roles");
        Join<Movie, Director> directorJoin = movieRoot.join("directors");
        query.where( cb.or(
                cb.like(roles.get("role"), "Tom%"),
                cb.like(roles.get("role"), "Tommy%")
                ));

        query.select(directorJoin);
        TypedQuery<Director> tq = session.createQuery(query);
        List<Director> movies = tq.getResultList();

        System.out.println("Выведите всех режиссеров, которые сняли фильмы с ролью Tom или Tommy");
        for (Director director : movies) {
            System.out.println(director);
        }
        System.out.println();
    }

    // Фильмы с 1995 по 2000 год
    public static void query4(){
        CriteriaQuery<Movie> query = cb.createQuery(Movie.class);
        Root<Movie> movieRoot = query.from(Movie.class);
        query.select(movieRoot);

        query.where(cb.between(movieRoot.get("year"), 1995, 2000));
        TypedQuery<Movie> tq =session.createQuery(query);

        List<Movie> movies = tq.getResultList();
        System.out.println("Выведите всю информацию о фильмах, которые вышли с 1995 по 2000 год.");
        for (Movie movie : movies) {
            System.out.println(movie);
        }

        System.out.println();
    }

    // Все актеры, которые снимались в 1995 году
    public  static  void query5(){
        CriteriaQuery<Tuple> query = cb.createTupleQuery();
        Root<Movie> movieRoot = query.from(Movie.class);
        Join<Movie, Role> roles = movieRoot.join("roles");
        Join<Role, Actor> actor = roles.join("actor");

        query.where(cb.equal(movieRoot.get("year"), 1995));
        query.multiselect(actor.get("firstName"), actor.get("lastName")).distinct(true);

        TypedQuery<Tuple> tq1 = session.createQuery(query);
        List<Tuple> result = tq1.getResultList();

        System.out.println("Выведите всех актеров, которые снимались в 1999 году.");
        for (Tuple movie : result) {
            String firstName = movie.get(0, String.class);
            String lastName = movie.get(1, String.class);
            System.out.printf("%s %s%n", firstName, lastName);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        query1();

        query2();

        query3();

        query4();

        query5();

        session.close();

    }

}
