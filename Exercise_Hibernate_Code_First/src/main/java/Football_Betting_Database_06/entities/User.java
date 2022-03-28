package Football_Betting_Database_06.entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false)
    private double balance;

    @OneToMany(targetEntity = Bet.class, mappedBy = "user")
    private Set<Bet> bets;

    public User() {
    }

}
