package Football_Betting_Database_06.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "competition_type")
public class CompetitionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;

    public CompetitionType() {}
}
