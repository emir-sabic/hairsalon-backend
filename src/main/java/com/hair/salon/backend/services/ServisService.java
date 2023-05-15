package com.hair.salon.backend.services;

import com.hair.salon.backend.models.ServisDto;
import com.hair.salon.backend.models.entities.AppointmentEntity;
import com.hair.salon.backend.models.entities.ServisEntity;
import com.hair.salon.backend.repositories.AppointmentRepository;
import com.hair.salon.backend.repositories.ServisRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServisService {
    private final ServisRepository servisRepository;

    public ServisService(ServisRepository servisRepository) {
        this.servisRepository = servisRepository;
    }

    public ServisDto createServis(ServisDto servisDto) {
        ServisEntity entity= toEntity(servisDto);
        entity = servisRepository.save(entity);

        return toDto(entity);
    }



    public List<ServisDto> getServisList() {
        List<ServisEntity> serviss = servisRepository.findAll();
        List<ServisDto> result = new ArrayList<>();
        for (ServisEntity servis : serviss) {
            result.add(toDto(servis));
        }
        return result;
    }

    public ServisDto getServis(long id) {
        ServisEntity entity = getEntity(id);
        return toDto(entity);

    }

    public ServisDto updateServis(long id, ServisDto servisDto) {
        ServisEntity entity = getEntity(id);
        entity.setName(servisDto.getName());
        entity.setDescription(servisDto.getDescription());
        entity.setPrice(servisDto.getPrice());
        ServisEntity servis = servisRepository.save(entity);

        return toDto(servis);
    }
    public void deleteServis(long id) {
        servisRepository.deleteById(id);
    }

    private ServisEntity getEntity(long id) {
        Optional<ServisEntity> servisOptional = servisRepository.findById(id);
        if (servisOptional.isPresent()) {
            return servisOptional.get();
        } else {
            throw new RuntimeException("Servis not found");
        }
    }
    private static ServisDto toDto(ServisEntity servis) {
        return new ServisDto(servis.getId(),
                servis.getName(),
                servis.getDescription(),
                servis.getPrice());
    }
    private ServisEntity toEntity(ServisDto servisDto) {
        ServisEntity servis = new ServisEntity();
        servis.setName(servisDto.getName());
        servis.setDescription(servisDto.getDescription());
        servis.setPrice(servisDto.getPrice());

        return servis;
    }
}
