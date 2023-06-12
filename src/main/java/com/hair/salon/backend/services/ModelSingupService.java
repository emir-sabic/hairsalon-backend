package com.hair.salon.backend.services;

import com.hair.salon.backend.models.AppointmentDto;
import com.hair.salon.backend.models.ModelSignupDto;
import com.hair.salon.backend.models.entities.AppointmentEntity;
import com.hair.salon.backend.models.entities.ModelSignupEntity;
import com.hair.salon.backend.repositories.ModelSignupRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModelSingupService {

    private final ModelSignupRepository modelSignupRepository;

    public ModelSingupService(ModelSignupRepository modelSignupRepository) {
        this.modelSignupRepository = modelSignupRepository;
    }

    public ModelSignupDto getModelSignup(long id) {
        ModelSignupEntity entity = getEntity(id);
        return toDto(entity);
    }

    public ModelSignupDto createModelSignup(ModelSignupDto modelSignupDto) {
        ModelSignupEntity entity= toEntity(modelSignupDto);
        ModelSignupEntity entitet = modelSignupRepository.save(entity);

        return toDto(entitet);
    }


    private ModelSignupEntity getEntity(long id) {
        Optional<ModelSignupEntity> modelSignupOptional = modelSignupRepository.findById(id);
        if (modelSignupOptional.isPresent()) {
            return modelSignupOptional.get();
        } else {
            throw new RuntimeException("Model Signup not found");
        }
    }

    private static ModelSignupDto toDto(ModelSignupEntity modelsignup) {
        return new ModelSignupDto(modelsignup.getId(),
                modelsignup.getFullname(),
                modelsignup.getEmail(),
                modelsignup.getPhonenumber(),
                modelsignup.getAge(),
                modelsignup.getPrevexp());
    }

    private ModelSignupEntity toEntity(ModelSignupDto modelSignupDto) {
        ModelSignupEntity modelsignup = new ModelSignupEntity();
        modelsignup.setFullname(modelSignupDto.getFullname());
        modelsignup.setEmail(modelSignupDto.getEmail());
        modelsignup.setPhonenumber(modelSignupDto.getPhonenumber());
        modelsignup.setAge(modelSignupDto.getAge());
        modelsignup.setPrevexp(modelSignupDto.getPrevexp());
        return modelsignup;
    }
}
