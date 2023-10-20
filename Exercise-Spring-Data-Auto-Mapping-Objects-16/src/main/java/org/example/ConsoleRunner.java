package org.example;

import org.example.exeptions.UserAlreadyExistsException;
import org.example.exeptions.UserNotLoggedInException;
import org.example.exeptions.IncorrectEmailException;
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
                     UserNotLoggedInException |
                     UserAlreadyExistsException exception)  // If we try to register the same email with the same fullname
            {
                result = exception.getMessage();
            }

            System.out.println(result);

            command = scanner.nextLine();
        }


    }

}
