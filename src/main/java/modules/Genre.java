package modules;


import lombok.Getter;
import lombok.ToString;

import javax.persistence.Embeddable;

@Embeddable
@ToString
@Getter

public class Genre {

    private String genre;

    public Genre(String genre) {
        this.genre = genre;
    }

    public Genre() {
    }
}
