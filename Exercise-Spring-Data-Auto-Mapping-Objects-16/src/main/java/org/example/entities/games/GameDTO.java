package org.example.entities.games;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.releaseDate = LocalDate.parse(commandParts[7], formatter);

        this.validate();
    }

    private void validate() {

    }
}
