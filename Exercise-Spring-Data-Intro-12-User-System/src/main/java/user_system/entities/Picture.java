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

    public Picture() {}
    public Picture(String title, String caption, String path, Album album) {
        this.title = title;
        this.caption = caption;
        this.path = path;
        this.album = album;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
