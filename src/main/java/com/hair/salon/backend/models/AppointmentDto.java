package com.hair.salon.backend.models;

import com.hair.salon.backend.models.entities.RoleEntity;
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


