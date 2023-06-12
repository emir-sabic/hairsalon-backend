package com.hair.salon.backend.services;

import com.hair.salon.backend.models.UserDto;
import com.hair.salon.backend.models.entities.UserEntity;
import com.hair.salon.backend.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto createUser(UserDto userDto) {
        UserEntity entity= toEntity(userDto);
        entity = userRepository.save(entity);

        return toDto(entity);
    }



    public List<UserDto> getUserList() {
        List<UserEntity> users = userRepository.findAll();
        List<UserDto> result = new ArrayList<>();
        for (UserEntity user : users) {
            result.add(toDto(user));
        }
        return result;
    }

    public UserDto getUser(long id) {
        UserEntity entity = getEntity(id);
        return toDto(entity);

    }

    public UserDto updateUser(long id, UserDto userDto) {
        UserEntity entity = getEntity(id);
        entity.setEmail(userDto.getEmail());
        entity.setName(userDto.getName());
        entity.setSurname(userDto.getSurname());
        entity.setUsername(userDto.getUsername());
        entity.setPassword(passwordEncoder.encode(userDto.getPassword()));

        UserEntity user = userRepository.save(entity);

        return toDto(user);
    }

    public void deleteUser(long id) {

        userRepository.deleteById(id);
    }

    private UserEntity getEntity(long id) {
        Optional<UserEntity> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new RuntimeException("User not found");
        }
    }
    private static UserDto toDto(UserEntity user) {
        return new UserDto(user.getId(),
                user.getEmail(),
                user.getName(),
                user.getSurname(),
                user.getUsername(),
                user.getPassword(),
                user.getRole()
              );
    }
    private UserEntity toEntity(UserDto userDto) {
        UserEntity user = new UserEntity();
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return user;
    }
}