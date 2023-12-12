package org.example.services.impl;

import org.example.entities.games.Game;
import org.example.entities.games.GameDTO;
import org.example.entities.users.LoginDTO;
import org.example.entities.users.RegisterDTO;
import org.example.entities.users.User;
import org.example.exeptions.games.UserIsNotAdminException;
import org.example.services.ExecutorService;
import org.example.services.GameService;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExecutorServiceImpl implements ExecutorService {
    private final UserService userService;

    @Autowired
    public ExecutorServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(String commandLine) {
        String[] commandParts = commandLine.split("\\|");

        String commandName = commandParts[0];
        String commandOutput = switch (commandName) {
            case REGISTER_USER_COMMAND -> registerUser(commandParts);
            case LOGIN_USER_COMMAND -> loginUser(commandParts);
            case LOGOUT_USER_COMMAND -> logoutUser();
            case ADD_GAME_COMMAND -> addGame(commandParts);
            case EDIT_GAME_COMMAND -> editGame(commandParts);
            case DELETE_GAME_COMMAND -> deleteGame(commandParts);
            case ALL_GAMES -> allGames();
            case DETAIL_GAME -> detailGame(commandParts);
            case OWNED_GAMES -> ownedGames(commandParts);
            case ADD_ITEM -> addItem(commandParts);
            case REMOVE_ITEM -> removeItem(commandParts);
            case BUY_ITEM -> buyItem(commandParts);
            default -> "Unknown command!";
        };

        return commandOutput;
    }

    private String registerUser(String[] commandParts) {
        RegisterDTO registerData = new RegisterDTO(commandParts);
        User user = userService.register(registerData);

        return String.format("User: %s was registered", user.getFullName());
    }

    private String loginUser(String[] commandParts) {
        LoginDTO loginData = new LoginDTO(commandParts);
        Optional<User> user = userService.login(loginData);

        return String.format("Successfully logged in %s", user.get().getFullName());
    }

    private String logoutUser() {
        User loggedUser = this.userService.getLoggedUser();

        this.userService.logout();
        return String.format("User %s successfully logged out!", loggedUser.getFullName());
    }

    private void isAdmin() {
        User loggedUser = this.userService.getLoggedUser();

        if (!loggedUser.isAdmin()) {
            throw new UserIsNotAdminException("User is not an Admin!");
        }
    }

    private String addGame(String[] commandParts) {
        isAdmin();

        GameDTO gameData = new GameDTO(commandParts);
        Game game = this.userService.addGame(gameData);

        return String.format("Added " + game.getTitle());
    }

    private String editGame(String[] commandParts) { // TODO: Fix it
        isAdmin();

        int gameId = Integer.parseInt(commandParts[1]);
        BigDecimal gamePrice = new BigDecimal(commandParts[2]);

        this.userService.editGame(gameId, gamePrice);

        return String.format("Successfully corrected game with id " + gameId);
    }

    private String deleteGame(String[] commandParts) {
        isAdmin();

        int gameId = Integer.parseInt(commandParts[1]);
        this.userService.delete(gameId);

        return String.format("Successfully deleted game with id " + gameId);
    }

    private String  allGames() {
        isAdmin();

        StringBuilder result = new StringBuilder();
        this.userService.getAllGames().forEach(game ->
                result.append(game.getTitle() + " " + game.getPrice()).append("\n")
        );

        return result.toString();
    }

    private String detailGame(String[] commandParts) {
        String gameTitle = commandParts[1];

        Game game = this.userService.getGameDetails(gameTitle);
        StringBuilder result = new StringBuilder();
        result.append("Title: " + game.getTitle()).append("\n")
                .append("Price: " + game.getPrice()).append("\n")
                .append("Description: " + game.getDescription()).append("\n")
                .append("Release date: " + game.getReleaseDate());

        return result.toString();
    }
    private String ownedGames(String[] commandParts) {
        return null;
    }

    private String addItem(String[] commandParts) {
        return null;
    }

    private String removeItem(String[] commandParts) {
        return null;
    }

    private String buyItem(String[] commandParts) {
        return null;
    }


}
