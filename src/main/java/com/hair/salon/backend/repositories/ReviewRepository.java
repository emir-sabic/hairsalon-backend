package com.hair.salon.backend.repositories;

import com.hair.salon.backend.models.entities.ModelSignupEntity;
import com.hair.salon.backend.models.entities.NewsLetterEntity;
import com.hair.salon.backend.models.entities.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

    Optional<ReviewEntity> findByEmail(String email);
    Optional<ReviewEntity> findById( long id);
}
