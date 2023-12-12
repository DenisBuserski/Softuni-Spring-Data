package org.example.services.impl;

import org.example.entities.games.Game;
import org.example.entities.games.GameDTO;
import org.example.entities.users.LoginDTO;
import org.example.entities.users.RegisterDTO;
import org.example.entities.users.User;
import org.example.exeptions.games.UserIsNotAdminException;
import org.example.exeptions.registration.IncorrectEmailException;
import org.example.services.ExecutorService;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
            case ALL_GAMES -> allGames(commandParts);
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

    private String addGame(String[] commandParts) {
        User loggedUser = this.userService.getLoggedUser();

        if (!loggedUser.isAdmin()) {
            throw new UserIsNotAdminException("User is not an Admin!");
        }

        GameDTO gameData = new GameDTO(commandParts);
        Game game = this.userService.addGame(gameData);

        return String.format("Added " + game.getTitle());
    }

    private String editGame(String[] commandParts) {
        User loggedUser = this.userService.getLoggedUser();

        if (!loggedUser.isAdmin()) {
            throw new UserIsNotAdminException("User is not an Admin!");
        }

        int gameId = Integer.parseInt(commandParts[1]);
        BigDecimal gamePrice = new BigDecimal(commandParts[2]);

        return String.format("Successfully corrected " + );
    }

    private String deleteGame(String[] commandParts) {
        return null;
    }

    private String allGames(String[] commandParts) {
        return null;
    }

    private String detailGame(String[] commandParts) {
        return null;
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
