package com.hairsalon.demo.services;

import com.hairsalon.demo.models.entities.ModelSignup;
import com.hairsalon.demo.repositories.ModelSingupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelSignupService {

    private final ModelSingupRepository modelSingupRepository;


    public ModelSignupService(ModelSingupRepository modelSingupRepository) {
        this.modelSingupRepository = modelSingupRepository;
    }

    public List<ModelSignup> findAllModels() {return this.modelSingupRepository.findAll();}

    public Optional<ModelSignup> findModelSignupById(Long id){return this.modelSingupRepository.findById(id);}

    public ModelSignup createModelSignup(ModelSignup modelSignup) {
        return this.modelSingupRepository.save(modelSignup);
    }

    public void deleteModelSignup(Long modelsignupId) { this.modelSingupRepository.deleteById(modelsignupId);}
}
