package org.example;

import org.example.exeptions.games.IncorrectGameException;
import org.example.exeptions.games.NotFoundGameException;
import org.example.exeptions.games.UserIsNotAdminException;
import org.example.exeptions.login_logout.UserNotFoundException;
import org.example.exeptions.login_logout.UserNotLoggedInException;
import org.example.exeptions.registration.*;
import org.example.services.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private ExecutorService executorService;

    @Autowired
    public ConsoleRunner(ExecutorService executorService) {
        this.executorService = executorService;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Please insert your command:" + System.lineSeparator());
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        while (!command.equals("STOP")) {
            String result;
            try {
                result = executorService.execute(command);
            } catch (
                    // REGISTRATION
                    UserAlreadyExistsException | // If we try to register the same email with the same fullname
                    IncorrectEmailException | // If the email is not in the correct format
                    PasswordLengthException | // If the password length is < 6 symbols
                    PasswordUpperCaseException | // If the password does not contain an uppercase letter
                    PasswordLowerCaseException | // If the password does not contain a lowercase letter
                    PasswordDigitException | // If the password does not contain a digit
                    ConfirmationPasswordException | // If Confirmation password != Password

                    // Login / Logout
                    UserNotLoggedInException | // When we want to logout and there is no user logged in
                    UserNotFoundException | // Incorrect email / password

                    // Games
                    UserIsNotAdminException | // User tries to add edit or delete games
                    IncorrectGameException | // Incorrect game data
                    NotFoundGameException // Game not found
                            
                            exception) {
                result = exception.getMessage();
            }

            System.out.println(result);

            command = scanner.nextLine();
        }


    }

}
