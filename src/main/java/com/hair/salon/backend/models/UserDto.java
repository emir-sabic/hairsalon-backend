package com.hair.salon.backend.models;

import com.hair.salon.backend.models.entities.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.management.relation.Role;
import javax.swing.text.html.parser.Entity;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String email;
    private String name;
    private String surname;
    private String username;
    private String password;
    private RoleEntity role;


}
