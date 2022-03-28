package Football_Betting_Database_06.entities;

import Football_Betting_Database_06.enums.PredictionValues;

import javax.persistence.*;

@Entity(name = "result_prediction")
public class ResultPrediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private PredictionValues prediction;

    public ResultPrediction() {
    }
}
