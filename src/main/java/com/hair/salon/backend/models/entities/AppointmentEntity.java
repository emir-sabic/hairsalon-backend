package com.hair.salon.backend.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="appointment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "service")
    private String service;

    @Column(name = "name")
    private String name;

    @Column(name = "time")
    private String time;

    @Column(name = "email")
    private String email;

    @Column(name = "number")
    private String number;

}
