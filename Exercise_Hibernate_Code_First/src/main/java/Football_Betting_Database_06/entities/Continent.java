package Football_Betting_Database_06.entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "continents")
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "continents")
    private Set<Country> countries;

    public Continent() {}
}
