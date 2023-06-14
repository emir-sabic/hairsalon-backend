package com.hairsalon.demo.repositories;

import com.hairsalon.demo.models.entities.NewsLetter;
import com.hairsalon.demo.models.entities.Stylist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StylistRepository extends JpaRepository<Stylist, Long> {
}
