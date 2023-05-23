package user_system.entities;

import javax.persistence.*;

@Entity(name = "pictures")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String caption;
    private String path;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "album_id", referencedColumnName = "id")
    private Album album;

}
