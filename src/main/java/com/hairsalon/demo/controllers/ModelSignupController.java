package com.hairsalon.demo.controllers;

import com.hairsalon.demo.models.ModelSignupVM;
import com.hairsalon.demo.models.entities.ModelSignup;
import com.hairsalon.demo.services.ModelSignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/modelsignup")
@RestController
public class ModelSignupController {

    @Autowired
    ModelSignupService modelSignupService;

    @GetMapping
    public List<ModelSignupVM> findAllModels() {
        return this.modelSignupService.findAllModels().stream().map(
                ModelSignupVM::new
        ).toList();
    }
    @PostMapping("/new")
    public ModelSignupVM createModelSignup(
            @RequestBody ModelSignupVM modelSignup
    ) {
        return new ModelSignupVM(this.modelSignupService.createModelSignup(new ModelSignup(modelSignup)));
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void deleteModelSignup(@PathVariable("id") Long modelsignupid) {
        this.modelSignupService.deleteModelSignup(modelsignupid);
    }


}
