package com.hairsalon.demo.services;

import com.hairsalon.demo.models.entities.NewsLetter;
import com.hairsalon.demo.models.entities.Stylist;
import com.hairsalon.demo.repositories.NewsLetterRepository;
import com.hairsalon.demo.repositories.StylistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StylistService {

    private final StylistRepository stylistRepository;

    public StylistService(StylistRepository stylistRepository) {
        this.stylistRepository = stylistRepository;
    }

    public List<Stylist> findAllStylist() {return this.stylistRepository.findAll();}

    public Optional<Stylist> findStylistById(Long id) {
        return this.stylistRepository.findById(id);
    }

    public Stylist createStylist(Stylist stylist) {
        return this.stylistRepository.save(stylist);
    }

    public void deleteStylistById(Long stylistId) {
        this.stylistRepository.deleteById(stylistId);
    }
}
