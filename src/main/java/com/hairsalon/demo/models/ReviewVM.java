package com.hairsalon.demo.models;

import com.hairsalon.demo.models.entities.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReviewVM  {
    private Long id;
    private String name;
    private String email;
    private String review;

    public ReviewVM(Review review) {
        this.id = review.getId();
        this.email = review.getEmail();
        this.review = review.getReview();
        this.name = review.getName();
    }

}