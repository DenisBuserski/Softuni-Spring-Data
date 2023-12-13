package org.example;

import com.google.gson.annotations.Expose;

public class LoginData {
    @Expose
    private String username;

    @Expose
    private String password;

    public LoginData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginData() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginData{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
