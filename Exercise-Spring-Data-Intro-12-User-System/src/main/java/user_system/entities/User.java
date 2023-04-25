package user_system.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "users")
public class User {
    @Id
    @@GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "born_town")
    private Town bornTown;

    @Column(name = "currently_living")
    private Town currentlyLiving;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    
    private User friends;
}
