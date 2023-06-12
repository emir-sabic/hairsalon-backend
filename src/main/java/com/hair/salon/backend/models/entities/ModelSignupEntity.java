package com.hair.salon.backend.models.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="modelsignup")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModelSignupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "email")
    private String email;

    @Column(name = "phonenumber")
    private String phonenumber;

    @Column(name = "age")
    private String age;

    @Column(name = "prevexp")
    private String prevexp;
}
