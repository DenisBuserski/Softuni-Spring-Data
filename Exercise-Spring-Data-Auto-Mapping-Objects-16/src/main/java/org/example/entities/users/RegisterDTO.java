package org.example.entities.users;

import org.example.exeptions.IncorrectEmailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public RegisterDTO(String[] commandParts) throws IncorrectEmailException {
        this.email = commandParts[1];
        this.password = commandParts[2];
        this.confirmPassword = commandParts[3];
        this.fullName = commandParts[4];

        this.validate();
    }

    private void validate() throws IncorrectEmailException {
        emailValidation();
        passwordValidation();



        // TODO: Validate password

        if (!password.equals(confirmPassword)) {
            throw new IncorrectEmailException("Password and Confirm password must match!");
        }
    }

    private void passwordValidation() {

    }

    private void emailValidation() {
        String emailPattern = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-]+)(\\.[a-zA-Z]{2,5}){1,2}$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher emailMatcher = pattern.matcher(email);

        if (!emailMatcher.matches()) {
            throw new IncorrectEmailException("Email is not correct!");
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
