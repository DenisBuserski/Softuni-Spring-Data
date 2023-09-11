package org.example.services.impl;

import org.example.entities.users.RegisterDTO;
import org.example.entities.users.User;
import org.example.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User register(RegisterDTO registerData) {
        return null;
    }

    @Override
    public User login() {
        return null;
    }

    @Override
    public void logout() {

    }
}
