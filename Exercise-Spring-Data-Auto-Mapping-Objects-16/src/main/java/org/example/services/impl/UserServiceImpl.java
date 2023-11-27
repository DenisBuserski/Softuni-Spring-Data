package org.example.services.impl;

import org.example.entities.games.Game;
import org.example.entities.games.GameDTO;
import org.example.entities.games.GameMapper;
import org.example.entities.users.LoginDTO;
import org.example.entities.users.RegisterDTO;
import org.example.entities.users.User;
import org.example.exeptions.registration.UserAlreadyExistsException;
import org.example.exeptions.login_logout.UserNotFoundException;
import org.example.exeptions.login_logout.UserNotLoggedInException;
import org.example.repositories.GameRepository;
import org.example.repositories.UserRepository;
import org.example.services.UserService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private User currentUser;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, GameRepository gameRepository) {
        this.gameRepository = gameRepository;
        this.currentUser = null;
        this.userRepository = userRepository;
    }

    @Override
    public User register(RegisterDTO registerData) {
        ModelMapper mapper = new ModelMapper();
        User userToRegister = mapper.map(registerData, User.class);

        User userByEmailAndFullName = this.userRepository.findByEmailAndFullName(userToRegister.getEmail(), userToRegister.getFullName());
        if (userByEmailAndFullName != null) {
            throw new UserAlreadyExistsException("User already exists!");
        }

        long userCount = this.userRepository.count();
        if (userCount == 0) {
            userToRegister.setAdmin(true); // First registered user is ADMIN
        }

        return this.userRepository.save(userToRegister);
    }

    @Override
    public Optional<User> login(LoginDTO loginDTO) {
        Optional<User> user = this.userRepository.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());

        if (user.isPresent()) {
            this.currentUser = user.get();
            return user;
        } else {
            throw new UserNotFoundException("Incorrect username / password!");
        }
    }

    @Override
    public void logout() {
        this.currentUser = null;
    }

    @Override
    public User getLoggedUser() {
        if (this.currentUser == null) {
            throw new UserNotLoggedInException("Cannot log out. No user was logged in.");
        }
        return this.currentUser;
    }

    @Override
    public Game addGame(GameDTO gameData) {
        Game gameToAdd = GameMapper.mapGameDTOToGame(gameData);

        return this.gameRepository.save(gameToAdd);
    }

    public User getCurrentUser() {
        return this.currentUser;
    }


}
