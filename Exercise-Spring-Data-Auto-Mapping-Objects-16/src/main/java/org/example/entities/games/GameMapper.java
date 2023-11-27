package org.example.entities.games;

public class GameMapper {
    public static Game mapGameDTOToGame(GameDTO gameDTO) {
        Game game = new Game();
        game.setTitle(gameDTO.getTitle());
        game.setPrice(gameDTO.getPrice());
        game.setSize(gameDTO.getSize());
        game.setTrailerId(gameDTO.getTrailerId());
        game.setThumbnailUrl(gameDTO.getThumbnailUrl());
        game.setDescription(gameDTO.getDescription());
        game.setReleaseDate(gameDTO.getReleaseDate());

        return game;
    }
}
