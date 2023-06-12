package com.hair.salon.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ModelSignupDto {
    private Long id;
    private String fullname;
    private String email;
    private String phonenumber;
    private String age;
    private String prevexp;
}
