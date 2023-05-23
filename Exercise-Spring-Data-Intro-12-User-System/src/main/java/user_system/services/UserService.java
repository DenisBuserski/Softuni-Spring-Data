package user_system.services;

import user_system.entities.Town;
import user_system.entities.User;

import java.time.LocalDateTime;

public interface UserService {
    void createUser(String username, String password, String email, LocalDateTime registrationDateTime, LocalDateTime lastTimeLoggedIn, int age, Town bornTown, Town currentlyLivingTown, String firstName, String lastName);

    String getUserFullName(String firstName, String lastName);

    User getUserByid(int id);

}
