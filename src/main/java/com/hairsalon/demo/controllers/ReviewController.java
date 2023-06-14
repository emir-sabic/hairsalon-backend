package com.hairsalon.demo.controllers;

import com.hairsalon.demo.models.ReviewVM;
import com.hairsalon.demo.models.entities.Review;
import com.hairsalon.demo.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping
    public List<ReviewVM> findAllReviews() {
        return this.reviewService.findAllReviews().stream().map(
                ReviewVM::new
        ).toList();
    }

    @PostMapping("/new")
    public ReviewVM createReview(
            @RequestBody ReviewVM review
    ) {
        return new ReviewVM(this.reviewService.createReview(new Review(review)));
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void deleteReviewById(@PathVariable("id") Long reviewId) {
        this.reviewService.deleteReview(reviewId);
    }

}
