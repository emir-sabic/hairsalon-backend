package com.hair.salon.backend.repositories;

import com.hair.salon.backend.models.entities.ModelSignupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModelSignupRepository extends JpaRepository<ModelSignupEntity, Long> {

    Optional<ModelSignupEntity> findById(long id);
    Optional<ModelSignupEntity> findByAge(String age);
}
