package com.hairsalon.demo.services;

import com.hairsalon.demo.models.entities.Appointment;
import com.hairsalon.demo.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment createAppointment(Appointment appointment){
        return this.appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long appointmentId) {
        this.appointmentRepository.deleteById(appointmentId);
    }

    public Optional<Appointment> findAppointmentById(Long id){return this.appointmentRepository.findById(id);}
    public List<Appointment> findAllAppointment(){return this.appointmentRepository.findAll();}



}
