package com.hair.salon.backend.controllers;


import com.hair.salon.backend.models.ModelSignupDto;
import com.hair.salon.backend.models.NewsLetterDto;
import com.hair.salon.backend.services.ModelSingupService;
import com.hair.salon.backend.services.NewsLetterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/modelsignup")
@RestController
public class NewsLetterController {

    private final NewsLetterService newsLetterService;

    public NewsLetterController(NewsLetterService newsLetterService) {
        this.newsLetterService = newsLetterService;
    }

    @PostMapping("/newsletter")
    public NewsLetterDto createnewsletter(@RequestBody NewsLetterDto newsLetterDto) {
        return newsLetterService.createNewsletter(newsLetterDto);
    }
}
