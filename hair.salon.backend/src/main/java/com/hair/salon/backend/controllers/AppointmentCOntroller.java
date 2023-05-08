package com.hair.salon.backend.controllers;
import com.hair.salon.backend.models.AppointmentDto;
import com.hair.salon.backend.services.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/appointment")
@RestController
public class AppointmentCOntroller {
    private final AppointmentService appointmentService;
    public AppointmentCOntroller(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public AppointmentDto createAppointment(@RequestBody AppointmentDto appointmentDto){
        return appointmentService.createAppointment(appointmentDto);
    }


    @GetMapping("/{appointmentId}/list")
    public List<AppointmentDto> getAppointments(@PathVariable long appointmentId) {
        return appointmentService.getAppointmentList();
    }


    @GetMapping("/{id}")
    public AppointmentDto getAppointment(@PathVariable long id){
        return appointmentService.getAppointment(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable long id) {
        appointmentService.deleteAppointment(id);
    }




}
