package org.example.entities.users;


import org.example.exeptions.ValidationException;

public class RegisterDTO {
    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;

    /**
     * Validate the data for registering the user
     *
     * commandParts[0] is skipped because it contains the command name, which is not needed in the user object
     * @param commandParts All data read from the console
     */
    public RegisterDTO(String[] commandParts) throws ValidationException {
        this.email = commandParts[1];
        this.password = commandParts[2];
        this.confirmPassword = commandParts[3];
        this.fullName = commandParts[4];

        this.validate();
    }

    private void validate() throws ValidationException {
        if (!email.contains("@") || !email.contains(".")) { // TODO: Add better logic
            throw new ValidationException("Email must contain @ and >");
        }

        // TODO: Validate password

        if (!password.equals(confirmPassword)) {
            throw new ValidationException("Password and Confirm password must match!");
        }
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }
}
