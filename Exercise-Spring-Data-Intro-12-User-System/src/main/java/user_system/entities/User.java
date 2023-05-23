package user_system.entities;

import org.hibernate.validator.constraints.Length;
import user_system.annotations.Email;
import user_system.annotations.Password;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Length(min = 4, max = 30)
    private String username;

    @Password
    private String password;

    @Email
    private String email;

    @Column(name = "registration_date_time")
    private LocalDateTime registrationDateTime;

    @Column(name = "last_time_logged_in")
    private LocalDateTime lastTimeLoggedIn;

    @Size(min = 1, max = 120)
    private int age;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @ManyToOne(optional = false)
    @JoinColumn(name = "born_town_id", referencedColumnName = "id")
    private Town bornTown;

    @ManyToOne(optional = false)
    @JoinColumn(name = "current_town_id", referencedColumnName = "id")
    private Town currentlyLivingTown;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Transient
    private String fullName; // firstName + " " + lastName - Shown only when asked for

    @ManyToMany()
    @JoinTable(name = "user_friends",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id"))
    private Set<User> friends;

    public User(String username, String password, String email, LocalDateTime registrationDateTime, LocalDateTime lastTimeLoggedIn, int age, Town bornTown, Town currentlyLivingTown, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.registrationDateTime = registrationDateTime;
        this.lastTimeLoggedIn = lastTimeLoggedIn;
        this.age = age;
        this.bornTown = bornTown;
        this.currentlyLivingTown = currentlyLivingTown;
        this.firstName = firstName;
        this.lastName = lastName;
        this.friends = new HashSet<>();
    }
}
