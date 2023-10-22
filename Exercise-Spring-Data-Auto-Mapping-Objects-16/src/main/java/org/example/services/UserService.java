package org.example.services;

import org.example.entities.users.LoginDTO;
import org.example.entities.users.RegisterDTO;
import org.example.entities.users.User;
import org.example.exeptions.login_logout.UserNotLoggedInException;

import java.util.Optional;

public interface UserService {
    User register(RegisterDTO registerData);

    Optional<User> login(LoginDTO loginDTO);

    User getLoggedUser() throws UserNotLoggedInException;

    void logout();
}
