package user_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user_system.annotations.Email;
import user_system.annotations.Password;
import user_system.entities.Town;
import user_system.entities.User;
import user_system.repositories.UserRepository;

import javax.xml.validation.Validator;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public void createUser(String username, String password, String email, LocalDateTime registrationDateTime, LocalDateTime lastTimeLoggedIn, int age, boolean isDeleted, Town bornTown, Town currentlyLivingTown, String firstName, String lastName) {
        boolean passwordValidator = Password.PasswordValidator.isValid(password);
        boolean emailValidation = Email.EmailValidator.isValid(email);
        if (passwordValidator == false) {
            System.out.println("Invalid password");
        } else if (emailValidation == false) {
            System.out.println("Invalid email");

        } else {
            User user = new User(username, password, email, registrationDateTime, lastTimeLoggedIn, age, isDeleted, bornTown, currentlyLivingTown, firstName, lastName);
            userRepository.save(user);
        }

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

    @Override
    public User setToDeleteUser(int id) {
        User user = this.userRepository.getUserById(id);
        if (user.getLastTimeLoggedIn().isBefore(LocalDateTime.of(2020, 1, 1, 12, 00))) {
            user.setDeleted(true);
            this.userRepository.save(user);
            return user;
        } else {
            System.out.println("User cannot be set to deleted");
            return null;
        }

    }

    @Override
    public void deleteUserById(int id) {
        this.userRepository.deleteById(id);
    }
}
