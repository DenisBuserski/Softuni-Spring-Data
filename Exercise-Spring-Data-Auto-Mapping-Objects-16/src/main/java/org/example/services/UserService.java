package org.example.services;

import org.example.entities.games.Game;
import org.example.entities.games.GameDTO;
import org.example.entities.users.LoginDTO;
import org.example.entities.users.RegisterDTO;
import org.example.entities.users.User;
import org.example.exeptions.login_logout.UserNotLoggedInException;

import java.math.BigDecimal;
import java.util.Optional;

public interface UserService {
    User register(RegisterDTO registerData);

    Optional<User> login(LoginDTO loginDTO);

    User getLoggedUser();

    void logout();

    Game addGame(GameDTO gameData);

    void editGame(int gameId, BigDecimal gamePrice);

    void delete(int gameId);
}
