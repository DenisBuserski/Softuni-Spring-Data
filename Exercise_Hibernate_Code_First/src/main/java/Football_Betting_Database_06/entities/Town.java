package Football_Betting_Database_06.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "towns")
public class Town  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

    @OneToMany(targetEntity = Team.class, mappedBy = "town")
    private Set<Team> teams;

    public Town() {}
}
