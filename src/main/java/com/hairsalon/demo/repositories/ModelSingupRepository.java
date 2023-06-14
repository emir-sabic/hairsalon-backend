package com.hairsalon.demo.repositories;

import com.hairsalon.demo.models.entities.ModelSignup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelSingupRepository  extends JpaRepository<ModelSignup, Long> {
}
