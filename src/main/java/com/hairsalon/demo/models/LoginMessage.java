package com.hairsalon.demo.models;

public class LoginMessage {
    String message;
    boolean status;

    public LoginMessage(String message, boolean status) {
        this.message = message;
        this.status = status;
    }
}
