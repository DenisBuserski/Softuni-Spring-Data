package Football_Betting_Database_06.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name = "games")
public class Game  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(optional = false)
    @JoinColumn(name = "home_team", referencedColumnName = "name")
    private Team homeTeam;

    @OneToOne(optional = false)
    @JoinColumn(name = "away_team", referencedColumnName = "name")
    private Team awayTeam;

    @Column(name = "home_team_goals", nullable = false)
    private int homeGoals;

    @Column(name = "away_team_goals", nullable = false)
    private int  awayGoals;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateAndTimeOfGame;

    @Column(name = "home_team_win_bet_rate", nullable = false)
    private double homeTeamWinBetRate;

    @Column(name = "away_team_win_bet_rate", nullable = false)
    private double awayTeamWinBetRate;

    @Column(name = "draw_game_bet_rate", nullable = false)
    private double drawGameBetRate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "round_id", referencedColumnName = "id")
    private Round round;

    @ManyToOne(optional = false)
    @JoinColumn(name = "competition_id", referencedColumnName = "id")
    private Competition competition;

    public Game() {}
}
