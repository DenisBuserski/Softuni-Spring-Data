package org.example;

import org.example.exeptions.UserNotLoggedInException;
import org.example.exeptions.ValidationException;
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

        String result;
        try {
            result = executorService.execute(command);
        } catch (ValidationException |
                 UserNotLoggedInException exception) {
            result = exception.getMessage();
        }

        System.out.println(result);

    }

}
