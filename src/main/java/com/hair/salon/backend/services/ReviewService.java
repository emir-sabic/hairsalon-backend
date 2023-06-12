package com.hair.salon.backend.services;

import com.hair.salon.backend.models.ModelSignupDto;
import com.hair.salon.backend.models.ReviewDto;
import com.hair.salon.backend.models.entities.ModelSignupEntity;
import com.hair.salon.backend.models.entities.ReviewEntity;
import com.hair.salon.backend.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public ReviewDto getReview(long id) {
        ReviewEntity entity = getEntity(id);
        return toDto(entity);
    }

    public ReviewDto createReview(ReviewDto reviewDto) {
        ReviewEntity entity= toEntity(reviewDto);
        ReviewEntity entitet = reviewRepository.save(entity);

        return toDto(entitet);
    }

    private static ReviewDto toDto(ReviewEntity review) {
        return new ReviewDto(review.getId(),
                review.getName(),
                review.getEmail(),
                review.getReview());
    }

    private ReviewEntity toEntity(ReviewDto reviewDto) {
        ReviewEntity review = new ReviewEntity();
        review.setId(reviewDto.getId());
        review.setName(reviewDto.getName());
        review.setEmail(reviewDto.getEmail());
        review.setReview(reviewDto.getReview());
        return review;
    }

    private ReviewEntity getEntity(long id) {
        Optional<ReviewEntity> reviewEntityOptional = reviewRepository.findById(id);
        if (reviewEntityOptional.isPresent()) {
            return reviewEntityOptional.get();
        } else {
            throw new RuntimeException("Review not found");
        }
    }
}
