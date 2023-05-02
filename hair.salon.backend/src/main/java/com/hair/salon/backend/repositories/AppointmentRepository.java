package com.hair.salon.backend.repositories;

import com.hair.salon.backend.models.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {
    Optional<AppointmentEntity> findById(long id);
    Optional<AppointmentEntity> findByService(String service);


}
