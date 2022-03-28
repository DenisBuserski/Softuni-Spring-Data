package Football_Betting_Database_06.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "bets")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bet_money", nullable = false)
    private double betMoney;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateAndTimeOfBet;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Bet() {
    }
}
