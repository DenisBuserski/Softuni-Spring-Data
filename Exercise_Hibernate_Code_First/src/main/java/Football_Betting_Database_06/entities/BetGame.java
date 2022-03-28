package Football_Betting_Database_06.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "bet_games")
public class BetGame implements Serializable {

    @Id
    @OneToOne(optional = false)
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;

    @Id
    @OneToOne(optional = false)
    @JoinColumn(name = "bet_id", referencedColumnName = "id")
    private Bet bet;

    @OneToOne
    @JoinColumn(name = "prediction_result", referencedColumnName = "prediction")
    private ResultPrediction resultPrediction;

    public BetGame() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BetGame betGame = (BetGame) o;
        return Objects.equals(game, betGame.game) && Objects.equals(bet, betGame.bet) && Objects.equals(resultPrediction, betGame.resultPrediction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, bet, resultPrediction);
    }
}
