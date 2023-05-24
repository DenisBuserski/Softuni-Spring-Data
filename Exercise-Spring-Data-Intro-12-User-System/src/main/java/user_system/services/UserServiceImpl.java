package user_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user_system.entities.Town;
import user_system.entities.User;
import user_system.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public void createUser(String username, String password, String email, LocalDateTime registrationDateTime, LocalDateTime lastTimeLoggedIn, int age, Town bornTown, Town currentlyLivingTown, String firstName, String lastName) {
        User user = new User(username, password, email, registrationDateTime, lastTimeLoggedIn, age, bornTown, currentlyLivingTown, firstName, lastName);
        userRepository.save(user);
    }

    @Override
    public String getUserFullNameById(int id) {
        return this.userRepository.getFirstAndLastNameById(id);
    }

    @Override
    public User getUserById(int id) {
        return this.userRepository.getUserById(id);
    }

    @Override
    public void addFriends(User user, User user1) {
        user.getFriends().add(user1);
        this.userRepository.save(user);
    }

    @Override
    public List<User> getUserByEmail(String email) {
        return this.userRepository.getUserByEmail(email);
    }
}
