package modules;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Embeddable
@Table(name = "roles")
public class Role {

    private String role;

    @ManyToOne
    private Actor actor;

}
