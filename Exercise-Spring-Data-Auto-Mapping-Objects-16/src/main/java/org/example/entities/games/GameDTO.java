package org.example.entities.games;

import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        this.price = new BigDecimal(commandParts[2]); // .setScale(2, RoundingMode.DOWN);
        this.size = Float.parseFloat(commandParts[3]);
        this.trailerId = String.valueOf(commandParts[4]);
        this.thumbnailUrl = commandParts[5];
        this.description = commandParts[6];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.releaseDate = LocalDate.parse(commandParts[7], formatter);

        // this.validate();
    }

    private void validate() {

    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getTrailerId() {
        return trailerId;
    }

    public void setTrailerId(String trailerId) {
        this.trailerId = trailerId;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
