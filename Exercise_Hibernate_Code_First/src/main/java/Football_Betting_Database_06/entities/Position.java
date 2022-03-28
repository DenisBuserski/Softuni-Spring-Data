package Football_Betting_Database_06.entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "positions")
public class Position  {

    @Id
    @Column(length = 2)
    private String id;

    @Column(name = "position_description")
    private String positionDescription;

    @OneToMany(targetEntity = Player.class, mappedBy = "position")
    private Set<Player> players;

    public Position() {}
}
