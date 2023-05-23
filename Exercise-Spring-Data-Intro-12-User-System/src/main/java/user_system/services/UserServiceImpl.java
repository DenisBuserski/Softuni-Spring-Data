package user_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user_system.entities.Town;
import user_system.entities.User;
import user_system.repositories.UserRepository;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public void createUser(String username, String password, String email, LocalDateTime registrationDateTime, LocalDateTime lastTimeLoggedIn, int age, Town bornTown, Town currentlyLivingTown, String firstName, String lastName) {
        User user = new User();
        userRepository.save(user);
    }

    @Override
    public String getUserFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }
}
