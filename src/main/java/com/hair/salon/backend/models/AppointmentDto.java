package com.hair.salon.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class AppointmentDto {
    private Long id;
    private String name;
    private String email;
    private String date;
    private String time;
    private String stylist;
    private String service;

}


