package com.hairsalon.demo.models.entities;

import com.hairsalon.demo.models.NewsLetterVM;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="newsletter")
@Getter
@Setter
public class NewsLetter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;


    public NewsLetter(NewsLetterVM newsLetterVM){
        this.email = newsLetterVM.getEmail();
    }

    public NewsLetter(){}
    @Override
    public String toString() {
        return "NewsLetter{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
