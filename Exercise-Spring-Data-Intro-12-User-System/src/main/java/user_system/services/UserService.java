package user_system.services;

import user_system.entities.Town;
import user_system.entities.User;

import java.time.LocalDateTime;
import java.util.List;

public interface UserService {
    void createUser(String username, String password, String email, LocalDateTime registrationDateTime, LocalDateTime lastTimeLoggedIn, int age, boolean isDeleted, Town bornTown, Town currentlyLivingTown, String firstName, String lastName);

    String getUserFullNameById(int id);

    User getUserById(int id);

    void addFriends(User user, User user1);

    List<User> getUserByEmail(String email);

    User setToDeleteUser(int id);

    void deleteUserById(int id);

}
