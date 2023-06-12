package com.hair.salon.backend.services;

import com.hair.salon.backend.models.ModelSignupDto;
import com.hair.salon.backend.models.NewsLetterDto;
import com.hair.salon.backend.models.entities.ModelSignupEntity;
import com.hair.salon.backend.models.entities.NewsLetterEntity;
import com.hair.salon.backend.repositories.NewsLetterRepository;
import org.springframework.stereotype.Service;

@Service
public class NewsLetterService {

    private final NewsLetterRepository newsLetterRepository;

    public NewsLetterService(NewsLetterRepository newsLetterRepository) {
        this.newsLetterRepository = newsLetterRepository;
    }

    public NewsLetterDto createNewsletter(NewsLetterDto newsLetterDto) {
        NewsLetterEntity entity= toEntity(newsLetterDto);
        NewsLetterEntity entitet = newsLetterRepository.save(entity);

        return toDto(entitet);
    }

    private static NewsLetterDto toDto(NewsLetterEntity newsLetter) {
        return new NewsLetterDto(newsLetter.getEmail());
    }

    private NewsLetterEntity toEntity(NewsLetterDto newsLetterDto) {
        NewsLetterEntity newsLetter = new NewsLetterEntity();
        newsLetter.setEmail(newsLetterDto.getEmail());
        return newsLetter;
    }
}
