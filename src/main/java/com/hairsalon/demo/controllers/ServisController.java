package com.hairsalon.demo.controllers;

import com.hairsalon.demo.models.ServisVM;
import com.hairsalon.demo.models.entities.Servis;
import com.hairsalon.demo.services.ServisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/servis")
public class ServisController {

    @Autowired
    ServisService servisService;

    @GetMapping
    public List<ServisVM> findAllSerivs() {
        return this.servisService.findAllServis().stream().map(
                ServisVM::new
        ).toList();
    }

    @PostMapping("/new")
    public ServisVM createServis(
            @RequestBody ServisVM servisVM
    ){
        return new ServisVM(this.servisService.createServis(new Servis(servisVM)));
    }



    @DeleteMapping("/delete/{id}")
    @Transactional
    public void deleteServisById(@PathVariable("id") Long servisId) {
        this.servisService.deleteServisById(servisId);
    }

}
