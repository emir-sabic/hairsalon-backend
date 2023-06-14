package com.hairsalon.demo.services;

import com.hairsalon.demo.models.entities.NewsLetter;
import com.hairsalon.demo.models.entities.Review;
import com.hairsalon.demo.repositories.NewsLetterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsLetterService {


    private final NewsLetterRepository newsLetterRepository;

    public NewsLetterService(NewsLetterRepository newsLetterRepository) {
        this.newsLetterRepository = newsLetterRepository;
    }

    public List<NewsLetter> findAllNewsLetter() {return this.newsLetterRepository.findAll();}

    public Optional<NewsLetter> findNewsLetterById(Long id) {
        return this.newsLetterRepository.findById(id);
    }

    public NewsLetter createNewsLetter(NewsLetter newsLetter) {
        return this.newsLetterRepository.save(newsLetter);
    }

    public void deleteNewsLetter(Long newsletterId) {
        this.newsLetterRepository.deleteById(newsletterId);
    }


}
