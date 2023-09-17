package org.example.services.impl;

import org.example.entities.users.LoginDTO;
import org.example.entities.users.RegisterDTO;
import org.example.entities.users.User;
import org.example.exeptions.ValidationException;
import org.example.services.ExecutorService;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExecutorServiceImpl implements ExecutorService {
    private final UserService userService;

    @Autowired
    public ExecutorServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(String commandLine) throws ValidationException {
        String[] commandParts = commandLine.split("\\|");

        String commandName = commandParts[0];
        String commandOutput = switch (commandName) {
            case REGISTER_USER_COMMAND -> {
                RegisterDTO registerData = new RegisterDTO(commandParts);
                User user = userService.register(registerData);

                yield String.format("%s user was registered", user.getFullName());
            }
            case LOGIN_USER_COMMAND -> {
                LoginDTO loginData = new LoginDTO(commandParts);
                Optional<User> user = userService.login(loginData);

                yield String.format("Successfully logged in %s", user.getFullName());
            }
//            case LOGOUT -> userService.logout();
            default -> "Unknown command!";
        };

        return commandOutput;
    }
}
