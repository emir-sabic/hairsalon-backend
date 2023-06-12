package com.hair.salon.backend.repositories;

import com.hair.salon.backend.models.entities.ModelSignupEntity;
import com.hair.salon.backend.models.entities.NewsLetterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NewsLetterRepository extends JpaRepository<NewsLetterEntity, Long> {
    Optional<NewsLetterEntity> findByEmail(String email);
}
