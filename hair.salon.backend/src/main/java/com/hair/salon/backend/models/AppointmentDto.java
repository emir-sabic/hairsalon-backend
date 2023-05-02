package com.hair.salon.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class AppointmentDto {
    private long id;
    private String service;
    private String name;
    private String time;
    private String email;
    private String number;
}
