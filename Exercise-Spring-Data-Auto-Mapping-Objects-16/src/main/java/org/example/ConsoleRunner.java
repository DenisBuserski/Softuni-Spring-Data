package org.example;

import org.example.entities.users.User;
import org.example.entities.users.RegisterDTO;
import org.example.exeptions.ValidationException;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final String REGISTER_USER_COMMAND = "RegisterUser";
    private final String LOGIN_USER_COMMAND = "LoginUser";
    private final String LOGOUT = "Logout";

    private final UserService userService;

    @Autowired
    public ConsoleRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        String result;

        try {
            result = execute(command);
        } catch (ValidationException exception) {
            result = exception.getMessage();
        }

        System.out.println(result);

    }

    private String execute(String commandLine) throws ValidationException {
        String[] commandParts = commandLine.split("\\|");

        String commandName = commandParts[0];
        String commandOutput = switch (commandName) {
            case REGISTER_USER_COMMAND -> {
                RegisterDTO registerData = new RegisterDTO(commandParts);
                User user = userService.register(registerData);

                yield String.format("%s user was registered", user.getFullName());
            }
//            case LOGIN_USER_COMMAND -> userService.login();
//            case LOGOUT -> userService.logout();
            default -> "Unknown command!";
        };

        return commandOutput;
    }
}
