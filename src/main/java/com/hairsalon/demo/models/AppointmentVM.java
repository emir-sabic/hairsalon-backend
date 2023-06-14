package com.hairsalon.demo.models;

import com.hairsalon.demo.models.entities.Appointment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class AppointmentVM {
    private Long id;
    private String name;
    private String email;
    private String date;
    private String time;
    private String stylist;
    private String service;

    public AppointmentVM(Appointment appointment){
        this.id = appointment.getId();
        this.name = appointment.getName();
        this.email = appointment.getEmail();
        this.date = appointment.getDate();
        this.time = appointment.getTime();
        this.stylist = appointment.getStylist();
        this.service = appointment.getService();
    }
}


