package com.hair.salon.backend.services;

import com.hair.salon.backend.models.AppointmentDto;
import com.hair.salon.backend.models.entities.AppointmentEntity;
import com.hair.salon.backend.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {


    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public AppointmentDto createAppointment(AppointmentDto appointmentDto){
        appointmentDto.setService(appointmentDto.getService());
        appointmentDto.setName(appointmentDto.getName());
        appointmentDto.setTime(appointmentDto.getTime());
        appointmentDto.setEmail(appointmentDto.getEmail());
        appointmentDto.setNumber(appointmentDto.getNumber());

        appointmentDto.setId(appointmentDto.getId());

        return appointmentDto;

    }

    public List<AppointmentDto> getAppointmentList(){
        List<AppointmentEntity> appointmentEntities = appointmentRepository.findAll();
        List<AppointmentDto> result = new ArrayList<>();
        for (AppointmentEntity appointment : appointmentEntities){
            result.add(new AppointmentDto(appointment.getId(), appointment.getService(),appointment.getName(),appointment.getTime(),appointment.getEmail(),appointment.getNumber()));

        }
        return result;
    }

    public AppointmentDto getAppointment(long id){
       appointmentRepository.findById(id);
       return new AppointmentDto(id, "Haircut","Emir", "dest","emirmail.cpom","012123");
    }

    public void deleteAppointment(long id) {
        System.out.println("Deleted " + id);
    }

    
}
