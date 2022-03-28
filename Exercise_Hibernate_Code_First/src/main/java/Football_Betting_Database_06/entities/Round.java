package Football_Betting_Database_06.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "rounds")
public class Round  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(targetEntity = Game.class, mappedBy = "round")
    private Set<Game> games;

    public Round() {}
}
