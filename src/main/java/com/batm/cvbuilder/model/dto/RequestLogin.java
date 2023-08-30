package com.batm.cvbuilder.model.dto;

public class RequestLogin {
    private String Email;
    private String Password;

    public RequestLogin() {
    }

    public RequestLogin(String email, String password) {
        Email = email;
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
