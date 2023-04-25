package user_system.entities;

import java.time.LocalDateTime;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private LocalDateTime registeredOn;
    private LocalDateTime lastTimeLoggedIn;
    private int age;
    private boolean isDeleted;
}
