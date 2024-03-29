package org.example.entities.games;

import org.example.exeptions.games.IncorrectGameException;
import org.example.exeptions.registration.IncorrectEmailException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        this.price = new BigDecimal(commandParts[2]);
        this.size = Float.parseFloat(commandParts[3]);
        this.trailerId = String.valueOf(commandParts[4]);
        this.thumbnailUrl = commandParts[5];
        this.description = commandParts[6];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.releaseDate = LocalDate.parse(commandParts[7], formatter);

        this.validate();
    }

    private void validate() {
        titleValidation();
        priceValidation();
        sizeValidation();
        trailerValidation();
        thumbnailValidation();
        descriptionValidation();
    }

    private void titleValidation() {
        String titleRegex = "^[A-Z].{2,99}$";
        Pattern titlePattern = Pattern.compile(titleRegex);
        Matcher titleMatcher = titlePattern.matcher(title);

        if (!titleMatcher.matches()) {
            throw new IncorrectGameException("Provided game data is incorrect!");
        }
    }

    private void priceValidation() {
        if (price.signum() <= 0) {
            throw new IncorrectGameException("Provided game data is incorrect!");
        }
    }

    private void sizeValidation() {
        if (size <= 0) {
            throw new IncorrectGameException("Provided game data is incorrect!");
        }
    }

    private void trailerValidation() {
        String trailerRegex = "www\\.youtube\\.com/watch\\?v=[a-zA-Z]{11}";
        Pattern trailerPattern = Pattern.compile(trailerRegex);
        Matcher trailerMatcher = trailerPattern.matcher(trailerId);

        if (!trailerMatcher.matches()) {
            throw new IncorrectGameException("Provided game data is incorrect!");
        }
    }

    private void thumbnailValidation() {
        if (!thumbnailUrl.equals("http://") && !thumbnailUrl.equals("https://")) {
            throw new IncorrectGameException("Provided game data is incorrect!");
        }
    }

    private void descriptionValidation() {
        if (description.length() < 20) {
            throw new IncorrectGameException("Provided game data is incorrect!");
        }
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
