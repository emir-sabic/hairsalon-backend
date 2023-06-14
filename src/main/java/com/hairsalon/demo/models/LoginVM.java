package com.hairsalon.demo.models;

public class LoginVM {
    private String email;
    private String password;

    public LoginVM() {

    }

    public LoginVM(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
