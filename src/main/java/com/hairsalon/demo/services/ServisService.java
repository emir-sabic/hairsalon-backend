package com.hairsalon.demo.services;

import com.hairsalon.demo.models.entities.Servis;
import com.hairsalon.demo.repositories.ServisRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServisService {
    private final ServisRepository servisRepository;

    public ServisService(ServisRepository servisRepository) {
        this.servisRepository = servisRepository;
    }

    public List<Servis> findAllServis() {return this.servisRepository.findAll();}

    public Optional<Servis> findServisById(Long id) {
        return this.servisRepository.findById(id);
    }

    public Servis createServis(Servis servis) {
        return this.servisRepository.save(servis);
    }

    public void deleteServisById(Long servisId) {
        this.servisRepository.deleteById(servisId);
    }

}
