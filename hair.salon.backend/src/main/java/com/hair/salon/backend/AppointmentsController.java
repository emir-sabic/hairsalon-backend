package com.hair.salon.backend;

import models.AppointmentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/appointment")
@RestController
public class AppointmentsController {

    @GetMapping
    public List<AppointmentDto> getAppointment(){
        List<AppointmentDto> result = new ArrayList<>();
        AppointmentDto x = new AppointmentDto("ID" ,"Service", "Name","Time", "Email", "Number");
        result.add(x);
        x= new AppointmentDto("ID","Service", "Name", "Time", "Email", "Number");
        return result;
    }

    }

