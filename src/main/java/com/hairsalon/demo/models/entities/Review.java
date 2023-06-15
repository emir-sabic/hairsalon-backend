package com.hairsalon.demo.models.entities;

import com.hairsalon.demo.models.ReviewVM;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="reviews")
@Getter
@Setter
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

    @Column(name = "username")
    private String username;


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
        this.username = reviewVM.getUsername();
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
