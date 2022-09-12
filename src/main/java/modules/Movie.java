package modules;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer year;

    private Float rank;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable (
            name = "movies_directors",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id")
    )
    private Set<Director> directors = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "movie_id"))
    private Set<Role> roles = new HashSet<>();


    @ElementCollection
    @CollectionTable(name = "movies_genres", joinColumns = @JoinColumn(name = "movie_id"))
    private Set<Genre> genres = new HashSet<>();

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", rank=" + rank +
                '}';
    }
}
