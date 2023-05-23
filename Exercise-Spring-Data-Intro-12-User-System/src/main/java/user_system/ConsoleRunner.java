package user_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import user_system.services.UserService;

import java.time.LocalDateTime;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final UserService userService;

    @Autowired
    public ConsoleRunner(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {
//        this.userService.createUser("test-1", "password-test-1", "test@mail.bg", LocalDateTime.now(), LocalDateTime.now(), 20, null, null, "TestFirst1", "TestLast1");
//        System.out.println(this.userService.getUserFullName("TestFirst1", "TestLast1"));
    }
}
