package com.hair.salon.backend.services;

import com.hair.salon.backend.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    public User createUser(User user) {
        user.setId(1L);
        user.setEmail("dino@example.com");
        user.setUsername("dino");
        user.setName("dino");
        user.setSurname("klacar");
        user.setPassword("dino");
        user.setAge(23);
        user.setGender("male");
        return user;
    }

    public List<User> getUserList() {
        List<User> result = new ArrayList<>();
        User x = new User(1L, "dino1@exmail.com", "dino1", "klacar1", "dino1", "dino1", 23, "male");
        result.add(x);
        return result;
    }

    public User getUser(long id) {
        return new User(id, "dino1@exmail.com", "dino1", "klacar1", "dino1", "dino1", 23, "male");
    }

}
