package user_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import user_system.services.UserService;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final UserService userService;

    @Autowired
    public ConsoleRunner(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {
        this.userService.createUser();
    }
}
