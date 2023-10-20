package org.example.services.impl;

import org.example.entities.users.LoginDTO;
import org.example.entities.users.RegisterDTO;
import org.example.entities.users.User;
import org.example.exeptions.UserAlreadyExistsException;
import org.example.exeptions.UserNotLoggedInException;
import org.example.repositories.UserRepository;
import org.example.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private User currentUser;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.currentUser = null;
        this.userRepository = userRepository;
    }

    @Override
    public User register(RegisterDTO registerData) {
        ModelMapper mapper = new ModelMapper();
        User userToRegister = mapper.map(registerData, User.class);

        User userByEmailAndFullName = this.userRepository.findByEmailAndFullName(userToRegister.getEmail(), userToRegister.getFullName());
        if (userByEmailAndFullName != null) {
            throw new UserAlreadyExistsException();
        }

        long userCount = this.userRepository.count();
        if (userCount == 0) {
            userToRegister.setAdmin(true); // First registered user is ADMIN
        }

        currentUser = userToRegister;

        return this.userRepository.save(userToRegister);
    }

    @Override
    public Optional<User> login(LoginDTO loginDTO) {

        Optional<User> user = this.userRepository.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());

        user.ifPresent(value -> this.currentUser = value);

        return user;
    }

    @Override
    public User getLoggedUser() throws UserNotLoggedInException {
        if (this.currentUser == null) {
            throw new UserNotLoggedInException();
        }
        return this.currentUser;
    }

    public User getCurrentUser() {
        return this.currentUser;
    }

    @Override
    public void logout() {

    }
}
