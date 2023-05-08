package com.hair.salon.backend.services;

import com.hair.salon.backend.controllers.auth.AuthenticationRequest;
import com.hair.salon.backend.controllers.auth.AuthenticationResponse;
import com.hair.salon.backend.controllers.auth.RegisterRequest;
import com.hair.salon.backend.models.entities.RoleEntity;
import com.hair.salon.backend.models.entities.UserEntity;
import com.hair.salon.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = UserEntity.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .username(request.getUsername())
                .email(request.getEmail())
                .gender(request.getGender())
                .age(request.getAge())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(RoleEntity.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
