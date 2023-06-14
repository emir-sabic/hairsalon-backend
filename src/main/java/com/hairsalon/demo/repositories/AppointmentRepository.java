package com.hairsalon.demo.repositories;
import com.hairsalon.demo.models.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Optional<Appointment> findById(long id);
    Optional<Appointment> findByService(String service);

}
