package com.hairsalon.demo.controllers;


import com.hairsalon.demo.models.AppointmentVM;
import com.hairsalon.demo.models.entities.Appointment;
import com.hairsalon.demo.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/appointment")
@RestController
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;


    @GetMapping
    public List<AppointmentVM> findAllAppointments(){
        return this.appointmentService.findAllAppointment().stream().map(
                AppointmentVM::new
        ).toList();
    }
    @PostMapping("/new")
    public AppointmentVM createAppointment(
            @RequestBody AppointmentVM appointment
    ) {
        return new AppointmentVM(this.appointmentService.createAppointment(new Appointment(appointment)));
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void deleteAppointmentById(@PathVariable("id") Long appointmentid) {
        this.appointmentService.deleteAppointment(appointmentid);
    }


}
