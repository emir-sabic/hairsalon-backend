package com.hairsalon.demo.services;

import com.hairsalon.demo.models.entities.Review;
import com.hairsalon.demo.repositories.ReviewRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> findAllReviews() {
        return this.reviewRepository.findAll();
    }

    public Optional<Review> findReviewById(Long id) {
        return this.reviewRepository.findById(id);
    }

    public Review createReview(Review review) {
        return this.reviewRepository.save(review);
    }

    public void deleteReview(Long reviewId) {
        this.reviewRepository.deleteById(reviewId);
    }

}
