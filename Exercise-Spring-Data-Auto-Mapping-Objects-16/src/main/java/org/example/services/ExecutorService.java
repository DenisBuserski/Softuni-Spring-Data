package org.example.services;

public interface ExecutorService {
    String REGISTER_USER_COMMAND = "RegisterUser";
    String LOGIN_USER_COMMAND = "LoginUser";
    String LOGOUT = "Logout";

    String execute(String command);
}
