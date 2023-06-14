package com.hairsalon.demo.models.entities;

import com.hairsalon.demo.models.ReviewVM;
import jakarta.persistence.*;

@Entity
@Table(name="reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "review")
    private String review;

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getReview() {
        return review;
    }

    public Review(ReviewVM reviewVM) {
        this.email = reviewVM.getEmail();
        this.review = reviewVM.getReview();
        this.name = reviewVM.getName();
    }

    public Review() {}

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", review='" + review + '\'' +
                '}';
    }
}
