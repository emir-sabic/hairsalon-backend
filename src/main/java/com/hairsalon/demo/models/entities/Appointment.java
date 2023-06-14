package com.hairsalon.demo.models.entities;

import com.hairsalon.demo.models.AppointmentVM;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "appointment")
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "stylist")
    private String stylist;

    @Column(name = "service")
    private String service;


    public Appointment(AppointmentVM appointment) {
        this.name = appointment.getName();
        this.email = appointment.getEmail();
        this.date = appointment.getDate();
        this.time = appointment.getTime();
        this.stylist = appointment.getStylist();
        this.service = appointment.getService();
    }

    public Appointment(){}

    @Override
    public String toString(){
        return "Appointment{"+
                "id=" + id +
                ", name" + name + '\'' +
                ", email" + email + '\'' +
                ", date" + date + '\'' +
                ", time" + time + '\'' +
                ", stylist" + stylist + '\'' +
                ", service" + service + '\'' +
                "}";
    }

}
