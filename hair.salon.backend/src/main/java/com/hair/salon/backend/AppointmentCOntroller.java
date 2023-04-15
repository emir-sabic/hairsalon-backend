package com.hair.salon.backend;
import java.sql.Time;
import models.AppointmentDto;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/appointment")
@RestController
public class AppointmentCOntroller {
    @PostMapping
    public boolean postAppointment(String ID, String Service, String Name, String Time, String Email, String Number){
        AppointmentDto x=new AppointmentDto(ID,Service, Name, Time, Email, Number);
        return false;
    }

    @DeleteMapping
    public boolean deleteAppointment(String ID){
        return true;
    }

    @PatchMapping
    public AppointmentDto patchAppointment(String ID, String Service, String Name, String Time, String Email, String Number){
        AppointmentDto x= new AppointmentDto(ID,Service,Name,Time,Email,Number);
        return x;
    }

}
