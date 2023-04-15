package com.hair.salon.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private Long id;
    private String email;
    private String name;
    private String surname;
    private String username;
    private String password;
    private Integer age;
    private String gender;
}
