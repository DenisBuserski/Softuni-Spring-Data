package Football_Betting_Database_06.entities;

import javax.persistence.*;

@Entity(name = "players")
public class Player   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "squad_number")
    private int squadNumber;

    @ManyToOne(optional = false)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;

    @ManyToOne(optional = false)
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

    @Column(name = "is_injured")
    private boolean injured;

    public Player() {}
}
