package com.hairsalon.demo.models;


import com.hairsalon.demo.models.entities.NewsLetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NewsLetterVM {
    private Long id;
    private String email;

    public NewsLetterVM(NewsLetter newsLetter)  {
        this.id = newsLetter.getId();
        this.email = newsLetter.getEmail();
    }
}
