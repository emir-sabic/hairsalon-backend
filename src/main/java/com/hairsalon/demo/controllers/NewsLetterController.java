package com.hairsalon.demo.controllers;

import com.hairsalon.demo.models.NewsLetterVM;
import com.hairsalon.demo.models.ReviewVM;
import com.hairsalon.demo.models.entities.NewsLetter;
import com.hairsalon.demo.models.entities.Review;
import com.hairsalon.demo.services.NewsLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/newsletter")
public class NewsLetterController {

    @Autowired
    NewsLetterService newsLetterService;

    @GetMapping
    public List<NewsLetterVM> findAllNewsLetter() {
        return this.newsLetterService.findAllNewsLetter().stream().map(
                NewsLetterVM::new
        ).toList();
    }

    @PostMapping("/new")
    public NewsLetterVM createNewsLetter(
            @RequestBody NewsLetterVM newsLetterVM
    ) {
        return new NewsLetterVM(this.newsLetterService.createNewsLetter(new NewsLetter(newsLetterVM)));
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void deleteNewsLetterById(@PathVariable("id") Long newsletterId) {
        this.newsLetterService.deleteNewsLetter(newsletterId);
    }

}
