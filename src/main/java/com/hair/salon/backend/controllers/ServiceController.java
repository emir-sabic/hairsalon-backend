package com.hair.salon.backend.controllers;

import com.hair.salon.backend.models.ServisDto;
import com.hair.salon.backend.services.ServisService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/service")
@RestController
public class ServiceController {

    private final ServisService servisService;

    ServiceController(ServisService servisService) {
        this.servisService = servisService;
    }

    @GetMapping("/{id}/list")
    public List<ServisDto> getServiceList(@PathVariable long id) {
        return servisService.getServisList();
    }


    @GetMapping("/{id}")
    public ServisDto getServis(@PathVariable long id) {
        return servisService.getServis(id);

    }

    @PostMapping
    public ServisDto createServis(@RequestBody ServisDto servisDto) {
        return servisService.createServis(servisDto);
    }

    @PutMapping("/{id}")
    public ServisDto updateServis(@PathVariable long id, @RequestBody ServisDto servisDto) {
        return servisService.updateServis(id, servisDto);
    }
    @GetMapping
    public List<ServisDto> getServices(){
        List<ServisDto> result=new ArrayList<>();
        ServisDto x=new ServisDto(10L,"Name","Desc",125);
        result.add(x);
        x=new ServisDto(20L,"ime","opis",50);
        result.add(x);
        return result;
    }
}
