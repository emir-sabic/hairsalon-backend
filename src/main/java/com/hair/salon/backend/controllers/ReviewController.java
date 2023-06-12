package com.hair.salon.backend.controllers;

import com.hair.salon.backend.models.ModelSignupDto;
import com.hair.salon.backend.models.ReviewDto;
import com.hair.salon.backend.services.ReviewService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/review")
@RestController
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @GetMapping("/{id}")
    public ReviewDto getReview(@PathVariable long id) {
        return reviewService.getReview(id);
    }

    @PostMapping("/postreview")
    public ReviewDto createReview(@RequestBody ReviewDto reviewDto) {
        return reviewService.createReview(reviewDto);
    }
}
