package org.example;

import org.example.exeptions.*;
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
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        while (!command.equals("STOP")) {
            String result;
            try {
                result = executorService.execute(command);
            } catch (IncorrectEmailException | // If the email is not in the correct format
                     PasswordLengthException | // If the password length is < 6 symbols
                     PasswordUpperCaseException | // If the password does not contain an uppercase letter
                     PasswordLowerCaseException | // If the password does not contain a lowercase letter
                     PasswordDigitException | // If the password does not contain a digit
                     ConfirmationPasswordException | // If Confirmation password != Password
                     UserAlreadyExistsException | // If we try to register the same email with the same fullname
                     UserNotFoundException | //
                     UserNotLoggedInException exception) // When we want to logout and there is not user logged in
            {
                result = exception.getMessage();
            }

            System.out.println(result);

            command = scanner.nextLine();
        }


    }

}
