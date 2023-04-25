package user_system.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String email;

    @Column(name = "registered_on")
    private LocalDateTime registeredOn;

    @Column(name = "last_time_logged_in")
    private LocalDateTime lastTimeLoggedIn;
    private int age;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @ManyToOne(optional = false)
    @JoinColumn(name = "born_town", referencedColumnName = "id")
    private Town bornTown;

    @ManyToMany
    @JoinTable(name = "users_living_towns",
    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "town_id", referencedColumnName = "id"))
    private Set<Town> currentlyLiving;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany
    private User friends;
}
