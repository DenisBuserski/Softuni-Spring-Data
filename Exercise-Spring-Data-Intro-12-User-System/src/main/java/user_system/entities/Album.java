package user_system.entities;

import javax.persistence.*;
import java.util.HashSet;
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

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Album() {}
    public Album(String name, String backgroundColor, boolean isPublic, User user) {
        this.name = name;
        this.backgroundColor = backgroundColor;
        this.isPublic = isPublic;
        this.pictures = new HashSet<>();
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
