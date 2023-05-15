package com.hair.salon.backend.data;

import com.hair.salon.backend.models.UserDto;
import com.hair.salon.backend.models.entities.RoleEntity;
import com.hair.salon.backend.models.entities.UserEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.hair.salon.backend.models.entities.RoleEntity.ADMIN;
import static com.hair.salon.backend.models.entities.RoleEntity.USER;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserTest {
    private static long id1 = 1L;
    private static String nickname1 = "nickname1";
    private static String name1 = "Name1";
    private static String surname1 = "surname1";
    private static String email1 = "email1@mail.com";
    private static String password1 = "password1";
    private static String gender1 = "male";
    private static Integer age1 = 23;


    private static RoleEntity role1 = ADMIN;


    public static UserEntity user() {
        UserEntity user = new UserEntity();
        user.setId(id1);
        user.setNickname(nickname1);
        user.setName(name1);
        user.setSurname(surname1);
        user.setEmail(email1);
        user.setPassword(password1);
        user.setRole(role1);
        user.setGender(gender1);
        user.setAge(age1);

        return user;
    }

    public static UserDto userDto1() {
        return new UserDto(id1, email1, name1, surname1, nickname1, password1, age1, gender1, role1);
    }

    public static UserDto userDto3() {
        return new UserDto(3L, "email2@mail.com",
                "firstname2",
                "lastname2",
                "nickname2",
                "password2",
                23,
                "female",
                USER);
    }
}
