package com.hairsalon.demo.controllers;

import com.hairsalon.demo.models.NewsLetterVM;
import com.hairsalon.demo.models.StylistVM;
import com.hairsalon.demo.models.entities.NewsLetter;
import com.hairsalon.demo.models.entities.Stylist;
import com.hairsalon.demo.services.StylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/stylist")
public class StylistController {

    @Autowired
    StylistService stylistService;

    @GetMapping
    public List<StylistVM> findAllStylist() {
        return this.stylistService.findAllStylist().stream().map(
                StylistVM::new
        ).toList();
    }

    @PostMapping("/new")
    public StylistVM createStylist(
            @RequestBody StylistVM stylistVM
    ) {
        return new StylistVM(this.stylistService.createStylist(new Stylist(stylistVM)));
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void deleteStylistById(@PathVariable("id") Long stylistId) {
        this.stylistService.deleteStylistById(stylistId);
    }

}
