package org.example.entities.games;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GameDTO {
    private String title;
    private BigDecimal price;
    private float size;
    private String trailerId;
    private String thumbnailUrl;
    private String description;
    private LocalDate releaseDate;

    public GameDTO(String[] commandParts) {
        this.title = commandParts[1];
        this.price = BigDecimal.valueOf(Long.parseLong(commandParts[2]));
        this.size = Float.parseFloat(commandParts[3]);
        this.trailerId = commandParts[4];
        this.thumbnailUrl = commandParts[5];
        this.description = commandParts[6];
        this.releaseDate = LocalDate.parse(commandParts[7]);

        this.validate();
    }

    private void validate() {

    }
}
