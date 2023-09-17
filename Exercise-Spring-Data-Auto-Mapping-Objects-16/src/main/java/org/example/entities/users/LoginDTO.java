package org.example.entities.users;

public class LoginDTO {
    private String email; // TODO: Validate email
    private String password;

    public LoginDTO(String [] commandLineParts) {
        this.email = commandLineParts[1];
        this.password = commandLineParts[2];
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
