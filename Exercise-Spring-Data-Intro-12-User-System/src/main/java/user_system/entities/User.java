package user_system.entities;

import org.hibernate.validator.constraints.Length;
import user_system.annotations.Email;
import user_system.annotations.Password;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

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

    private Town bornTown;
    private Town currentlyLivingTown;
}
