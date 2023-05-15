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
    private String nickname;
    private String password;
    private Integer age;
    private String gender;
    private RoleEntity role;

    public UserDto(Long id, String email, String name, String surname, String nickname, RoleEntity role,Integer age,String gender) {
        this.id=id;
        this.email=email;
        this.name=name;
        this.surname=surname;
        this.nickname=nickname;
        this.role=role;
        this.age=age;
        this.gender=gender;
    }

}
