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

    @OneToMany(mappedBy = "user",
            targetEntity = Album.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Album> albums;

    public User() {}
    public User(String username, String password, String email, LocalDateTime registrationDateTime, LocalDateTime lastTimeLoggedIn, int age, Town bornTown, Town currentlyLivingTown, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.registrationDateTime = registrationDateTime;
        this.lastTimeLoggedIn = lastTimeLoggedIn;
        this.age = age;
        this.isDeleted = setDeleted(this.albums);
        this.bornTown = bornTown;
        this.currentlyLivingTown = currentlyLivingTown;
        this.firstName = firstName;
        this.lastName = lastName;
        this.friends = new HashSet<>();
        this.albums = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegistrationDateTime() {
        return registrationDateTime;
    }

    public void setRegistrationDateTime(LocalDateTime registrationDateTime) {
        this.registrationDateTime = registrationDateTime;
    }

    public LocalDateTime getLastTimeLoggedIn() {
        return lastTimeLoggedIn;
    }

    public void setLastTimeLoggedIn(LocalDateTime lastTimeLoggedIn) {
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public boolean setDeleted(Set<Album> albums) {
        if (albums == null || albums.size() <= 0) {
            return true;
        }
        return false;
    }

    public Town getBornTown() {
        return bornTown;
    }

    public void setBornTown(Town bornTown) {
        this.bornTown = bornTown;
    }

    public Town getCurrentlyLivingTown() {
        return currentlyLivingTown;
    }

    public void setCurrentlyLivingTown(Town currentlyLivingTown) {
        this.currentlyLivingTown = currentlyLivingTown;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}
