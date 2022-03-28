package Football_Betting_Database_06.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity(name = "player_statistics")
public class PlayerStatistic implements Serializable{

    @Id
    @ManyToOne()
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;

    @Id
    @ManyToOne()
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;

    @Column(name = "scored_goals")
    private int scoredGoals;

    @Column(name = "player_assists")
    private int playerAssists;

    @Column(name = "played_minutes")
    private int minutesPlayed;

    public PlayerStatistic() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerStatistic that = (PlayerStatistic) o;
        return scoredGoals == that.scoredGoals && playerAssists == that.playerAssists && minutesPlayed == that.minutesPlayed && Objects.equals(game, that.game) && Objects.equals(player, that.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, player, scoredGoals, playerAssists, minutesPlayed);
    }
}
