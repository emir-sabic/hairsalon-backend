package com.hairsalon.demo.models;

public class UserVM {

    private Long id;
    private String username;
    private String email;
    private String password;

    public UserVM() {

    }

    public UserVM(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
