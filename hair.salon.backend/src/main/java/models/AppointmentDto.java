package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.security.Provider;
import java.sql.Time;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
public class AppointmentDto {
    private String id;
    private String service;
    private String name;
    private String time;
    private String email;
    private String number;

}
