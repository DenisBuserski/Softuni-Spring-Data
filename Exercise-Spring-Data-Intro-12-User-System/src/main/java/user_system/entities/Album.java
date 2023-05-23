package user_system.entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String backgroundColor;
    private boolean isPublic;

    @OneToMany(mappedBy = "album",
            targetEntity = Picture.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Picture> pictures;
}
