package com.hairsalon.demo.repositories;

import com.hairsalon.demo.models.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
