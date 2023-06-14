package com.hairsalon.demo.repositories;

import com.hairsalon.demo.models.entities.Servis;
import com.hairsalon.demo.models.entities.Stylist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServisRepository extends JpaRepository<Servis, Long> {
}
