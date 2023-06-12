package com.hair.salon.backend.controllers;

import com.hair.salon.backend.models.AppointmentDto;
import com.hair.salon.backend.services.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/bookapointment")
@RestController
public class AppointmentCOntroller {


    private final AppointmentService appointmentService;

    public AppointmentCOntroller(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/{id}/list")
    public List<AppointmentDto> getAppointments(@PathVariable long id) {
        return appointmentService.getAppointmentList();
    }

    @GetMapping("/{id}")
    public AppointmentDto getAppointment(@PathVariable long id) {
        return appointmentService.getAppointment(id);
    }

    @PostMapping("/bookapointment")
    public AppointmentDto createAppointment(@RequestBody AppointmentDto appointmentDto) {
        return appointmentService.createAppointment(appointmentDto);
    }

    @PutMapping("/{id}")
    public AppointmentDto updateAppointment(@PathVariable long id, @RequestBody AppointmentDto appointmentDto) {
        return appointmentService.updateAppointment(id, appointmentDto);
    }


//    private final AppointmentService appointmentService;
//    public AppointmentCOntroller(AppointmentService appointmentService) {
//        this.appointmentService = appointmentService;
//    }
//
//    @PostMapping("/appointment")
//    public void createAppointment(@RequestBody AppointmentEntity appointmentEntity){
//        appointmentService.createAppointment(appointmentEntity);
//    }
//
//
//    @GetMapping("/{appointmentId}/list")
//    public List<AppointmentEntity> getAppointments(@PathVariable long appointmentId) {
//        return appointmentService.getAppointmentList(appointmentId);
//    }
//
//
//    @GetMapping("/{id}")
//    public AppointmentDto getAppointment(@PathVariable long id){
//        return appointmentService.getAppointment(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteAppointment(@PathVariable long id) {
//        appointmentService.deleteAppointment(id);
//    }
//
//


}
