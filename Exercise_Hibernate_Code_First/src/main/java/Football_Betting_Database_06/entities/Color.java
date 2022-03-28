package Football_Betting_Database_06.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "colors")
public class Color  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    public Color() {}
}
