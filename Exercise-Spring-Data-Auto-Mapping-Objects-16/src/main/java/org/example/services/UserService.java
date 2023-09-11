package org.example.services;

import org.example.entities.users.RegisterDTO;
import org.example.entities.users.User;

public interface UserService {
    User register(RegisterDTO registerData);

    User login();

    void logout();
}
