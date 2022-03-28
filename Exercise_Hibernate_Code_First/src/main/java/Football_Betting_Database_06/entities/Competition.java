package Football_Betting_Database_06.entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "competitions")
public class Competition  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne()
    @JoinColumn(name = "competition_type", referencedColumnName = "id")
    private CompetitionType type;

    @OneToMany(targetEntity = Game.class, mappedBy = "competition")
    private Set<Game> games;

    public Competition() {}
}
