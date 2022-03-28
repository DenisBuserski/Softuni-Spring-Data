package Football_Betting_Database_06.entities;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "teams")
public class Team  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String logo;

    @Column(length = 3, unique = true)
    private String initials;

    @ManyToOne(optional = false)
    @JoinColumn(name = "primary_kit_color", referencedColumnName = "name")
    private Color primaryKitColor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "secondary_kit_color", referencedColumnName = "name")
    private Color secondaryKitColor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "town_id", referencedColumnName = "id")
    private Town town;

    @OneToMany(targetEntity = Player.class, mappedBy = "team")
    private Set<Player> players;

    private double budget;

    public Team() {}

}

