package com.hair.salon.backend.controllers;
import com.hair.salon.backend.models.AppointmentDto;
import com.hair.salon.backend.models.ModelSignupDto;
import com.hair.salon.backend.services.ModelSingupService;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/modelsignup")
@RestController
public class ModelSingupController {

    private final ModelSingupService modelSingupService;


    public ModelSingupController(ModelSingupService modelSingupService) {
        this.modelSingupService = modelSingupService;
    }

    @GetMapping("/{id}")
    public ModelSignupDto getModelSignup(@PathVariable long id) {
        return modelSingupService.getModelSignup(id);
    }

    @PostMapping("/modelsignup")
    public ModelSignupDto createModelSignup(@RequestBody ModelSignupDto modelSignupDto) {
        return modelSingupService.createModelSignup(modelSignupDto);
    }
}
