package com.hair.salon.backend.services;

import com.hair.salon.backend.models.AppointmentDto;
import com.hair.salon.backend.models.entities.AppointmentEntity;
import com.hair.salon.backend.repositories.AppointmentRepository;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
        AppointmentEntity entity= toEntity(appointmentDto);
        entity = appointmentRepository.save(entity);

        return toDto(entity);
    }



    public List<AppointmentDto> getAppointmentList() {
        List<AppointmentEntity> appointments = appointmentRepository.findAll();
        List<AppointmentDto> result = new ArrayList<>();
        for (AppointmentEntity appointment : appointments) {
            result.add(toDto(appointment));
        }
        return result;
    }

    public AppointmentDto getAppointment(long id) {
        AppointmentEntity entity = getEntity(id);
        return toDto(entity);

    }

    public AppointmentDto updateAppointment(long id, AppointmentDto appointmentDto) {
        AppointmentEntity entity = getEntity(id);
        entity.setName(appointmentDto.getName());
        entity.setEmail(appointmentDto.getEmail());
        entity.setDate(appointmentDto.getDate());
        entity.setTime(appointmentDto.getTime());
        entity.setStylist(appointmentDto.getStylist());
        entity.setService(appointmentDto.getService());
        AppointmentEntity appointment = appointmentRepository.save(entity);

        return toDto(appointment);
    }
    public void deleteAppointment(long id) {
        appointmentRepository.deleteById(id);
    }

    private AppointmentEntity getEntity(long id) {
        Optional<AppointmentEntity> appointmentOptional = appointmentRepository.findById(id);
        if (appointmentOptional.isPresent()) {
            return appointmentOptional.get();
        } else {
            throw new RuntimeException("Appointment not found");
        }
    }
    private static AppointmentDto toDto(AppointmentEntity appointment) {
        return new AppointmentDto(appointment.getId(),
                appointment.getName(),
                appointment.getEmail(),
                appointment.getDate(),
                appointment.getTime(),
                appointment.getStylist(),
                appointment.getService());
    }
    private AppointmentEntity toEntity(AppointmentDto appointmentDto) {
        AppointmentEntity appointment = new AppointmentEntity();
        appointment.setName(appointmentDto.getName());
        appointment.setEmail(appointmentDto.getEmail());
        appointment.setDate(appointmentDto.getDate());
        appointment.setTime(appointmentDto.getTime());
        appointment.setStylist(appointmentDto.getStylist());
        appointment.setService(appointmentDto.getService());
        return appointment;
    }


//    private final AppointmentRepository appointmentRepository;
//
//    public AppointmentService(AppointmentRepository appointmentRepository) {
//        this.appointmentRepository = appointmentRepository;
//    }
//
//    public AppointmentDto createAppointment(AppointmentDto appointmentDto){
//        appointmentDto.setService(appointmentDto.getService());
//        appointmentDto.setName(appointmentDto.getName());
//        appointmentDto.setTime(appointmentDto.getTime());
//        appointmentDto.setEmail(appointmentDto.getEmail());
//
//        return appointmentDto;
//    }
//
//    public void createAppointment(AppointmentEntity appointmentEntity) {
//        appointmentRepository.save(appointmentEntity);
//    }
//
//    private static AppointmentDto toDto(AppointmentDto appointmentDto) {
//        return new AppointmentDto(null,null,null,null,null,null);
//    }
//    private static AppointmentEntity toEntity(AppointmentDto appointmentDto) {
//        AppointmentEntity bookappointment = new AppointmentEntity();
//        bookappointment.setName(appointmentDto.getName());
//        bookappointment.setEmail(appointmentDto.getEmail());
//        bookappointment.setDate(appointmentDto.getDate());
//        bookappointment.setTime(appointmentDto.getTime());
//        bookappointment.setStylist(appointmentDto.getStylist());
//        bookappointment.setService(appointmentDto.getTime());
//        return bookappointment;
//    }
//
//    public List<AppointmentDto> getAppointmentList(){
//        List<AppointmentEntity> appointmentEntities = appointmentRepository.findAll();
//        List<AppointmentDto> result = new ArrayList<>();
//        for (AppointmentEntity appointment : appointmentEntities){
//            result.add(new AppointmentDto (appointment.getService(),appointment.getName(),appointment.getTime(),appointment.getEmail(),appointment.getDate(), appointment.getStylist()));
//
//        }
//        return result;
//    }
//
//    public AppointmentDto getAppointment(long id){
//       appointmentRepository.findById(id);
//       return new AppointmentDto("Haircut","Emir", "dest","emirmail.cpom","012123", "1231");
//    }
//
//    public void deleteAppointment(long id) {
//        System.out.println("Deleted " + id);
//    }


}
